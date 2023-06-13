package com.example.facebookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private EditText edTendangnhap;
    private EditText edPassword;
    private Button btnDangnhap;
    private Button btnCancel;
    private CheckBox cbShow;
    private String TENDANGNHAP="abc";
    private String MATKHAU="xyz";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTendangnhap=findViewById(R.id.edTendangnhap);
        edPassword=findViewById(R.id.edMatkhau);
        btnDangnhap=findViewById(R.id.btnDangnhap);
        btnCancel=findViewById(R.id.btnCancel);
        cbShow=findViewById(R.id.cbShowpsw);

        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(edTendangnhap.getText()) || TextUtils.isEmpty(edTendangnhap.getText())){
                    Toast.makeText(MainActivity.this, "Cần điền đủ các trường thông tin", Toast.LENGTH_SHORT).show();
                }
                else{
                    String account=edTendangnhap.getText().toString();
                    String password=edPassword.getText().toString();
                    boolean checkAccount=account.equals(TENDANGNHAP);
                    boolean checkPassword=password.equals(MATKHAU);
                    if(checkAccount == false){
                        Toast.makeText(MainActivity.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                    }
                    else if(checkPassword==false){
                        Toast.makeText(MainActivity.this, "Mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edTendangnhap.setText("");
                edPassword.setText("");
            }
        });
        cbShow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cbShow.isChecked()){
                    edPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    edPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }
}