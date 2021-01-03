package com.example.bai_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Button bt_chuyen;
    ArrayAdapter<CharSequence> adapter;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = (Spinner) findViewById(R.id.spin);
        //Lấy giá trị của mảng "day" trong file string.xml bằng lệnh sau ("R.array.day" là tên mảng giá trị trong file string)
        adapter = ArrayAdapter.createFromResource(this, R.array.day, android.R.layout.simple_spinner_item);
        //set các giá trị vào spinner
        sp.setAdapter(adapter);

        bt_chuyen=findViewById(R.id.bt_chuyen);

        bt_chuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();


            }
        });
    }
    public  void showAlertDialog(){
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        //Thiết lập tiêu đề
              b.setTitle("Xác nhận");
              b.setMessage("Bạn có đồng ý thoát chương trình không?");
        // Nút Ok
                b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        //Nút Cancel
              b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                   dialog.cancel();
            }
        });
        //Tạo dialog
         AlertDialog al = b.create();
        //Hiển thị
         al.show();
    }


}