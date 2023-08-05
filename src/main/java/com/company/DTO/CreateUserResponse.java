package com.company.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserResponse {
    private Long id;
    private String name;
    private String surname;
    private String nickName;
    private int age;
    private String phoneNumber;
    private Date birthDate;
    private Date createTime;

}
