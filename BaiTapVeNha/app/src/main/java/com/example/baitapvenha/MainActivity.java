package com.example.baitapvenha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView ig1, ig2, ig3;
    Button bt_ran, bt_NM, bt_TD;
    TextView tv_kq,bt_end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ig1 = findViewById(R.id.imageView1);
        ig2 = findViewById(R.id.imageView2);
        ig3 = findViewById(R.id.imageView3);
        bt_ran = findViewById(R.id.bt_ran);
        tv_kq = findViewById(R.id.tx_kq);
        bt_NM = findViewById(R.id.bt_May);
        bt_TD=findViewById(R.id.bt_tudong);
        bt_end = findViewById(R.id.bt_Back);

        ig3.setImageResource(R.drawable.up);
        ig2.setImageResource(R.drawable.up);
       ig1.setImageResource(R.drawable.up);


    bt_NM.setOnClickListener(new View.OnClickListener() {
    @Override
         public void onClick(View view) {
              Intent nm = new Intent(MainActivity.this,Nguoi_May.class);
                 startActivity(nm);
         }
    });
        bt_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    bt_TD.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent td = new Intent(MainActivity.this,Tudong.class);
            startActivity(td);
        }
    });
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
                Random a = new Random();
                // int hinh;
                int tong = 0;

                int b1, b2, b3;
                do {
                    b1 = a.nextInt(52);// tra ve int random tu 0-51
                    b2 = a.nextInt(52);
                    b3 = a.nextInt(52);
                }

                while (b1 == b2 || b2 == b3 || b3 == b1);
                ig1.setTag(baiCao[b1]);// gan gia tri
                ig1.setImageResource(baiCao[b1]);
//                ig3.setImageResource(R.drawable.sj);
//                ig2.setImageResource(R.drawable.cj);
//                ig1.setImageResource(R.drawable.dj);
                ig2.setTag(baiCao[b2]);
                ig2.setImageResource(baiCao[b2]);
                ig3.setTag(baiCao[b3]);
               ig3.setImageResource(baiCao[b3]);

                tong+=soNut(Integer.parseInt(ig1.getTag().toString()));
                tong+=soNut(Integer.parseInt(ig2.getTag().toString()));
                tong+=soNut(Integer.parseInt(ig3.getTag().toString()));

              int dem =0;
                    dem += batay(tay, Integer.parseInt(ig1.getTag().toString()));
                    dem += batay(tay, Integer.parseInt(ig2.getTag().toString()));
                    dem += batay(tay, Integer.parseInt(ig3.getTag().toString()));


                 if(dem == 3)
                     tv_kq.setText("Ba tây nha");
                 else
                     tv_kq.setText("Nút:"+tong%10);


            }


        });
    }

    public static int batay(int a[], int x) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] == x)
                return 1;

        }
        return -1;
    }

    public static  int soNut(int n) {
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