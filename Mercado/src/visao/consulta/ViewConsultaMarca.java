package visao.consulta;

import controller.visao.consulta.ControllerViewConsultaMarca;
import javax.swing.JLabel;
import modelo.dao.gerenciais.DaoMarca;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Consulta de Marcas do Sistema.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   10/11/2015
 */
public final class ViewConsultaMarca extends ViewConsulta {

    /**
     * Metodo constrututor herdado da superclasse.
     * @since  22/10/2015
     * @param oViewParent 
     */
    public ViewConsultaMarca(View oViewParent) {
        super(oViewParent);
        this.controller = new ControllerViewConsultaMarca(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Consulta de Marcas");
        this.setSize(370, 450);
        this.setLocation(410, 150);
        this.addHeader();
        this.addComponents();
        this.clear();
    }

    @Override
    public void addHeader() {
        super.addHeader("consulta_marca.jpg");
    }
    
    @Override
    public void addComponents() {
        this.add(new JLabel("Marca: "));
        this.addCampos();
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Id", "Nome", "Sigla"};
        this.setColumns(sColumns);
        
        int[]    iColumns = {75, 200, 120};
        this.setColumnSize(iColumns);
        
        this.addLinhas(1);
        
        this.addButtons();
    }

    @Override
    public void clear() {
        this.jTextFieldPesquisa.setText("");
        this.jTextFieldPesquisa.requestFocus();
        this.addRows(new DaoMarca().getMarcas(new DaoMarca().list()));
    }
}