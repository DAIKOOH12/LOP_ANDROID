package com.example.broadcast_reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class BroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
        if(isAirplaneModeOn){
            Toast.makeText(context, "Airplane mode is on", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Airplane mode is off", Toast.LENGTH_SHORT).show();
        }
    }
}
