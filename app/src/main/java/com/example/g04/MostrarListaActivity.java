package com.example.g04;
import static com.example.g04.MainActivity.lstTrabajadores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.g04.adapters.TrabajadorAdapter;

public class MostrarListaActivity extends AppCompatActivity {

    private TrabajadorAdapter trabajadorAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Toast.makeText(this, "DATOS: " + lstTrabajadores, Toast.LENGTH_SHORT).show();
        trabajadorAdapter = new TrabajadorAdapter(lstTrabajadores);
        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.rcvTrabajadores);
        recyclerView.setAdapter(trabajadorAdapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
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