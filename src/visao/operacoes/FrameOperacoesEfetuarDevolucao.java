/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 19/08/2015                                                         *
 * Classe: visao.operacoes.FrameOperacoesEfetuarDevolucao                     *
 * Coment: Classe responsavel por representar o Frame de Devolucao no Sistema.*
 *         Subclasse da Classe Abstrata FrameModal.                           *
 * ========================================================================== */

package visao.operacoes;

import controllers.ControllerDevolucao;
import controllers.ControllerVenda;
import modelo.internos.Usuario;
import modelo.relacionais.Devolucao;
import modelo.relacionais.ItemVenda;
import modelo.relacionais.Venda;
import visao.Frame;
import visao.pesquisa.FramePesquisarVenda;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import visao.mensagens.FrameMensagem;

public class FrameOperacoesEfetuarDevolucao extends FrameOperacoes {
    private JLabel          oLabelHeader;
    
    private JTextField      oTextFieldFuncionario;
    
    private JTextField      oTextFieldVenda;
    private JButton         oButtonSearch;
    
    private JTextField      oTextFieldTotalItens;
    private JTextField      oTextFieldValorTotal;
    
    private JButton         oButtonConfirmar;
    private JButton         oButtonCancelar;
    
    private Usuario         usuario;
    private Venda           venda;
    private List<ItemVenda> itensVenda;
    private Devolucao       devolucao;

    public FrameOperacoesEfetuarDevolucao(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario     = oUsuario;
        this.venda       = new Venda();
        this.devolucao   = new Devolucao();
        this.devolucao.setFuncionario(this.usuario);
        this.itensVenda  = new ArrayList<>();
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Efetuar Devolucao");
        this.setLocation(300, 100);
        this.setSize(500, 500);
        this.addComponents();
    }
    
    private void addComponents() {
        
        this.addLine(1);
        
        this.oLabelHeader      = new JLabel("EFETUAR DEVOLUCAO");
        this.oLabelHeader.setFont(new Font("Tahoma", 1, 25));
        this.add(this.oLabelHeader);
        
        this.addLine(1);
        
        this.oTextFieldFuncionario = new JTextField(25);
        this.oTextFieldFuncionario.setEditable(false);
        this.oTextFieldFuncionario.setText(this.usuario.getFuncionario().toString());
        this.add(new JLabel("Funcionario: "));
        this.add(this.oTextFieldFuncionario);
        
        this.addLine(1);
        
        this.oTextFieldVenda  = new JTextField(20);
        this.oButtonSearch     = this.createButton("", "search.jpg");
        this.oTextFieldVenda.setEditable(false);
        this.add(new JLabel("Venda: "));
        this.add(this.oTextFieldVenda);
        this.add(this.oButtonSearch);
        
        this.addLine(1);
        
        this.addTable();
        String[] sDados = {"Descrição", "Quantidade", "Preço Unitário"};
        this.addColumns(sDados);
        
        this.addLine(1);
        
        this.oTextFieldTotalItens  = new JTextField(10);
        this.oTextFieldTotalItens.setEditable(false);
        this.add(new JLabel("Total Itens: "));
        this.add(this.oTextFieldTotalItens);
        
        this.oTextFieldValorTotal  = new JTextField(10);
        this.oTextFieldValorTotal.setEditable(false);
        this.add(new JLabel("Valor Total: "));
        this.add(this.oTextFieldValorTotal);
        
        this.addLine(1);
        
        this.oButtonConfirmar = this.createButton("Confirmar", "yes.jpg");
        this.oButtonCancelar  = this.createButton(" Cancelar", "no.jpg");
        
        this.add(this.oButtonConfirmar);
        this.add(this.oButtonCancelar);
    }
    
    public void setVenda(Venda oVenda) {
        this.venda      = oVenda;
        this.itensVenda = ControllerVenda.getItensVenda(oVenda);
        this.devolucao.setVenda(oVenda);
        this.oTextFieldVenda.setText(this.venda.toString());
        this.atualizarDados();
    }
    
    private void atualizarDados() {
        this.clearTable();
        String[][] sItensVenda = new String[this.itensVenda.size()][3];
        float      fValorTotal  = 0.0f;
        int        iTotalItens  = 0;
        for (int i = 0; i < this.itensVenda.size(); ++i) {                
            sItensVenda[i][0] = this.itensVenda.get(i).getProduto().getDescricao();
            sItensVenda[i][1] = Integer.toString(this.itensVenda.get(i).getQuantidade());
            sItensVenda[i][2] = Float.toString(this.itensVenda.get(i).getValorUnitario());
            iTotalItens      += this.itensVenda.get(i).getQuantidade();
            fValorTotal      += this.itensVenda.get(i).getValorUnitario() * this.itensVenda.get(i).getQuantidade();
        }
        this.addRows(sItensVenda);
        this.oTextFieldTotalItens.setText(Integer.toString(iTotalItens));
        this.oTextFieldValorTotal.setText(Float.toString(fValorTotal));
    }


    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSearch)) {
            new FramePesquisarVenda(this).setVisible(true);
        }else if (oEvento.getSource().equals(this.oButtonConfirmar)) {
            if (this.devolucao.getVenda() != null) {
            
                ControllerDevolucao.adicionar(this.venda, this.usuario);
                ControllerDevolucao.atualizarEstoque(this.itensVenda);
                
                new FrameMensagem(this, "Devolucao Realizada com Sucesso!").setVisible(true);
                
                this.dispose();
            }
        }else if (oEvento.getSource().equals(this.oButtonCancelar)) {
            this.dispose();
        }
    }
}