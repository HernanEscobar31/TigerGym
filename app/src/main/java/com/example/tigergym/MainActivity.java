package com.example.tigergym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click=findViewById(R.id.click);
    }
    public void sesion(View view){
        //Revisar que login y password sean iguales
        Intent v1 = new Intent(MainActivity.this, loginUFire.class);
        //view.setAction(Intent.ACTION_VIEW);
        //view.setData(Uri.parse());
        startActivity(v1);

    }
}