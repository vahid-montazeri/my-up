package com.example.myup.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String name;
    private String family;
    private String nationalCode;

    @Min(value = 11, message = "شماره موبایل باید 11 رقم باشد")
    @Max(value = 11, message = "شماره موبایل باید 11 رقم باشد")
    private String phoneNumber;
}
