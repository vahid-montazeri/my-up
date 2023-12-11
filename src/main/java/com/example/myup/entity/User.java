package com.example.myup.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tbl_user")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity {

    private String name;

    private String family;

    private String fatherName;

    @Column(name = "national_code",unique = true,length = 10)
    private String nationalCode;
    @Column(unique = true,length = 11)
    private String phoneNumber;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Account> accounts;


}
