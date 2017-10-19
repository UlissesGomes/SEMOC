package com.example.nero.semoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextSwitcher;
import android.widget.TextView;

import model.TrabalhosAprovados;

public class DetalheTrabalhos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        Intent intent = getIntent();
        TrabalhosAprovados trab = (TrabalhosAprovados) intent.getSerializableExtra("trabalho");

        TextView titulo = (TextView) findViewById(R.id.titulodetalhe);
        TextView inscricao = (TextView) findViewById(R.id.inscricaodetalhe);
        TextView responsaveis = (TextView) findViewById(R.id.responsaveisdetalhe);

        titulo.setText(" "+trab.getTitulo());
        inscricao.setText(" "+trab.getInscricao());
        responsaveis.setText(" "+trab.getResponsaveis());

    }
}
