package modelo.dao.estruturais;

import java.util.List;
import modelo.dao.Dao;
import modelo.estruturais.Acao;

/**
 * <p>Classe Dao da Classe de Modelo <b>Acao</b>.</p>
 * <p>Classe responsavel pelas operacoes entre a classe Acao e o BD.</p>
 * @author  Leandro
 * @version 1.0
 * @since   12/11/2015
 * @see     modelo.dao.Dao
 * @see     modelo.estruturais.Operacao
 */
public class DaoAcao extends Dao<Acao> {

    /**
     * Metodo construtor padrão.
     * Define a Classe do Modelo Acao como Entidade da superclasse Dao.
     */
    public DaoAcao() {
        super(Acao.class);
    }
    
    /**
     * Metodo responsavel por retornar a Acao pela Descricao.
     * @param  sDescricao Descricao da Acao.
     * @return Acao encontrada.
     */
    public Acao findAcaoByDescricao(String sDescricao) {
        String     sSql   = "SELECT e FROM Acao e WHERE e.descricao LIKE '" + sDescricao.toUpperCase() + "'";
        List<Acao> oAcoes = (List<Acao>) acesso.createQuery(sSql).getResultList();
        return (oAcoes.isEmpty() == true) ? null : oAcoes.get(0);
    }
}