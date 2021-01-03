package com.example.btl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class DangKyActivity extends AppCompatActivity{
    Button btDangKy;
    EditText etPass,etConf,etDiaChi;
    FrameLayout frag;
    FragXacNhan fragXacNhan;
    TextView tvSDT;
    int p,con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        btDangKy = findViewById(R.id.buttonDK);
        etPass = findViewById(R.id.editTextTextPassword_DK);
        etConf = findViewById(R.id.editTextConfirmPassword_DK);
        etDiaChi = findViewById(R.id.editTextTextPostalAddress);
        frag = findViewById(R.id.fragVerify_DK);
        tvSDT = findViewById(R.id.textViewSDT_DK);
        String phonenumber = getIntent().getStringExtra("phonenumber");
        tvSDT.setText(phonenumber);
        btDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = etPass.getText().toString();
                String conf = etConf.getText().toString();
                String dia = etDiaChi.getText().toString();
                if (pass.isEmpty()) {
                    etPass.setError("Không được trống");
                    etPass.requestFocus();
                    return;
                }
                if (conf.isEmpty()) {
                    etConf.setError("Không được trống");
                    etConf.requestFocus();
                    return;
                }
                if (dia.isEmpty()) {
                    etDiaChi.setError("Không được trống");
                    etDiaChi.requestFocus();
                    return;
                }
                if(!pass.equals(conf)){
                    Toast.makeText(DangKyActivity.this,"Mật khẩu và xác nhận mật khẩu không khớp",Toast.LENGTH_LONG).show();
                    return;
                }
                fragXacNhan = new FragXacNhan();
                fragXacNhan.PhoneNum = "+84"+phonenumber;
                fragXacNhan.acc.setDiaChi(etDiaChi.getText().toString());
                fragXacNhan.acc.setMK(etPass.getText().toString());
                fragXacNhan.acc.setSDT(phonenumber);
                getSupportFragmentManager().beginTransaction().add(R.id.fragVerify_DK,fragXacNhan,"verify_DK").commit();
            }
        });
    }
}