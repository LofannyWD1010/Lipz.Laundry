package com.example.lipzlaundry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    private Button kelogin;
    private EditText mEmail, mKataSandi;
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.email2);
        mKataSandi = findViewById(R.id.katasandi2);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        kelogin = (Button) findViewById(R.id.masuk);
        kelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mKataSandi.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email Harus Diisi.");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mKataSandi.setError("Kata Sandi Harus Diisi.");
                    return;
                }
                if (password.length() < 6) {
                    mKataSandi.setError("Kata Sandi Harus Lebih Dari 6 Huruf");
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            if (mAuth.getCurrentUser().isEmailVerified()) {
                                startActivity(new Intent(Login.this, MainActivity.class));
                                finish();
                            } else {
                                Toast.makeText(Login.this, "Tolong Verifikasi Email Anda" , Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Login.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
    public void daftar(View view) {
        startActivity(new Intent(getApplicationContext(), Daftar.class));
        finish();
    }
}