package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBManager extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME="QUANLISINHVIEN";
    private static final String TABLE_NAME="tblSINHVIEN";
    private static final String maSV="iMaSV";
    private static final String tenSV="sHoTen";
    private static final String sdtSV="sSDT";
    private static final String diachiSV="sDiaChi";
    private static final String emailSV="sEmail";
    private static final int version=1;

    private String create_table="CREATE TABLE "+TABLE_NAME+" ("+
            maSV+" integer primary key AUTOINCREMENT, "+
            tenSV+" TEXT, "+
            sdtSV+" TEXT, "+
            diachiSV+ " TEXT, "+
            emailSV+ " TEXT)";
    public DBManager(@Nullable Context context) {
        super(context, DATABASE_NAME, null, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addSinhVien(SinhVien sv){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(tenSV,sv.getsHoTen());
        values.put(sdtSV,sv.getsSDT());
        values.put(diachiSV,sv.getsDiaChi());
        values.put(emailSV,sv.getsEmail());

        db.insert(TABLE_NAME,null,values);
        db.close();
        Toast.makeText(context, "Lưu thành công", Toast.LENGTH_SHORT).show();
    }
}
