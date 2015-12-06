package controller.visao.editar;

import controller.modelo.gerenciais.ControllerMarca;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.dao.gerenciais.DaoMarca;
import modelo.gerenciais.Marca;
import visao.editar.ViewEditarMarca;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewEditarMarca.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   19/11/2015
 * @see     controller.visao.editar.ControllerViewEditar
 */
public class ControllerViewEditarMarca extends ControllerViewEditar {
    private final ViewEditarMarca viewEditarMarca;
    private final ControllerMarca controllerMarca;
    private final DaoMarca        daoMarca;
    
    /**
     * Metodo construtor da Classe. 
     * @param oView
     */
    public ControllerViewEditarMarca(ViewEditarMarca oView) {
        super(oView);
        this.viewEditarMarca = oView;
        this.controllerMarca = new ControllerMarca();
        this.daoMarca        = new DaoMarca();
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
    protected void save() {
        String sNome  = this.viewEditarMarca.getTextFieldNome().getText().trim();
        String sSigla = this.viewEditarMarca.getTextFieldSigla().getText().trim();
        if (this.checkParameters(sNome, sSigla) == true) {
            Marca oMarca = this.viewEditarMarca.getMarca();
                  oMarca.setNome(sNome);
                  oMarca.setSigla(sSigla);
            this.daoMarca.update(oMarca);
            new ViewMensagem(this.viewEditarMarca, "Marca Atualizada com Sucesso!").setVisible(true);
            this.viewEditarMarca.dispose();
            this.viewEditarMarca.getViewConsultaMarca().clear();
        }
    }
    
    private boolean checkParameters(String sNome, String sSigla) {
        if (this.controllerMarca.checkNome(sNome) == false) {
            new ViewErro(this.viewEditarMarca, "Nome Inválido!").setVisible(true);
            this.viewEditarMarca.getTextFieldNome().requestFocus();
            return false;
        }else if (this.controllerMarca.checkSigla(sSigla) == false) {
            new ViewErro(this.viewEditarMarca, "Sigla Inválida!").setVisible(true);
            this.viewEditarMarca.getTextFieldSigla().requestFocus();
            return false;
        }else if (this.controllerMarca.checkUpdate(sSigla, sNome, this.viewEditarMarca.getMarca().getId()) == false) {
            new ViewErro(this.viewEditarMarca, "Marca já Cadastrada!").setVisible(true);
            this.viewEditarMarca.getTextFieldNome().requestFocus();
            return false;
        }
        return true;
    }
}