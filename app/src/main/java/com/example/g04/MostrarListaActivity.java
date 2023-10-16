package com.example.g04;
import static com.example.g04.MainActivity.lstTrabajadores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.g04.adapters.TrabajadorAdapter;
import com.example.g04.databinding.ActivityMostrarListaBinding;

public class MostrarListaActivity extends AppCompatActivity {

    private ActivityMostrarListaBinding binding;
    private TrabajadorAdapter trabajadorAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMostrarListaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Toast.makeText(this, "DATOS: " + lstTrabajadores, Toast.LENGTH_SHORT).show();
        //Configurando adaptador
        trabajadorAdapter = new TrabajadorAdapter(lstTrabajadores);
        layoutManager = new LinearLayoutManager(this);
        binding.rcvTrabajadores.setAdapter(trabajadorAdapter);
        binding.rcvTrabajadores.setLayoutManager(layoutManager);
        binding.rcvTrabajadores.setHasFixedSize(true);
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