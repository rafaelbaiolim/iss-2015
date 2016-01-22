package visao.operacoes;

import controller.visao.operacoes.ControllerViewOperacaoRegistrarPedido;
import funct.FunctDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.dao.relacionais.entrada.DaoItemPedido;
import modelo.gerenciais.Fornecedor;
import modelo.relacionais.entrada.ItemPedido;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Registro de Pedidos do Sistema.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   28/12/2015
 */
public final class ViewOperacaoRegistrarPedido extends ViewOperacao {
    private JTextField jTextFieldFornecedor;
    private JButton    jButtonSearchFornecedor;
    
    private JButton    jButtonAdicionarItem;
    private JButton    jButtonRemoverItem;
    
    private JTextField jTextFieldQuantidadeTotal;
    private JTextField jTextFieldValorTotal;
    private JTextField jTextFieldDataPagamento;
    
    private Fornecedor fornecedor;
    
    private List<ItemPedido> itens;
    private int              quantidade;
    private float            valorTotal;
    private final DaoItemPedido daoItemPedido;
    
    public ViewOperacaoRegistrarPedido(View oViewParent) {
        super(oViewParent);
        this.controller    = new ControllerViewOperacaoRegistrarPedido(this);
        this.itens         = new ArrayList<>();
        this.quantidade    = 0;
        this.valorTotal    = 0.0f;
        this.daoItemPedido = new DaoItemPedido();
        this.initComponents();
        
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Registrar Pedido");
        this.setSize(450, 570);
        this.setLocation(370, 90);
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
        this.jButtonRemoverItem   = this.createButton(" Remover ", "exit.jpg");
        
        this.add(this.jButtonAdicionarItem);
        this.add(this.jButtonRemoverItem);
        
        this.addLinhas(1);
        
        this.jTextFieldQuantidadeTotal = this.createTextField(4);
        this.jTextFieldQuantidadeTotal.setText("0");
        this.jTextFieldQuantidadeTotal.setEditable(false);
        this.jTextFieldValorTotal      = this.createTextField(6);
        this.jTextFieldValorTotal.setText("0.00");
        this.jTextFieldValorTotal.setEditable(false);
        
        this.add(new JLabel("Total Itens: "));
        this.add(this.jTextFieldQuantidadeTotal);
        this.add(new JLabel("   "));
        this.add(new JLabel("Valor Total"));
        this.add(this.jTextFieldValorTotal);
        this.add(new JLabel("   "));
        
        this.addLinhas(1);
        
        this.jTextFieldDataPagamento   = this.createTextField(6);
        this.jTextFieldDataPagamento.setText(new FunctDate().getFormattedDate(new Date()));
        this.add(new JLabel("Data Pagamento"));
        this.add(this.jTextFieldDataPagamento);
        
        this.addLinhas(1);
        
        this.addButtons();
        
        this.jButtonAction2.setVisible(false);
    }

    @Override
    public void clear() {
        this.fornecedor = null;
        this.itens      = new ArrayList<>();
        this.quantidade = 0;
        this.valorTotal = 0;
        
        this.jTextFieldFornecedor.setText("");
        this.refreshTable();
    }
    
    public void addItemPedido(ItemPedido oItemPedido) {
        boolean bAdd  = false;
        for (int i = 0; i < this.itens.size(); ++i) {
            if ((this.itens.get(i).getProduto().equals(oItemPedido.getProduto()))
                    && (this.itens.get(i).getPrecoUnitario() == oItemPedido.getPrecoUnitario())) {
                this.itens.get(i).setQuantidade(this.itens.get(i).getQuantidade() + oItemPedido.getQuantidade());
                this.quantidade += oItemPedido.getQuantidade();
                this.valorTotal += (oItemPedido.getQuantidade() * oItemPedido.getPrecoUnitario());
                bAdd = true;
            }
        }
        if (bAdd == false) {
            this.itens.add(oItemPedido);
            this.quantidade += oItemPedido.getQuantidade();
            this.valorTotal += (oItemPedido.getQuantidade() * oItemPedido.getPrecoUnitario());
        }
        this.refreshTable();
    }
    
    public void removeItemPedido(int iIndex) {
        this.quantidade -= this.itens.get(iIndex).getQuantidade();
        this.valorTotal -= this.itens.get(iIndex).getQuantidade() * this.itens.get(iIndex).getPrecoUnitario();
        this.itens.remove(iIndex);
        this.refreshTable();
    }
    
    public void refreshTable() {
        this.addRows(this.daoItemPedido.getItensPedido(this.itens));
        this.jTextFieldQuantidadeTotal.setText(Integer.toString(this.quantidade));
        this.jTextFieldValorTotal.setText(Float.toString(this.valorTotal));
    }

    public JButton getButtonSearchFornecedor() {
        return this.jButtonSearchFornecedor;
    }

    public JButton getButtonAdicionarItem() {
        return this.jButtonAdicionarItem;
    }

    public JButton getButtonRemoverItem() {
        return this.jButtonRemoverItem;
    }

    public JTextField getTextFieldDataPagamento() {
        return this.jTextFieldDataPagamento;
    }

    public List<ItemPedido> getItens() {
        return this.itens;
    }
    
    public Fornecedor getFornecedor() {
        return this.fornecedor;
    }

    public void setFornecedor(Fornecedor oFornecedor) {
        this.fornecedor = oFornecedor;
        this.jTextFieldFornecedor.setText(this.fornecedor.toString());
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public float getValorTotal() {
        return this.valorTotal;
    }
}