package com.bcx.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name="user_name")
    private String userName;

    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="user_password")
    private String userPassword;

    @Column(name="user_status")
    private String userStatus;

    @Column(name="create_time")
    private String createTime;

    @Column(name="last_login_time")
    private String lastLoginTime;

    @Column(name="last_update_time")
    private String lastUpdateTime;

    private String avatar;


}
