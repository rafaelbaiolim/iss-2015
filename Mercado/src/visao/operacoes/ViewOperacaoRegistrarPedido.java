package visao.operacoes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.cadastrais.Produto;
import modelo.gerenciais.Fornecedor;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Registro de Pedidos do Sistema.
 * @author  Leandro
 * @version 1.0
 * @since   28/12/2015
 */
public final class ViewOperacaoRegistrarPedido extends ViewOperacao {
    private JTextField jTextFieldFornecedor;
    private JButton    jButtonSearchFornecedor;
    
    private JButton    jButtonAdicionarItem;
    private JButton    jButtonEditarItem;
    private JButton    jButtonRemoverItem;
    
    private JTextField jTextFieldQuantidadeTotal;
    private JTextField jTextFieldValorTotal;
    
    private Fornecedor fornecedor;
    
    private List<Produto> itens;
    
    public ViewOperacaoRegistrarPedido(View oViewParent) {
        super(oViewParent);
        //this.controller =
        this.initComponents();
        this.itens = new ArrayList<>();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Registrar Pedido");
        this.setSize(450, 530);
        this.setLocation(370, 110);
        this.addHeader();
        this.addComponents();
        this.clear();
    }
    
    @Override
    public void addHeader() {
        super.addHeader("registrar_pedido.jpg");
    }

    @Override
    public void addComponents() {
        this.jTextFieldFornecedor    = this.createTextField(25);
        this.jTextFieldFornecedor.setEditable(false);
        this.jButtonSearchFornecedor = this.createButton("", "search2.jpg");
        this.add(new JLabel("Fornecedor: "));
        this.add(this.jTextFieldFornecedor);
        this.add(this.jButtonSearchFornecedor);
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Nome", "Quantidade", "Preço"};
        this.setColumns(sColumns);
        
        int[]    iColumns = {50, 10, 10};
        this.setColumnSize(iColumns);
        
        this.jButtonAdicionarItem = this.createButton("Adicionar", "add.jpg");
        this.jButtonEditarItem    = this.createButton("  Editar ", "edit.jpg");
        this.jButtonRemoverItem   = this.createButton(" Remover ", "exit.jpg");
        
        this.add(this.jButtonAdicionarItem);
        this.add(this.jButtonEditarItem);
        this.add(this.jButtonRemoverItem);
        
        this.addLinhas(1);
        
        this.jTextFieldQuantidadeTotal = this.createTextField(5);
        this.jTextFieldQuantidadeTotal.setText("0");
        this.jTextFieldQuantidadeTotal.setEditable(false);
        this.jTextFieldValorTotal      = this.createTextField(10);
        this.jTextFieldValorTotal.setText("0.00");
        this.jTextFieldValorTotal.setEditable(false);
        
        this.add(new JLabel("Total Itens: "));
        this.add(this.jTextFieldQuantidadeTotal);
        this.add(new JLabel("   "));
        this.add(new JLabel("Valor Total"));
        this.add(this.jTextFieldValorTotal);
        
        this.addLinhas(1);
        
        this.addButtons();
    }

    @Override
    public void clear() {
        this.fornecedor = null;
        this.itens      = new ArrayList<>();
        
        this.jTextFieldFornecedor.setText("");
        this.clearTable();
    }

    public JButton getButtonSearchFornecedor() {
        return this.jButtonSearchFornecedor;
    }

    public JButton getButtonAdicionarItem() {
        return this.jButtonAdicionarItem;
    }

    public JButton getButtonEditarItem() {
        return this.jButtonEditarItem;
    }

    public JButton getButtonRemoverItem() {
        return this.jButtonRemoverItem;
    }

    public Fornecedor getFornecedor() {
        return this.fornecedor;
    }

    public void setFornecedor(Fornecedor oFornecedor) {
        this.fornecedor = oFornecedor;
        this.jTextFieldFornecedor.setText(this.fornecedor.toString());
    }
}