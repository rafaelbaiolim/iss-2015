package visao.pesquisa;

import controller.visao.pesquisa.ControllerViewPesquisaCliente;
import javax.swing.JLabel;
import visao.ViewModal;

/**
 * Classe responsavel por definir a Interface de Pesquisa de Clientes do Sistema.
 * @author  Leandro
 * @version 1.0
 * @since   09/01/2016
 */
public final class ViewPesquisaCliente extends ViewPesquisa {
    private final ViewModal viewParent;

    /**
     * Metodo constrututor herdado da superclasse.
     * @since  09/01/2016
     * @param oViewParent 
     */
    public ViewPesquisaCliente(ViewModal oViewParent) {
        super(oViewParent);
        this.viewParent = oViewParent;
        this.controller = new ControllerViewPesquisaCliente(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Pesquisa de Clientes");
        this.setSize(370, 450);
        this.setLocation(410, 150);
        this.addHeader();
        this.addComponents();
        this.clear();
    }

    @Override
    public void addHeader() {
        super.addHeader("pesquisa_cliente.jpg");
    }
    
    @Override
    public void addComponents() {
        this.add(new JLabel("Cliente: "));
        this.addCampos();
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Id", "Nome", "CPF"};
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
        ((ControllerViewPesquisaCliente) this.controller).pesquisar();
    }

    public ViewModal getViewParent() {
        return this.viewParent;
    }
}