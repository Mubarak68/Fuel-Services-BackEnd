package com.fuelservices.Fuel.and.Services.App.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_entity")
public class UserEntity {

    @Id
    @Column(name = "user_Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_Id;

    @Column(name = "user_name", nullable = false)
    private String username;


    @Column(name = "email", nullable = false)
    private String email;


    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roles;

    public Long getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Long user_Id) {
        this.user_Id = user_Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public RoleEntity getRoles() {
        return roles;
    }

    public void setRoles(RoleEntity roles) {
        this.roles = roles;
    }
}
