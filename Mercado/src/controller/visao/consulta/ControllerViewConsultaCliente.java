package controller.visao.consulta;

import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.event.KeyEvent;
import modelo.cadastrais.Cliente;
import modelo.cadastrais.ClienteFisico;
import modelo.cadastrais.ClienteJuridico;
import modelo.dao.cadastrais.DaoCliente;
import visao.consulta.ViewConsultaCliente;
import visao.editar.ViewEditarClienteFisico;
import visao.editar.ViewEditarClienteJuridico;
import visao.mensagens.ViewErro;
import visao.remover.ViewRemoverCliente;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewConsultaCliente.
 * @author  Hadyne
 * @version 1.0
 * @since   18/11/2015
 * @see     controller.visao.consulta.ControllerViewConsulta
 */
public class ControllerViewConsultaCliente extends ControllerViewConsulta {
    private final ViewConsultaCliente viewConsultaCliente;
    private final DaoCliente          daoCliente;
    private       List<Cliente>       clientes;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewConsultaCliente(ViewConsultaCliente oView) {
        super(oView);
        this.viewConsultaCliente = oView;
        this.daoCliente          = new DaoCliente();
        this.clientes            = this.daoCliente.list();
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
        String sCliente = this.viewConsultaCliente.getTextFieldPesquisa().getText();
        this.clientes   = this.daoCliente.findClientes(sCliente);
        this.viewConsultaCliente.addRows(this.daoCliente.getClientes(this.clientes));
    }

    @Override
    protected void edit() {
        int iIndex    = this.viewConsultaCliente.getTable().getSelectedRow();
        int iClientes = this.clientes.size();
        if ((iIndex >= 0) 
         && (iIndex < iClientes)) {
            if (this.clientes.get(iIndex) instanceof ClienteFisico) {
                new ViewEditarClienteFisico(this.viewConsultaCliente,   (ClienteFisico)   this.clientes.get(iIndex)).setVisible(true);
            }else if (this.clientes.get(iIndex) instanceof ClienteJuridico) {
                new ViewEditarClienteJuridico(this.viewConsultaCliente, (ClienteJuridico) this.clientes.get(iIndex)).setVisible(true);
            }
        }else {
            new ViewErro(this.viewConsultaCliente, "Selecione um Cliente!").setVisible(true);
            this.viewConsultaCliente.getTextFieldPesquisa().requestFocus();
        }
    }

    @Override
    protected void remove() {
        int iIndex    = this.viewConsultaCliente.getTable().getSelectedRow();
        int iClientes = this.clientes.size();
        if ((iIndex >= 0) 
         && (iIndex < iClientes)) {
            new ViewRemoverCliente(this.viewConsultaCliente, this.clientes.get(iIndex)).setVisible(true);
        }else {
            new ViewErro(this.viewConsultaCliente, "Selecione um Cliente!").setVisible(true);
            this.viewConsultaCliente.getTextFieldPesquisa().requestFocus();
        }
    }
}