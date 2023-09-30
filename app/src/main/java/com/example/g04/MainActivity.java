package com.example.g04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.g04.clases.Trabajador;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnIrAgregar, btnIrMostrar, btnIrAcercaDe;
    public static ArrayList<Trabajador> lstTrabajadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstTrabajadores = new ArrayList<Trabajador>();
        btnIrAgregar = findViewById(R.id.btnAgregar);
        btnIrMostrar = findViewById(R.id.btnMostrarLista);
        btnIrAcercaDe = findViewById(R.id.btnAcercaDe);

        btnIrAgregar.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ElegirTipoTrabajadorActivity.class));
        });

        btnIrMostrar.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MostrarListaActivity.class));
        });

        btnIrAcercaDe.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AcercaDeActivity.class));
        });

    }
}