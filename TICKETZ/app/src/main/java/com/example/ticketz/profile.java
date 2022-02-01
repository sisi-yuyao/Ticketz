package com.example.ticketz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ticketz.databinding.ActivityProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class profile extends AppCompatActivity {


     private ActivityProfileBinding binding;
     private ActionBar actionBar;
     private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_profile);

        actionBar=getSupportActionBar();
        actionBar.setTitle("login");

            firebaseAuth=FirebaseAuth.getInstance();
            checkUser();

            binding.botonLogout.setOnClickListener(new View.OnClickListener() {
                @Override

            public void onClick(View v){
                    firebaseAuth.signOut();
                    checkUser();

                }

        });


    }

    private void checkUser() {
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser==null){

            startActivity(new Intent(this, login.class));
            finish();
        }else{

String email= firebaseUser.getEmail();
            binding.emailtv.setText(email);


        }

    }
}