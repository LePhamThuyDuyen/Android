package com.example.appsanpham;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class ThongTinCaNhan extends AppCompatActivity {
    TextView txt_hoTen, txt_mk, txt_sdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_ca_nhan);
        txt_hoTen= findViewById(R.id.txt_HoTen);
        txt_mk=findViewById(R.id.txt_mk);
        txt_sdt=findViewById(R.id.txt_sdt);
    }
}