package com.example.tigergym;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    TextView nuevo;
    EditText password, usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nuevo=findViewById(R.id.nuevo);
        password=findViewById(R.id.pass);
        usuario=findViewById(R.id.user);

    }
    public void nuevoUser(View view){
        //Revisar que login y password sean iguales
        Intent v3 = new Intent(login.this, nuevoC.class);
        startActivity(v3);

    }
    public void ladmin(View view){
        //Revisar que login y password sean iguales
        Intent v1 = new Intent(login.this, loginAdmin.class);
        startActivity(v1);

    }
    public void sesion(View view){
        //Construccion
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion3", null, 1);//Crear la clase
        SQLiteDatabase bd = admin.getWritableDatabase();
        String p = password.getText().toString();
        String u = usuario.getText().toString();
        Cursor fila = bd.rawQuery("select usuario,password from usuarios where idU="+u,null);
        //Cursor fila = bd.rawQuery("select usuario,password from usuarios where usuario='"+u+"' and password='"+p+"'",null);
        try{

        if(fila.moveToFirst()) {
//capturamos los valores del cursos y lo almacenamos en variable
            //String usua = fila.getString(0);
            //if (usuario.equals(usua)){
                Intent v1=new Intent(login.this, menu_usuario.class);
                startActivity(v1);
                //limpiamos las las cajas de texto
                password.setText("");
                usuario.setText("");
            //}
        }
        else {
            Toast toast=Toast.makeText(this,"Datos incorrectos",Toast.LENGTH_LONG);
            toast.show();
        }
        } catch (Exception e) {//capturamos los errores que ubieran
            Toast toast=Toast.makeText(this,"Error en" + e.getMessage(),Toast.LENGTH_LONG);
            toast.show();
        }
    }

}