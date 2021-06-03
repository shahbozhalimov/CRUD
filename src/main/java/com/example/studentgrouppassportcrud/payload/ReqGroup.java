package com.example.studentgrouppassportcrud.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ReqGroup {

    private UUID id;

    private String name;

    private String groupStatus;

}
