package com.example.tigergym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class crearCuentaU extends AppCompatActivity {
    EditText editnombre, editcorreo, editpass, editedad;
    Button btnRegistrar;
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    private String nameUser = "";
    private String coUser = "";
    private String passUser = "";
    private String edadUser = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta_u);
        editnombre = findViewById(R.id.editnombre);
        editcorreo = findViewById(R.id.editcorreo);
        editpass = findViewById(R.id.editpass);
        editedad = findViewById(R.id.editedad);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameUser = editnombre.getText().toString();
                coUser = editcorreo.getText().toString();
                passUser = editpass.getText().toString();
                edadUser = editedad.getText().toString();

                if(nameUser.isEmpty() && coUser.isEmpty() && passUser.isEmpty() && edadUser.isEmpty()){
                    Toast.makeText(crearCuentaU.this, "Complete los datos", Toast.LENGTH_SHORT).show();

                }else{
                    registrarUsuarios();
                }
            }
        });


    }

    private void registrarUsuarios(){
        mAuth.createUserWithEmailAndPassword(coUser, passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Map<String, Object> map = new HashMap<>();
                    map.put("nombre", nameUser);
                    map.put("correo", coUser);
                    map.put("contraseña", passUser);
                    map.put("edad", edadUser);
                    String id = mAuth.getCurrentUser().getUid();
                    mDatabase.child("User").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if(task2.isSuccessful()){
                                Toast.makeText(crearCuentaU.this, "Registrado con exito", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(crearCuentaU.this, loginUFire.class));
                                finish();
                            }else{
                                Toast.makeText(crearCuentaU.this, "No se pudo registrar", Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
                }
                else{
                    Toast.makeText(crearCuentaU.this, "No se pudo crear los datos", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

}
