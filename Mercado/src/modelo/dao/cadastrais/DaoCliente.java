package modelo.dao.cadastrais;

import java.util.List;
import modelo.cadastrais.Cliente;
import modelo.dao.Dao;

/**
 * <p>Classe Dao da Classe de Modelo <b>Cliente</b>.</p>
 * <p>Classe responsavel pelas operacoes entre a classe Cliente e o BD.</p>
 * @author  Hadyne
 * @version 1.0
 * @since   12/11/2015
 * @see     modelo.dao.Dao
 * @see     modelo.cadastrais.Cliente
 */
public class DaoCliente extends Dao<Cliente> {

    /**
     * Metodo construtor padrão.
     * Define a Classe do Modelo Cliente como Entidade da superclasse Dao.
     */
    public DaoCliente() {
        super(Cliente.class);
    }
    
    /**
     * Metodo responsavel por retornar um Cliente pelo Documento.
     * @param  sDocumento Documento do Cliente.
     * @return Cliente encontrado.
     */
    public Cliente findClienteByDocumento(String sDocumento) {
        String        sSql      = "SELECT e FROM Cliente e WHERE e.documento LIKE '" + sDocumento + "'";
        List<Cliente> oClientes = (List<Cliente>) acesso.createQuery(sSql).getResultList();
        return (oClientes.isEmpty() == true) ? null : oClientes.get(0);
    }
    
    /**
     * Metodo responsavel por retornar um Cliente pelo Documento e pelo Id diferente.
     * @param  sDocumento Documento do Cliente.
     * @param  lId Id do Cliente.
     * @return Cliente encontrado.
     */
    public Cliente findClienteByDocumento(String sDocumento, Long lId) {
        String        sSql      = "SELECT e FROM Cliente e WHERE e.documento LIKE '" + sDocumento + "' ";
                      sSql     += "AND e.id <> " + lId + "";
        List<Cliente> oClientes = (List<Cliente>) acesso.createQuery(sSql).getResultList();
        return (oClientes.isEmpty() == true) ? null : oClientes.get(0);
    }
    
    /**
     * Metodo responsavel por retornar uma Lista de Clientes pelo seu Documento/Nome.
     * @param  sCliente Documento/Nome do Cliente.
     * @return Lista de Clientes encontrados.
     */
    public List<Cliente> findClientes(String sCliente) {
        String        sSql      = "SELECT e FROM Cliente e WHERE e.documento LIKE '%" + sCliente + "%' ";
                      sSql     += "OR e.nome LIKE '%" + sCliente.toUpperCase() + "%'";
        List<Cliente> oClientes = (List<Cliente>) acesso.createQuery(sSql).getResultList();
        return oClientes;
    }
    
    /**
     * Metodo responsavel por retornar uma Matriz com os elementos principais dos Clientes.
     * @param  oClientes Lista de Clientes a serem listadas.
     * @return Matriz com os dados dos Clientes.
     */
    public String[][] getClientes(List<Cliente> oClientes) {
        String[][] sClientes = new String[oClientes.size()][3];
        for (int i = 0; i < oClientes.size(); ++i) {
            sClientes[i] = oClientes.get(i).getInfo();
        }
        return sClientes;
    }
}