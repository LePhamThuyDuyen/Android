package com.example.btl;

public class Account {
    String SDT,MK,diaChi;

    public Account(String sDT, String mK, String diaChi) {
        this.SDT = sDT;
        this.MK = mK;
        this.diaChi = diaChi;
    }

    public Account() {
        this.SDT = "";
        this.MK = "";
        this.diaChi = "";
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMK() {
        return MK;
    }

    public void setMK(String MK) {
        this.MK = MK;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
