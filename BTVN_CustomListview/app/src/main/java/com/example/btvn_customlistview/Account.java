package com.example.btvn_customlistview;

import android.net.Uri;

import java.io.Serializable;

public class Account implements Serializable {
    private String pathImg;
    private String sName;
    private String sPhone;

    private String sEmail;
    public Account(String pathImg, String sName, String sPhone, String sEmail) {
        this.pathImg = pathImg;
        this.sName = sName;
        this.sPhone = sPhone;
        this.sEmail = sEmail;
    }

    public String getPathImg() {
        return pathImg;
    }

    public void setPathImg(String pathImg) {
        this.pathImg = pathImg;
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

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }
}
