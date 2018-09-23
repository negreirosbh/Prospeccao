package e.willamesnegreiros.prospeccao.model;

public class Prospeccao {
    private String nc;
    private String cidade;
    private String dt;
    private String hora;

    public Prospeccao(){


    }

    public Prospeccao(String nc, String cidade, String dt, String hora) {
        this.nc = nc;
        this.cidade = cidade;
        this.dt = dt;
        this.hora = hora;

    }

    public String getNc() {
        return nc;
    }
    public void setNc(String nc) {
        this.nc = nc;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
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
}
