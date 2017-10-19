package com.example.nero.semoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import dao.TrabalhosAprovadosDAO;
import model.TrabalhosAprovados;
import model.TrabalhosAprovadosAdapter;

public class ListaTrabalhos extends AppCompatActivity {

    private TrabalhosAprovadosDAO dao;
    private ListView listView;
    private TrabalhosAprovadosAdapter adapter;
    private ArrayList<TrabalhosAprovados> listaTrabalhos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_trabalhos);
        dao = new TrabalhosAprovadosDAO(this);
        listaTrabalhos = new ArrayList<>();

        listaTrabalhos = dao.listarTrabalhos();
        listView = (ListView) findViewById(R.id.listaTrabalhosID);
        adapter = new TrabalhosAprovadosAdapter(this, listaTrabalhos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TrabalhosAprovados trabalho = (TrabalhosAprovados) parent.getItemAtPosition(position);
                Intent intent = new Intent(ListaTrabalhos.this, DetalheTrabalhos.class);
                intent.putExtra("trabalho", trabalho);
                startActivity(intent);
            }
        });

    }
}
