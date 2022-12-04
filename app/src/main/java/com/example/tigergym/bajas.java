package com.example.tigergym;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class bajas extends AppCompatActivity {
    EditText idus, nombre, edad, correo, usuario, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajas);
        nombre=findViewById(R.id.nombre);
        edad=findViewById(R.id.edad);
        correo=findViewById(R.id.correo);
        usuario=findViewById(R.id.usuario);
        password=findViewById(R.id.password);
        idus=findViewById(R.id.idus);
    }
    public void buscarUsuarios(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion3", null, 1);//Crear la clase
        SQLiteDatabase bd = admin.getWritableDatabase();
        String idusuario = idus.getText().toString();
        Cursor fila = bd.rawQuery("select usuario, password,nombre, edad, correo from usuarios where idU="+idusuario, null);
        if(fila.moveToFirst()){
            usuario.setText(fila.getString(0));
            password.setText(fila.getString(1));
            nombre.setText(fila.getString(2));
            edad.setText(fila.getString(3));
            correo.setText(fila.getString(4));

        }
        else{
            Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
            bd.close();
        }
    }
    public void bajasUsuarios(View view){
        //Construccion
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion3", null, 1);//Crear la clase
        SQLiteDatabase bd = admin.getWritableDatabase();
        String idusuario = idus.getText().toString();
        int cant = bd.delete("usuarios", "idU="+idusuario, null);
        if(cant==1){
            Toast.makeText(this, "Usuario Eliminado", Toast.LENGTH_SHORT).show();
            this.limpiar();
        }
        else{
            Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
        }
        bd.close();

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