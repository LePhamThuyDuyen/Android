package com.example.bai_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText ed_F, ed_C;
Button bt_FtoC, btCtoF;
Button bt_Clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_C = (EditText) findViewById(R.id.ed_C);
        ed_F = (EditText) findViewById(R.id.ed_F);

        bt_FtoC = (Button) findViewById(R.id.FtoC);
        bt_FtoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int F = Integer.parseInt(ed_F.getText().toString());
                float kq = (float) ((F-32)*((5.0)/9));
                ed_C.setText(String.valueOf(kq));

            }
        });

        btCtoF = (Button) findViewById(R.id.CtoF);
        btCtoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int C= Integer.parseInt(ed_C.getText().toString());
                float kq = (float)(C*9/(5.0)+32);
                ed_F.setText(String.valueOf(kq));
            }
        });
    bt_Clear =(Button) findViewById(R.id.Clear);
    bt_Clear.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ed_F.getText().clear();
            ed_C.getText().clear();
        }
    });

    }
}