/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 25/06/2015                                                         *
 * Classe: factory.FactoryCliente                                             *
 * Coment: Classe responsavel pelo Padrao de Projeto Factory da Classe de     *
 *         Entidade Cliente.                                                  *
 * ========================================================================== */

package factory;

import modelo.cadastrais.Cliente;
import modelo.cadastrais.ClienteFisico;
import modelo.cadastrais.ClienteJuridico;

public class FactoryCliente {
    
    public static Cliente getCliente(String sDocumento) {
        if (sDocumento.length() == 11) {
            return new ClienteFisico();
        }else if (sDocumento.length() == 14) {
            return new ClienteJuridico();
        }
        return null;
    }
}