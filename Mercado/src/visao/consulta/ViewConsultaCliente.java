package visao.consulta;

import controller.visao.consulta.ControllerViewConsultaCliente;
import javax.swing.JLabel;
import modelo.dao.cadastrais.DaoCliente;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Consulta de Clientes do Sistema.
 * @author  Hadyne
 * @version 1.0
 * @since   10/11/2015
 */
public final class ViewConsultaCliente extends ViewConsulta {

    /**
     * Metodo constrututor herdado da superclasse.
     * @since  22/10/2015
     * @param oViewParent 
     */
    public ViewConsultaCliente(View oViewParent) {
        super(oViewParent);
        this.controller = new ControllerViewConsultaCliente(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Consulta de Clientes");
        this.setSize(370, 450);
        this.setLocation(410, 150);
        this.addHeader();
        this.addComponents();
        this.clear();
    }

    @Override
    public void addHeader() {
        super.addHeader("consulta_cliente.jpg");
    }
    
    @Override
    public void addComponents() {
        this.add(new JLabel("Cliente: "));
        this.addCampos();
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Id", "Documento", "Nome"};
        this.setColumns(sColumns);
        
        int[]    iColumns = {75, 175, 175};
        this.setColumnSize(iColumns);
        
        this.addLinhas(1);
        
        this.addButtons();
    }

    @Override
    public void clear() {
        this.jTextFieldPesquisa.setText("");
        this.jTextFieldPesquisa.requestFocus();
        this.addRows(new DaoCliente().getClientes(new DaoCliente().list()));
    }
}