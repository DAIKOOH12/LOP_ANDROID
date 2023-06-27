package com.example.sqlite;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edName;
    private EditText edSDT;
    private EditText edDiachi;
    private EditText edEmail;
    private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getID();
        DBManager db=new DBManager(this);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SinhVien sv=createSinhVien();
                db.addSinhVien(sv);
            }
        });
    }
    public void getID(){
        edName=findViewById(R.id.tvName);
        edSDT=findViewById(R.id.tvPhone);
        edDiachi=findViewById(R.id.tvAddress);
        edEmail=findViewById(R.id.tvEmail);
        btnSave=findViewById(R.id.btnSave);
    }
    private SinhVien createSinhVien(){
        String name=edName.getText().toString();
        String sdt=edSDT.getText().toString();
        String diachi=edDiachi.getText().toString();
        String email=edEmail.getText().toString();

        SinhVien sv=new SinhVien(name,sdt,diachi,email);
        return sv;
    }
}