package com.example.g04;
import static com.example.g04.MainActivity.lstTrabajadores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.g04.clases.TrabajadorHora;
import com.example.g04.clases.TrabajadorTiempoCompleto;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AgregarTrabajadorActivity extends AppCompatActivity {

    private Button btnAgregar;
    private TextInputEditText edtSalario, edtId, edtNombre, edtApellido, edtEdad, edtValor, edtHoras;
    private TextInputLayout txlySalario, txlyValor, txlyHoras;
    private Bundle bundle;
    private int idEleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_trabajador);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnAgregar = findViewById(R.id.btnProcesar);
        edtSalario = findViewById(R.id.edtSalario);
        edtId = findViewById(R.id.edtId);
        edtNombre = findViewById(R.id.edtNombre);
        edtApellido = findViewById(R.id.edtApellido);
        edtEdad = findViewById(R.id.edtEdad);
        edtValor = findViewById(R.id.edtValor);
        edtHoras = findViewById(R.id.edtHoras);

        txlySalario = findViewById(R.id.txtLyoutSalario);
        txlyValor = findViewById(R.id.txtLyoutValor);
        txlyHoras = findViewById(R.id.txtLyoutHoras);


        bundle = getIntent().getExtras();
        idEleccion = bundle.getInt("tipoEleccion");

        if(idEleccion == 1){
            txlySalario.setVisibility(View.GONE);
        }else{
            txlyValor.setVisibility(View.GONE);
            txlyHoras.setVisibility(View.GONE);
        }

        btnAgregar.setOnClickListener(view -> {
            if(idEleccion == 1){
                AgregarTrabajadorHora();
            }else{
                AgregarTrabajadorTiempoCompleto();
            }
            new AlertDialog.Builder(this).setMessage("Insertado con éxito").setPositiveButton("Ok", (dialog, which) -> finish()).show();
        });
    }

    private void AgregarTrabajadorTiempoCompleto(){
        if(edtId.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar un ID", Toast.LENGTH_SHORT).show();
            return;
        }
        if(edtNombre.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar un nombre", Toast.LENGTH_SHORT).show();
            return;
        }
        if(edtApellido.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar un apellido", Toast.LENGTH_SHORT).show();
            return;
        }
        if(edtEdad.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar la edad", Toast.LENGTH_SHORT).show();
            return;
        }
        if(edtSalario.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el salario", Toast.LENGTH_SHORT).show();
            return;
        }

        lstTrabajadores.add(
                new TrabajadorTiempoCompleto(
                        edtId.getText().toString(),
                        edtNombre.getText().toString(),
                        edtApellido.getText().toString(),
                        Float.valueOf(edtSalario.getText().toString())
                )
        );
    }

    private void AgregarTrabajadorHora(){
        if(edtId.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar un ID", Toast.LENGTH_SHORT).show();
            return;
        }
        if(edtNombre.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar un nombre", Toast.LENGTH_SHORT).show();
            return;
        }
        if(edtApellido.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar un apellido", Toast.LENGTH_SHORT).show();
            return;
        }
        if(edtEdad.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar la edad", Toast.LENGTH_SHORT).show();
            return;
        }
        if(edtValor.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar un ID", Toast.LENGTH_SHORT).show();
            return;
        }
        if(edtHoras.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar un ID", Toast.LENGTH_SHORT).show();
            return;
        }

        lstTrabajadores.add(
                new TrabajadorHora(
                        edtId.getText().toString(),
                        edtNombre.getText().toString(),
                        edtApellido.getText().toString(),
                        Integer.parseInt(edtHoras.getText().toString()),
                        Float.valueOf(edtValor.getText().toString())
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