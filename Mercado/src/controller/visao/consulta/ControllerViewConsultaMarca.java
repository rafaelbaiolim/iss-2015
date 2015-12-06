package controller.visao.consulta;

import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.event.KeyEvent;
import modelo.dao.gerenciais.DaoMarca;
import modelo.gerenciais.Marca;
import visao.consulta.ViewConsultaMarca;
import visao.editar.ViewEditarMarca;
import visao.mensagens.ViewErro;
import visao.remover.ViewRemoverMarca;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewConsultaMarca.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   18/11/2015
 * @see     controller.visao.consulta.ControllerViewConsulta
 */
public class ControllerViewConsultaMarca extends ControllerViewConsulta {
    private final ViewConsultaMarca viewConsultaMarca;
    private final DaoMarca          daoMarca;
    private       List<Marca>       marcas;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewConsultaMarca(ViewConsultaMarca oView) {
        super(oView);
        this.viewConsultaMarca = oView;
        this.daoMarca          = new DaoMarca();
        this.marcas            = this.daoMarca.list();
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
        String sMarca = this.viewConsultaMarca.getTextFieldPesquisa().getText();
        this.marcas   = this.daoMarca.findMarcas(sMarca);
        this.viewConsultaMarca.addRows(this.daoMarca.getMarcas(this.marcas));
    }

    @Override
    protected void edit() {
        int iIndex        = this.viewConsultaMarca.getTable().getSelectedRow();
        int iFornecedores = this.marcas.size();
        if ((iIndex >= 0) 
         && (iIndex < iFornecedores)) {
            new ViewEditarMarca(this.viewConsultaMarca, this.marcas.get(iIndex)).setVisible(true);
        }else {
            new ViewErro(this.viewConsultaMarca, "Selecione uma Marca!").setVisible(true);
            this.viewConsultaMarca.getTextFieldPesquisa().requestFocus();
        }
    }

    @Override
    protected void remove() {
        int iIndex        = this.viewConsultaMarca.getTable().getSelectedRow();
        int iFornecedores = this.marcas.size();
        if ((iIndex >= 0) 
         && (iIndex < iFornecedores)) {
            new ViewRemoverMarca(this.viewConsultaMarca, this.marcas.get(iIndex)).setVisible(true);
        }else {
            new ViewErro(this.viewConsultaMarca, "Selecione uma Marca!").setVisible(true);
            this.viewConsultaMarca.getTextFieldPesquisa().requestFocus();
        }
    }
}