package visao.pesquisa;

import controller.visao.pesquisa.ControllerViewPesquisaProduto;
import javax.swing.JLabel;
import visao.ViewModal;

/**
 * Classe responsavel por definir a Interface de Pesquisa de Produtos do Sistema.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   13/01/2016
 */
public final class ViewPesquisaProduto extends ViewPesquisa {
    private final ViewModal viewParent;

    /**
     * Metodo constrututor herdado da superclasse.
     * @param oViewParent 
     */
    public ViewPesquisaProduto(ViewModal oViewParent) {
        super(oViewParent);
        this.viewParent = oViewParent;
        this.controller = new ControllerViewPesquisaProduto(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Pesquisa de Produtos");
        this.setSize(370, 450);
        this.setLocation(410, 150);
        this.addHeader();
        this.addComponents();
        this.clear();
    }

    @Override
    public void addHeader() {
        super.addHeader("pesquisa_produto.jpg");
    }
    
    @Override
    public void addComponents() {
        this.add(new JLabel("Produto: "));
        this.addCampos();
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Id", "Descricao", "Marca"};
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
        ((ControllerViewPesquisaProduto) this.controller).pesquisar();
    }

    public ViewModal getViewParent() {
        return this.viewParent;
    }
}