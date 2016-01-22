package visao.pesquisa;

import controller.visao.pesquisa.ControllerViewPesquisaFornecedor;
import javax.swing.JLabel;
import visao.ViewModal;
import visao.operacoes.ViewOperacaoRegistrarPedido;

/**
 * Classe responsavel por definir a Interface de Pesquisa de Fornecedores do Sistema.
 * @author  Vanessa
 * @version 1.0
 * @since   09/01/2016
 */
public final class ViewPesquisaFornecedor extends ViewPesquisa {
    private final ViewOperacaoRegistrarPedido viewParent;

    /**
     * Metodo constrututor herdado da superclasse.
     *@author   Vanessa Nakahara 
     * @since  09/01/2016
     * @param oViewParent 
     */
    public ViewPesquisaFornecedor(ViewModal oViewParent) {
        super(oViewParent);
        this.viewParent = (ViewOperacaoRegistrarPedido) oViewParent;
        this.controller = new ControllerViewPesquisaFornecedor(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Pesquisa de Fornecedores");
        this.setSize(370, 450);
        this.setLocation(410, 150);
        this.addHeader();
        this.addComponents();
        this.clear();
    }

    @Override
    public void addHeader() {
        super.addHeader("pesquisa_fornecedor.jpg");
    }
    
    @Override
    public void addComponents() {
        this.add(new JLabel("Fornecedor: "));
        this.addCampos();
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Id", "Nome", "CNPJ"};
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
        ((ControllerViewPesquisaFornecedor) this.controller).pesquisar();
    }

    public ViewOperacaoRegistrarPedido getViewParent() {
        return this.viewParent;
    }
}