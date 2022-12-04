package com.example.tigergym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class altas extends AppCompatActivity {
    EditText idus, nombre, edad, correo, usuario, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altas);
        nombre=findViewById(R.id.nombre);
        edad=findViewById(R.id.edad);
        correo=findViewById(R.id.correo);
        usuario=findViewById(R.id.usuario);
        password=findViewById(R.id.password);
        idus=findViewById(R.id.idus);
    }
    public void altasUsuarios(View view) {
        //Construccion
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion3", null, 1);//Crear la clase
        SQLiteDatabase bd = admin.getWritableDatabase();
        //Hacer alta
        String idu = idus.getText().toString();
        String u = usuario.getText().toString();
        String p = password.getText().toString();
        String n = nombre.getText().toString();
        String e = edad.getText().toString();
        String c = correo.getText().toString();
        ContentValues registro = new ContentValues();//Hacer una pila
        registro.put("idU", idu);
        registro.put("usuario", u);
        registro.put("password", p);
        registro.put("nombre", n);
        registro.put("edad", e);
        registro.put("correo", c);

        //Insertar los valores en la BD
        bd.insert("usuarios", null, registro);
        bd.close();//Se cierra para poder seguir registrando

        Toast.makeText(this, "Datos registrados con exito", Toast.LENGTH_SHORT).show();//Para mandar mensajes emergentes
        this.limpiar();//Metodo de limpiar
    }
    public void mlimpiar(View view){
        limpiar();
    }

    public void limpiar() {
        idus.setText("");
        nombre.setText("");
        edad.setText("");
        correo.setText("");
        usuario.setText("");
        password.setText("");
    }
    public void cerrar(View view) {
        finish();
    }


}