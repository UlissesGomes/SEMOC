package com.example.nero.semoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import model.Minicurso;

public class DetalheMinicurso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_minicurso);

        Intent intent = getIntent();
        Minicurso minicurso = (Minicurso) intent.getSerializableExtra("minicurso");

        TextView txtNome = (TextView) findViewById(R.id.nomeminicursodetalhe);
        TextView txtLocal = (TextView) findViewById(R.id.localminicursodetalhe);
        TextView txtData = (TextView) findViewById(R.id.dataminicursodetalhe);
        TextView txtHora = (TextView) findViewById(R.id.horaminicursodetalhe);
        TextView txtProf = (TextView) findViewById(R.id.professorminicursodetalhe);
        TextView txtCarga = (TextView) findViewById(R.id.cargaminicursodetalhe);

        txtNome.setText(minicurso.getNome());
        txtLocal.setText(minicurso.getLocal());
        txtData.setText(minicurso.getData());
        txtHora.setText(minicurso.getHorario());
        txtProf.setText(minicurso.getProfessor());
        txtCarga.setText(minicurso.getCargaHoraria());

    }
}
