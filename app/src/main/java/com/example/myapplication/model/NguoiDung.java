package com.example.myapplication.model;

public class NguoiDung {
    private String username, password, ten, sdt;

    public NguoiDung() {
    }

    public NguoiDung(String username, String password, String ten, String sdt) {
        this.username = username;
        this.password = password;
        this.ten = ten;
        this.sdt = sdt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "NguoiDung{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ten='" + ten + '\'' +
                ", sdt='" + sdt + '\'' +
                '}';
    }
}
