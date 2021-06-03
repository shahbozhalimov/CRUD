package com.example.studentgrouppassportcrud.entity;

import com.example.studentgrouppassportcrud.entity.model.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Passport extends AbsEntity {


    @Column(nullable = false, length = 2)
    private String serial;

    @Column(nullable = false, length = 7)
    private String number;

}
