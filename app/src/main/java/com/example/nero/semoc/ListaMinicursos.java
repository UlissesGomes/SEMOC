package com.example.nero.semoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import dao.MinicursoDAO;
import model.Minicurso;
import model.MinicursoAdapter;

public class ListaMinicursos extends AppCompatActivity {

    private MinicursoDAO dao;
    private ListView listView;
    private MinicursoAdapter adapter;
    private ArrayList<Minicurso> listaMinicursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_minicursos);
        dao = new MinicursoDAO(this);
        listaMinicursos = new ArrayList<>();
        listaMinicursos = dao.listarMinicursos();
        listView = (ListView) findViewById(R.id.listaMinicursos);
        adapter = new MinicursoAdapter(this, listaMinicursos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Minicurso minicurso = (Minicurso) parent.getItemAtPosition(position);
                Intent intent = new Intent(ListaMinicursos.this, DetalheMinicurso.class);
                intent.putExtra("minicurso", minicurso);
                startActivity(intent);
            }
        });
    }
}
