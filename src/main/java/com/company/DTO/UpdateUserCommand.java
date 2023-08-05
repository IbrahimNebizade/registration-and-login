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
public class UpdateUserCommand {
    private String name;
    private String surname;
    private String nickName;
    private int age;
    private Date birthDate;
    private String phoneNumber;
}
