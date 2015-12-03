package visao;

import controller.Controller;
import funct.FunctFrame;
import funct.FunctString;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * <p>Classe Abstrata View Modal.</p>
 * <p>Classe de referencia para as Interfaces do Sistema.</p>
 * <p>Classe abstrata, que deve ser especificada para suas subclasses.</p>
 * @author  Rafael e Vanessa
 * @version 1.0
 * @since   06/10/2015
 */
public abstract class ViewModal extends JDialog {
    protected JLabel     jLabelHeader;
    protected JLabel     jLabelMessage;
    
    protected JButton    jButtonAction1;
    protected JButton    jButtonAction2;
    protected JButton    jButtonAction3;
    
    protected Controller controller;
    
    /**
     * Metodo construtor que recebe a View Parent como parametro.
     * @param oView View Parent.
     */
    public ViewModal(View oView) {
        super(oView, "", true);
        this.setSettings();
    }
    
    /**
     * Metodo construtor que recebe a View Parent como parametro.
     * @param oViewModal View Parent.
     */
    public ViewModal(ViewModal oViewModal) {
        super(oViewModal, "", true);
        this.setSettings();
    }
    
    /**
     * Metodo responsavel por definir propriedades padrao para a ViewModal.
     */
    private void setSettings() {
        this.setSize(220, 120);
        this.setLocation(350, 400);
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icone.jpg")).getImage());
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    /**
     * Metodo responsavel por adicionar linhas em uma <b>ViewModal</b>.
     * @since 08/10/2015
     * @param iLinhas Número de Linhas a serem adicionadas em uma ViewModal.
     */
    protected void addLinhas(int iLinhas) {
        for (int i = 0; i < iLinhas; ++i) {
            this.add(new JLabel(new FunctString().getEspacos(200)));
        }
    }
    
    /**
     * <p>Metodo responsavel por instanciar e retornar um <b>JTextField</b>.</p>
     * <p>Adiciona um listener da biblioteca como padrao.</p>
     * @since  19/11/2015
     * @param  iSize Tamanho do JTextField.
     * @return JTextField.
     */
    protected JTextField createTextField(int iSize) {
        JTextField jTextField = new JTextField(iSize);
                   jTextField.addKeyListener(this.controller);
        return     jTextField;
    }
    
    /**
     * <p>Metodo responsavel por instanciar e retornar um <b>JPasswordTextField</b>.</p>
     * <p>Adiciona um listener da biblioteca como padrao.</p>
     * @since  19/11/2015
     * @param  iSize Tamanho do JPasswordField.
     * @return JPasswordField.
     */
    protected JPasswordField createPasswordField(int iSize) {
        JPasswordField jPasswordField = new JPasswordField(iSize);
                       jPasswordField.addKeyListener(this.controller);
        return         jPasswordField;
    }
    
    /**
     * Metodo responsavel por criar um <b>JButton</b> com imagem e mensagem.
     * @since  10/10/2015
     * @param  sMessage  Mensagem a ser exibida.
     * @param  sUrlImage URL da Imagem a ser exibida.
     * @return JButton
     */
    protected JButton createButton(String sMessage, String sUrlImage) {
        JButton jButton = new JButton(new FunctFrame().createImage("buttons/" + sUrlImage));
                jButton.setText(sMessage);
                jButton.addActionListener(this.controller);
                jButton.addKeyListener(this.controller);
        return  jButton;
    }
    
    /**
     * Metodo responsavel por criar os radio-botoes padroes para a View de Cadastro.
     * @since  30/10/2015
     * @param  sMessage Mensagem exibida no Radio Botao.
     * @return JRadioButton novo.
     */
    public JRadioButton createRadioButton(String sMessage) {
        JRadioButton oRadioButton = new JRadioButton(sMessage);
                     oRadioButton.addActionListener(this.controller);
                     oRadioButton.addKeyListener(this.controller);
        return       oRadioButton;
    }
}