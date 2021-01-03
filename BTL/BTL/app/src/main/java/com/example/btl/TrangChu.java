package com.example.btl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TrangChu extends AppCompatActivity {
    private ActionBar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        toolbar = getSupportActionBar();
        String phonenumber = getIntent().getStringExtra("phonenumber");
        toolbar.setTitle("Thông tin cá nhân");
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        KhoiTao();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Frag_DanhSachSanPham frag_danhSachSanPham = new Frag_DanhSachSanPham();


            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    toolbar.setTitle("Thông tin cá nhân");
                    return true;
                case R.id.navigation_listSP:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, frag_danhSachSanPham, "dssp").commit();
                    toolbar.setTitle("Danh sách sản phẩm");
                    return true;
                case R.id.navigation_shoppingcard:

                    toolbar.setTitle("Giỏ hàng");
                    return true;
                return false;
            }
        }

        ;

        void KhoiTao() {
            DatabaseHelper db = new DatabaseHelper(this);
            db.InsertPro(new Product("Lamington siêu hấp dẫn", 120000, 10, R.drawable.lamington, "Siêu ngon hấp dẫn", "Thòi gian đặt trước là 2 ngày cho 5 bánh"), 5);
            db.InsertPro(new Product("Lamington siêu hấp dẫn", 120000, 10, R.drawable.lamington1, "Siêu ngon hấp dẫn", "Thòi gian đặt trước là 2 ngày cho 5 bánh"), 6);
            db.InsertPro(new Product("Lamington siêu ngon", 120000, 10, R.drawable.lamington2, "Siêu ngon hấp dẫn", "Thòi gian đặt trước là 2 ngày cho 5 bánh"), 7);
            db.InsertPro(new Product("Lamington siêu ngon", 120000, 10, R.drawable.lamington3, "Siêu ngon hấp dẫn", "Thòi gian đặt trước là 2 ngày cho 5 bánh"), 8);
            db.InsertPro(new Product("Lamington siêu ngon", 120000, 10, R.drawable.lamington4, "Siêu ngon hấp dẫn", "Thòi gian đặt trước là 2 ngày cho 5 bánh"), 9);
        }
    }
}