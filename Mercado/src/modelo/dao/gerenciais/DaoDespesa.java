package modelo.dao.gerenciais;

import java.util.List;
import modelo.dao.Dao;
import modelo.gerenciais.Despesa;

/**
 * <p>Classe Dao da Classe de Modelo <b>Despesa</b>.</p>
 * <p>Classe responsavel pelas operacoes entre a classe Despesa e o BD.</p>
 * @author  Rafael
 * @version 1.0
 * @since   12/11/2015
 * @see     modelo.dao.Dao
 * @see     modelo.gerenciais.Despesa
 */
public class DaoDespesa extends Dao<Despesa> {

    /**
     * Metodo construtor padrão.
     * Define a Classe do Modelo Despesa como Entidade da superclasse Dao.
     */
    public DaoDespesa() {
        super(Despesa.class);
    }
    
    /**
     * Metodo responsavel por retornar a Despesa pelo sua descricao.
     * @param  sDescricao Descricao da Despesa.
     * @return Despesa encontrada.
     */
    public Despesa findDespesaByDescricao(String sDescricao) {
        String        sSql      = "SELECT e FROM Despesa e WHERE e.descricao LIKE '" + sDescricao + "'";
        List<Despesa> oDespesas = (List<Despesa>) acesso.createQuery(sSql).getResultList();
        return (oDespesas.isEmpty() == true) ? null : oDespesas.get(0);
    }
    
    /**
     * Metodo responsavel por retornar a Despesa pelo sua descricao e com Id diferente.
     * @param  sDescricao Descricao da Despesa.
     * @param  lId        Id da Despesa.
     * @return Despesa encontrada.
     */
    public Despesa findDespesaByDescricao(String sDescricao, Long lId) {
        String        sSql      = "SELECT e FROM Despesa e WHERE e.descricao LIKE '" + sDescricao + "' ";
                      sSql     += "AND e.id <> lId";
        List<Despesa> oDespesas = (List<Despesa>) acesso.createQuery(sSql).getResultList();
        return (oDespesas.isEmpty() == true) ? null : oDespesas.get(0);
    }
    
    /**
     * Metodo responsavel por retornar uma Lista de Despesas pela Descricao.
     * @param  sDescricao Descricao da Despesa.
     * @return Lista de Despesas encontradas.
     */
    public List<Despesa> findDespesas(String sDescricao) {
        String        sSql      = "SELECT e FROM Despesa e WHERE e.descricao LIKE '%" + sDescricao + "%'";
        List<Despesa> oDespesas = (List<Despesa>) acesso.createQuery(sSql).getResultList();
        return oDespesas;
    }
    
    /**
     * Metodo responsavel por retornar uma Matriz com os elementos principais das Despesas.
     * @param  oDespesas Lista de Despesas a serem listadas.
     * @return Matriz com os dados das Despesas.
     */
    public String[][] getDespesas(List<Despesa> oDespesas) {
        String[][] sDespesas = new String[oDespesas.size()][3];
        for (int i = 0; i < oDespesas.size(); ++i) {
            sDespesas[i] = oDespesas.get(i).getInfo();
        }
        return sDespesas;
    }
}