package e.willamesnegreiros.prospeccao.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

import e.willamesnegreiros.prospeccao.model.Prospeccao;



public class ProspeccaoDAO implements IProspeccaoDAO {

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public ProspeccaoDAO(Context context) {
        DbHelper db = new DbHelper( context );
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Prospeccao prospeccao) {

        ContentValues cv = new ContentValues();
        cv.put("cidade", prospeccao.getCidade());
        cv.put("nc", prospeccao.getNc());
        cv.put("nf", prospeccao.getNf());
        cv.put("fases", prospeccao.getFases());
        cv.put("disjuntor", prospeccao.getDisjuntor());
        cv.put("leitura", prospeccao.getLeitura());
        cv.put("disco", prospeccao.getDisco());
        cv.put("volta", prospeccao.getVoltas());
        cv.put("kdMedid", prospeccao.getKdMedid());
        cv.put("classe", prospeccao.getClasse());
        cv.put("atividade", prospeccao.getAtividade());
        cv.put("coordenadaX", prospeccao.getCoordenadaX());
        cv.put("coordenadaY", prospeccao.getCoordenadaY());
        cv.put("acao", prospeccao.getAcao());
        cv.put("obs", prospeccao.getObservacao());
        cv.put("nomeFoto", prospeccao.getNomeFoto());
        cv.put("dt", prospeccao.getDt());
        cv.put("hora", prospeccao.getHora());
        cv.put("estado", prospeccao.getEstado());


        try {
            escreve.insert(DbHelper.TABELA_PROSPECCAO, null, cv );
            Log.i("INFO", "Tarefa salva com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao salvar tarefa " + e.getMessage() );
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Prospeccao prospeccao, String[] args ) {

        ContentValues cv = new ContentValues();
        cv.put("cidade", prospeccao.getCidade());
        cv.put("nc", prospeccao.getNc());
        cv.put("nf", prospeccao.getNf());
        cv.put("fases", prospeccao.getFases());
        cv.put("disjuntor", prospeccao.getDisjuntor());
        cv.put("leitura", prospeccao.getLeitura());
        cv.put("disco", prospeccao.getDisco());
        cv.put("volta", prospeccao.getVoltas());
        cv.put("kdMedid", prospeccao.getKdMedid());
        cv.put("classe", prospeccao.getClasse());
        cv.put("atividade", prospeccao.getAtividade());
        cv.put("coordenadaX", prospeccao.getCoordenadaX());
        cv.put("coordenadaY", prospeccao.getCoordenadaY());
        cv.put("acao", prospeccao.getAcao());
        cv.put("obs", prospeccao.getObservacao());
        cv.put("nomeFoto", prospeccao.getNomeFoto());
        cv.put("dt", prospeccao.getDt());
        cv.put("hora", prospeccao.getHora());
        cv.put("estado", prospeccao.getEstado());

        try {

            escreve.update(DbHelper.TABELA_PROSPECCAO,cv, "nc = ? AND dt = ? AND hora = ?", args);
            Log.i("INFO", "Tarefa atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizada tarefa " + e.getMessage() );
            return false;
        }

        return true;
    }

    @Override
    public boolean deletar(String[] args) {

        try {

            escreve.delete(DbHelper.TABELA_PROSPECCAO, "nc = ? AND dt = ? AND hora = ?", args );
            Log.i("INFO", "Tarefa removida com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao remover tarefa " + e.getMessage() );
            return false;
        }

        return true;
    }

    @Override
    public Prospeccao consulta(String[] args) {
        Prospeccao prospeccao = new Prospeccao();

        String sql = "SELECT * FROM " + DbHelper.TABELA_PROSPECCAO + " WHERE nc = ? AND dt = ? AND hora = ?;";
        Cursor c = le.rawQuery( sql, args );

        while ( c.moveToNext() )
        {
            Long id = c.getLong( c.getColumnIndex("id") );
            String cidade = c.getString(c.getColumnIndex("cidade"));
            Long nc = c.getLong(c.getColumnIndex("nc"));
            Long nf = c.getLong(c.getColumnIndex("nf"));
            String fases = c.getString(c.getColumnIndex("fases"));
            String disjuntor = c.getString(c.getColumnIndex("disjuntor"));
            String leitura = c.getString(c.getColumnIndex("leitura"));
            Integer disco = c.getInt(c.getColumnIndex("disco"));
            Integer voltas = c.getInt(c.getColumnIndex("volta"));
            String kdMedid = c.getString(c.getColumnIndex("kdMedid"));
            String classe = c.getString(c.getColumnIndex("classe"));
            String atividade = c.getString(c.getColumnIndex("atividade"));
            Long coordenadaX = c.getLong(c.getColumnIndex("coordenadaX"));
            Long coordenadaY = c.getLong(c.getColumnIndex("coordenadaY"));
            String acao = c.getString(c.getColumnIndex("acao"));
            String observacao = c.getString(c.getColumnIndex("obs"));
            String nomeFoto = c.getString(c.getColumnIndex("nomeFoto"));
            //String dt = c.getString(c.getColumnIndex("dt"));
            //String hora = c.getString(c.getColumnIndex("hora"));
            String estado = c.getString(c.getColumnIndex("estado"));

            prospeccao.setId(id);
            prospeccao.setCidade(cidade);
            prospeccao.setNc(nc);
            prospeccao.setNf(nf);
            prospeccao.setFases(fases);
            prospeccao.setDisjuntor(disjuntor);
            prospeccao.setLeitura(leitura);
            prospeccao.setDisco(disco);
            prospeccao.setVoltas(voltas);
            prospeccao.setKdMedid(kdMedid);
            prospeccao.setClasse(classe);
            prospeccao.setAtividade(atividade);
            prospeccao.setCoordenadaX(coordenadaX);
            prospeccao.setCoordenadaY(coordenadaY);
            prospeccao.setAcao(acao);
            prospeccao.setObservacao(observacao);
            prospeccao.setDt(args[1]);
            prospeccao.setHora(args[2]);
            prospeccao.setNomeFoto(nomeFoto);
            prospeccao.setEstado(estado);
        }


        return prospeccao;
    }

    @Override
    public List<Prospeccao> listar() {

        List<Prospeccao> prospeccoes = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_PROSPECCAO + " ;";
        Cursor c = le.rawQuery(sql, null);


        while ( c.moveToNext() ){

            Prospeccao prospeccao = new Prospeccao();

            Long id = c.getLong( c.getColumnIndex("id") );
            String cidade = c.getString(c.getColumnIndex("cidade"));
            Long nc = c.getLong(c.getColumnIndex("nc"));
            Long nf = c.getLong(c.getColumnIndex("nf"));
            String fases = c.getString(c.getColumnIndex("fases"));
            String disjuntor = c.getString(c.getColumnIndex("disjuntor"));
            String leitura = c.getString(c.getColumnIndex("leitura"));
            Integer disco = c.getInt(c.getColumnIndex("disco"));
            Integer voltas = c.getInt(c.getColumnIndex("volta"));
            String kdMedid = c.getString(c.getColumnIndex("kdMedid"));
            String classe = c.getString(c.getColumnIndex("classe"));
            String atividade = c.getString(c.getColumnIndex("atividade"));
            Long coordenadaX = c.getLong(c.getColumnIndex("coordenadaX"));
            Long coordenadaY = c.getLong(c.getColumnIndex("coordenadaY"));
            String acao = c.getString(c.getColumnIndex("acao"));
            String observacao = c.getString(c.getColumnIndex("obs"));
            String nomeFoto = c.getString(c.getColumnIndex("nomeFoto"));
            String dt = c.getString(c.getColumnIndex("dt"));
            String hora = c.getString(c.getColumnIndex("hora"));
            String estado = c.getString(c.getColumnIndex("estado"));

            prospeccao.setId(id);
            prospeccao.setCidade(cidade);
            prospeccao.setNc(nc);
            prospeccao.setNf(nf);
            prospeccao.setFases(fases);
            prospeccao.setDisjuntor(disjuntor);
            prospeccao.setLeitura(leitura);
            prospeccao.setDisco(disco);
            prospeccao.setVoltas(voltas);
            prospeccao.setKdMedid(kdMedid);
            prospeccao.setClasse(classe);
            prospeccao.setAtividade(atividade);
            prospeccao.setCoordenadaX(coordenadaX);
            prospeccao.setCoordenadaY(coordenadaY);
            prospeccao.setAcao(acao);
            prospeccao.setObservacao(observacao);
            prospeccao.setDt(dt);
            prospeccao.setHora(hora);
            prospeccao.setNomeFoto(nomeFoto);
            prospeccao.setEstado(estado);


            prospeccoes.add( prospeccao );
            //Log.i("prospeccaoDao", prospeccao.getNc().toString() );
        }

        return prospeccoes;

    }
}
