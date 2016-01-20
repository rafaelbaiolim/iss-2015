package controller.visao.pesquisa;

import controller.visao.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.util.List;
import modelo.dao.estruturais.DaoUsuario;
import modelo.estruturais.Usuario;
import visao.mensagens.ViewErro;
import visao.operacoes.ViewOperacaoGerenciarUsuario;
import visao.pesquisa.ViewPesquisaUsuario;

/**
 * Classe responsavel por definir o controlador da View de Pesquisa de Usuarios.
 * @author  Rafael
 * @version 1.0
 * @since   18/01/2016
 */
public class ControllerViewPesquisaUsuario extends ControllerViewModal {
    private final ViewPesquisaUsuario viewPesquisaUsuario;
    private final DaoUsuario          daoUsuario;
    private       List<Usuario>       usuarios;

    public ControllerViewPesquisaUsuario(ViewPesquisaUsuario oView) {
        super(oView);
        this.viewPesquisaUsuario = oView;
        this.daoUsuario          = new DaoUsuario();
        this.usuarios            = this.daoUsuario.list();
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewPesquisaUsuario.getButtonPesquisa())) {
            this.pesquisar();
        }else if (oActionEvent.getSource().equals(this.viewPesquisaUsuario.getButtonSelect())) {
            this.select();
        }else if (oActionEvent.getSource().equals(this.viewPesquisaUsuario.getButtonBack())) {
            this.viewPesquisaUsuario.dispose();
        }
    }

    public void pesquisar() {
        String sUsuario = this.viewPesquisaUsuario.getTextFieldPesquisa().getText();
        this.usuarios   = this.daoUsuario.findUsuariosByLogin(sUsuario);
        this.viewPesquisaUsuario.addRows(this.daoUsuario.getUsuarios(this.usuarios));
    }
    
    protected void select() {
        int iIndex    = this.viewPesquisaUsuario.getTable().getSelectedRow();
        int iUsuarios = this.usuarios.size();
        if ((iIndex >= 0) 
            && (iIndex < iUsuarios)) {
            ((ViewOperacaoGerenciarUsuario) this.viewPesquisaUsuario.getViewParent()).setUsuario(this.usuarios.get(iIndex));
            this.viewPesquisaUsuario.dispose();
        }else {
            new ViewErro(this.viewPesquisaUsuario, "Selecione um Usuario!").setVisible(true);
            this.viewPesquisaUsuario.getTextFieldPesquisa().requestFocus();
        }
    }
}