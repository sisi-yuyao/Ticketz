package com.example.ticketz;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ticketz.databinding.ActivityRegistroBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registro extends AppCompatActivity {

    private ActivityRegistroBinding binding;
    private String email= "", password= "";
    FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        binding= ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth= FirebaseAuth.getInstance();

        progressDialog= new ProgressDialog(this);
        progressDialog.setTitle("espere por favor");
        progressDialog.setMessage("creando cuenta");
        progressDialog.setCanceledOnTouchOutside(false);

        binding.boton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                validateData();


            }
        });
}

            private void validateData() {
            
        //get data
                email=binding.correo.getText().toString().trim();
                password=binding.contraseA.getText().toString().trim();
                
                //validar data
                
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    binding.correo.setError("email invalido");
                }else if (TextUtils.isEmpty(password)){
                    binding.contraseA.setError("introduce la contraseña");
                    
                }else if(password.length()<6){
                    binding.correo.setError("la contraseña tiene que ser mayor de 6");
                    
                }else{
                    firebaseSignup();
                }
                    
                    
                    
                }

    private void firebaseSignup() {
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {

            @Override
            public void onSuccess(AuthResult authResult) {
                progressDialog.dismiss();
                FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
                String email = firebaseUser.getEmail();
                Toast.makeText(registro.this,"cuenta creada\n"+email, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(registro.this, menuprincipal.class));
            finish();
            }
        })
.addOnFailureListener(new OnFailureListener() {
    @Override
    public void onFailure(@NonNull Exception e) {

        progressDialog.dismiss();
        Toast.makeText(registro.this,""+e.getMessage(), Toast.LENGTH_SHORT).show();

    }
});

    }


}

}    