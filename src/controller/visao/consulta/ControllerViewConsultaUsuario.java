package controller.visao.consulta;

import java.awt.event.ActionEvent;
import java.util.List;
import modelo.dao.estruturais.DaoUsuario;
import modelo.estruturais.Usuario;
import controller.Controller;
import visao.consulta.ViewConsultaUsuario;
import visao.editar.ViewEditarUsuario;
import visao.mensagens.ViewErro;
import visao.remover.ViewRemoverUsuario;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewConsultaUsuario.
 * @author  Leandro
 * @version 1.0
 * @since   29/10/2015
 * @see     controller.Controller
 */
public class ControllerViewConsultaUsuario extends Controller {
    private final ViewConsultaUsuario viewConsultaUsuario;
    private final DaoUsuario          daoUsuario;
    private       List<Usuario>       usuarios;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewConsultaUsuario(ViewConsultaUsuario oView) {
        this.viewConsultaUsuario = oView;
        this.daoUsuario          = new DaoUsuario();
        this.usuarios            = this.daoUsuario.list();
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        int iIndexSelecionado = this.viewConsultaUsuario.getTable().getSelectedRow();
        int iUsuariosListados = this.usuarios.size();
        if (oActionEvent.getSource().equals(this.viewConsultaUsuario.getButtonPesquisa())) {
            String sUsuario = this.viewConsultaUsuario.getTextFieldPesquisa().getText();
            this.usuarios   = this.daoUsuario.findUsuariosByLogin(sUsuario);
            this.viewConsultaUsuario.addRows(this.daoUsuario.getUsuarios(this.usuarios));
        }else if (oActionEvent.getSource().equals(this.viewConsultaUsuario.getButtonEdit())) {
            if ((iIndexSelecionado >= 0) 
                    && (iIndexSelecionado < iUsuariosListados)) {
                new ViewEditarUsuario(this.viewConsultaUsuario, this.usuarios.get(iIndexSelecionado)).setVisible(true);
            }else {
                new ViewErro(this.viewConsultaUsuario, "Selecione um Usuario!").setVisible(true);
                this.viewConsultaUsuario.getTextFieldPesquisa().requestFocus();
            }
        }else if (oActionEvent.getSource().equals(this.viewConsultaUsuario.getButtonRemove())) {
            if ((iIndexSelecionado >= 0) 
                    && (iIndexSelecionado < iUsuariosListados)) {
                new ViewRemoverUsuario(this.viewConsultaUsuario, this.usuarios.get(iIndexSelecionado)).setVisible(true);
            }else {
                new ViewErro(this.viewConsultaUsuario, "Selecione um Usuario!").setVisible(true);
                this.viewConsultaUsuario.getTextFieldPesquisa().requestFocus();
            }
        }else if (oActionEvent.getSource().equals(this.viewConsultaUsuario.getButtonBack())) {
            this.viewConsultaUsuario.dispose();
        }
    }
}