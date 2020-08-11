package com.example.deliverol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    TextInputEditText ph,otp;
    Button genOtp,reg;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ph=findViewById(R.id.phNo);
        otp=findViewById(R.id.Otp);
        genOtp=findViewById(R.id.otp_btn);
        reg=findViewById(R.id.registerB);
        firebaseAuth=FirebaseAuth.getInstance();
        user=firebaseAuth.getCurrentUser();
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        genOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNO=ph.getText().toString();

                String compPhone="+91"+""+phoneNO;
                if(phoneNO.isEmpty())
                {
                    Toast.makeText(LoginActivity.this,"Pls enter the number",Toast.LENGTH_LONG).show();
                }
//                else {
//                    progressBar.setVisibility(View.VISIBLE);
//                    PhoneAuthProvider.getInstance().verifyPhoneNumber(compPhone,
//                            60,
//                            TimeUnit.SECONDS,
//                            LoginActivity.this,
//                            mCallbacks);
//                }
                else{
                    Intent intent=new Intent(LoginActivity.this,OtpActivity.class);
                    startActivity(intent);
                }
            }
        });
//        mCallbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//            @Override
//            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
//                signInWithPhone(phoneAuthCredential);
//            }
//
//            @Override
//            public void onVerificationFailed(FirebaseException e) {
//                Toast.makeText(LoginActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onCodeSent(final String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//                super.onCodeSent(s, forceResendingToken);
//                new android.os.Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        Intent sendOtp=new Intent(LoginActivity.this,OtpActivity.class);
//                        sendOtp.putExtra("AuthCredentials",s);
//                        startActivity(sendOtp);
//                    }
//                },10000);
//
//            }
//        };
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        if(user!=null){
//            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(intent);
//            finish();
//        }
//    }
//    private void signInWithPhone(PhoneAuthCredential phoneAuthCredential){
//        firebaseAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful()){
//                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
//                    startActivity(intent);
//                }
//                else {
//                    if(task.getException() instanceof FirebaseAuthInvalidCredentialsException){
//                        Toast.makeText(LoginActivity.this,"Error in Otp verification",Toast.LENGTH_LONG).show();
//                    }
//
//                }
//            }
//        });
//    }
}