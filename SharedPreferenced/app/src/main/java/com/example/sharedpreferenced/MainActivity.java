package com.example.sharedpreferenced;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.NoCopySpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView tvLastOpen;
    private Button btnQuit;
    private Button btnRemove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLastOpen=findViewById(R.id.tvLastLogin);
        btnQuit=findViewById(R.id.btnQuit);
        btnRemove=findViewById(R.id.btnRemove);
        SharedPreferences sharedPreferences=getSharedPreferences("lastOpen",Context.MODE_PRIVATE);
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                int hour=calendar.get(Calendar.HOUR_OF_DAY);
                int minute=calendar.get(Calendar.MINUTE);
                int second=calendar.get(Calendar.SECOND);
                String date=hour+":"+minute+":"+second;
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("lastopen",date);
                editor.apply();
                finish();
            }
        });
        String date=sharedPreferences.getString("lastopen","no date");
        tvLastOpen.setText("Lần cuối mở app: "+date);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.apply();
            }
        });
    }
}