package com.example.btvn_customlistview;

import android.net.Uri;

public class Account {
    private Uri uriImg;
    private String sName;
    private String sPhone;
    private String sEmai;

    public Account(Uri uriImg, String sName, String sPhone, String sEmai) {
        this.uriImg = uriImg;
        this.sName = sName;
        this.sPhone = sPhone;
        this.sEmai = sEmai;
    }

    public Uri getUriImg() {
        return uriImg;
    }

    public void setUriImg(Uri uriImg) {
        this.uriImg = uriImg;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    public String getsEmai() {
        return sEmai;
    }

    public void setsEmai(String sEmai) {
        this.sEmai = sEmai;
    }
}
