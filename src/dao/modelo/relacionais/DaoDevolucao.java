/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 25/07/2015                                                         *
 * Classe: dao.modelo.relacionais.DaoDevolucao                                *
 * Coment: Classe responsavel pelas operacoes entre a Classe de Entidade      *
 *         Devolucao e o Banco de Dados.                                      *
 * ========================================================================== */

package dao.modelo.relacionais;

import dao.Dao;
import modelo.relacionais.Devolucao;

public class DaoDevolucao extends Dao<Devolucao> {

    public DaoDevolucao() {
        super(Devolucao.class);
    }
}