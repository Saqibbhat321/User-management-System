package com.saqib.user_management_system.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "register_table")

@NamedQuery(name = "findEntityByEmail",query = "select e from RegisterEntity e where e.email=:setEmail")

public class RegisterEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;

}
