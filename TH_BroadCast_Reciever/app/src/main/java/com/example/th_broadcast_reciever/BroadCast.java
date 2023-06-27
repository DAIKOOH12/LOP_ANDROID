package com.example.th_broadcast_reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class BroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String phoneState =intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        if(phoneState.equals((TelephonyManager.EXTRA_STATE_RINGING))){
            String phoneNumber=intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Toast.makeText(context, "Cuộc gọi từ: "+phoneNumber, Toast.LENGTH_SHORT).show();
        }
    }
}
