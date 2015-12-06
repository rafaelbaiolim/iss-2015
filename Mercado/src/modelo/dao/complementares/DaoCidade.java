package modelo.dao.complementares;

import java.util.List;
import modelo.complementares.Cidade;
import modelo.complementares.UF;
import modelo.dao.Dao;

/**
 * <p>Classe responsavel pelas operacoes entre a Classe de Entidade <b>Cidade</b> e a Persitencia.</p>
 * @author  Leandro
 * @version 1.0
 * @since   07/11/2015
 * @see     modelo.dao.Dao
 * @see     modelo.complementares.Cidade
 */
public class DaoCidade extends Dao<Cidade> {
    
    public DaoCidade() {
        super(Cidade.class);
    }
    
    /**
     * Metodo responsavel por retornar uma Cidade pelo seu Nome e UF.
     * @param  sNome Nome da Cidade.
     * @return Cidade encontrada pelo nome e UF.
     */
    public Cidade findCidadeByNome(String sNome) {
        List<Cidade> oCidades = this.list();
        if (oCidades.isEmpty() == false) {
            for (Cidade oCurrentCidade : oCidades) {
                if (oCurrentCidade.toString().toUpperCase().trim().equals(sNome.toUpperCase().trim())) {
                    return oCurrentCidade;
                }
            }
        }
        return null;
    }
    
    /**
     * Metodo responsavel por retornar uma Cidade pelo seu Nome e UF.
     * @param  sNome Nome da Cidade.
     * @param  oUF   UF da Cidade.
     * @return Cidade encontrada pelo nome e UF.
     */
    public Cidade findCidadeByNomeAndUF(String sNome, UF oUF) {
        String       sSql     = "SELECT e FROM Cidade e "
                              + "WHERE e.nome LIKE '" + sNome.toUpperCase().trim() + "' ";
                     sSql    += (oUF != null) ?  "AND e.uf.id = " + oUF.getId() : "";
        List<Cidade> oCidades = (List<Cidade>) acesso.createQuery(sSql).getResultList();
        return (oCidades.isEmpty() == true) ? null : oCidades.get(0);
    }
    
    /**
     * Metodo responsavel por retornar uma Cidade pelo seu Nome e UF e com um Id diferente.
     * @param  sNome Nome da Cidade.
     * @param  oUF   UF da Cidade.
     * @param  lId   Id da Cidade.
     * @return Cidade encontrada.
     */
    public Cidade findCidadeByNomeAndUF(String sNome, UF oUF, Long lId) {
        String       sSql     = "SELECT e FROM Cidade e "
                              + "WHERE e.nome LIKE '" + sNome.toUpperCase().trim() + "' ";
                     sSql    += (oUF != null) ?  "AND e.uf.id = " + oUF.getId() + " " : " ";
                     sSql    += (lId != null) ?  "AND e.id   <> " + lId : "";
        List<Cidade> oCidades = (List<Cidade>) acesso.createQuery(sSql).getResultList();
        return (oCidades.isEmpty() == true) ? null : oCidades.get(0);
    }
    
    /**
     * Metodo responsavel por retornar uma Lista de Cidades pelo Nome ou UF.
     * @param  sCidade Nome da Cidade.
     * @return Lista de Cidades encontradas.
     */
    public List<Cidade> findCidades(String sCidade) {
        String       sSql     = "SELECT e FROM Cidade e ";
                     sSql    += "WHERE e.nome LIKE '%"  + sCidade.toUpperCase().trim() + "%' ";
                     sSql    += "OR e.uf.sigla LIKE '%" + sCidade.toUpperCase().trim() + "%' ";
        List<Cidade> oCidades = (List<Cidade>) acesso.createQuery(sSql).getResultList();
        return oCidades;
    }
    
    /**
     * Metodo responsavel por retornar uma Lista de Cidades pelo Nome e UF.
     * @param  sNome Nome da Cidade.
     * @param  oUF   UF da Cidade.
     * @return Lista de Cidades encontradas.
     */
    public List<Cidade> findCidadesByNomeAndUF(String sNome, UF oUF) {
        String       sSql     = "SELECT e FROM Cidade e "
                              + "WHERE e.nome LIKE '" + sNome.toUpperCase().trim() + "' ";
                     sSql    += (oUF != null) ?  "AND e.uf.id = " + oUF.getId() : "";
        List<Cidade> oCidades = (List<Cidade>) acesso.createQuery(sSql).getResultList();
        return oCidades;
    }
    
    @Override
    public List<Cidade> list() {
        String       sSql     = "SELECT e FROM Cidade e ORDER BY e.nome, e.uf.sigla";
        List<Cidade> oCidades = (List<Cidade>) acesso.createQuery(sSql).getResultList();
        return oCidades;
    }
    
    /**
     * Metodo responsavel por retornar um Vetor com as Cidades cadastradas.
     * @return Lista com as Cidades.
     */
    public String[] getCidades() {
        List<Cidade> oCidades    = this.list();
        String[]     sCidades    = new String[oCidades.size() + 1];
                     sCidades[0] = "Selecione";
        for (int i = 0; i < oCidades.size(); ++i) {
            sCidades[i + 1] = oCidades.get(i).toString();
        }
        return sCidades;
    }
    
    /**
     * Metodo responsavel por retornar uma Matriz com os elementos principais das Cidades.
     * @param  oCidades Lista de Cidades a serem listadas.
     * @return Matriz com os dados das Cidades.
     */
    public String[][] getCidades(List<Cidade> oCidades) {
        String[][] sCidades = new String[oCidades.size()][3];
        for (int i = 0; i < oCidades.size(); ++i) {
            sCidades[i] = oCidades.get(i).getInfo();
        }
        return sCidades;
    }
}