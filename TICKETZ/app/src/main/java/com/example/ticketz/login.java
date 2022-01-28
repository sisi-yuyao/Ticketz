package com.example.ticketz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ticketz.databinding.ActivityLoginBinding;

public class login extends AppCompatActivity {

    private ActivityLoginBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      binding= ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot();
    }
}