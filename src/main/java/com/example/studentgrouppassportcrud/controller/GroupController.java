package com.example.studentgrouppassportcrud.controller;

import com.example.studentgrouppassportcrud.entity.Groups;
import com.example.studentgrouppassportcrud.entity.enums.GroupStatus;
import com.example.studentgrouppassportcrud.entity.model.ApiResponseModel;
import com.example.studentgrouppassportcrud.payload.ReqGroup;
import com.example.studentgrouppassportcrud.repository.GroupRepository;
import com.example.studentgrouppassportcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("group")
public class GroupController {

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    public String getGroupPage(Model model) {
        List<Groups> groups = groupRepository.findAll();
        model.addAttribute("groups", groups);
        return "group";
    }

    @ResponseBody
    @GetMapping("{id}")
    public ApiResponseModel getGroupById(@PathVariable UUID id) {
        return new ApiResponseModel("group", true, groupRepository.findById(id).get());
    }

    @PostMapping()
    public String saveGroup(@ModelAttribute ReqGroup reqGroup) {
        if (reqGroup.getId() == null) {
            groupRepository.save(new Groups(reqGroup.getName(), GroupStatus.valueOf(reqGroup.getGroupStatus())));
        } else {
            Groups group = groupRepository.findById(reqGroup.getId()).get();
            group.setName(reqGroup.getName());
            group.setGroupStatus(GroupStatus.valueOf(reqGroup.getGroupStatus()));
            groupRepository.save(group);
        }
        return "redirect:/group";
    }

    @ResponseBody
    @Transactional
    @PostMapping("{id}")
    public ApiResponseModel deleteGroup(@PathVariable UUID id) {
        studentRepository.deleteAllByGroupId(id);
        groupRepository.deleteById(id);
        return new ApiResponseModel("deleted", true, null);
    }

}
