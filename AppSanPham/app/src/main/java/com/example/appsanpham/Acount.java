package com.example.appsanpham;

public class Acount {
    private  String hoTen, sdt, mk;

    public Acount(String hoTen, String sdt, String mk) {
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.mk = mk;
    }
    public Acount() {
        this.hoTen = "";
        this.sdt = "";
        this.mk = "";
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }
}
