package com.example.th_broadcast_reciever;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<HistoryCall> {
    private Context context;
    private int resource;
    private ArrayList<HistoryCall> arrHis;
    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<HistoryCall> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.arrHis=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.item_history,parent,false);

        TextView tvPhone=convertView.findViewById(R.id.tvPhone);
        TextView tvTime=convertView.findViewById(R.id.tvTime);

        HistoryCall hc=arrHis.get(position);
        tvPhone.setText(hc.getsPhoneNum());
        tvTime.setText(hc.getsTime());
        return convertView;
    }
}
