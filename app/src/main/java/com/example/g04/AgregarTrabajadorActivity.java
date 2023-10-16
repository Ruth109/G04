package com.example.g04;
import static com.example.g04.MainActivity.lstTrabajadores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.g04.clases.TrabajadorHora;
import com.example.g04.clases.TrabajadorTiempoCompleto;
import com.example.g04.databinding.ActivityAgregarTrabajadorBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AgregarTrabajadorActivity extends AppCompatActivity {

    private ActivityAgregarTrabajadorBinding binding;
    private Bundle bundle;
    private int idEleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAgregarTrabajadorBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        bundle = getIntent().getExtras();
        idEleccion = bundle.getInt("tipoEleccion");

        if(idEleccion == 1){
             binding.txtLyoutSalario.setVisibility(View.GONE);
        }else{
            binding.txtLyoutValor.setVisibility(View.GONE);
            binding.txtLyoutHoras.setVisibility(View.GONE);
        }

        binding.btnProcesar.setOnClickListener(v -> {
            if(idEleccion == 1){
                AgregarTrabajadorHora();
            }else{
                AgregarTrabajadorTiempoCompleto();
            }
            new AlertDialog.Builder(this).setMessage("Insertado con éxito").setPositiveButton("Ok", (dialog, which) -> finish()).show();
        });
    }

    private void AgregarTrabajadorTiempoCompleto(){
        if(binding.edtId.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar un ID", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtNombre.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar un nombre", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtApellido.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar un apellido", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtEdad.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar la edad", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtSalario.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el salario", Toast.LENGTH_SHORT).show();
            return;
        }

        lstTrabajadores.add(
                new TrabajadorTiempoCompleto(
                        binding.edtId.getText().toString(),
                        binding.edtNombre.getText().toString(),
                        binding.edtApellido.getText().toString(),
                        Float.valueOf(binding.edtSalario.getText().toString())
                )
        );
    }

    private void AgregarTrabajadorHora(){
        if(binding.edtId.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar un ID", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtNombre.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar un nombre", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtApellido.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar un apellido", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtEdad.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar la edad", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtValor.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar un ID", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtHoras.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar un ID", Toast.LENGTH_SHORT).show();
            return;
        }

        lstTrabajadores.add(
                new TrabajadorHora(
                        binding.edtId.getText().toString(),
                        binding.edtNombre.getText().toString(),
                        binding.edtApellido.getText().toString(),
                        Integer.parseInt(binding.edtHoras.getText().toString()),
                        Float.valueOf(binding.edtValor.getText().toString())
                )
        );
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