/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 15/07/2015                                                         *
 * Classe: dao.modelo.gerenciais.DaoDespesa                                   *
 * Coment: Classe responsavel pelas operacoes entre a Classe de Entidade      *
 *         Despesa e o Banco de Dados.                                        *
 * ========================================================================== */

package dao.modelo.gerenciais;

import dao.Dao;
import modelo.gerenciais.Despesa;
import java.util.List;

public class DaoDespesa extends Dao<Despesa> {
    
    public DaoDespesa() {
        super(Despesa.class);
    }
    
    public List<Despesa> getDespesasByDescricao(String sDescricao) {
        return acesso.createQuery("SELECT e FROM Despesa e WHERE e.descricao LIKE '%" + sDescricao.toUpperCase() + "%'").getResultList();
    }
}