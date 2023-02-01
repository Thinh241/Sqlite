package com.example.mysqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySqlite extends SQLiteOpenHelper {

    //Tao bang sinh vien
    private static final String SQL_SINHVIEN = "CREATE TABLE svien (" +
            "masv TEXT PRIMARY KEY, " +
            "tensv TEXT, " +
            "tuoi TEXT )";

    private static final String SQL_DELETE_SV = "DROP TABLE IF EXISTS svien";

    public MySqlite(@Nullable Context context) {
        super(context, "QLSV.db", null, 1);
    }
    //Tao bang du lieu
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_SINHVIEN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_SV);//Xoa bang cu, tao bang moi
    }

}
