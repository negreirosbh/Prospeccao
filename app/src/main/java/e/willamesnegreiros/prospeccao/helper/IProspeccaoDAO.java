package e.willamesnegreiros.prospeccao.helper;



import java.util.List;

import e.willamesnegreiros.prospeccao.model.Prospeccao;

/**
 * Created by jamiltondamasceno
 */

public interface IProspeccaoDAO {

    public boolean salvar(Prospeccao tarefa);
    public boolean atualizar(Prospeccao tarefa);
    public boolean deletar(Prospeccao tarefa);
    public List<Prospeccao> listar();

}
