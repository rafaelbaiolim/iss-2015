package modelo.dao.complementares;

import java.util.List;
import modelo.complementares.UF;
import modelo.dao.Dao;

/**
 * <p>Classe responsavel pelas operacoes entre a Classe de Entidade <b>UF</b> e a Persitencia.</p>
 * @author  Hadyne
 * @version 1.0
 * @since   07/11/2015
 * @see     modelo.dao.Dao
 * @see     modelo.complementares.UF
 */
public class DaoUF extends Dao<UF> {

    public DaoUF() {
        super(UF.class);
        this.loadUFs();
    }
    
    /**
     * Metodo responsavel por carregar as UFs no Banco de Dados.
     */
    private void loadUFs() {
        if (this.size() == 0) {
            this.insert(new UF("ACRE"               , "AC"));
            this.insert(new UF("ALAGOAS"            , "AL"));
            this.insert(new UF("AMAPA"              , "AP"));
            this.insert(new UF("AMAZONAS"           , "AM"));
            this.insert(new UF("BAHIA"              , "BA"));
            this.insert(new UF("CEARA"              , "CE"));
            this.insert(new UF("DISTRITO FEDERAL"   , "DF"));
            this.insert(new UF("ESPIRITO SANTO"     , "ES"));
            this.insert(new UF("GOIAS"              , "GO"));
            this.insert(new UF("MARANHAO"           , "MA"));
            this.insert(new UF("MATO GROSSO"        , "MT"));
            this.insert(new UF("MATO GROSSO DO SUL" , "MS"));
            this.insert(new UF("MINAS GERAIS"       , "MG"));
            this.insert(new UF("PARA"               , "PA"));
            this.insert(new UF("PARAIBA"            , "PB"));
            this.insert(new UF("PARANA"             , "PR"));
            this.insert(new UF("PERNAMBUCO"         , "PE"));
            this.insert(new UF("PIAUI"              , "PI"));
            this.insert(new UF("RIO DE JANEIRO"     , "RJ"));
            this.insert(new UF("RIO GRANDE DO NORTE", "RN"));
            this.insert(new UF("RIO GRANDE DO SUL"  , "RS"));
            this.insert(new UF("RONDONIA"           , "RO"));
            this.insert(new UF("RORAIMA"            , "RR"));
            this.insert(new UF("SANTA CATARINA"     , "SC"));
            this.insert(new UF("SAO PAULO"          , "SP"));
            this.insert(new UF("SERGIPE"            , "SE"));
            this.insert(new UF("TOCANTINS"          , "TO"));
        }
    }
    
    /**
     * Metodo responsavel por retornar as siglas das UFs cadastradas no BD.
     * @return Lista de Siglas.
     */
    public List<String> getSiglas() {
        String       sSql    = "SELECT e.sigla FROM UF e ORDER BY e.sigla";
        List<String> oSiglas = (List<String>) acesso.createQuery(sSql).getResultList();
        return oSiglas;
    }
    
    /**
     * Metodo responsavel por retornar uma UF pela sua Sigla. 
     * @param  sSigla Sigla da UF.
     * @return UF encontrada pela Sigla.
     */
    public UF findUFBySigla(String sSigla) {
        String   sSql = "SELECT e FROM UF e WHERE e.sigla LIKE '" + sSigla.toUpperCase().trim() + "'";
        List<UF> oUFs = (List<UF>) acesso.createQuery(sSql).getResultList();
        return (oUFs.isEmpty() == true) ? null : oUFs.get(0);
    }
}