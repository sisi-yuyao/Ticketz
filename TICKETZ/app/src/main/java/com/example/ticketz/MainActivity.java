
package com.example.ticketz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




public void siguiente_registro(View view) {

    Intent intent = new Intent(this, registro.class);
    startActivity(intent);
}


    public void siguiente_login(View view) {

        Intent intent1 = new Intent(this, login.class);
        startActivity(intent1);
    }



}
