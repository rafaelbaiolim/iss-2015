package visao.consulta;

import modelo.dao.estruturais.DaoUsuario;
import javax.swing.JLabel;
import visao.View;
import controller.visao.consulta.ControllerViewConsultaUsuario;

/**
 * Classe responsavel por definir a Interface de Consulta de Usuarios do Sistema.
 * @author  Rafael
 * @version 1.0
 * @since   22/10/2015
 */
public final class ViewConsultaUsuario extends ViewConsulta {

    /**
     * Metodo constrututor herdado da superclasse.
     * @since  22/10/2015
     * @param oViewParent 
     */
    public ViewConsultaUsuario(View oViewParent) {
        super(oViewParent);
        this.controller = new ControllerViewConsultaUsuario(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Consulta de Usuários");
        this.setSize(370, 450);
        this.setLocation(410, 150);
        this.addHeader();
        this.addComponents();
        this.clear();
    }

    @Override
    public void addHeader() {
        super.addHeader("consulta_usuario.jpg");
    }
    
    @Override
    public void addComponents() {
        this.add(new JLabel("Usuário: "));
        this.addCampos();
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Id", "Login", "Ativo"};
        this.setColumns(sColumns);
        
        int[]    iColumns = {75, 250, 75};
        this.setColumnSize(iColumns);
        
        this.addLinhas(1);
        
        this.addButtons();
    }

    @Override
    public void clear() {
        this.jTextFieldPesquisa.setText("");
        this.jTextFieldPesquisa.requestFocus();
        this.addRows(new DaoUsuario().getUsuarios(new DaoUsuario().list()));
    }
}