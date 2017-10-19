package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import model.Minicurso;

/**
 * Created by Nero on 16/10/2017.
 */

public class MinicursoDAO {


    private SQLiteDatabase db;
    private BancoDeDados bancoDeDados;
    private static int id;
    private static String NOME = "nome";
    private static String LOCAL = "local";
    private static String HORARIO = "horario";
    private static String PROFESSOR = "professor";
    private static String CARGA_HORARIA = "carga_horaria";
    private static String DATA = "data";

    public MinicursoDAO(Context context){
        this.bancoDeDados = new BancoDeDados(context);
    }

    public String inserirMinicurso(Minicurso minicurso){
        db = bancoDeDados.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(NOME, minicurso.getNome());
        valores.put(LOCAL, minicurso.getLocal());
        valores.put(HORARIO, minicurso.getHorario());
        valores.put(PROFESSOR, minicurso.getProfessor());
        valores.put(CARGA_HORARIA, minicurso.getCargaHoraria());
        valores.put(DATA, minicurso.getData());

        long resultado = db.insert(bancoDeDados.TABELA_MINICURSOS, null, valores);

        if(resultado == -1){
            return "ERRO AO INSERIR TRABALHO";
        }else {
            return "TRABALHO ADICIONADO COM SUCESSO";
        }
    }

    public ArrayList<Minicurso> listarMinicursos(){
        ArrayList<Minicurso> lista = new ArrayList<>();
        Cursor cursor = bancoDeDados.getReadableDatabase().query(BancoDeDados.TABELA_MINICURSOS,
                new String[]{NOME, LOCAL, HORARIO, PROFESSOR,CARGA_HORARIA,DATA},
                null,null,null,null,null);

        cursor.moveToFirst();
        do {
            Minicurso minicurso = new Minicurso(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
            lista.add(minicurso);
        }while(cursor.moveToNext());
        return lista;
    }

    public void exluirTudo(){
        db = bancoDeDados.getWritableDatabase();
        db.execSQL("delete from "+ BancoDeDados.TABELA_MINICURSOS);
    }

}
