package com.example.btl;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private ActionBar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String ma = getIntent().getStringExtra("id");
        toolbar = getSupportActionBar();
        toolbar.setTitle("Chi tiết sản phẩm");

        ImageView img = findViewById(R.id.imageView_DP);
        TextView tvName = findViewById(R.id.textViewName_DP);
        TextView tvGia = findViewById(R.id.textViewGia_DP);
        TextView tvSL = findViewById(R.id.textViewNoteSL_DP);
        TextView tvNote = findViewById(R.id.textViewnote_DP);
        TextView tvMota = findViewById(R.id.textViewMoTa_DP);
        Button btnBuy = findViewById(R.id.buttonMua_DP);

        DatabaseHelper db = new DatabaseHelper(this);

        Product product = db.getProDetail(Integer.parseInt(ma));

        img.setImageResource(product.getAnh());
        if(product.getSol()>0)
            tvSL.setText("Hiện có: "+product.getSol());
        else
            tvSL.setText("Tạm hết hàng");
        tvGia.setText(String.valueOf(product.getGia()));
        tvName.setText(product.getName());
        tvNote.setText(product.getGhiChu());
        tvMota.setText(product.getMoTa());

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}