package com.example.mysqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText t_masv, t_tensv, t_tuoisv;
    Button bt_them, bt_sua, bt_xoa, bt_hienthi;
    ListView lv_sv;
    ArrayAdapter<String> arrayAdapter;
    SinhVienDAO sinhVienDAO;
    List<String> list = new ArrayList<>();//tao list rong
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t_masv = findViewById(R.id.masinhvien);
        t_tensv = findViewById(R.id.tensinhvien);
        t_tuoisv = findViewById(R.id.tuoi);

        bt_them = findViewById(R.id.them);
        bt_sua = findViewById(R.id.sua);
        bt_xoa = findViewById(R.id.xoa);
        bt_hienthi = findViewById(R.id.hienthi);

        lv_sv = findViewById(R.id.listview_sv);
        context = this;
        //hien thi du lieu khi chay chuong trinh
        list.clear();
        sinhVienDAO = new SinhVienDAO(context);//tao CSDL va bang du lieu
        list = sinhVienDAO.SinhvientoString();
        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,list);
        lv_sv.setAdapter(arrayAdapter);

        bt_hienthi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.clear();
                sinhVienDAO = new SinhVienDAO(MainActivity.this);
                list = sinhVienDAO.SinhvientoString();
                arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,list);
                lv_sv.setAdapter(arrayAdapter);
            }
        });

        bt_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinhVien sv = new SinhVien();//tao doi tuong chua du lieu nhap
                //Dua du lieu vao doi tuong
                sv.setMasv(t_masv.getText().toString());
                sv.setTensv(t_tensv.getText().toString());
                sv.setTuoi(Integer.parseInt(t_tuoisv.getText().toString()));
                //goi ham them
                int kq = sinhVienDAO.ThemSinhVien(sv);
                if(kq==-1){
                    Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                }
                if(kq==1){
                    Toast.makeText(context, "Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinhVien sv = new SinhVien();
                sv.setMasv(t_masv.getText().toString());
                sv.setTensv(t_tensv.getText().toString());
                sv.setTuoi(Integer.parseInt(t_tuoisv.getText().toString()));

                int kq = sinhVienDAO.SuaSinhVien(sv);
                if(kq==-1){
                    Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                }
                if(kq==1){
                    Toast.makeText(context, "Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String masv = t_masv.getText().toString();

                int kq = sinhVienDAO.XoaSinhVien(masv);
                if(kq==-1){
                    Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                }
                if(kq==1){
                    Toast.makeText(context, "Successful", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

}