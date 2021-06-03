package com.example.studentgrouppassportcrud.entity;

import com.example.studentgrouppassportcrud.entity.model.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student extends AbsEntity {

    private String firstName;

    private String lastName;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Groups group;

    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Passport passport;

}
