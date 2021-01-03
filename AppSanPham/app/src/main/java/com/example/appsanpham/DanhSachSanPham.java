package com.example.appsanpham;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DanhSachSanPham extends AppCompatActivity {
    TextView txtTen, txtGia;
    Button btnTim;
    EditText deTim;
    RecyclerView listView;
    DataHelper db;
    ArrayList<SanPham> Array_sanPhams;
    SanPhamAdapter sanPhamAdapter;
    AdapterRec adap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_san_pham);

       txtGia=findViewById(R.id.txt_Gia);
        txtTen=findViewById(R.id.txt_Tensp);
        btnTim=findViewById(R.id.btnTim);
        listView = findViewById(R.id.list_View);
        db =new DataHelper(this);

        Array_sanPhams = new ArrayList<SanPham>();
        Array_sanPhams = db.getAllSP();
        adap = new AdapterRec(Array_sanPhams,this);

listView.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL,false));
//
//        sanPhamAdapter = new SanPhamAdapter(Array_sanPhams,DanhSachSanPham.this);
//        ArrayAdapter listSP;
//         listSP=new ArrayAdapter
//                (this, android.R.layout.simple_list_item_1,Array_sanPhams);
         listView .setAdapter(adap);







    }

}