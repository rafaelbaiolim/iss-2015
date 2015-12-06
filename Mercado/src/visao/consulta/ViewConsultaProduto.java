package visao.consulta;

import controller.visao.consulta.ControllerViewConsultaProduto;
import javax.swing.JLabel;
import modelo.dao.cadastrais.DaoProduto;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Consulta de Produtos do Sistema.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   22/10/2015
 */
public final class ViewConsultaProduto extends ViewConsulta {

    /**
     * Metodo constrututor herdado da superclasse.
     * @since  22/10/2015
     * @param oViewParent 
     */
    public ViewConsultaProduto(View oViewParent) {
        super(oViewParent);
        this.controller = new ControllerViewConsultaProduto(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Consulta de Produtos");
        this.setSize(370, 450);
        this.setLocation(410, 150);
        this.addHeader();
        this.addComponents();
        this.clear();
    }

    @Override
    public void addHeader() {
        super.addHeader("consulta_produto.jpg");
    }
    
    @Override
    public void addComponents() {
        this.add(new JLabel("Produto: "));
        this.addCampos();
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Id", "Descricao", "Marca"};
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
        this.addRows(new DaoProduto().getProdutos(new DaoProduto().list()));
    }
}