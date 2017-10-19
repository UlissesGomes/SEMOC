package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import model.Mesa;

/**
 * Created by Nero on 16/10/2017.
 */

public class MesaDAO {

    private SQLiteDatabase db;
    private BancoDeDados bancoDeDados;
    private static final String DATA = "data";
    private static final String TURNO = "turno";
    private static final String HORARIO= "horario";
    private static final String EIXO = "eixo";
    private static final String NOME_MESA = "nome_mesa";
    private static final String COORDENADOR = "coordenador";
    private static final String PARTICIPANTES = "participantes";
    private static final String LOCAL = "local";

    public MesaDAO(Context context){
        this.bancoDeDados = new BancoDeDados(context);
    }

    public String inserirMesa(Mesa mesa){
        db = bancoDeDados.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(DATA, mesa.getData());
        valores.put(TURNO, mesa.getTurno());
        valores.put(HORARIO, mesa.getHorario());
        valores.put(EIXO, mesa.getEixo());
        valores.put(NOME_MESA, mesa.getNomeMesa());
        valores.put(COORDENADOR, mesa.getCoordenador());
        valores.put(PARTICIPANTES, mesa.getParticipantes());
        valores.put(LOCAL, mesa.getLocal());

        long resultado = db.insert(bancoDeDados.TABELA_MESAS, null, valores);

        if(resultado == -1){
            return "ERRO AO INSERIR TRABALHO";
        }else {
            return "TRABALHO ADICIONADO COM SUCESSO";
        }
    }

    public ArrayList<Mesa> listarMesas(){
        ArrayList<Mesa> lista = new ArrayList<>();
        Cursor cursor = bancoDeDados.getReadableDatabase().query(BancoDeDados.TABELA_MESAS,
                new String[]{DATA,TURNO,HORARIO,EIXO,NOME_MESA,COORDENADOR,PARTICIPANTES,LOCAL},
                null,null,null,null,null);

        cursor.moveToFirst();
        do {
            Mesa mesa = new Mesa(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7));
            lista.add(mesa);
        }while(cursor.moveToNext());
        return lista;
    }
    public void exluirTudo(){
        db = bancoDeDados.getWritableDatabase();
        db.execSQL("delete from "+ BancoDeDados.TABELA_MESAS);
    }
}
