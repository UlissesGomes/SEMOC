package dao;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nero on 13/10/2017.
 */

public class BancoDeDados extends SQLiteOpenHelper{

    private static final String nome = "BANCO_DADOS_SEMOC";
    public static final String TABELA_TRABALHOS_APROVADOS = "trabalhos_aprovados";
    public static final String TABELA_MESAS = "mesas";
    public static final String TABELA_MINICURSOS = "minicursos";
    private static final int versao = 6;

    public BancoDeDados(Context context) {
        super(context, nome, null,versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABELA_TRABALHOS_APROVADOS+"(" +
                    "id integer primary key autoincrement, " +
                    "inscricao text not null," +
                    "titulo text not null, " +
                    "responsaveis text not null" +
                ")");

        db.execSQL("create table "+TABELA_MINICURSOS+"(" +
                "id integer primary key autoincrement, " +
                "nome text not null," +
                "local text not null, " +
                "horario text not null," +
                "professor text," +
                "carga_horaria text," +
                "data text not null" +
                ")");

        db.execSQL("create table "+TABELA_MESAS+"(" +
                "id integer primary key autoincrement, " +
                "data text not null," +
                "turno text not null, " +
                "horario text not null," +
                "eixo text," +
                "nome_mesa text not null," +
                "coordenador text not null," +
                "participantes text not null," +
                "local text not null" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABELA_TRABALHOS_APROVADOS);
        db.execSQL("DROP TABLE IF EXISTS "+TABELA_MINICURSOS);
        db.execSQL("DROP TABLE IF EXISTS "+TABELA_MESAS);
        onCreate(db);
    }
}
