package com.example.nero.semoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import dao.MesaDAO;
import model.Mesa;
import model.MesaAdapter;

public class ListaMesas extends AppCompatActivity {

    private  ListView listView;
    private ArrayList<Mesa> listaMesas;
    private MesaDAO dao;
    private MesaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mesas);
        dao = new MesaDAO(this);

        listaMesas = new ArrayList<>();
        listaMesas = dao.listarMesas();
        listView = (ListView) findViewById(R.id.listaMesas);
        adapter = new MesaAdapter(this, listaMesas);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Mesa mesa = (Mesa) parent.getItemAtPosition(position);
                Intent intent = new Intent(ListaMesas.this, DetalheMesa.class);
                intent.putExtra("mesa", mesa);
                startActivity(intent);
            }
        });

    }
}
