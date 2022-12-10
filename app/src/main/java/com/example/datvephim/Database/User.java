package com.example.datvephim.Database;

import java.sql.Date;

public class User {

    private String Username, Password, Ho_ten, Sdt, Email, Dia_chi, Cmnd;
    private java.sql.Date Ngay_sinh;
    public User(String username, String password, String ho_ten, String sdt, String email,
                String dia_chi, String cmnd, java.sql.Date ngay_sinh)
    {
        Username = username;
        Password = password;
        Ho_ten = ho_ten;
        Sdt = sdt;
        Email = email;
        Dia_chi = dia_chi;
        Cmnd = cmnd;
        Ngay_sinh = ngay_sinh;
    }

    public User(String Username , String Password){
        this.Username = Username;
        this.Password = Password;
        this.Ho_ten = "";
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getHo_ten() {
        return Ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        Ho_ten = ho_ten;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDia_chi() {
        return Dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        Dia_chi = dia_chi;
    }

    public String getCmnd() {
        return Cmnd;
    }

    public void setCmnd(String cmnd) {
        Cmnd = cmnd;
    }

    public Date getNgay_sinh() {
        return Ngay_sinh;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        Ngay_sinh = ngay_sinh;
    }
}
