package com.example.baitapvenha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Nguoi_May extends AppCompatActivity {
    ImageView ig1, ig2, ig3, ig4, ig5, ig6;
    TextView tv_N, tv_M;
    Button bt_ran ;
    int dem = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi__may);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        ig1 = findViewById(R.id.imageView1);
        ig2 = findViewById(R.id.imageView2);
        ig3 = findViewById(R.id.imageView3);
        ig4 = findViewById(R.id.imageView4);
        ig5 = findViewById(R.id.imageView5);
        ig6 = findViewById(R.id.imageView6);
        tv_M = findViewById(R.id.tx_kqMay);
        tv_N = findViewById(R.id.tx_kqNguoi);
        bt_ran = findViewById(R.id.bt_ran);


        ig3.setImageResource(R.drawable.up);
        ig2.setImageResource(R.drawable.up);
        ig1.setImageResource(R.drawable.up);
        ig4.setImageResource(R.drawable.up);
        ig5.setImageResource(R.drawable.up);
        ig6.setImageResource(R.drawable.up);


        final int[] baiCao = {

                R.drawable.c1,
                R.drawable.c2,
                R.drawable.c3,
                R.drawable.c4,
                R.drawable.c5,
                R.drawable.c6,
                R.drawable.c7,
                R.drawable.c8,
                R.drawable.c9,
                R.drawable.c10,
                R.drawable.cj,
                R.drawable.cq,
                R.drawable.ck,

                R.drawable.h1,
                R.drawable.h2,
                R.drawable.h3,
                R.drawable.h4,
                R.drawable.h5,
                R.drawable.h6,
                R.drawable.h7,
                R.drawable.h8,
                R.drawable.h9,
                R.drawable.h10,
                R.drawable.hj,
                R.drawable.hq,
                R.drawable.hk,

                R.drawable.d1,
                R.drawable.d2,
                R.drawable.d3,
                R.drawable.d4,
                R.drawable.d5,
                R.drawable.d6,
                R.drawable.d7,
                R.drawable.d8,
                R.drawable.d9,
                R.drawable.d10,
                R.drawable.dj,
                R.drawable.dq,
                R.drawable.dk,

                R.drawable.s1,
                R.drawable.s2,
                R.drawable.s3,
                R.drawable.s4,
                R.drawable.s5,
                R.drawable.s6,
                R.drawable.s7,
                R.drawable.s8,
                R.drawable.s9,
                R.drawable.s10,
                R.drawable.sj,
                R.drawable.sq,
                R.drawable.sk,

        };

        final int[] tay = {
                R.drawable.sj,
                R.drawable.sq,
                R.drawable.sk,

                R.drawable.cj,
                R.drawable.cq,
                R.drawable.ck,

                R.drawable.hj,
                R.drawable.hq,
                R.drawable.hk,

                R.drawable.dj,
                R.drawable.dq,
                R.drawable.dk
        };

        bt_ran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random ran = new Random();
                dem++;

                int b1, b2, b3, b4, b5, b6;
                int kqMay = 0, kqNguoi = 0;

                do {
                    b1 = ran.nextInt(52);
                    b2 = ran.nextInt(52);
                    b3 = ran.nextInt(52);
                    b4 = ran.nextInt(52);
                    b5 = ran.nextInt(52);
                    b6 = ran.nextInt(52);

                }

                while (b1 == b2 || b1 == b3 || b1 == b4 || b1 == b5 || b1 == b6 ||
                        b2 == b3 || b2 == b4 || b2 == b5 || b2 == b6 ||
                        b3 == b4 || b3 == b5 || b3 == b6 || b4 == b5 || b4 == b6 || b5 == b6);
                // phan may
                int may = 0;
                ig1.setImageResource(baiCao[b1]);
                ig1.setTag(baiCao[b1]);
                ig2.setImageResource(baiCao[b2]);
                ig2.setTag(baiCao[b2]);
                ig3.setImageResource(baiCao[b3]);
                ig3.setTag(baiCao[b3]);

                kqMay += soNut(Integer.parseInt(ig1.getTag().toString()));
                kqMay += soNut(Integer.parseInt(ig2.getTag().toString()));
                kqMay += soNut(Integer.parseInt(ig3.getTag().toString()));

                int demMay = 0;
                demMay += batay(tay, Integer.parseInt(ig1.getTag().toString()));
                demMay += batay(tay, Integer.parseInt(ig2.getTag().toString()));
                demMay += batay(tay, Integer.parseInt(ig3.getTag().toString()));
                // tv_M.setText("Ban la ba tay");
                //  may = 1;


                if (demMay == 3)

                    tv_M.setText("Ban la ba tay");
                else
                    tv_M.setText("Diem:" + kqMay%10);

                int nguoi = 0;
                // phan nguoi
                ig4.setImageResource(baiCao[b4]);
                ig4.setTag(baiCao[b4]);
                ig5.setImageResource(baiCao[b5]);
                ig5.setTag(baiCao[b5]);
                ig6.setImageResource(baiCao[b6]);
                ig6.setTag(baiCao[b6]);

                kqNguoi += soNut(Integer.parseInt(ig4.getTag().toString()));
                kqNguoi += soNut(Integer.parseInt(ig5.getTag().toString()));
                kqNguoi += soNut(Integer.parseInt(ig6.getTag().toString()));

                int demNguoi = 0;
                demNguoi += batay(tay, Integer.parseInt(ig4.getTag().toString()));
                demNguoi += batay(tay, Integer.parseInt(ig5.getTag().toString()));
                demNguoi += batay(tay, Integer.parseInt(ig6.getTag().toString()));
                //nguoi = 1;

                if (demNguoi == 3)

                    tv_N.setText("Ban la ba tay");
                else
                    tv_N.setText("Diem:" + kqNguoi % 10);


                if (kqMay%10 > kqNguoi%10) {
                    may++;
                } else if (kqMay%10 < kqNguoi%10) {
                    nguoi++;
                }



                if (dem == 3) {
                    AlertDialog.Builder mydialog = new AlertDialog.Builder(Nguoi_May.this);
                    if (may<nguoi)
                        mydialog.setTitle("Bạn WIN");
                    else if (may>nguoi)
                        mydialog.setTitle("Máy WIN");

                    else
                        mydialog.setTitle("Hòa");
                    AlertDialog alertDialog = mydialog.create();
                    alertDialog.show();
                   // finish();
                }

            }

        });



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static int batay(int a[], int x) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] == x)
                return 1;

        }
        return -1;
    }

    public static int soNut(int n) {
        switch (n) {

            case R.drawable.c1:
            case R.drawable.d1:
            case R.drawable.h1:
            case R.drawable.s1:
                return 1;

            case R.drawable.c2:
            case R.drawable.d2:
            case R.drawable.h2:
            case R.drawable.s2:
                return 2;
            //    break;
            case R.drawable.c3:
            case R.drawable.d3:
            case R.drawable.h3:
            case R.drawable.s3:
                return 3;
            //    break;
            case R.drawable.c5:
            case R.drawable.d5:
            case R.drawable.h5:
            case R.drawable.s5:
                return 5;
            //     break;

            case R.drawable.c6:
            case R.drawable.d6:
            case R.drawable.h6:
            case R.drawable.s6:
                return 6;
            //  break;

            case R.drawable.c7:
            case R.drawable.d7:
            case R.drawable.h7:
            case R.drawable.s7:
                return 7;
            //    break;

            case R.drawable.c4:
            case R.drawable.d4:
            case R.drawable.h4:
            case R.drawable.s4:
                return 4;
            //  break;

            case R.drawable.c8:
            case R.drawable.d8:
            case R.drawable.h8:
            case R.drawable.s8:
                return 8;
            //   break;

            case R.drawable.c9:
            case R.drawable.d9:
            case R.drawable.h9:
            case R.drawable.s9:
                return 9;
            // break;
            default:
                return 10;


        }
    }

}