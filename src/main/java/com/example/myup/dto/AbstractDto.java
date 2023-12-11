package com.example.myup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbstractDto {

    private Long id;
    private Date insertTimeStamp;
    private Date lastUpdateTimeStamp;
}
