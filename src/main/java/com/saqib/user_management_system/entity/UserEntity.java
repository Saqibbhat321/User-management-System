package com.saqib.user_management_system.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
@Data
@RequiredArgsConstructor
@NamedQuery(name = "updateUserProfileById", query = "UPDATE UserEntity ue SET ue.name = :name, ue.email = :email, ue.phNo = :phNo, ue.country = :country WHERE ue.id = :id")

@NamedQuery(name = "deleteUserById", query = "DELETE FROM UserEntity ue WHERE ue.id = :id")
@NamedQuery(name = "getAllUsers", query = "SELECT u FROM UserEntity u")
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
    private String phNo;

    // Getters and Setters
}