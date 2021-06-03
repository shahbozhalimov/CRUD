package com.example.studentgrouppassportcrud.repository;

import com.example.studentgrouppassportcrud.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PassportRepository extends JpaRepository<Passport, UUID> {


}
