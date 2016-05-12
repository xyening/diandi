package com.alka.example.models;


import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by len.li on 21/3/2016.
 * user_id userId
 */
//@LightTable(name = "users")
public class UserModel {
    private Integer id;


    private String userName;
    private String userNick;

    private String email;
    private String qq;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}
