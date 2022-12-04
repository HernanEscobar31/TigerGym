package com.example.tigergym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class loginAdmin extends AppCompatActivity {
    String lo = "HernanEscobar", password="12345";
    EditText user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        user=findViewById(R.id.user);
        pass=findViewById(R.id.pass);
    }
    public void sesionAdmin(View view){
        //Revisar que login y password sean iguales
        Intent v4 = new Intent(loginAdmin.this, menu_adminstrador.class);
        String l=user.getText().toString();//Se declaran las variables
        String p=pass.getText().toString();
        if(lo.equals(l) && password.equals(p)){//Con variables
            startActivity(v4);
        }
        else{
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}