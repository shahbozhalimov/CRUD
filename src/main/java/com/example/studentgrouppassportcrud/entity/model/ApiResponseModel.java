package com.example.studentgrouppassportcrud.entity.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ApiResponseModel {

    private String message;

    private boolean success;

    private Object object;

}
