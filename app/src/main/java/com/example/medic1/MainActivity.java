package com.example.medic1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Metodos de los botones
    public void abrirVistaMedico(View view){
        Intent vmedico = new Intent(this, RegistroMedico.class);
        startActivity(vmedico);
    }
}