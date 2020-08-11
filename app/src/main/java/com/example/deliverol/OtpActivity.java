package com.example.deliverol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class OtpActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser CurrentUser;
    String mAuthCredentials;
    TextInputEditText Otp;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        mAuth=FirebaseAuth.getInstance();
        Otp=findViewById(R.id.Otp);
        login=findViewById(R.id.login);
        CurrentUser=mAuth.getCurrentUser();
        mAuthCredentials=getIntent().getStringExtra("AuthCredentials");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp=Otp.getText().toString();
//                PhoneAuthCredential credential= PhoneAuthProvider.getCredential(mAuthCredentials,otp);
//                signInWithPhone(credential);
                if(otp.equals("1234")){
                    Intent intent=new Intent(OtpActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(OtpActivity.this,"Wrong otp",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
//    private void signInWithPhone(PhoneAuthCredential phoneAuthCredential){
//        mAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful()){
//                    Intent intent=new Intent(OtpActivity.this,MainActivity.class);
//                    startActivity(intent);
//                }
//                else {
//                    if(task.getException() instanceof FirebaseAuthInvalidCredentialsException){
//                        Toast.makeText(OtpActivity.this,"Error in Otp verification",Toast.LENGTH_LONG).show();
//                    }
//
//                }
//            }
//        });
//    }
}