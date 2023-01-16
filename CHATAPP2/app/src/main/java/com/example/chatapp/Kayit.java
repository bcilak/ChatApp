package com.example.chatapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Kayit extends AppCompatActivity {
    EditText EmailAddressEditText, passwordEditText ;
    Button button3;
    Button button4;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        EmailAddressEditText=findViewById(R.id.EmailAddress);
        passwordEditText=findViewById(R.id.Password);

        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        mAuth = FirebaseAuth.getInstance();

        button4.setOnClickListener(v->{
            startActivity(new Intent(Kayit.this , Login.class));
            finish();
        });
        button3.setOnClickListener(v -> {
            String email= EmailAddressEditText.getText().toString();
            String password =passwordEditText.getText().toString();
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(Kayit.this, "Lütfen Bu Alanları Doldurunuz !!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (password.length() < 6) {
                Toast.makeText(Kayit.this, "Şifreniz En Az 6 Karakter Olmalıdır !!", Toast.LENGTH_SHORT).show();
                return;
            }
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(Kayit.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Kayit.this, MainActivity2.class));
                    finish();
                }else {
                    Toast.makeText(Kayit.this, "Kayıt Başarısız!!", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}