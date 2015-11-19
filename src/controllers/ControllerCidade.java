/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 17/06/2015                                                         *
 * Classe: controllers.ControllerCidade                                       *
 * Coment: Classe responsavel pelas regras de negocios da Classe de Entidade  *
 *         Cidade.                                                            *
 * ========================================================================== */

package controllers;

import dao.modelo.estruturais.DaoCidade;
import dao.modelo.estruturais.DaoUF;
import dao.modelo.internos.DaoAcesso;
import dao.modelo.internos.DaoOperacao;
import modelo.estruturais.Cidade;
import modelo.internos.Acesso;
import modelo.internos.Usuario;
import java.util.List;

public class ControllerCidade {
    private static DaoCidade oDaoCidade = new DaoCidade();
    
    public static boolean nomeIsAble(String sNome) {
        return sNome.trim().length() > 2;
    }
    
    public static boolean checkCidade(String sNome, String sUF) {
        return oDaoCidade.getCidadeByNomeAndUF(sNome, new DaoUF().getUFBySigla(sUF)) == null;
    }
    
    public static String[] getCidades() {
        return oDaoCidade.getCidades();
    }
    
    public static List<Cidade> getCidadesByNome(String sNome) {
        return oDaoCidade.getCidadesByNome(sNome);
    }
    
    public static String[][] getCidades(List<Cidade> oCidades) {
        String[][] sCidades = new String[oCidades.size()][2];
        for (int i = 0; i < oCidades.size(); ++i) {
            sCidades[i][0] = oCidades.get(i).getNome();
            sCidades[i][1] = oCidades.get(i).getUF().getSigla();
        }
        return sCidades;
    }
    
    public static void adicionar(String sNome, String sUF, Usuario oUsuario) {
        Cidade oCidade = new Cidade(sNome, new DaoUF().getUFBySigla(sUF));
        oDaoCidade.insert(oCidade);
        new DaoAcesso().insert(new Acesso("Cidade = " + oCidade.toString(), new DaoOperacao().getOperacaoByDescricao("CADASTRO DE CIDADE"), oUsuario));
    }
    
    public static void gravar(Cidade oCidade, String sNome, String sUF, Usuario oUsuario) {
        oCidade.setNome(sNome);
        oCidade.setUF(new DaoUF().getUFBySigla(sUF));
        oDaoCidade.update(oCidade);
        new DaoAcesso().insert(new Acesso("Cidade = " + oCidade.toString(), new DaoOperacao().getOperacaoByDescricao("ALTERACAO DE CIDADE"), oUsuario));
    }
    
    public static void remover(Cidade oCidade, Usuario oUsuario) {
        oDaoCidade.remove(oCidade.getId());
        new DaoAcesso().insert(new Acesso("Cidade = " + oCidade.toString(), new DaoOperacao().getOperacaoByDescricao("REMOCAO DE CIDADE"), oUsuario));
    }
}