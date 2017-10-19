package com.example.nero.semoc;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dao.MesaDAO;
import dao.MinicursoDAO;
import dao.TrabalhosAprovadosDAO;
import model.Mesa;
import model.Minicurso;
import model.TrabalhosAprovados;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class LerCSV extends AppCompatActivity {
    MesaDAO mesaDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ler_csv);
        mesaDAO = new MesaDAO(this);

        try {
            lerCSV();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void lerCSV() throws IOException{

        String linha = null;
        File arquivo = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+"/mesas_f.csv");

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo),"ISO-8859-1"));

        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(";");
            Mesa mesa = new Mesa(dados[0],dados[1],dados[2],dados[3],dados[4],dados[5],dados[6],dados[7]);
            mesaDAO.inserirMesa(mesa);
        }
        reader.close();
    }
}
