package com.example.customlistview;

import android.net.Uri;

public class User {
    private String name;
    private String phone;
    private int number;

    public User(String name, String phone, int number) {
        this.name = name;
        this.phone = phone;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
