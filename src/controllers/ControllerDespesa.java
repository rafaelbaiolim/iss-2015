/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 17/06/2015                                                         *
 * Classe: controllers.ControllerDespesa                                      *
 * Coment: Classe responsavel pelas regras de negocios da Classe de Entidade  *
 *         Despesa.                                                           *
 * ========================================================================== */

package controllers;

import dao.modelo.gerenciais.DaoDespesa;
import dao.modelo.internos.DaoAcesso;
import dao.modelo.internos.DaoOperacao;
import modelo.gerenciais.Despesa;
import modelo.internos.Acesso;
import modelo.internos.Usuario;
import funcoes.FunctDate;
import java.util.Date;
import java.util.List;

public class ControllerDespesa {
    private static DaoDespesa oDaoDespesa = new DaoDespesa();
    
    public static boolean checkDescricao(String sDescricao) {
        return sDescricao.length() > 1;
    }
    
    public static List<Despesa> getDespesasByDescricao(String sDescricao) {
        return oDaoDespesa.getDespesasByDescricao(sDescricao);
    }
    
    public static float valorTotalDespesas() {
        float fValorTotal = 0.0f;
        if (oDaoDespesa.list().isEmpty() == false) {
            for (Despesa oCurrentDespesa : oDaoDespesa.list()) {
                fValorTotal += oCurrentDespesa.getValor();
            }
        }
        return fValorTotal;
    }
    
    public static int totalDespesas() {
        return oDaoDespesa.size();
    }
    
    public static String[][] getDespesas(List<Despesa> oDespesas) {
        String[][] sDespesas = new String[oDespesas.size()][3];
        for (int i = 0; i < oDespesas.size(); ++i) {
            sDespesas[i][0] = oDespesas.get(i).getDescricao();
            sDespesas[i][1] = Float.toString(oDespesas.get(i).getValor());
            sDespesas[i][2] = FunctDate.getFormattedDate(oDespesas.get(i).getDataPagamento());
        }
        return sDespesas;
    }
    
    public static void adicionar(String sDescricao, float fValor, Date dDataPagamento, String sObservacao, Usuario oUsuario) {
        Despesa oDespesa = new Despesa(sDescricao, sObservacao, fValor, dDataPagamento, oUsuario);
        new DaoAcesso().insert(new Acesso("Despesa = " + oDespesa.toString(), new DaoOperacao().getOperacaoByDescricao("CADASTRO DE DESPESA"), oUsuario));
        oDaoDespesa.insert(oDespesa);
    }
    
    public static void remover(Despesa oDespesa, Usuario oUsuario) {
        new DaoAcesso().insert(new Acesso("Despesa = " + oDespesa.toString(), new DaoOperacao().getOperacaoByDescricao("REMOCAO DE DESPESA"), oUsuario));
        oDaoDespesa.remove(oDespesa.getId());
    }
    
    public static void gravar(Despesa oDespesa, String sDescricao, float fValor, Date dDataPagamento, String sObservacao, Usuario oUsuario) {
        oDespesa.setDescricao(sDescricao);
        oDespesa.setValor(fValor);
        oDespesa.setValor(fValor);
        oDespesa.setDataPagamento(dDataPagamento);
        oDespesa.setObservacao(sObservacao);
        oDaoDespesa.update(oDespesa);
        new DaoAcesso().insert(new Acesso("Despesa = " + oDespesa.toString(), new DaoOperacao().getOperacaoByDescricao("ALTERACAO DE DESPESA"), oUsuario));
    }
}