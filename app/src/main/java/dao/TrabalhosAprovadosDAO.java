package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import model.TrabalhosAprovados;

/**
 * Created by Nero on 14/10/2017.
 */

public class TrabalhosAprovadosDAO {

    private SQLiteDatabase db;
    private BancoDeDados bancoDeDados;
    private static final String INSCRICAO = "inscricao";
    private static final String TITULO = "titulo";
    private static final String RESPONSAVEIS = "responsaveis";


    public TrabalhosAprovadosDAO(Context context){
        this.bancoDeDados = new BancoDeDados(context);
    }

    public String inserirTrabalho(TrabalhosAprovados trabalhos){
        db = bancoDeDados.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(INSCRICAO,trabalhos.getInscricao());
        valores.put(TITULO,trabalhos.getTitulo());
        valores.put(RESPONSAVEIS,trabalhos.getResponsaveis());

        long resultado = db.insert(bancoDeDados.TABELA_TRABALHOS_APROVADOS, null, valores);

        if(resultado == -1){
            return "ERRO AO INSERIR TRABALHO";
        }else {
            return "TRABALHO ADICIONADO COM SUCESSO";
        }
    }

    public ArrayList<TrabalhosAprovados> listarTrabalhos(){

        ArrayList<TrabalhosAprovados> lista = new ArrayList<>();
        Cursor cursor = bancoDeDados.getReadableDatabase().query(BancoDeDados.TABELA_TRABALHOS_APROVADOS,
                new String[]{INSCRICAO, TITULO, RESPONSAVEIS},
                null,null,null,null,null);

        cursor.moveToFirst();

        do {
            TrabalhosAprovados trab = new TrabalhosAprovados(cursor.getString(0),cursor.getString(1),cursor.getString(2));
            lista.add(trab);
        }while(cursor.moveToNext());
        return lista;
    }

    public void exluirTudo(){
        db = bancoDeDados.getWritableDatabase();
        db.execSQL("delete from "+ BancoDeDados.TABELA_TRABALHOS_APROVADOS);
    }

}
