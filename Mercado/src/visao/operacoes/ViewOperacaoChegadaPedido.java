package visao.operacoes;

import controller.visao.operacoes.ControllerViewOperacaoChegadaPedido;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.dao.relacionais.entrada.DaoItemPedido;
import modelo.dao.relacionais.entrada.DaoPedido;
import modelo.relacionais.entrada.Pedido;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Chegada de Pedidos do Sistema.
 * @author  Rafael
 * @version 1.0
 * @since   29/12/2015
 */
public final class ViewOperacaoChegadaPedido extends ViewOperacao {
    private JTextField    jTextFieldPedido;
    private JButton       jButtonSearchPedido;
    private JTextField    jTextFieldQuantidadeTotal;
    private JTextField    jTextFieldValorTotal;
    private Pedido        pedido;
    private DaoPedido     daoPedido;
    private DaoItemPedido daoItemPedido;

    public ViewOperacaoChegadaPedido(View oViewParent) {
        super(oViewParent);
        this.controller = new ControllerViewOperacaoChegadaPedido(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Chegada do Pedido");
        this.setSize(450, 500);
        this.setLocation(370, 125);
        this.addHeader();
        this.addComponents();
        this.clear();
    }
    
    @Override
    public void addHeader() {
        super.addHeader("chegada_pedido.jpg");
    }

    @Override
    public void addComponents() {
        this.jTextFieldPedido    = this.createTextField(25);
        this.jTextFieldPedido.setEditable(false);
        this.jButtonSearchPedido = this.createButton("", "search2.jpg");
        
        this.add(new JLabel("Pedido: "));
        this.add(this.jTextFieldPedido);
        this.add(this.jButtonSearchPedido);
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Nome", "Quantidade", "Preço"};
        int[]    iColumns = {50, 10, 10};
        this.setColumns(sColumns);
        this.setColumnSize(iColumns);
        
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
    public void addButtons() {
        this.jButtonAction1 = this.createButton("Confirmar", "ok.jpg");
        this.jButtonAction2 = this.createButton("  Voltar ", "back.jpg");
        
        this.add(this.jButtonAction1);
        this.add(this.jButtonAction2);
    }

    @Override
    public void clear() {
        this.pedido = null;
        this.jTextFieldPedido.setText("");
        this.clearTable();
        this.jTextFieldQuantidadeTotal.setText("0");
        this.jTextFieldValorTotal.setText("0.00");
        this.jTextFieldPedido.requestFocus();
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido oPedido) {
        this.pedido        = oPedido;
        this.daoPedido     = new DaoPedido();
        this.daoItemPedido = new DaoItemPedido();
        this.jTextFieldPedido.setText(this.pedido.toString());
        this.jTextFieldQuantidadeTotal.setText(Integer.toString(this.pedido.getTotalItens()));
        this.jTextFieldValorTotal.setText(Float.toString(this.pedido.getValorTotal()));
        this.addRows(this.daoItemPedido.getItensPedido(this.daoPedido.getItensPedido(this.pedido)));
    }
    
    public JButton getButtonSearchPedido() {
        return this.jButtonSearchPedido;
    }

    public JButton getButtonConfirmar() {
        return this.jButtonAction1;
    }

    public JButton getButtonVoltar() {
        return this.jButtonAction2;
    }
}
