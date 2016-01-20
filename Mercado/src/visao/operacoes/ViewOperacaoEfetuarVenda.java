package visao.operacoes;

import controller.visao.operacoes.ControllerViewOperacaoEfetuarVenda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.cadastrais.Cliente;
import modelo.dao.relacionais.saida.DaoItemVenda;
import modelo.relacionais.saida.ItemVenda;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Venda do Sistema.
 * @author  Hadyne
 * @version 1.0
 * @since   12/01/2016
 */
public final class ViewOperacaoEfetuarVenda extends ViewOperacao {
    private JTextField jTextFieldCliente;
    private JButton    jButtonSearchCliente;
    
    private JButton    jButtonAdicionarItem;
    private JButton    jButtonRemoverItem;
    
    private JTextField jTextFieldQuantidadeTotal;
    private JTextField jTextFieldValorTotal;
    
    private Cliente    cliente;
    private int        quantidade;
    private float      valorTotal;
    private List<ItemVenda> itens;
    private final DaoItemVenda daoItemVenda;
    
    public ViewOperacaoEfetuarVenda(View oViewParent) {
        super(oViewParent);
        this.controller   = new ControllerViewOperacaoEfetuarVenda(this);
        this.itens        = new ArrayList<>();
        this.daoItemVenda = new DaoItemVenda();
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Efetuar Venda");
        this.setSize(450, 530);
        this.setLocation(370, 110);
        this.addHeader();
        this.addComponents();
        this.clear();
    }
    
    @Override
    public void addHeader() {
        super.addHeader("efetuar_venda.jpg");
    }

    @Override
    public void addComponents() {
        this.jTextFieldCliente    = this.createTextField(25);
        this.jTextFieldCliente.setEditable(false);
        this.jButtonSearchCliente = this.createButton("", "search2.jpg");
        this.add(new JLabel("Cliente: "));
        this.add(this.jTextFieldCliente);
        this.add(this.jButtonSearchCliente);
        
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
        this.jButtonAction2.setVisible(false);
    }
    
    public void addItemVenda(ItemVenda oItemVenda) {
        boolean bAdd  = false;
        for (int i = 0; i < this.itens.size(); ++i) {
            if ((this.itens.get(i).getProduto().equals(oItemVenda.getProduto()))
                    && (this.itens.get(i).getValorUnitario() == oItemVenda.getValorUnitario())) {
                this.itens.get(i).setQuantidade(this.itens.get(i).getQuantidade() + oItemVenda.getQuantidade());
                this.quantidade += oItemVenda.getQuantidade();
                this.valorTotal += (oItemVenda.getQuantidade() * oItemVenda.getValorUnitario());
                bAdd = true;
            }
        }
        if (bAdd == false) {
            this.itens.add(oItemVenda);
            this.quantidade += oItemVenda.getQuantidade();
            this.valorTotal += (oItemVenda.getQuantidade() * oItemVenda.getValorUnitario());
        }
        this.refreshTable();
    }
    
    public void removeItemVenda(int iIndex) {
        this.quantidade -= this.itens.get(iIndex).getQuantidade();
        this.valorTotal -= this.itens.get(iIndex).getQuantidade() * this.itens.get(iIndex).getValorUnitario();
        this.itens.remove(iIndex);
        this.refreshTable();
    }
    
    public boolean checkQuantidade(ItemVenda oItemVenda) {
        for (int i = 0; i < this.itens.size(); ++i) {
            if (this.itens.get(i).getProduto().equals(oItemVenda.getProduto())) {
                return ((this.itens.get(i).getQuantidade() + oItemVenda.getQuantidade()) <= this.itens.get(i).getProduto().getQuantidade());
            }
        }
        return true;
    }
    
    public void refreshTable() {
        this.addRows(this.daoItemVenda.getItensVenda(this.itens));
        this.jTextFieldQuantidadeTotal.setText(Integer.toString(this.quantidade));
        this.jTextFieldValorTotal.setText(Float.toString(this.valorTotal));
    }

    @Override
    public void clear() {
        this.cliente    = null;
        this.itens      = new ArrayList<>();
        this.valorTotal = 0.0f;
        this.quantidade = 0;
        
        this.jTextFieldCliente.setText("");
        this.refreshTable();
    }

    public JButton getButtonSearchCliente() {
        return this.jButtonSearchCliente;
    }

    public JButton getButtonAdicionarItem() {
        return this.jButtonAdicionarItem;
    }

    public JButton getButtonRemoverItem() {
        return this.jButtonRemoverItem;
    }

    public List<ItemVenda> getItens() {
        return this.itens;
    }
    
    public int getQuantidade() {
        return this.quantidade;
    }

    public float getValorTotal() {
        return this.valorTotal;
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente oCliente) {
        this.cliente = oCliente;
        this.jTextFieldCliente.setText(this.cliente.toString());
    }
}