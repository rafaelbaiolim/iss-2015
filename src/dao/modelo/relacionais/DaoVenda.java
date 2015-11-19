/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 25/07/2015                                                         *
 * Classe: dao.modelo.relacionais.DaoVenda                                    *
 * Coment: Classe responsavel pelas operacoes entre a Classe de Entidade      *
 *         Venda e o Banco de Dados.                                          *
 * ========================================================================== */

package dao.modelo.relacionais;

import dao.Dao;
import modelo.relacionais.Venda;
import java.util.ArrayList;
import java.util.List;

public class DaoVenda extends Dao<Venda> {

    public DaoVenda() {
        super(Venda.class);
    }
    
    public List<Venda> getVendasByCliente(String sCliente) {
        List<Venda> oVendasEnc = new ArrayList<>();
        if (this.list().isEmpty() == false) {
            for (Venda oCurrentVenda : this.list()) {
                if (oCurrentVenda.getCliente().getNome().contains(sCliente.toUpperCase())) {
                    oVendasEnc.add(oCurrentVenda);
                }
            }
        }
        return oVendasEnc;
    }
    
    public List<Venda> getEncomendas() {
        List<Venda> oVendasEnc = new ArrayList<>();
        if (this.list().isEmpty() == false) {
            for (Venda oCurrentVenda : this.list()) {
                if ((oCurrentVenda.isEncomenda() == true) 
                        && (oCurrentVenda.isEntrega() == false)) {
                    oVendasEnc.add(oCurrentVenda);
                }
            }
        }
        return oVendasEnc;
    }
}