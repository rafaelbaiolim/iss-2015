/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 11/07/2015                                                         *
 * Classe: dao.modelo.cadastrais.DaoCliente                                   *
 * Coment: Classe responsavel pelas operacoes entre a Classe de Entidade      *
 *         Cliente e o Banco de Dados.                                        *
 * ========================================================================== */

package dao.modelo.cadastrais;

import dao.Dao;
import modelo.cadastrais.Cliente;
import java.util.ArrayList;
import java.util.List;

public class DaoCliente extends Dao<Cliente> {
    
    public DaoCliente() {
        super(Cliente.class);
    }

    public Cliente getClienteByDocumento(String sDocumento) {
        List<Cliente> oClientes = this.list();
        if (oClientes.isEmpty() == false) {
            for (Cliente oCurrentCliente : oClientes) {
                if (oCurrentCliente.getDocumento().equals(sDocumento)) {
                    return oCurrentCliente;
                }
            }
        }
        return null;
    }
    
    public List<Cliente> getClientesByNome(String sString) {
        List<Cliente> oClientes       = this.list();
        List<Cliente> oClientesByNome = new ArrayList<>();
        if (oClientes.isEmpty() == false) {
            for (Cliente oCurrentCliente : oClientes) {
                if (oCurrentCliente.getNome().contains(sString.toUpperCase())) {
                    oClientesByNome.add(oCurrentCliente);
                }
            }
        }
        return oClientesByNome;
    }
}