package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvUser;
    private ListView lvNormal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvUser=findViewById(R.id.lvInfo);

        User user1=new User("Phạm Duy Trường","03293293284",Color.BLUE);
        User user2=new User("Nguyễn Văn A","093232737274", Color.GREEN);
        User user3=new User("Nguyễn Văn B","04928472745", Color.RED);
        User user4=new User("Nguyễn Văn C","0932382372", Color.GRAY);

        ArrayList<User> arrUser=new ArrayList<User>();
        arrUser.add(user1);
        arrUser.add(user2);
        arrUser.add(user3);
        arrUser.add(user4);
        CustomAdapter adapter=new CustomAdapter(this,R.layout.listview_item,arrUser);
        lvUser.setAdapter(adapter);
    }
}