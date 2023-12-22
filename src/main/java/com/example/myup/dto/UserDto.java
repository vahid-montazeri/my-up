package com.example.myup.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends AbstractDto {

    private String name;
    private String family;
    private String nationalCode;

    @Min(value = 11, message = "شماره موبایل باید 11 رقم باشد")
    @Max(value = 11, message = "شماره موبایل باید 11 رقم باشد")
    private String phoneNumber;
}
