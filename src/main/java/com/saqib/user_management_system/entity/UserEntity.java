package com.saqib.user_management_system.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
@Data
@RequiredArgsConstructor


@NamedQuery(name = "findAll", query = "SELECT u FROM UserEntity u")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private double phNo;

    // Getters and Setters
}