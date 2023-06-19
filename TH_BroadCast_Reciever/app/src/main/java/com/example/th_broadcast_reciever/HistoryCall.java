package com.example.th_broadcast_reciever;

import java.util.Date;

public class HistoryCall {
    private String sPhoneNum;
    private String sTime;

    public HistoryCall(String sPhoneNum, String sTime) {
        this.sPhoneNum = sPhoneNum;
        this.sTime = sTime;
    }

    public String getsPhoneNum() {
        return sPhoneNum;
    }

    public void setsPhoneNum(String sPhoneNum) {
        this.sPhoneNum = sPhoneNum;
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }
}
