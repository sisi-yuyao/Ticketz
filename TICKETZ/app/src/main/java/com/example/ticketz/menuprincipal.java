package com.example.ticketz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class menuprincipal extends AppCompatActivity {

    Button calendario;
    Button conci;
    Button perfil;
    Button expo;
    Button furbo;
    Button logout;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);

        calendario = findViewById(R.id.calendario);
        calendario.setOnClickListener(view -> {
            intent = new Intent(getApplicationContext(), calendario.class);
            startActivity(intent);
        });

        conci = findViewById(R.id.conci);
        conci.setOnClickListener(view -> {
            intent = new Intent(getApplicationContext(), conci.class);
            startActivity(intent);
        });

        expo = findViewById(R.id.expo);
        expo.setOnClickListener(view -> {
            intent = new Intent(getApplicationContext(), expo.class);
            startActivity(intent);
        });

        furbo = findViewById(R.id.furbo);
        furbo.setOnClickListener(view -> {
            intent = new Intent(getApplicationContext(), furbo.class);
            startActivity(intent);
        });

        // ----------------- Botones barra superior -------------------

        perfil = findViewById(R.id.boton_perfil);
        perfil.setOnClickListener(view -> {
            intent = new Intent(getApplicationContext(), profile.class);
            startActivity(intent);
        });

        logout = findViewById(R.id.boton_logout);
        logout.setOnClickListener(view -> {
            intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });

        }
    }
