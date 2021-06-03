package com.example.studentgrouppassportcrud.repository;

import com.example.studentgrouppassportcrud.entity.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<Groups, UUID> {
}
