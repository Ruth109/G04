package com.example.g04.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g04.R;

public class ViewHolderTrabajador extends RecyclerView.ViewHolder {
    private TextView idTrabajador;
    private TextView nombreTrabajador;
    private TextView apellidoTrabajador;
    private TextView tipoTrabajador;
    private TextView salarioTrabajador;

    public ViewHolderTrabajador(@NonNull View itemView) {
        super(itemView);
        this.idTrabajador  = itemView.findViewById(R.id.txvId);
        this.nombreTrabajador  = itemView.findViewById(R.id.txvNombre);
        this.apellidoTrabajador  = itemView.findViewById(R.id.txvApellido);
        this.tipoTrabajador  = itemView.findViewById(R.id.txvTipo);
        this.salarioTrabajador  = itemView.findViewById(R.id.txvSalario);
    }

    public TextView getIdTrabajador() {
        return idTrabajador;
    }

    public TextView getNombreTrabajador() {
        return nombreTrabajador;
    }

    public TextView getApellidoTrabajador() {
        return apellidoTrabajador;
    }

    public TextView getTipoTrabajador() {
        return tipoTrabajador;
    }

    public TextView getSalarioTrabajador() {
        return salarioTrabajador;
    }
}
