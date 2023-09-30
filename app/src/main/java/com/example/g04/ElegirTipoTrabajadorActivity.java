package com.example.g04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;

public class ElegirTipoTrabajadorActivity extends AppCompatActivity {

    RadioButton rbTH, rbTC;
    Button btnSiguiente;
    private Bundle bundle;
    private int idEleccion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_tipo_trabajador);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        rbTH = findViewById(R.id.rgTH);
        rbTC = findViewById(R.id.rgTC);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        rbTH.setOnClickListener(view -> idEleccion =1);
        rbTC.setOnClickListener(view -> idEleccion = 2);

        btnSiguiente.setOnClickListener(view -> {
            bundle = new Bundle();
            bundle.putInt("tipoEleccion", idEleccion);
            Intent intent = new Intent(this, AgregarTrabajadorActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}