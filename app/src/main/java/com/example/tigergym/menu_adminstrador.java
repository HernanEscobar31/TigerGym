package com.example.tigergym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menu_adminstrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_adminstrador);
    }
    public void altasven(View view){
        Intent ven1 = new Intent(menu_adminstrador.this, altas.class);
        startActivity(ven1);

    }
    public void bajasven(View view){
        Intent ven2 = new Intent(menu_adminstrador.this, bajas.class);
        startActivity(ven2);

    }
    public void cambiosven(View view){
        Intent ven3 = new Intent(menu_adminstrador.this, cambios.class);
        startActivity(ven3);

    }
}