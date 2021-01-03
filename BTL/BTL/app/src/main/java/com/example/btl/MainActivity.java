package com.example.btl;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLog;
    EditText etPhone,etPass;
    DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle("TIÊU ĐỀ ACTIVITY"); //Thiết lập tiêu đề nếu muốn
       // String title = actionBar.getTitle().toString(); //Lấy tiêu đề nếu muốn
        actionBar.hide(); //Ẩn ActionBar nếu muốn
        dbhelper = new DatabaseHelper(this);
        btnLog = findViewById(R.id.buttonLogIn);
        etPass = findViewById(R.id.editTextTextPasswordL);
        etPhone = findViewById(R.id.editTextPhoneL);

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = etPhone.getText().toString().trim();
                if (number.isEmpty() || number.length() < 10) {
                    etPhone.setError("Valid number is required");
                    etPhone.requestFocus();
                    return;
                }
                Account tmp = dbhelper.GetAcc(number);
                if(tmp!=null)
                {
                    if(tmp.getMK().equals(etPass.getText().toString())){
                        Intent intent = new Intent(MainActivity.this, TrangChu.class);
                        intent.putExtra("phonenumber", number);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Sai mật khẩu",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    //String num = number.substring(1,number.length()-1);
                    Intent intent = new Intent(MainActivity.this, DangKyActivity.class);
                    intent.putExtra("phonenumber", number);
                    startActivity(intent);
                }
            }
        });
    }
}