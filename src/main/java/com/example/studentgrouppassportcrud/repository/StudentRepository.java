package com.example.studentgrouppassportcrud.repository;

import com.example.studentgrouppassportcrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    void deleteAllByGroupId(UUID groupId);

    @Query(value = "select * from student  where lower(first_name) like concat('%',,'%')", nativeQuery = true)
    List<Student> getStudentByAllParameters(String search);

}
