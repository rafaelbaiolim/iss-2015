package visao.editar;

import controller.visao.editar.ControllerViewEditarFornecedor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.gerenciais.Fornecedor;
import visao.consulta.ViewConsultaFornecedor;

/**
 * Classe responsavel por definir a Interface de Edicao de Fornecedores no Sistema.
 * @author  Vanessa
 * @version 1.0
 * @since   18/11/2015
 * @see     visao.editar.ViewEditar
 */
public final class ViewEditarFornecedor extends ViewEditar {
    private       JTextField             jTextFieldNome;
    private       JTextField             jTextFieldCNPJ;
    private       JTextField             jTextFieldTelefone;
    private final ViewConsultaFornecedor viewConsultaFornecedor;
    private final Fornecedor             fornecedor;

    /**
     * Metodo constrututor herdado da superclasse.
     * @param oView
     * @param oFornecedor 
     */
    public ViewEditarFornecedor(ViewConsultaFornecedor oView, Fornecedor oFornecedor) {
        super(oView);
        this.controller             = new ControllerViewEditarFornecedor(this);
        this.viewConsultaFornecedor = oView;
        this.fornecedor             = oFornecedor;
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Editar Fornecedor");
        this.setSize(370, 300);
        this.setLocation(408, 210);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }

    @Override
    public void addHeader() {
        super.addHeader("editar_fornecedor.jpg");
    }
    
    @Override
    public void addComponents() {
        this.jTextFieldNome = this.createTextField(27);
        this.jTextFieldNome.setText(this.fornecedor.getNome());
        this.add(new JLabel("Nome*: "));
        this.add(this.jTextFieldNome);
        
        this.addLinhas(1);
        
        this.jTextFieldCNPJ = this.createTextField(10);
        this.jTextFieldCNPJ.setText(this.fornecedor.getCnpj());
        this.add(new JLabel("CNPJ*: "));
        this.add(this.jTextFieldCNPJ);
        
        this.jTextFieldTelefone = this.createTextField(10);
        this.jTextFieldTelefone.setText(this.fornecedor.getTelefone());
        this.add(new JLabel("  Telefone: "));
        this.add(this.jTextFieldTelefone);
        
        this.addLinhas(1);
    }

    public JTextField getTextFieldNome() {
        return this.jTextFieldNome;
    }

    public JTextField getTextFieldCNPJ() {
        return this.jTextFieldCNPJ;
    }

    public JTextField getTextFieldTelefone() {
        return this.jTextFieldTelefone;
    }

    public ViewConsultaFornecedor getViewConsultaFornecedor() {
        return this.viewConsultaFornecedor;
    }

    public Fornecedor getFornecedor() {
        return this.fornecedor;
    }
}