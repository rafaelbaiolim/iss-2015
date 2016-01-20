package controller.visao.operacoes;

import controller.visao.ControllerViewModal;
import java.awt.event.ActionEvent;
import visao.operacoes.ViewOperacaoGerenciarUsuario;
import visao.pesquisa.ViewPesquisaUsuario;

/**
 * Metodo responsavel por ser o <b>controlador</b> da View da Chegada de Pedido.
 * @author Rafael
 * @since  16/01/2016
 */
public class ControllerViewOperacaoGerenciarUsuario extends ControllerViewModal {
    private final ViewOperacaoGerenciarUsuario viewOperacaoGerenciarUsuario;
   
    public ControllerViewOperacaoGerenciarUsuario(ViewOperacaoGerenciarUsuario oView) {
        super(oView);
        this.viewOperacaoGerenciarUsuario = oView;
    }
    
    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewOperacaoGerenciarUsuario.getButtonSearchUsuario())) {
            new ViewPesquisaUsuario(this.viewOperacaoGerenciarUsuario).setVisible(true);
        }else if (oActionEvent.getSource().equals(this.viewOperacaoGerenciarUsuario.getButtonOk())) {
            this.viewOperacaoGerenciarUsuario.dispose();
        }else if (oActionEvent.getSource().equals(this.viewOperacaoGerenciarUsuario.getButtonBack())) {
            this.viewOperacaoGerenciarUsuario.dispose();
        }
    }
}