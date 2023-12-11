package com.example.myup.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Table(name = "tbl-card")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Card extends AbstractEntity {
    private String cardNumber;
    private Date expieDate;
    private Integer ccv2;
}
