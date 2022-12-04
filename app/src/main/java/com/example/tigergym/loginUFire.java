package com.example.tigergym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginUFire extends AppCompatActivity {
    TextView newCuenta;
    EditText edcorreo, edcontraseña;
    Button btnlogin;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ufire);
        mAuth = FirebaseAuth.getInstance();
        newCuenta = findViewById(R.id.newCuenta);
        edcorreo = findViewById(R.id.edcorreo);
        edcontraseña = findViewById(R.id.edcontraseña);
        btnlogin = findViewById(R.id.btnlogin);

        newCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginUFire.this, crearCuentaU.class));
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailUser = edcorreo.getText().toString().trim();
                String passUser = edcontraseña.getText().toString().trim();

                if(emailUser.isEmpty() && passUser.isEmpty()){
                    Toast.makeText(loginUFire.this, "Ingresar los datos", Toast.LENGTH_SHORT).show();
                }
                else{
                    loginUser(emailUser, passUser);

                }
            }
        });
    }
    private void loginUser(String emailUser, String passUser) {
        mAuth.signInWithEmailAndPassword(emailUser, passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    finish();
                    startActivity(new Intent(loginUFire.this, menu_usuario.class));
                    Toast.makeText(loginUFire.this, "Bienvenido", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(loginUFire.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(loginUFire.this, "Error al iniciar sesion", Toast.LENGTH_SHORT).show();
            }
        });
    }

}