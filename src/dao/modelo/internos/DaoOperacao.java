/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 20/07/2015                                                         *
 * Classe: dao.modelo.internos.DaoOperacao                                    *
 * Coment: Classe responsavel pelas operacoes entre a Classe de Entidade      *
 *         Operacao e o Banco de Dados.                                       *
 * ========================================================================== */

package dao.modelo.internos;

import dao.Dao;
import modelo.internos.Operacao;
import java.util.ArrayList;
import java.util.List;

public class DaoOperacao extends Dao<Operacao> {
    
    public DaoOperacao() {
        super(Operacao.class);
        this.loadOperacoes();
    }
    
    private void loadOperacoes() {
        if (this.size() == 0) {
            this.insert(new Operacao("LOGIN"));
            this.insert(new Operacao("LOGOFF"));
            this.insert(new Operacao("SAIR"));
            
            this.insert(new Operacao("CADASTRO DE CIDADE"));
            this.insert(new Operacao("ALTERACAO DE CIDADE"));
            this.insert(new Operacao("REMOCAO DE CIDADE"));
            
            this.insert(new Operacao("CADASTRO DE CLIENTE"));
            this.insert(new Operacao("REMOCAO DE CLIENTE"));
            
            this.insert(new Operacao("CADASTRO DE DESPESA"));
            this.insert(new Operacao("ALTERACAO DE DESPESA"));
            this.insert(new Operacao("REMOCAO DE DESPESA"));

            this.insert(new Operacao("CADASTRO DE FORNECEDOR"));
            this.insert(new Operacao("ALTERACAO DE FORNECEDOR"));
            this.insert(new Operacao("REMOCAO DE FORNECEDOR"));
            
            this.insert(new Operacao("CADASTRO DE FUNCIONARIO"));
            this.insert(new Operacao("ALTERACAO DE FUNCIONARIO"));
            this.insert(new Operacao("REMOCAO DE FUNCIONARIO"));
            
            this.insert(new Operacao("CADASTRO DE PRODUTO"));
            this.insert(new Operacao("ALTERACAO DE PRODUTO"));
            this.insert(new Operacao("REMOCAO DE PRODUTO"));
            
            this.insert(new Operacao("CADASTRO DE USUARIO"));
            this.insert(new Operacao("ALTERACAO DE USUARIO"));
            this.insert(new Operacao("REMOCAO DE USUARIO"));
            
            this.insert(new Operacao("CADASTRO DE PEDIDO"));
            this.insert(new Operacao("CONFIRMACAO DE ENTRADA"));
            this.insert(new Operacao("DEVOLUCAO"));
            this.insert(new Operacao("CADASTRO DE VENDA"));
            
            this.insert(new Operacao("ENVIO DE MENSAGEM"));
        }
    }
    
    public Operacao getOperacaoByDescricao(String sDescricao) {
        List<Operacao> oOperacoes = this.list();
        if (oOperacoes.isEmpty() == false) {
            for (Operacao oCurrentOperacao : oOperacoes) {
                if (oCurrentOperacao.getDescricao().equals(sDescricao.toUpperCase().trim())) {
                    return oCurrentOperacao;
                }
            }
        }
        return null;
    }
       
    public List<Operacao> getOperacoesByDescricao(String sDescricao) {
        List<Operacao> oOperacoes            = this.list();
        List<Operacao> oOperacoesByDescricao = new ArrayList<>();
        if (oOperacoes.isEmpty() == false) {
            for (Operacao oCurrentOperacao : oOperacoes) {
                if (oCurrentOperacao.getDescricao().equals(sDescricao.toUpperCase().trim())) {
                    oOperacoesByDescricao.add(oCurrentOperacao);
                }
            }
        }
        return oOperacoesByDescricao;
    }
    
    public List<String> getOperacoes() {
        return (List<String>) acesso.createQuery("SELECT e.descricao FROM Operacao e ORDER BY e.descricao").getResultList();
    }
}