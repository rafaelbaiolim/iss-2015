package visao.editar;

import controller.modelo.complementares.ControllerUF;
import controller.visao.editar.ControllerViewEditarCidade;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.complementares.Cidade;
import visao.consulta.ViewConsultaCidade;

/**
 * Classe responsavel por definir a Interface de Edicao de Cidades no Sistema.
 * @author  Leandro
 * @version 1.0
 * @since   18/11/2015
 * @see     visao.editar.ViewEditar
 */
public final class ViewEditarCidade extends ViewEditar {
    private       JTextField         jTextFieldNome;
    private       JComboBox          jComboBoxUF;
    private final ViewConsultaCidade viewConsultaCidade;
    private final Cidade             cidade;

    /**
     * Metodo constrututor herdado da superclasse.
     * @param oView
     * @param oCidade 
     */
    public ViewEditarCidade(ViewConsultaCidade oView, Cidade oCidade) {
        super(oView);
        this.controller         = new ControllerViewEditarCidade(this);
        this.viewConsultaCidade = oView;
        this.cidade             = oCidade;
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Editar Cidade");
        this.setSize(350, 250);
        this.setLocation(420, 235);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }

    @Override
    public void addHeader() {
        super.addHeader("editar_cidade.jpg");
    }
    
    @Override
    public void addComponents() {
        this.jTextFieldNome = this.createTextField(15);
        this.jTextFieldNome.setText(this.cidade.getNome());
        this.add(new JLabel("Nome*: "));
        this.add(this.jTextFieldNome);
        
        this.jComboBoxUF    = new JComboBox(new ControllerUF().getSiglas());
        this.jComboBoxUF.addKeyListener(this.controller);
        this.jComboBoxUF.setSelectedItem(this.cidade.getUf().getSigla());
        this.jComboBoxUF.setPreferredSize(new Dimension(50, 20));
        this.add(new JLabel("UF*: "));
        this.add(this.jComboBoxUF);
        
        this.addLinhas(1);
    }
    
    public JTextField getTextFieldNome() {
        return this.jTextFieldNome;
    }

    public JComboBox getComboBoxUF() {
        return this.jComboBoxUF;
    }

    public ViewConsultaCidade getViewConsultaCidade() {
        return this.viewConsultaCidade;
    }
    
    public Cidade getCidade() {
        return this.cidade;
    }
}