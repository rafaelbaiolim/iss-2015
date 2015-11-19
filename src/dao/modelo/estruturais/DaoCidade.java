/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 11/07/2015                                                         *
 * Classe: dao.modelo.estruturais.DaoCidade                                   *
 * Coment: Classe responsavel pelas operacoes entre a Classe de Entidade      *
 *         Cidade e o Banco de Dados.                                         *
 * ========================================================================== */

package dao.modelo.estruturais;

import dao.Dao;
import modelo.estruturais.Cidade;
import modelo.estruturais.UF;
import java.util.ArrayList;
import java.util.List;

public class DaoCidade extends Dao<Cidade> {
    
    public DaoCidade() {
        super(Cidade.class);
        this.loadCidades();
    }

    private void loadCidades() {
        if (this.size() == 0) {
            this.insert(new Cidade("CURITIBA", new DaoUF().getUFBySigla("PR")));
            this.insert(new Cidade("LONDRINA", new DaoUF().getUFBySigla("PR")));
            this.insert(new Cidade("MARINGA" , new DaoUF().getUFBySigla("PR")));
            this.insert(new Cidade("CASCAVEL", new DaoUF().getUFBySigla("PR")));
        }
    }

    public Cidade getCidade(String sCidade) {
        if (this.list().isEmpty() == false) {
            for (Cidade oCurrentCidade : this.list()) {
                if (oCurrentCidade.toString().equals(sCidade)) {
                    return oCurrentCidade;
                }
            }
        }
        return null;
    }
    
    public List<Cidade> getCidadesByUF(UF oUF) {
        List<Cidade> oCidades      = this.list();
        List<Cidade> oCidadesPorUF = new ArrayList<>();
        if (oCidades.isEmpty() == false) {
            for (Cidade oCurrentCidade : oCidades) {
                if (oCurrentCidade.getUF().equals(oUF)) {
                    oCidadesPorUF.add(oCurrentCidade);
                }
            }
        }
        return oCidadesPorUF;
    }
    
    public Cidade getCidadeByNomeAndUF(String sNome, UF oUF) {
        List<Cidade> oCidades = this.list();
        if (oCidades.isEmpty() == false) {
            for (Cidade oCurrentCidade : oCidades) {
                if ((oCurrentCidade.getNome().equals(sNome.toUpperCase().trim()))
                        && (oCurrentCidade.getUF().equals(oUF))) {
                    return oCurrentCidade;
                }
            }
        }
        return null;
    }
    
    public List<Cidade> listCidades() {
        return (List<Cidade>) acesso.createQuery("SELECT e FROM Cidade e ORDER BY e.nome").getResultList();
    }
    
    public List<Cidade> getCidadesByNome(String sNome) {
        return (List<Cidade>) acesso.createQuery("SELECT e FROM Cidade e WHERE e.nome LIKE '%" + sNome.toUpperCase() + "%' ORDER BY e.nome").getResultList();
    }
    
    public String[] getCidades() {
        String[] sCidades     = new String[this.listCidades().size()];
        List<Cidade> oCidades = this.listCidades();
        for (int i = 0; i < oCidades.size(); ++i) {
            sCidades[i] = oCidades.get(i).toString();
        }
        return sCidades;
    }
}