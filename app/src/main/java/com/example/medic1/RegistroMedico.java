package com.example.medic1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroMedico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_medico);
    }

    // Metodo para los botones

    public void registrarMedico(View view){
        Intent vmain = new Intent(this, MainActivity.class);
        startActivity(vmain);
    }
}