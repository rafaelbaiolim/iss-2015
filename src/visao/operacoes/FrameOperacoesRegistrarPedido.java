/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 18/08/2015                                                         *
 * Classe: visao.operacoes.FrameOperacoesRegistrarPedido                      *
 * Coment: Classe responsavel por representar o Frame de Registrar Pedido no  *
 *         Sistema.                                                           *
 *         Subclasse da Classe Abstrata FrameOperacoes.                       *
 * ========================================================================== */

package visao.operacoes;

import modelo.cadastrais.Produto;
import modelo.gerenciais.Fornecedor;
import modelo.internos.Usuario;
import modelo.relacionais.ItemPedido;
import modelo.relacionais.Pedido;
import visao.Frame;
import visao.pesquisa.FramePesquisarFornecedor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameOperacoesRegistrarPedido extends FrameOperacoes {
    private JLabel           oLabelHeader;
    
    private JTextField       oTextFieldFuncionario;
    
    private JTextField       oTextFieldFornecedor;
    private JButton          oButtonSearch;
    
    private JTextField       oTextFieldTotalItens;
    private JTextField       oTextFieldValorTotal;
    
    private JButton          oButtonFinalizar;
    private JButton          oButtonCancelar;
    
    private Usuario          usuario;
    private Pedido           pedido;
    private List<ItemPedido> itensPedido;

    public FrameOperacoesRegistrarPedido(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario     = oUsuario;
        this.pedido      = new Pedido();
        this.itensPedido = new ArrayList<>();
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Registrar Pedido");
        this.setLocation(300, 70);
        this.setSize(500, 560);
        this.addComponents();
    }
    
    private void addComponents() {
        
        this.addLine(1);
        
        this.oLabelHeader      = new JLabel("REGISTRAR PEDIDO");
        this.oLabelHeader.setFont(new Font("Tahoma", 1, 25));
        this.add(this.oLabelHeader);
        
        this.addLine(1);
        
        this.oTextFieldFuncionario = new JTextField(25);
        this.oTextFieldFuncionario.setEditable(false);
        this.oTextFieldFuncionario.setText(this.usuario.getFuncionario().toString());
        this.add(new JLabel("Funcionario: "));
        this.add(this.oTextFieldFuncionario);
        
        this.addLine(1);
        
        this.oTextFieldFornecedor  = new JTextField(20);
        this.oButtonSearch         = this.createButton("", "search.jpg");
        this.oTextFieldFornecedor.setEditable(false);
        this.add(new JLabel("Fornecedor: "));
        this.add(this.oTextFieldFornecedor);
        this.add(this.oButtonSearch);
        
        this.addLine(1);
        
        this.addTable();
        String[] sDados = {"Produto", "Quantidade", "Preco Compra"};
        this.addColumns(sDados);
        this.oScrollPane.setPreferredSize(new Dimension(350, 150));
        
        this.addLine(1);
        
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

        this.oButtonFinalizar = this.createButton("Finalizar", "yes.jpg");
        this.oButtonCancelar  = this.createButton(" Cancelar", "no.jpg");
        
        this.add(this.oButtonFinalizar);
        this.add(this.oButtonCancelar);
    }
    
    public void setFornecedor(Fornecedor oFornecedor) {
        this.pedido.setFornecedor(oFornecedor);
        this.oTextFieldFornecedor.setText(this.pedido.getFornecedor().toString());
    }

    private void atualizarDados() {
        this.clearTable();
        String[][] sItensPedido = new String[this.itensPedido.size()][3];
        float      fValorTotal  = 0.0f;
        int        iTotalItens  = 0;
        for (int i = 0; i < this.itensPedido.size(); ++i) {                
            sItensPedido[i][0] = this.itensPedido.get(i).getProduto().getDescricao();
            sItensPedido[i][1] = Integer.toString(this.itensPedido.get(i).getQuantidade());
            sItensPedido[i][2] = Float.toString(this.itensPedido.get(i).getPrecoUnitario());
            iTotalItens      += this.itensPedido.get(i).getQuantidade();
            fValorTotal      += this.itensPedido.get(i).getPrecoUnitario() * this.itensPedido.get(i).getQuantidade();
        }
        this.addRows(sItensPedido);
        this.oTextFieldTotalItens.setText(Integer.toString(iTotalItens));
        this.oTextFieldValorTotal.setText(Float.toString(fValorTotal));
        this.pedido.setTotalItens(iTotalItens);
        this.pedido.setValorTotal(fValorTotal);
    }

    public void addProduto(Produto oProduto, int iQuantidade, float fPrecoUnitario) {
        boolean bAdd = false;
        if (this.itensPedido.isEmpty() == false) {
            for (ItemPedido oCurrentItemPedido : this.itensPedido) {
                if ((oCurrentItemPedido.getProduto().equals(oProduto)) 
                        && (oCurrentItemPedido.getPrecoUnitario() == fPrecoUnitario)) {
                    oCurrentItemPedido.setQuantidade(oCurrentItemPedido.getQuantidade() + iQuantidade);
                    bAdd = true;
                }
            }
        }
        
        if (bAdd == false) {
            this.itensPedido.add(new ItemPedido(this.pedido, oProduto, iQuantidade, fPrecoUnitario));
        }
        this.atualizarDados();
    }


    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSearch)) {
            new FramePesquisarFornecedor(this).setVisible(true);
        }else if (oEvento.getSource().equals(this.oButtonAdd)) {
            new FrameOperacoesAdicionarProduto(this).setVisible(true);
        }else if (oEvento.getSource().equals(this.oButtonRemove)) {
            if ((this.oTable.getSelectedRow() > -1) 
                    && (this.oTable.getSelectedRows().length == 1)) {
                this.itensPedido.remove(this.oTable.getSelectedRow());
                this.atualizarDados();
            }
        }else if (oEvento.getSource().equals(this.oButtonFinalizar)) {
            if ((this.itensPedido.isEmpty() == false)
                    && (this.pedido.getFornecedor() != null)) {
                new FrameOperacoesFinalizarPedido(this, this.usuario, this.pedido, this.itensPedido).setVisible(true);
            }
        }else if (oEvento.getSource().equals(this.oButtonCancelar)) {
            this.dispose();
        }
    }
}