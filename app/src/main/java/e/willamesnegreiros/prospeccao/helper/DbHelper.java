package e.willamesnegreiros.prospeccao.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jamiltondamasceno
 */

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NOME_DB = "DB_PROSPECCAO";
    public static String TABELA_PROSPECCAO = "prospeccao";

    public DbHelper(Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_PROSPECCAO
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " nc INTEGER NOT NULL," +
                    " nf INTEGER," +
                    " fases TEXT," +
                    " disjuntor TEXT," +
                    " leitura TEXT," +
                    " disco INTEGER," +
                    " volta INTEGER," +
                    " kdMedid TEXT," +
                    " classe TEXT," +
                    " atividade TEXT," +
                    " coordenadaX TEXT," +
                    " coordenadaY TEXT," +
                    " acao TEXT," +
                    " obs TEXT," +
                    " nomeFoto TEXT," +
                    " estado TEXT); ";

        try {
            db.execSQL( sql );
            Log.i("INFO DB", "Sucesso ao criar a tabela" );
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage() );
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS " + TABELA_PROSPECCAO + " ;" ;

        try {
            db.execSQL( sql );
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualizar App" );
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao atualizar App" + e.getMessage() );
        }

    }

}
