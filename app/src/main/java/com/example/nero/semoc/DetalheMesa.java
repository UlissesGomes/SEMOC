package com.example.nero.semoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import model.Mesa;

public class DetalheMesa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_mesa);

        Intent intent = getIntent();
        Mesa mesa = (Mesa) intent.getSerializableExtra("mesa");

        TextView txtNome = (TextView) findViewById(R.id.nomemesadetalhe);
        TextView txtEixo = (TextView) findViewById(R.id.eixomesadetalhe);
        TextView txtLocal = (TextView) findViewById(R.id.localmesadetalhe);
        TextView txtData = (TextView) findViewById(R.id.datamesadetalhe);
        TextView txtHora = (TextView) findViewById(R.id.horamesadetalhe);
        TextView txtCoord = (TextView) findViewById(R.id.coordenadormesadetalhe);
        TextView txtPart = (TextView) findViewById(R.id.parcipantesmesadetalhe);

        txtNome.setText(mesa.getNomeMesa());
        txtEixo.setText(mesa.getEixo());
        txtLocal.setText(mesa.getLocal());
        txtData.setText(mesa.getData());
        txtHora.setText(mesa.getHorario() +" ("+mesa.getTurno()+")");
        txtCoord.setText(mesa.getCoordenador());
        txtPart.setText(mesa.getParticipantes());
    }
}
