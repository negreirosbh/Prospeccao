package e.willamesnegreiros.prospeccao.helper;



import java.util.List;

import e.willamesnegreiros.prospeccao.model.Prospeccao;

/**
 * Created by jamiltondamasceno
 */

public interface IProspeccaoDAO {

    public boolean salvar(Prospeccao prospeccao);
    public boolean atualizar(Prospeccao prospeccao, String[] args);
    public boolean deletar(String[] args);
    public Prospeccao consulta(String[] args);
    public List<Prospeccao> listar();

}
