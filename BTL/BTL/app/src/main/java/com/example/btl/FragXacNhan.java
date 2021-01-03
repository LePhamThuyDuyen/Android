package com.example.btl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class FragXacNhan extends Fragment {
    private EditText etcode;
    private Button confirm;
    //
    private FirebaseAuth auth;
    private PhoneAuthOptions options;
    private String verificationIds;
    String PhoneNum = "";
    Account acc = new Account();

    DatabaseHelper dbhelper;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View frag = inflater.inflate(R.layout.fragment_verify_code,container,false);
        etcode = frag.findViewById(R.id.etCode_fvc);
        confirm = frag.findViewById(R.id.button_xacnhan_fvc);

        dbhelper = new DatabaseHelper(getContext());

        sendVerificationCode(PhoneNum);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = etcode.getText().toString().trim();

                if (code.isEmpty() || code.length() < 6) {

                    etcode.setError("Enter code...");
                    etcode.requestFocus();
                    return;
                }
                verifyCode(code);
            }
        });

        return frag;
    }
    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationIds, code);
        signInWithPhoneAuthCredential(credential);
//     credential.getSmsCode();

    }
    void sendVerificationCode(String num){
        auth = FirebaseAuth.getInstance();
        options = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(num)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(getActivity())
                .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(String verificationId,
                                           PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        // Save the verification id somewhere
                        // ...

                        // The corresponding whitelisted code above should be used to complete sign-in.
                        super.onCodeSent(verificationId, forceResendingToken);
                        verificationIds = verificationId;
                        //DangKyActivity.this.enableUserManuallyInputCode();
                    }

                    @Override
                    public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                        // Sign in with the credential
                        // ...
                        Toast.makeText(getContext(),phoneAuthCredential.getSmsCode(), Toast.LENGTH_LONG).show();
                        signInWithPhoneAuthCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(FirebaseException e) {
                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                        //editText.setText(e.getMessage());
                    }
                })
                .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        auth.signInWithCredential(credential).addOnCompleteListener(getActivity(),new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    if(dbhelper.InsertAcc(acc)>0)
                        Toast.makeText(getContext(), "đã lưu thành công", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getContext(), "đã lưu thất bại!!!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "Không xác nhận được mã", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
