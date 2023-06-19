package com.example.broadcast_reciever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private BroadCast bc;
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        boolean mode = networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
        status = findViewById(R.id.tvStatus);
        if (mode == true) {
            status.setText("Internet connected");
        } else {
            status.setText("Internet disconnected");
        }

        bc = new BroadCast(status);
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(bc, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(bc);
    }
}