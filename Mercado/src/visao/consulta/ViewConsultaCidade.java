package visao.consulta;

import controller.visao.consulta.ControllerViewConsultaCidade;
import javax.swing.JLabel;
import modelo.dao.complementares.DaoCidade;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Consulta de Cidades do Sistema.
 * @author  Leandro
 * @version 1.0
 * @since   10/11/2015
 */
public final class ViewConsultaCidade extends ViewConsulta {

    /**
     * Metodo constrututor herdado da superclasse.
     * @since  22/10/2015
     * @param oViewParent 
     */
    public ViewConsultaCidade(View oViewParent) {
        super(oViewParent);
        this.controller = new ControllerViewConsultaCidade(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Consulta de Cidades");
        this.setSize(370, 450);
        this.setLocation(410, 150);
        this.addHeader();
        this.addComponents();
        this.clear();
    }

    @Override
    public void addHeader() {
        super.addHeader("consulta_cidade.jpg");
    }
    
    @Override
    public void addComponents() {
        this.add(new JLabel("Cidade: "));
        this.addCampos();
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Id", "Nome", "UF"};
        this.setColumns(sColumns);
        
        int[]    iColumns = {75, 250, 75};
        this.setColumnSize(iColumns);
        
        this.addLinhas(1);
        
        this.addButtons();
    }

    @Override
    public void clear() {
        this.jTextFieldPesquisa.setText("");
        this.jTextFieldPesquisa.requestFocus();
        this.addRows(new DaoCidade().getCidades(new DaoCidade().list()));
    }
}