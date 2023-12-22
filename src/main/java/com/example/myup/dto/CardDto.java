package com.example.myup.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto extends AbstractDto {

    @Pattern(regexp = "^[0-9]{16}", message = "cardNumber.size")
    private String cardNumber;

    private Date expireDate;

    private Integer ccv2;


}
