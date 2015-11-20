package visao.pesquisa;

import javax.swing.JLabel;
import modelo.dao.estruturais.DaoUsuario;
import visao.ViewModal;

/**
 * Classe responsavel por definir a Interface de Pesquisa de Usuarios do Sistema.
 * @author  Leandro Flores
 * @version 1.0
 * @since   03/11/2015
 */
public class ViewPesquisaUsuario extends ViewPesquisa {

    public ViewPesquisaUsuario(ViewModal oViewParent) {
        super(oViewParent);
    }

    @Override
    public void initComponents() {
        this.setTitle("UEM/ASP - Pesquisar Usuário");
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
        this.add(new JLabel("Usuário: "));
        this.addCampos();
        
        this.addLinhas(1);
        
        this.addTable();
        String[] sColumns = {"Id", "Login", "Ativo"};
        int[]    iColumns = {5, 80, 15};
        this.setColumns(sColumns, iColumns);
        
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