package modelo.dao.relacionais.saida;

import modelo.dao.Dao;
import modelo.relacionais.saida.Devolucao;

/**
 * <p>Classe responsavel pelas operacoes entre a classe Devolucao e o BD.</p>
 * @autor: Hadyne
 * @version 1.0
 * @since   12/11/2015
 * @see     modelo.dao.Dao
 */
public class DaoDevolucao extends Dao<Devolucao> {

    public DaoDevolucao() {
        super(Devolucao.class);
    }
}