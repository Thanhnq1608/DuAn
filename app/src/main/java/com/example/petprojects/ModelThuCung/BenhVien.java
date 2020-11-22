package com.example.petprojects.ModelThuCung;

public class BenhVien {
    private String idBenhVien, tenBenhVien, DiaChiBenhVien;
    private int resouceImages;

    public BenhVien() {
    }

    public BenhVien(String idBenhVien, String tenBenhVien, String diaChiBenhVien, int resouceImages) {
        this.idBenhVien = idBenhVien;
        this.tenBenhVien = tenBenhVien;
        DiaChiBenhVien = diaChiBenhVien;
        this.resouceImages = resouceImages;
    }

    public String getIdBenhVien() {
        return idBenhVien;
    }

    public void setIdBenhVien(String idBenhVien) {
        this.idBenhVien = idBenhVien;
    }

    public String getTenBenhVien() {
        return tenBenhVien;
    }

    public void setTenBenhVien(String tenBenhVien) {
        this.tenBenhVien = tenBenhVien;
    }

    public String getDiaChiBenhVien() {
        return DiaChiBenhVien;
    }

    public void setDiaChiBenhVien(String diaChiBenhVien) {
        DiaChiBenhVien = diaChiBenhVien;
    }

    public int getResouceImages() {
        return resouceImages;
    }

    public void setResouceImages(int resouceImages) {
        this.resouceImages = resouceImages;
    }
}
