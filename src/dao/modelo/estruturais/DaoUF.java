/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 11/07/2015                                                         *
 * Classe: dao.modelo.estruturais.DaoUF                                       *
 * Coment: Classe responsavel pelas operacoes entre a Classe de Entidade      *
 *         UF e o Banco de Dados.                                             *
 * ========================================================================== */

package dao.modelo.estruturais;

import dao.Dao;
import modelo.estruturais.UF;
import java.util.List;

public class DaoUF extends Dao<UF> {
    
    public DaoUF() {
        super(UF.class);
        this.loadUFs();
    }
    
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
    
    public List<String> getSiglas() {
        return acesso.createQuery("SELECT e.sigla FROM UF e ORDER BY e.sigla").getResultList();
    }
    
    public UF getUFBySigla(String sSigla) {
        List<UF> oUFs = this.list();
        if (oUFs.isEmpty() == false) {
            for (UF oCurrentUF : oUFs) {
                if (oCurrentUF.getSigla().equals(sSigla.toUpperCase().trim())) {
                    return oCurrentUF;
                }
            }
        }
        return null;
    }
}