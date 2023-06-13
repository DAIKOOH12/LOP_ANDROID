package com.example.intent_pracetice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edName;
    private EditText edAge;
    private EditText edPhone;
    private Button btnSend;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOnclick();
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendValue();
            }
        });
    }

    public void setOnclick() {
        edName = findViewById(R.id.edName);
        edAge = findViewById(R.id.edAge);
        edPhone = findViewById(R.id.edPhone);
        btnSend = findViewById(R.id.btnSend);
        tvResult = findViewById(R.id.tvResult);
    }

    public void sendValue() {
        String hoten = edName.getText().toString();
        String tuoi = edAge.getText().toString();
        String sdt = edPhone.getText().toString();
        if (TextUtils.isEmpty(hoten) && TextUtils.isEmpty(tuoi) && TextUtils.isEmpty(sdt)) {
            Toast.makeText(this, "Bạn chưa điền đủ thông tin", Toast.LENGTH_SHORT).show();
        } else {
            int iTuoi = Integer.parseInt(tuoi);
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("hoten", hoten);
            intent.putExtra("tuoi", iTuoi);
            intent.putExtra("sdt", sdt);
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            String result = data.getStringExtra("message");
            tvResult.setText(result);
        }
    }
}
