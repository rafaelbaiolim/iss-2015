/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 11/07/2015                                                         *
 * Classe: dao.modelo.cadastrais.DaoClienteJuridico                           *
 * Coment: Classe responsavel pelas operacoes entre a Classe de Entidade      *
 *         ClienteJuridico e o Banco de Dados.                                *
 * ========================================================================== */

package dao.modelo.cadastrais;

import dao.Dao;
import modelo.cadastrais.ClienteJuridico;

public class DaoClienteJuridico extends Dao<ClienteJuridico> {
    
    public DaoClienteJuridico() {
        super(ClienteJuridico.class);
    }
}