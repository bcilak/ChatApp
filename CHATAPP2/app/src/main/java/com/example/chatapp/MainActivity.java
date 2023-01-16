package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;



public class MainActivity extends AppCompatActivity  {

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button2).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, Kayit.class));
        });
        findViewById(R.id.button).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, Login.class));

        });
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser()!=null){
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
            //finish();
            Toast.makeText(MainActivity.this, "Yönlendiriliyorsunuz !!", Toast.LENGTH_SHORT).show();
        }


    }


}

