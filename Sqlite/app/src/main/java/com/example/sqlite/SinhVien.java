package com.example.sqlite;

public class SinhVien {
    private String sHoTen;
    private String sSDT;
    private String sDiaChi;
    private String sEmail;

    public SinhVien( String sHoTen, String sSDT, String sDiaChi, String sEmail) {
        this.sHoTen = sHoTen;
        this.sSDT = sSDT;
        this.sDiaChi = sDiaChi;
        this.sEmail = sEmail;
    }

    public String getsHoTen() {
        return sHoTen;
    }

    public void setsHoTen(String sHoTen) {
        this.sHoTen = sHoTen;
    }

    public String getsSDT() {
        return sSDT;
    }

    public void setsSDT(String sSDT) {
        this.sSDT = sSDT;
    }

    public String getsDiaChi() {
        return sDiaChi;
    }

    public void setsDiaChi(String sDiaChi) {
        this.sDiaChi = sDiaChi;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }
}
