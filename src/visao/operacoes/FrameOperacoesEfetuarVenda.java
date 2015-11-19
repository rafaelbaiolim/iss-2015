/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 18/08/2015                                                         *
 * Classe: visao.operacoes.FrameOperacoesEfetuarVenda                         *
 * Coment: Classe responsavel por representar o Frame de Efetuar Venda no     *
 *         Sistema.                                                           *
 *         Subclasse da Classe Abstrata FrameOperacoes.                       *
 * ========================================================================== */

package visao.operacoes;

import visao.pesquisa.FramePesquisarCliente;
import modelo.cadastrais.Cliente;
import modelo.cadastrais.Produto;
import modelo.internos.Usuario;
import modelo.relacionais.ItemVenda;
import modelo.relacionais.Venda;
import visao.Frame;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameOperacoesEfetuarVenda extends FrameOperacoes {
    private JLabel          oLabelHeader;
    
    private JTextField      oTextFieldFuncionario;
    
    private JTextField      oTextFieldCliente;
    private JButton         oButtonSearch;
    
    private JTextField      oTextFieldTotalItens;
    private JTextField      oTextFieldValorTotal;
    
    private JButton         oButtonFinalizar;
    private JButton         oButtonCancelar;
    
    private Usuario         usuario;
    private Venda           venda;
    private List<ItemVenda> itensVenda;

    public FrameOperacoesEfetuarVenda(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario    = oUsuario;
        this.venda      = new Venda();
        this.itensVenda = new ArrayList<>();
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Efetuar Venda");
        this.setLocation(300, 70);
        this.setSize(500, 550);
        this.addComponents();
    }
    
    private void addComponents() {
        
        this.addLine(1);
        
        this.oLabelHeader      = new JLabel("EFETUAR VENDA");
        this.oLabelHeader.setFont(new Font("Tahoma", 1, 25));
        this.add(this.oLabelHeader);
        
        this.addLine(1);
        
        this.oTextFieldFuncionario = new JTextField(30);
        this.oTextFieldFuncionario.setEditable(false);
        this.oTextFieldFuncionario.setText(this.usuario.getFuncionario().toString());
        this.add(new JLabel("Funcionario: "));
        this.add(this.oTextFieldFuncionario);
        
        this.addLine(1);
        
        this.oTextFieldCliente     = new JTextField(25);
        this.oButtonSearch         = this.createButton("", "search.jpg");
        this.oTextFieldCliente.setEditable(false);
        this.add(new JLabel("Nome Cliente: "));
        this.add(this.oTextFieldCliente);
        this.add(this.oButtonSearch);
        
        this.addLine(1);
        
        this.addTable();
        String[] sDados = {"Produto", "Quantidade", "Preco Unitário"};
        this.addColumns(sDados);
        this.oScrollPane.setPreferredSize(new Dimension(350, 150));
        
        this.addButtons();
        this.oButtonEdit.setVisible(false);
        
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
        
        this.oButtonFinalizar     = this.createButton("Finalizar", "yes.jpg");
        this.oButtonCancelar     = this.createButton(" Cancelar", "no.jpg");
        this.add(this.oButtonFinalizar);
        this.add(this.oButtonCancelar);
    }

    private void atualizarDados() {
        this.clearTable();
        String[][] sItensVenda = new String[this.itensVenda.size()][3];
        float      fValorTotal = 0.0f;
        int        iTotalItens = 0;
        for (int i = 0; i < this.itensVenda.size(); ++i) {                
            sItensVenda[i][0] = this.itensVenda.get(i).getProduto().getDescricao();
            sItensVenda[i][1] = Integer.toString(this.itensVenda.get(i).getQuantidade());
            sItensVenda[i][2] = Float.toString(this.itensVenda.get(i).getValorUnitario());
            fValorTotal      += (this.itensVenda.get(i).getValorUnitario() * this.itensVenda.get(i).getQuantidade());
            iTotalItens      += this.itensVenda.get(i).getQuantidade();
        }
        this.addRows(sItensVenda);
        this.oTextFieldTotalItens.setText(Integer.toString(iTotalItens));
        this.oTextFieldValorTotal.setText(Float.toString(fValorTotal));
        this.venda.setNumeroItens(iTotalItens);
        this.venda.setValorTotal(fValorTotal);
    }
    
    public void addCliente(Cliente oCliente) {
        this.venda.setCliente(oCliente);
        this.oTextFieldCliente.setText(this.venda.getCliente().toString());
    }
    
    public void addProduto(Produto oProduto, int iQuantidade) {
        boolean bAdd = false;
        if (this.itensVenda.isEmpty() == false) {
            for (ItemVenda oCurrentItemVenda : this.itensVenda) {
                if (oCurrentItemVenda.getProduto().equals(oProduto)) {
                    oCurrentItemVenda.setQuantidade(oCurrentItemVenda.getQuantidade() + iQuantidade);
                    bAdd = true;
                }
            }
        }
        
        if (bAdd == false) {
            this.itensVenda.add(new ItemVenda(oProduto, iQuantidade, oProduto.getPrecoUnitario(), this.venda));
        }
        this.atualizarDados();
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSearch)) {
            new FramePesquisarCliente(this).setVisible(true);
        }else if (oEvento.getSource().equals(this.oButtonAdd)) {
            new FrameOperacoesInserirProduto(this).setVisible(true);
        }else if (oEvento.getSource().equals(this.oButtonRemove)) {
            if ((this.oTable.getSelectedRow() > -1) 
                    && (this.oTable.getSelectedRows().length == 1)) {
                this.itensVenda.remove(this.oTable.getSelectedRow());
                this.atualizarDados();
            }
        }else if (oEvento.getSource().equals(this.oButtonFinalizar)) {
            this.venda.setFuncionario(this.usuario);
            if (this.itensVenda.isEmpty() == false) {
                new FrameOperacoesFinalizarVenda(this, this.venda, this.itensVenda, this.usuario).setVisible(true);
            }
        }else if (oEvento.getSource().equals(this.oButtonCancelar)) {
            this.dispose();
        }
    }
}