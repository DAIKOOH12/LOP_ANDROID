package com.example.broadcast_reciever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private BroadCast bc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bc=new BroadCast();
        IntentFilter intentFilter=new IntentFilter("android.intent.action.AIRPLANE_MODE");
        registerReceiver(bc,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(bc);
    }
}