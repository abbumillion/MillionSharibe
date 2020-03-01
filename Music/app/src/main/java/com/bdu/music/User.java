package com.bdu.music;

import java.util.List;

public class User {
    String phone;
    String fname;
    String username;
    String sex;
    String email;
    String password;

    public User(){}

    public User(String phone,String fname, String username, String sex, String email, String password) {
        this.phone=phone;
        this.fname = fname;
        this.username = username;
        this.sex = sex;
        this.email = email;
        this.password = password;

    }

    public User(String fname, String username, String email) {
        this.fname = fname;
        this.username = username;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

}
