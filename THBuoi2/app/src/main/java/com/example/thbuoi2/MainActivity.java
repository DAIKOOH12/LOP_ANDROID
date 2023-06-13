package com.example.thbuoi2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    private String[] prglang = {"Thiếu nhi", "Giáo khoa", "Lịch sử", "Tài liệu", "Nấu ăn", "Kinh doanh"};
    private AutoCompleteTextView edKind;
    private EditText edAmount;
    private EditText edSum;
    private EditText edTotal;
    private EditText edDate;
    private CheckBox cbVIP;
    private int thanhTien;
    private Double thucThu;
    private Button btnAdd;
    private Button btnRemove;
    private Button btnCancel;
    private EditText edName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edKind = findViewById(R.id.edKind);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, prglang);
        edKind.setThreshold(1);
        edKind.setAdapter(adapter);

        edAmount = findViewById(R.id.edAmount);
        edSum = findViewById(R.id.edSum);
        edTotal = findViewById(R.id.Total);
        cbVIP = findViewById(R.id.cbVIP);
        btnAdd=findViewById(R.id.btnAdd);
        btnRemove=findViewById(R.id.btnRemove);
        btnCancel=findViewById(R.id.btnCancel);
        edName=findViewById(R.id.edName);

        edKind.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String loaiSach = edKind.getText().toString();
                edAmount.setEnabled(true);
                if (TextUtils.isEmpty(loaiSach)) {
                    edAmount.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String loaiSach = edKind.getText().toString();
                if (loaiSach.equals("Thiếu nhi")) {
                    int amount = Integer.parseInt(edAmount.getText().toString());
                    int sum = amount * 43000;
                    edSum.setText(sum + " VNĐ");
                    thanhTien=sum;
                    if (cbVIP.isChecked()) {
                        Double total = (Double) (sum - sum * 0.1);
                        edTotal.setText(total + " VNĐ");
                        thucThu=total;
                    } else {
                        edTotal.setText(sum + " VNĐ");
                    }
                }
                if (loaiSach.equals("Tài liệu")) {
                    int amount = Integer.parseInt(edAmount.getText().toString());
                    int sum = amount * 49000;
                    edSum.setText(sum + " VNĐ");
                    thanhTien=sum;
                    if (cbVIP.isChecked()) {
                        Double total = (Double) (sum - sum * 0.1);
                        edTotal.setText(total + " VNĐ");
                        thucThu=total;
                    } else {
                        edTotal.setText(sum + " VNĐ");
                    }
                }
                if (loaiSach.equals("Giáo khoa")) {
                    int amount = Integer.parseInt(edAmount.getText().toString());
                    int sum = amount * 73000;
                    edSum.setText(sum + " VNĐ");
                    thanhTien=sum;
                    if (cbVIP.isChecked()) {
                        Double total = (Double) (sum - sum * 0.1);
                        edTotal.setText(total + " VNĐ");
                        thucThu=total;
                    } else {
                        edTotal.setText(sum + " VNĐ");
                    }
                }
                if (loaiSach.equals("Lịch sử")) {
                    int amount = Integer.parseInt(edAmount.getText().toString());
                    int sum = amount * 27000;
                    edSum.setText(sum + " VNĐ");
                    thanhTien=sum;
                    if (cbVIP.isChecked()) {
                        Double total = (Double) (sum - sum * 0.1);
                        edTotal.setText(total + " VNĐ");
                        thucThu=total;
                    } else {
                        edTotal.setText(sum + " VNĐ");
                    }
                }
                if (loaiSach.equals("Nấu ăn")) {
                    int amount = Integer.parseInt(edAmount.getText().toString());
                    int sum = amount * 50000;
                    edSum.setText(sum + " VNĐ");
                    thanhTien=sum;
                    if (cbVIP.isChecked()) {
                        Double total = (Double) (sum - sum * 0.1);
                        edTotal.setText(total + " VNĐ");
                        thucThu=total;
                    } else {
                        edTotal.setText(sum + " VNĐ");
                    }
                }
                if (loaiSach.equals("Kinh doanh")) {
                    int amount = Integer.parseInt(edAmount.getText().toString());
                    int sum = amount * 90000;
                    edSum.setText(sum + " VNĐ");
                    thanhTien=sum;
                    if (cbVIP.isChecked()) {
                        Double total = (Double) (sum - sum * 0.1);
                        edTotal.setText(total + " VNĐ");
                        thucThu=total;
                    } else {
                        edTotal.setText(sum + " VNĐ");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        edDate = findViewById(R.id.dtpDate);
        edDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int iYear = c.get(Calendar.YEAR);
                int iMonth = c.get(Calendar.MONTH);
                int iDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        edDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, iYear, iMonth, iDay);
                dialog.show();
            }
        });

        cbVIP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cbVIP.isChecked()) {
                    Double total=(double)(thanhTien-thanhTien*0.1);
                    edTotal.setText(total + " VNĐ");
                } else {
                    edTotal.setText(thanhTien + " VNĐ");
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=Integer.parseInt(edAmount.getText().toString());
                count+=1;
                edAmount.setText(count+"");
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=Integer.parseInt(edAmount.getText().toString());
                if(count==0){
                    edAmount.setText(count+"");
                }
                else{
                    count-=1;
                    edAmount.setText(count+"");
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,MainActivity.class);
//                MainActivity.this.startActivity(intent);
                edName.setText("");
                edKind.setText("");
                edAmount.setText("0");
                cbVIP.setChecked(false);
                edDate.setText("Chọn ngày");
                edSum.setText("0");
                edTotal.setText("0");
            }
        });
    }
}