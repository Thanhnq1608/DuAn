package com.example.petprojects.ModelThuCung;

class CuaHang {
    private String idCuaHang, tenCuaHang, dichVuCuaHang, voteCuaHang;

    public CuaHang() {
    }

    public CuaHang(String idCuaHang, String tenCuaHang, String dichVuCuaHang, String voteCuaHang) {
        this.idCuaHang = idCuaHang;
        this.tenCuaHang = tenCuaHang;
        this.dichVuCuaHang = dichVuCuaHang;
        this.voteCuaHang = voteCuaHang;
    }

    public String getIdCuaHang() {
        return idCuaHang;
    }

    public void setIdCuaHang(String idCuaHang) {
        this.idCuaHang = idCuaHang;
    }

    public String getTenCuaHang() {
        return tenCuaHang;
    }

    public void setTenCuaHang(String tenCuaHang) {
        this.tenCuaHang = tenCuaHang;
    }

    public String getDichVuCuaHang() {
        return dichVuCuaHang;
    }

    public void setDichVuCuaHang(String dichVuCuaHang) {
        this.dichVuCuaHang = dichVuCuaHang;
    }

    public String getVoteCuaHang() {
        return voteCuaHang;
    }

    public void setVoteCuaHang(String voteCuaHang) {
        this.voteCuaHang = voteCuaHang;
    }
}
