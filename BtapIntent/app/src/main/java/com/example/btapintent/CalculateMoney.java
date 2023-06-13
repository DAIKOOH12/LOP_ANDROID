package com.example.btapintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class CalculateMoney extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_money);
        Intent intent=getIntent();
        String hoten=intent.getStringExtra("Name");
        String dungcu=intent.getStringExtra("dungcu");
        int soluong=intent.getIntExtra("soluong",0);
        Double sum=0.0;

        String[] arrdungcu=dungcu.split(",");
        for(int i = 0; i<arrdungcu.length; i++){
            arrdungcu[i]=arrdungcu[i].trim();
            if(arrdungcu[i].equals("Bóng đá")){
                sum+=200000;
            }
            if(arrdungcu[i].equals("Bóng rổ")){
                sum+=350000;
            }
            if(arrdungcu[i].equals("Vợt cầu lông")){
                sum+=120000;
            }
        }
        if(soluong==2){
            sum=sum-sum*0.1;
        }
        else if(soluong==3){
            sum=sum-sum*0.2;
        }

        Intent hoadon=new Intent();
        hoadon.putExtra("name",hoten);
        hoadon.putExtra("dungcu",dungcu);
        hoadon.putExtra("thanhtien",sum);
        setResult(1,hoadon);
        finish();
    }
}