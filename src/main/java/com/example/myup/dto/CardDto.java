package com.example.myup.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    @Pattern(regexp = "^[0-9]{16}" , message = "cardNumber.size")
    private String cardNumber;
    private Date expieDate;
    private Integer ccv2;


}
