package com.example.myfirst.dtos;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class MemberDTO {

    @NotBlank(message = "LastName should not be blank")
    String firstName;
    String middleName;
    String lastName;
    String gender;
    String dateOfBirth;
    String father;
    String mother;
}
