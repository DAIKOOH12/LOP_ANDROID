package com.example.broadcast_reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.TextView;
import android.widget.Toast;

public class BroadCast extends BroadcastReceiver {
    private TextView tvStatus;

    public BroadCast(TextView tvStatus) {
        this.tvStatus = tvStatus;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(isOnline(context)){
            tvStatus.setText("Internet connected");
        }
        else{
            tvStatus.setText("Internet disconnected");
        }
    }
    private boolean isOnline(Context context){
        try{
            ConnectivityManager cm=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=cm.getActiveNetworkInfo();
            return (networkInfo !=null &&networkInfo.isConnected());
        }catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }
}
