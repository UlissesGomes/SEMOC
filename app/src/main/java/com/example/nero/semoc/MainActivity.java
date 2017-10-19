package com.example.nero.semoc;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import dao.MesaDAO;
import dao.TrabalhosAprovadosDAO;
import model.TrabalhosAprovados;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.sobre:
                Intent intent1 = new Intent(MainActivity.this, Sobre.class);
                startActivity(intent1);
                break;
            case R.id.mesas:
                Intent intent3 = new Intent(MainActivity.this, ListaMesas.class);
                startActivity(intent3);
                break;
            case R.id.trabalhos_aprovados:
                Intent intent = new Intent(MainActivity.this, ListaTrabalhos.class);
                startActivity(intent);
                break;
            case R.id.minicursos:
                Intent intent2 = new Intent(MainActivity.this, ListaMinicursos.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
