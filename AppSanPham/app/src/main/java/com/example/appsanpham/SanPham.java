package com.example.appsanpham;

public class SanPham {
    private  String maS, tenSP, moTa;
    private  int anh,soLuong,gia;




    public SanPham(String maS, String tenSP, String moTa, int anh, int soLuong, int gia) {
        this.maS = maS;
        this.tenSP = tenSP;
        this.moTa = moTa;
        this.anh = anh;
        this.soLuong = soLuong;
        this.gia = gia;
    }
    public  SanPham(){
        this.maS="";
        this.tenSP="";
        this.moTa="";
        this.anh=0;
        this.soLuong=0;
        this.gia=0;
    }

    public String getMaS() {
        return maS;
    }

    public void setMaS(String maS) {
        this.maS = maS;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
