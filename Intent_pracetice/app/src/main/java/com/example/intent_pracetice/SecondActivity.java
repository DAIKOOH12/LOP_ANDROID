package com.example.intent_pracetice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView tvName;
    private TextView tvAge;
    private TextView tvPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent= getIntent();
        String hoten=intent.getStringExtra("hoten");
        int tuoi=intent.getIntExtra("tuoi",1);
        String sdt= intent.getStringExtra("sdt");

        tvName=findViewById(R.id.tvName);
        tvAge=findViewById(R.id.tvAge);
        tvPhone=findViewById(R.id.tvPhone);

        tvName.setText("Họ tên: "+hoten);
        tvAge.setText("Tuổi: "+tuoi);
        tvPhone.setText("Số điện thoại: "+sdt);
        String result="";
        if(tuoi>18){
             result="Đạt tiêu chuẩn";
        }else{
            result="Không đạt tiêu chuẩn";
        }
        Intent intentBack=new Intent();
        intentBack.putExtra("message",result);
        setResult(1,intentBack);
        finish();
    }
}