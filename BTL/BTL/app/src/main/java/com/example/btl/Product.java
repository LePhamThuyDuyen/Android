package com.example.btl;

public class Product {
    String name,moTa,ghiChu;
    int anh, sol, gia,id;

    public Product(String name,  int gia,int sol, int anh, String moTa, String ghiChu) {
        this.name = name;
        this.moTa = moTa;
        this.ghiChu = ghiChu;
        this.anh = anh;
        this.sol = sol;
        this.gia = gia;
    }
    public Product(String name,  int gia,int sol, int anh, String moTa, String ghiChu,int id) {
        this.name = name;
        this.moTa = moTa;
        this.ghiChu = ghiChu;
        this.anh = anh;
        this.sol = sol;
        this.gia = gia;
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public int getSol() {
        return sol;
    }

    public void setSol(int sol) {
        this.sol = sol;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
