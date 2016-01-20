package modelo.dao.relacionais.saida;

import java.util.List;
import modelo.dao.Dao;
import modelo.relacionais.saida.Venda;

/**
 * <p>Classe responsavel pelas operacoes entre a classe Venda e o BD.</p>
 * @author Hadyne
 * @version 1.0
 * @since   12/11/2015
 * @see     modelo.dao.Dao
 */
public class DaoVenda extends Dao<Venda> {

    public DaoVenda() {
        super(Venda.class);
    }
    
    public List<Venda> findVendas(String sCliente) {
        String sSql = "SELECT e FROM Venda e WHERE e.cliente.nome LIKE '%" + sCliente + "%'";
        return (List<Venda>) acesso.createQuery(sSql).getResultList();
    }
    
    public List<Venda> findEncomendas(String sCliente) {
        String sSql = "SELECT e FROM Venda e WHERE e.cliente.nome LIKE '%" + sCliente + "%' AND e.encomenda=true AND e.entrega=false";
        return (List<Venda>) acesso.createQuery(sSql).getResultList();
    }
    
    /**
     * Metodo responsavel por retornar uma Matriz com os elementos principais das Vendas.
     * @param  oVendas Lista de Vendas a serem listadas.
     * @return Matriz com os dados das Vendas.
     */
    public String[][] getVendas(List<Venda> oVendas) {
        String[][] sVendas = new String[oVendas.size()][3];
        for (int i = 0; i < oVendas.size(); ++i) {
            sVendas[i] = oVendas.get(i).getInfo();
        }
        return sVendas;
    }
}