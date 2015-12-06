package modelo.dao.gerenciais;

import java.util.List;
import modelo.dao.Dao;
import modelo.gerenciais.Marca;

/**
 * <p>Classe Dao da Classe de Modelo <b>Marca</b>.</p>
 * <p>Classe responsavel pelas operacoes entre a classe Marca e o BD.</p>
 * @author  Vanessa
 * @version 1.0
 * @since   12/11/2015
 * @see     modelo.dao.Dao
 * @see     modelo.gerenciais.Marca
 */
public class DaoMarca extends Dao<Marca>{

    /**
     * <p>Metodo construtor padrão.</p>
     * <p>Define a Classe do Modelo <b>Marca</b> como Entidade da superclasse Dao.</p>
     */
    public DaoMarca() {
        super(Marca.class);
    }
    
    /**
     * Metodo responsavel por retornar a Marca pelo nome.
     * @param  sNome Nome da Marca.
     * @return Marca encontrada.
     */
    public Marca findMarcaByNome(String sNome) {
        String sSql         = "SELECT e FROM Marca e WHERE e.nome LIKE '" + sNome.toUpperCase().trim() + "'";
        List<Marca> oMarcas = acesso.createQuery(sSql).getResultList();
        return (oMarcas.isEmpty() == true) ? null : oMarcas.get(0);
    }
    
    /**
     * Metodo responsavel por retornar a Marca pela sigla.
     * @param  sSigla Sigla da Marca.
     * @return Marca encontrada.
     */
    public Marca findMarcaBySigla(String sSigla) {
        String sSql         = "SELECT e FROM Marca e WHERE e.sigla LIKE '" + sSigla.toUpperCase().trim() + "'";
        List<Marca> oMarcas = acesso.createQuery(sSql).getResultList();
        return (oMarcas.isEmpty() == true) ? null : oMarcas.get(0);
    }
    
    /**
     * * Metodo responsavel por retornar um Marca pelo seu Nome e Sigla e com um Id diferente.
     * @param  sNome  Nome da Marca.
     * @param  sSigla Sigla da Marca.
     * @param  lId    Id da Marca.
     * @return Marca encontrada.
     */
    public Marca findMarcaByNomeAndSigla(String sNome, String sSigla, Long lId) {
        String           sSql           = "SELECT e FROM Marca e WHERE (e.nome LIKE '" + sNome + "' ";
                         sSql          += "OR e.sigla LIKE '" + sSigla + "') AND e.id <> " + lId;
        List<Marca> oMarcas = acesso.createQuery(sSql).getResultList();
        return (oMarcas.isEmpty() == true) ? null : oMarcas.get(0);
    }
    
    /**
     * Metodo responsavel por retornar uma Lista de Marcas pelo Nome/Sigla.
     * @param  sMarca Nome/Sigla das Marcas.
     * @return Lista de Marcas encontradas.
     */
    public List<Marca> findMarcas(String sMarca) {
        String      sSql    = "SELECT e FROM Marca e WHERE e.nome LIKE '%" + sMarca + "%' ";
                    sSql   += "OR e.sigla LIKE '%" + sMarca + "%'";
        List<Marca> oMarcas = acesso.createQuery(sSql).getResultList();
        return      oMarcas;
    }
    
    /**
     * Metodo responsavel por retornar uma Matriz com os elementos principais das Marcas.
     * @param  oMarcas Lista de Marcas a serem listados.
     * @return Matriz com os dados das Marcas.
     */
    public String[][] getMarcas(List<Marca> oMarcas) {
        String[][] sMarcas = new String[oMarcas.size()][3];
        for (int i = 0; i < oMarcas.size(); ++i) {
            sMarcas[i] = oMarcas.get(i).getInfo();
        }
        return sMarcas;
    }
}