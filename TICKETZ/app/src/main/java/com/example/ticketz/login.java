package com.example.ticketz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ticketz.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    private ActivityLoginBinding binding;

    //actionbar
    private ActionBar actionBar;
    private String email="";
    private String password="";

    private ProgressDialog progressDialog;

    //firebase auth
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        actionBar = getSupportActionBar();
        actionBar.setTitle("login");


        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("please wait");
        progressDialog.setMessage("loggin in");
        progressDialog.setCanceledOnTouchOutside(false);


        firebaseAuth = FirebaseAuth.getInstance();
        checkUser();

        //si tienes cuenta clicka aqui
        binding.tengocuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, registro.class));

            }

        });
        binding.botonIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validate data
                validateData();
            }
        });

    }
        private void checkUser() {
FirebaseUser firebaseUser= firebaseAuth.getCurrentUser();
if(firebaseUser!=null){
    startActivity(new Intent(this,menuprincipal.class));
    finish();


}

        }



        private void validateData(){
                // get data

        email= binding.textoIn.getText().toString().trim();
            password= binding.contraseAIn.getText().toString().trim();

          //validate data

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
               binding.user.setError("email invalido");


            }else if (TextUtils.isEmpty(password)){
                binding.contraseAIn.setError("introduce la contraseña");

            }else{
                firebaselogin();
            }







        }







    private void firebaselogin() {
    //show progresss
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
            //login success
                //get user info
                FirebaseUser firebaseUser= firebaseAuth.getCurrentUser();
                String email=firebaseUser.getEmail();
                Toast.makeText(login.this, "loggedin\n"+email,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(login.this, menuprincipal.class));
                finish();

            }
        })
.addOnFailureListener(new OnFailureListener() {
    @Override
    public void onFailure(@NonNull Exception e) {
            //login failed get and show error message
        progressDialog.dismiss();
        Toast.makeText(login.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();

    }
});


    }
}





