package com.example.studentgrouppassportcrud.controller;

import com.example.studentgrouppassportcrud.entity.Passport;
import com.example.studentgrouppassportcrud.entity.Student;
import com.example.studentgrouppassportcrud.entity.model.ApiResponseModel;
import com.example.studentgrouppassportcrud.payload.ReqStudent;
import com.example.studentgrouppassportcrud.payload.ResStudent;
import com.example.studentgrouppassportcrud.repository.GroupRepository;
import com.example.studentgrouppassportcrud.repository.PassportRepository;
import com.example.studentgrouppassportcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    PassportRepository passportRepository;

    @GetMapping
    public String getGroupPage(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("groups", groupRepository.findAll());
        return "student";
    }

    @ResponseBody
    @GetMapping("{id}")
    public ApiResponseModel getStudentById(@PathVariable UUID id) {
        Student student = studentRepository.findById(id).get();
        ResStudent resStudent = new ResStudent();
        resStudent.setId(student.getId());
        resStudent.setFirstName(student.getFirstName());
        resStudent.setLastName(student.getLastName());
        resStudent.setGroupId(student.getGroup().getId());
        resStudent.setSerial(student.getPassport().getSerial());
        resStudent.setNumber(student.getPassport().getNumber());
        return new ApiResponseModel("resStudent", true, resStudent);
    }

//    @GetMapping("search")
//    public ApiResponseModel searchStudentByAllParameters(@RequestParam String search){
//        studentRepository
//    }

    @PostMapping
    public String saveStudent(@ModelAttribute ReqStudent reqStudent) {
        if (reqStudent.getId() == null) {
            studentRepository.save(new Student(
                            reqStudent.getFirstName(),
                            reqStudent.getLastName(),
                            groupRepository.findById(reqStudent.getGroupId()).get(),
                            passportRepository.save(new Passport(reqStudent.getSerial(), reqStudent.getNumber()))
                    )
            );

        } else {
            Student student = studentRepository.findById(reqStudent.getId()).get();
            student.setFirstName(reqStudent.getFirstName());
            student.setLastName(reqStudent.getLastName());
            student.setGroup(groupRepository.findById(reqStudent.getGroupId()).get());
            Passport passport = student.getPassport();
            passport.setSerial(reqStudent.getSerial());
            passport.setNumber(reqStudent.getNumber());
            studentRepository.save(student);
        }
        return "redirect:/student";
    }

    @ResponseBody
    @DeleteMapping("{id}")
    public ApiResponseModel deleteStudent(@PathVariable UUID id) {
        try {
            studentRepository.deleteById(id);
            return new ApiResponseModel("deleted", true, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponseModel("error", false, null);
        }

    }

}
