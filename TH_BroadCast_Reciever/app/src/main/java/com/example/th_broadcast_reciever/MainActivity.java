package com.example.th_broadcast_reciever;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvHis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<HistoryCall> arrHis=new ArrayList<HistoryCall>();
        SimpleDateFormat sdf=new SimpleDateFormat("hh:mm");
        String time=sdf.format(new Date());
        HistoryCall hc1=new HistoryCall("0398673207","11:33");
        HistoryCall hc2=new HistoryCall("0398673207","12:44");
        HistoryCall hc3=new HistoryCall("0398673207","13:54");
        HistoryCall hc4=new HistoryCall("0398673207",time);

        arrHis.add(hc1);
        arrHis.add(hc2);
        arrHis.add(hc3);
        arrHis.add(hc4);

        CustomAdapter adapter=new CustomAdapter(this,R.layout.item_history,arrHis);
        lvHis.setAdapter(adapter);
    }
}