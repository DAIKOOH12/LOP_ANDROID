package com.example.btapintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edName;
    private TextView tvFootball;
    private TextView tvBasket;
    private TextView tvBadmin;
    private CheckBox cbFootball;
    private CheckBox cbBasket;
    private CheckBox cbBadmin;
    private Button btnOrder;
    private TextView tvName;
    private TextView tvDungcu;
    private TextView tvThanhtien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setID();
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOrder();
            }
        });
    }
    public void setID(){
        edName=findViewById(R.id.edName);
        tvFootball=findViewById(R.id.tvFootball);
        tvBasket=findViewById(R.id.tvBasket);
        tvBadmin=findViewById(R.id.tvBadmin);
        cbFootball=findViewById(R.id.cbFootball);
        cbBasket=findViewById(R.id.cbBasket);
        cbBadmin=findViewById(R.id.cbBadmin);
        btnOrder=findViewById(R.id.btnOrder);
        tvName=findViewById(R.id.tvTenKH);
        tvDungcu=findViewById(R.id.tvDungcu);
        tvThanhtien=findViewById(R.id.tvThanhtien);
    }
    public void sendOrder(){
        int count=0;
        String name=edName.getText().toString();
        String dungcu="";
        if(cbFootball.isChecked()){
            dungcu+="Bóng đá";
            count++;
        }
        if(cbBasket.isChecked()){
            if(TextUtils.isEmpty(dungcu)){
                dungcu+="Bóng rổ";
            }
            else{
                dungcu+=", Bóng rổ";
            }
            count++;
        }
        if(cbBadmin.isChecked()){
            if(TextUtils.isEmpty(dungcu)){
                dungcu+="Vợt cầu lông";
            }
            else{
                dungcu+=", Vợt cầu lông";
            }
            count++;
        }
        Intent intent=new Intent(MainActivity.this,CalculateMoney.class);
        intent.putExtra("Name",name);
        intent.putExtra("dungcu",dungcu);
        intent.putExtra("soluong",count);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1){
            String hoten=data.getStringExtra("name");
            String dungcu=data.getStringExtra("dungcu");
            Double thanhtien=data.getDoubleExtra("thanhtien",0);

            tvName.setText(hoten);
            tvDungcu.setText(dungcu);
            tvThanhtien.setText(thanhtien+" VNĐ");
        }
    }
}