/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 11/07/2015                                                         *
 * Classe: dao.modelo.cadastrais.DaoClienteFisico                             *
 * Coment: Classe responsavel pelas operacoes entre a Classe de Entidade      *
 *         ClienteFisico e o Banco de Dados.                                  *
 * ========================================================================== */

package dao.modelo.cadastrais;

import dao.Dao;
import modelo.cadastrais.ClienteFisico;

public class DaoClienteFisico extends Dao<ClienteFisico> {
    
    public DaoClienteFisico() {
        super(ClienteFisico.class);
    }
}