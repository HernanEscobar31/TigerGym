package com.example.tigergym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class menu_usuario extends AppCompatActivity {
    TextView tscanner;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);
        tscanner=findViewById(R.id.tscanner);
        mAuth = FirebaseAuth.getInstance();
    }
    public void crearubicacion(View view){
        Intent i= new Intent(menu_usuario.this, ubicacionGPS.class);
        startActivity(i);
    }
    public void terminarsesion(View view){
        mAuth.signOut();
        startActivity(new Intent(menu_usuario.this, loginUFire.class));
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override public boolean onOptionsItemSelected(MenuItem opcion_menu){
     int id=opcion_menu.getItemId();

     if(id==R.id.ubicacion){
         crearubicacion(null);
         return true;
     }
        if(id==R.id.csesion){
            terminarsesion(null);
            return true;
        }
     return super.onOptionsItemSelected(opcion_menu);
    }

    public void irScanner(View view){

        Intent vscanner = new Intent(menu_usuario.this, scannerQR.class);
        startActivity(vscanner);

    }
}