package controller.visao.consulta;

import java.awt.event.ActionEvent;
import java.util.List;
import modelo.dao.estruturais.DaoUsuario;
import modelo.estruturais.Usuario;
import java.awt.event.KeyEvent;
import visao.consulta.ViewConsultaUsuario;
import visao.editar.ViewEditarUsuario;
import visao.mensagens.ViewErro;
import visao.remover.ViewRemoverUsuario;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewConsultaUsuario.
 * @author  Rafael
 * @version 1.0
 * @since   29/10/2015
 * @see     controller.visao.consulta.ControllerViewConsulta
 */
public class ControllerViewConsultaUsuario extends ControllerViewConsulta {
    private final ViewConsultaUsuario viewConsultaUsuario;
    private final DaoUsuario          daoUsuario;
    private       List<Usuario>       usuarios;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewConsultaUsuario(ViewConsultaUsuario oView) {
        super(oView);
        this.viewConsultaUsuario = oView;
        this.daoUsuario          = new DaoUsuario();
        this.usuarios            = this.daoUsuario.list();
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        super.actionPerformed(oActionEvent);
    }
    
     @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
    }

    @Override
    protected void pesquisar() {
        String sUsuario = this.viewConsultaUsuario.getTextFieldPesquisa().getText();
        this.usuarios   = this.daoUsuario.findUsuariosByLogin(sUsuario);
        this.viewConsultaUsuario.addRows(this.daoUsuario.getUsuarios(this.usuarios));
    }

    @Override
    protected void edit() {
        int iIndex    = this.viewConsultaUsuario.getTable().getSelectedRow();
        int iUsuarios = this.usuarios.size();
        if ((iIndex >= 0) 
         && (iIndex < iUsuarios)) {
            new ViewEditarUsuario(this.viewConsultaUsuario, this.usuarios.get(iIndex)).setVisible(true);
        }else {
            new ViewErro(this.viewConsultaUsuario, "Selecione um Usuario!").setVisible(true);
            this.viewConsultaUsuario.getTextFieldPesquisa().requestFocus();
        }
    }

    @Override
    protected void remove() {
        int iIndex    = this.viewConsultaUsuario.getTable().getSelectedRow();
        int iUsuarios = this.usuarios.size();
        if ((iIndex >= 0) 
         && (iIndex < iUsuarios)) {
            new ViewRemoverUsuario(this.viewConsultaUsuario, this.usuarios.get(iIndex)).setVisible(true);
        }else {
            new ViewErro(this.viewConsultaUsuario, "Selecione um Usuario!").setVisible(true);
            this.viewConsultaUsuario.getTextFieldPesquisa().requestFocus();
        }
    }
}