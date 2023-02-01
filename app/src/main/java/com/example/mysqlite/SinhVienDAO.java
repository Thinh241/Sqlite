package com.example.mysqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {
    private SQLiteDatabase db;
    private MySqlite dbHelper;
    private Context context;

    public SinhVienDAO(Context context) {
        this.context = context;
        dbHelper = new MySqlite(context);//tao database
        db = dbHelper.getWritableDatabase();//cho phep ghi du lieu vao database
    }

    //Them du lieu
    public int ThemSinhVien (SinhVien sv){
        ContentValues contentValues = new ContentValues();//tao doi tuong chua du lieu
        //Dua du lieu vao doi tuong chua
        contentValues.put("masv", sv.getMasv());
        contentValues.put("tensv", sv.getTensv());
        contentValues.put("tuoi", String.valueOf(sv.getTuoi()));
        //thuc thi them
        long kq = db.insert("svien", null, contentValues);
        //kiem tra ket qua
        if(kq<=0){
            return -1;
        }
        return 1;
    }

    public int XoaSinhVien (String masv){
        int kq = db.delete("svien", "masv=?", new String[]{masv});
        if(kq<=0){
            return -1;
        }
        return 1;
    }

    public int SuaSinhVien (SinhVien sv){
        ContentValues contentValues = new ContentValues();
        contentValues.put("masv", sv.getMasv());
        contentValues.put("tensv", sv.getTensv());
        contentValues.put("tuoi", String.valueOf(sv.getTuoi()));


        long kq = db.update("svien",contentValues,"masv=?",new String[]{sv.getMasv()});

        if(kq<=0){
            return -1;
        }
        return 1;
    }

    //Hien thi du lieu dang String
    public List<String> SinhvientoString(){
        List<String> ls = new ArrayList<>();//tao danh sach rong
        //Tao con tro doc bang du lieu
        Cursor c = db.query("svien",null, null, null, null, null, null);
        c.moveToFirst();

        while (c.isAfterLast()==false){
            SinhVien sv1 = new SinhVien();//tao doi tuong chua du lieu
            sv1.setMasv(c.getString(0));//doc du lieu truong masv dua vao doi tuong
            sv1.setTensv(c.getString(1));
            sv1.setTuoi(c.getInt(2));
            //Chuyen doi tuong thanh chuoi
            String chuoi = sv1.getMasv()+" - "+sv1.getTensv()+" - "+sv1.getTuoi();
            ls.add(chuoi);//dua chuoi vao list
            c.moveToNext();
        }
        c.close();
        return ls;
    }
}
