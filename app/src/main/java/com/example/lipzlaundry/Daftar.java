package com.example.lipzlaundry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class Daftar extends AppCompatActivity implements View.OnClickListener {
    private Button kedaftar;
    private EditText mNamaPengguna, mKataSandi, mEmail, mNotelpon;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        mNamaPengguna = findViewById(R.id.namapengguna);
        mKataSandi = findViewById(R.id.katasandi);
        mEmail = findViewById(R.id.email);
        mNotelpon = findViewById(R.id.notelpon);

        mAuth = FirebaseAuth.getInstance();

        kedaftar = (Button) findViewById(R.id.daftar);
        kedaftar.setOnClickListener(this);

        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
    }

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

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Daftar.this, "User Berhasil Dibuat , CEK EMAIL ANDA", Toast.LENGTH_SHORT).show();
                                mEmail.setText("");
                                mKataSandi.setText("");
                                mNamaPengguna.setText("");
                                mNotelpon.setText("");
                            } else {
                                Toast.makeText(Daftar.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(Daftar.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public void masuk(View view) {
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}
