package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText EmailAddressEditText, passwordEditText ;
    Button button5;
    Button button6;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EmailAddressEditText=findViewById(R.id.GirisEmailAddress);
        EmailAddressEditText=findViewById(R.id.GirisPassword);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);

        mAuth= FirebaseAuth.getInstance();
        button6.setOnClickListener(v -> {
            startActivity(new Intent(Login.this, Kayit.class));
            finish();
        });
        button5.setOnClickListener(v -> {
            String email =EmailAddressEditText.getText().toString();
            String password =passwordEditText.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(Login.this, "Lütfen Boş Alanları Doldurunuz", Toast.LENGTH_SHORT).show();
                return;

            }
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if (task.isSuccessful()){
                    Toast.makeText(Login.this, "Giriş Başarılı!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this,MainActivity2.class));
                    finish();
                }else{
                    Toast.makeText(Login.this, "Giriş Başarısız !!", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}