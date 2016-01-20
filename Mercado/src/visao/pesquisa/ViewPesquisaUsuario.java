package visao.pesquisa;

import controller.visao.pesquisa.ControllerViewPesquisaUsuario;
import javax.swing.JLabel;
import visao.ViewModal;

/**
 * Classe responsavel por definir a Interface de Pesquisa de Usuarios do Sistema.
 * @author  Rafael
 * @version 1.0
 * @since   18/01/2016
 */
public final class ViewPesquisaUsuario extends ViewPesquisa {
    private final ViewModal viewParent;

    /**
     * Metodo constrututor herdado da superclasse.
     * @param oViewParent 
     */
    public ViewPesquisaUsuario(ViewModal oViewParent) {
        super(oViewParent);
        this.viewParent = oViewParent;
        this.controller = new ControllerViewPesquisaUsuario(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Pesquisa de Usuários");
        this.setSize(370, 450);
        this.setLocation(410, 150);
        this.addHeader();
        this.addComponents();
        this.clear();
    }

    @Override
    public void addHeader() {
        super.addHeader("pesquisa_usuario.jpg");
    }
    
    @Override
    public void addComponents() {
        this.add(new JLabel("Usuario: "));
        this.addCampos();
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Id", "Login", "Ativo"};
        this.setColumns(sColumns);
        
        int[]    iColumns = {75, 200, 120};
        this.setColumnSize(iColumns);
        
        this.addLinhas(1);
        
        this.addButtons();
    }

    @Override
    public void clear() {
        this.jTextFieldPesquisa.setText("");
        this.jTextFieldPesquisa.requestFocus();
        ((ControllerViewPesquisaUsuario) this.controller).pesquisar();
    }

    public ViewModal getViewParent() {
        return this.viewParent;
    }
}