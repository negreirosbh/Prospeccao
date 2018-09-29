package e.willamesnegreiros.prospeccao.model;

import java.io.Serializable;

public class Prospeccao implements Serializable {

    private String cidade;
    private Long nc;
    private Long nf;
    private String fases;
    private String disjuntor;
    private String leitura;
    private Integer disco;
    private Integer voltas;
    private String kdMedid;
    private String classe;
    private String atividade;
    private Long coordenadaX;
    private Long coordenadaY;
    private String acao;
    private String observacao;
    private String dt;
    private String hora;
    private String nomeFoto;
    private String estado;

    public Prospeccao(){

    }



    public Prospeccao(Long nc, String cidade, String dt, String hora) {
        this.nc = nc;
        this.cidade = cidade;
        this.dt = dt;
        this.hora = hora;

    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Long getNc() {
        return nc;
    }

    public void setNc(Long nc) {
        this.nc = nc;
    }

    public Long getNf() {
        return nf;
    }

    public void setNf(Long nf) {
        this.nf = nf;
    }

    public String getFases() {
        return fases;
    }

    public void setFases(String fases) {
        this.fases = fases;
    }

    public String getDisjuntor() {
        return disjuntor;
    }

    public void setDisjuntor(String disjuntor) {
        this.disjuntor = disjuntor;
    }

    public String getLeitura() {
        return leitura;
    }

    public void setLeitura(String leitura) {
        this.leitura = leitura;
    }

    public Integer getDisco() {
        return disco;
    }

    public void setDisco(Integer disco) {
        this.disco = disco;
    }

    public Integer getVoltas() {
        return voltas;
    }

    public void setVoltas(Integer voltas) {
        this.voltas = voltas;
    }

    public String getKdMedid() {
        return kdMedid;
    }

    public void setKdMedid(String kdMedid) {
        this.kdMedid = kdMedid;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public Long getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(Long coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public Long getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(Long coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNomeFoto() {
        return nomeFoto;
    }

    public void setNomeFoto(String nomeFoto) {
        this.nomeFoto = nomeFoto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
