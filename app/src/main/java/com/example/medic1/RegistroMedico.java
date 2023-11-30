package com.example.medic1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medic1.db.DbHelper;

public class RegistroMedico extends AppCompatActivity {

    private EditText et_nombres, et_apellidos, et_usuario, et_clave, et_confirmar, et_celular, et_correo, et_nacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_medico);

        et_nombres = (EditText) findViewById(R.id.txt_nombres);
        et_apellidos = (EditText) findViewById(R.id.txt_apellidos);
        et_usuario = (EditText) findViewById(R.id.txt_usuario);
        et_clave = (EditText) findViewById(R.id.txt_clave);
        et_confirmar = (EditText) findViewById(R.id.txt_confirm);
        et_celular = (EditText) findViewById(R.id.txt_celular);
        et_correo = (EditText) findViewById(R.id.txt_correo);
        et_nacimiento = (EditText) findViewById(R.id.txt_nacimiento);
    }

    // Metodo para los botones

    public void registrarMedico(View view){

        DbHelper admin = new DbHelper(this);
        SQLiteDatabase BD = admin.getWritableDatabase();

        String nombres = et_nombres.getText().toString();
        String apellidos = et_apellidos.getText().toString();
        String usuario = et_usuario.getText().toString();
        String clave = et_clave.getText().toString();
        String confirmar = et_confirmar.getText().toString();
        String celular = et_celular.getText().toString();
        String correo = et_correo.getText().toString();
        String nacimiento = et_nacimiento.getText().toString();

        if(!nombres.isEmpty() && !apellidos.isEmpty() && !usuario.isEmpty() && !clave.isEmpty() &&
           !confirmar.isEmpty() && !celular.isEmpty() && !correo.isEmpty() && !nacimiento.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("nombres", nombres);
            registro.put("apellidos", apellidos);
            registro.put("usuario", usuario);
            registro.put("contrasena", clave);
            registro.put("celular", celular);
            registro.put("correo", correo);
            registro.put("nacimiento", nacimiento);

            BD.insert("usuario", null, registro);
            BD.close();

            et_nombres.setText("");
            et_apellidos.setText("");
            et_usuario.setText("");
            et_clave.setText("");
            et_confirmar.setText("");
            et_celular.setText("");
            et_correo.setText("");
            et_nacimiento.setText("");

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }

    }

    public void obtenerMedico(View view){

        DbHelper admin = new DbHelper(this);
        SQLiteDatabase BD = admin.getWritableDatabase();

        String correo = "lol";
        Cursor medico = BD.rawQuery("Select * from usuario where correo ="+ correo, null);

        if(medico.moveToFirst()){
            String nombreM = medico.getString(1);
            Toast.makeText(this, ("Medico encontrado" + nombreM), Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, ("No se encontro el Medico"), Toast.LENGTH_SHORT).show();
        }
        BD.close();
    }

    public void eliminarMedico(View view){

        DbHelper admin = new DbHelper(this);
        SQLiteDatabase BD = admin.getWritableDatabase();

        String correo = "lol";
        int cantidad = BD.delete("usuario", "correo="+correo, null);
        BD.close();

        if(cantidad == 1){
            Toast.makeText(this, "Se elimino el medico", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "No Se elimino el medico", Toast.LENGTH_SHORT).show();
        }

    }

    public void actualizarMedico(View view){

        DbHelper admin = new DbHelper(this);
        SQLiteDatabase BD = admin.getWritableDatabase();

        String nombres = "douglas";
        String correo = "lol";

        ContentValues registro = new ContentValues();
        registro.put("nombres", nombres);

        int cantidad = BD.update("usuario", registro, "correo=" + correo, null);
        BD.close();

        if(cantidad == 1){
            Toast.makeText(this, "Actualizacion exitosa", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "No se actualizo", Toast.LENGTH_SHORT).show();
        }

    }




}






















