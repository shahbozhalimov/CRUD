package com.example.studentgrouppassportcrud.entity;

import com.example.studentgrouppassportcrud.entity.enums.GroupStatus;
import com.example.studentgrouppassportcrud.entity.model.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Groups extends AbsEntity {

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private GroupStatus groupStatus;

}
