package visao.editar;

import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.gerenciais.Marca;
import visao.consulta.ViewConsultaMarca;

/**
 * Classe responsavel por definir a Interface de Edicao de Marcas no Sistema.
 * @author  Vanessa
 * @version 1.0
 * @since   18/11/2015
 * @see     visao.editar.ViewEditar
 */
public final class ViewEditarMarca extends ViewEditar {
    private       JTextField        jTextFieldNome;
    private       JTextField        jTextFieldSigla;
    private final ViewConsultaMarca viewConsultaMarca;
    private final Marca             marca;

    /**
     * Metodo constrututor herdado da superclasse.
     * @param oView
     * @param oMarca 
     */
    public ViewEditarMarca(ViewConsultaMarca oView, Marca oMarca) {
        super(oView);
        //this.controller        = new ControllerViewEditarFornecedor(this);
        this.viewConsultaMarca = oView;
        this.marca             = oMarca;
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Editar Marca");
        this.setSize(370, 300);
        this.setLocation(408, 210);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }

    @Override
    public void addHeader() {
        super.addHeader("editar_marca.jpg");
    }
    
    @Override
    public void addComponents() {
        this.jTextFieldNome = this.createTextField(27);
        this.jTextFieldNome.setText(this.marca.getNome());
        this.add(new JLabel("Nome*: "));
        this.add(this.jTextFieldNome);
        
        this.addLinhas(1);
        
        this.jTextFieldSigla = this.createTextField(10);
        this.jTextFieldSigla.setText(this.marca.getSigla());
        this.add(new JLabel("Sigla*: "));
        this.add(this.jTextFieldSigla);
        
        this.add(new JLabel("                "));
        
        this.addLinhas(1);
    }

    public JTextField getTextFieldNome() {
        return this.jTextFieldNome;
    }

    public JTextField getTextFieldSigla() {
        return this.jTextFieldSigla;
    }
    
    public ViewConsultaMarca getViewConsultaMarca() {
        return this.viewConsultaMarca;
    }

    public Marca getMarca() {
        return this.marca;
    }
}
