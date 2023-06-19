package com.example.internet_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class BroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(isOnline(context)){
            Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "disconnected", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean isOnline(Context context){
        try{
            ConnectivityManager cm= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nIF=cm.getActiveNetworkInfo();
            return (nIF!=null && nIF.isAvailable() && nIF.isConnected());
        }
        catch (NullPointerException exception){
            exception.printStackTrace();
            return false;
        }
    }
}
