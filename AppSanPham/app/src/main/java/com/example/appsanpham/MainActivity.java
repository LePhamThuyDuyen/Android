package com.example.appsanpham;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = getSupportActionBar();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        khoiTao();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            DanhSachSanPham danhSachSanPham = new DanhSachSanPham();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle("Danh sách sản phẩm");
                    Intent a = new Intent(MainActivity.this , DanhSachSanPham.class);
                    startActivity(a);
                    return true;
                case R.id.navigation_Proflie:
                    toolbar.setTitle("Thông tin cá nhân");
                    Intent b = new Intent(MainActivity.this , ThongTinCaNhan.class);
                    startActivity(b);
                    return true;
                case R.id.navigation_ShoppingCard:

                    toolbar.setTitle("Giỏ hàng");
                    return true;
            }
            return false;
        }
    };

    void khoiTao()

    {
        DataHelper db = new DataHelper(this);
        db.InsertSP(new SanPham("111","Hoa Hồng rung động","Hoa hong bo",R.drawable.a1,12,1000000),1);
        db.InsertSP(new SanPham("112","Hoa Yêu thương","Hoa hong bo",R.drawable.a2,12,150000),2);
        db.InsertSP(new SanPham("113","Hoa Tình bạn","Hoa hong bo",R.drawable.a3,13,1500000),3);
        db.InsertSP(new SanPham("114","Hoa Chân thành","Hoa hong bo",R.drawable.a4,11,1000000),4);
        db.InsertSP(new SanPham("115","Hoa Tỏ tình","Hoa hong bo",R.drawable.a5,11,1000000),5);
        db.InsertSP(new SanPham("116","Hoa Mộng mơ","Hoa hong bo",R.drawable.a6,11,1000000),6);
        db.InsertSP(new SanPham("117","Hoa Chúc mừng ","Hoa hong bo",R.drawable.a7,11,1000000),7);

    }
}


