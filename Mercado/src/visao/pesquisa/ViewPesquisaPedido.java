package visao.pesquisa;

import controller.visao.pesquisa.ControllerViewPesquisaPedido;
import javax.swing.JLabel;
import visao.ViewModal;
import visao.operacoes.ViewOperacaoChegadaPedido;

/**
 * Classe responsavel por definir a Interface de Pesquisa de Pedidos do Sistema.
 * @author  Vanessa
 * @version 1.0
 * @since   09/01/2016
 */
public final class ViewPesquisaPedido extends ViewPesquisa {
    private final ViewOperacaoChegadaPedido viewParent;

    /**
     * Metodo constrututor herdado da superclasse.
     * @since  09/01/2016
     * @param oViewParent 
     */
    public ViewPesquisaPedido(ViewModal oViewParent) {
        super(oViewParent);
        this.viewParent = (ViewOperacaoChegadaPedido) oViewParent;
        this.controller = new ControllerViewPesquisaPedido(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Pesquisa de Pedidos");
        this.setSize(370, 450);
        this.setLocation(410, 150);
        this.addHeader();
        this.addComponents();
        this.clear();
    }

    @Override
    public void addHeader() {
        super.addHeader("pesquisa_pedido.jpg");
    }
    
    @Override
    public void addComponents() {
        this.add(new JLabel("Pedido: "));
        this.addCampos();
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Id", "Data", "Hora"};
        this.setColumns(sColumns);
        
        int[]    iColumns = {75, 160, 160};
        this.setColumnSize(iColumns);
        
        this.addLinhas(1);
        
        this.addButtons();
    }

    @Override
    public void clear() {
        this.jTextFieldPesquisa.setText("");
        this.jTextFieldPesquisa.requestFocus();
        ((ControllerViewPesquisaPedido) this.controller).pesquisar();
    }

    public ViewOperacaoChegadaPedido getViewParent() {
        return this.viewParent;
    }
}