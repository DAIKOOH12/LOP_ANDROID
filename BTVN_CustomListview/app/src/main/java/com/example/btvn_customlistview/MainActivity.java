package com.example.btvn_customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.security.AccessControlContext;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getID();
        getListAccount();
        lvAccount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = lvAccount.getItemAtPosition(position).toString();
                Account acc = (Account) parent.getItemAtPosition(position);
                Intent intent=new Intent(MainActivity.this,SettingAccount.class);
                intent.putExtra("account",acc);
            }
        });
    }

    public void getID() {
        lvAccount = findViewById(R.id.lvAccount);
    }

    public void getListAccount() {
        ArrayList<Account> arrAccount = new ArrayList<Account>();
        Account acc1 = new Account(null, "Nguyễn Văn A", "094934838434", "abcxxxx@gmail.com");
        Account acc2 = new Account(null, "Nguyễn Văn B", "034939483854", "dvbdxxx@gmail.com");
        Account acc3 = new Account(null, "Nguyễn Văn C", "093483847723", "dqwezxxx@gmail.com");
        Account acc4 = new Account(null, "Nguyễn Văn D", "039238284824", "drvewxxx@gmail.com");

        arrAccount.add(acc1);
        arrAccount.add(acc2);
        arrAccount.add(acc3);
        arrAccount.add(acc4);

        CustomAdapter adapter = new CustomAdapter(this, R.layout.listitem_account, arrAccount);
        lvAccount.setAdapter(adapter);
    }
}