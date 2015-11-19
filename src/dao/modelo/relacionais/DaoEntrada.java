/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 25/07/2015                                                         *
 * Classe: dao.modelo.relacionais.DaoEntrada                                  *
 * Coment: Classe responsavel pelas operacoes entre a Classe de Entidade      *
 *         Entrada e o Banco de Dados.                                        *
 * ========================================================================== */

package dao.modelo.relacionais;

import dao.Dao;
import modelo.relacionais.Entrada;

public class DaoEntrada extends Dao<Entrada> {

    public DaoEntrada() {
        super(Entrada.class);
    }
}