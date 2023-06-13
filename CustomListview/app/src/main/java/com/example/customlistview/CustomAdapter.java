package com.example.customlistview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<User> {
    private Context context;
    private int resource;
    private ArrayList<User> arrUser;
    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<User> arrUser) {
        super(context, resource, arrUser);
        this.context=context;
        this.resource=resource;
        this.arrUser=arrUser;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.listview_item,parent,false);

        TextView tvAva= convertView.findViewById(R.id.tvAva);
        TextView tvName=convertView.findViewById(R.id.tvName);
        TextView tvPhone=convertView.findViewById(R.id.tvPhone);

        User user= arrUser.get(position);
        tvAva.setBackgroundColor(user.getNumber());
        tvAva.setText((position+1)+"");
        tvName.setText(user.getName());
        tvPhone.setText(user.getPhone());


        return convertView;
    }

}
