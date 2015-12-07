package controller.visao.consulta;

import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.event.KeyEvent;
import modelo.complementares.Cidade;
import modelo.dao.complementares.DaoCidade;
import visao.consulta.ViewConsultaCidade;
import visao.editar.ViewEditarCidade;
import visao.mensagens.ViewErro;
import visao.remover.ViewRemoverCidade;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewConsultaCidade.
 * @author  Leandro
 * @version 1.0
 * @since   18/11/2015
 * @see     controller.visao.consulta.ControllerViewConsulta
 */
public class ControllerViewConsultaCidade extends ControllerViewConsulta {
    private final ViewConsultaCidade viewConsultaCidade;
    private final DaoCidade          daoCidade;
    private       List<Cidade>       cidades;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewConsultaCidade(ViewConsultaCidade oView) {
        super(oView);
        this.viewConsultaCidade = oView;
        this.daoCidade          = new DaoCidade();
        this.cidades            = this.daoCidade.list();
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
        String sCidade = this.viewConsultaCidade.getTextFieldPesquisa().getText();
        this.cidades   = this.daoCidade.findCidades(sCidade);
        this.viewConsultaCidade.addRows(this.daoCidade.getCidades(this.cidades));
    }

    @Override
    protected void edit() {
        int iIndex    = this.viewConsultaCidade.getTable().getSelectedRow();
        int iCidades  = this.cidades.size();
        if ((iIndex >= 0) 
         && (iIndex < iCidades)) {
            new ViewEditarCidade(this.viewConsultaCidade, this.cidades.get(iIndex)).setVisible(true);
        }else {
            new ViewErro(this.viewConsultaCidade, "Selecione uma Cidade!").setVisible(true);
            this.viewConsultaCidade.getTextFieldPesquisa().requestFocus();
        }
    }

    @Override
    protected void remove() {
        int iIndex    = this.viewConsultaCidade.getTable().getSelectedRow();
        int iCidades  = this.cidades.size();
        if ((iIndex >= 0) 
         && (iIndex < iCidades)) {
            new ViewRemoverCidade(this.viewConsultaCidade, this.cidades.get(iIndex)).setVisible(true);
        }else {
            new ViewErro(this.viewConsultaCidade, "Selecione uma Cidade!").setVisible(true);
            this.viewConsultaCidade.getTextFieldPesquisa().requestFocus();
        }
    }
}