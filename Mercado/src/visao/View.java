package visao;

import controller.Controller;
import funct.FunctFrame;
import funct.FunctString;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * <p><b>Classe Abstrata View.</b></p> 
 * <p>Classe de referencia para as Interfaces do Sistema.</p>
 * <p>Classe abstrata, que deve ser especificada para suas subclasses.</p>
 * @author  Leandro e Hadyne
 * @version 1.0
 * @since   06/10/2015
 */
public abstract class View extends JFrame {
    protected Controller controller;
    
    /**
     * Metodo contrutor padrão.
     */
    public View() {
        super();
        this.setSettings();
    }
    
    /**
     * Metodo responsavel por definir propriedades padrao para a View.
     * @since 06/10/2015
     */
    private void setSettings() {
        this.setSize(800, 550);
        this.setLocation(200, 100);
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icone.jpg")).getImage());
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    /**
     * Metodo responsavel por adicionar linhas em uma Frame.
     * @since 06/10/2015
     * @param iLinhas Número de Linhas a serem adicionadas.
     */
    protected void addLinhas(int iLinhas) {
        for (int i = 0; i < iLinhas; ++i) {
            this.add(new JLabel(new FunctString().getEspacos(300)));
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
     * <p>Metodo responsavel por instanciar e retornar um <b>JButton</b>.</p>
     * <p>Adiciona um listener da biblioteca como padrao.</p>
     * @since  08/10/2015
     * @param  sMessage  Mensagem a ser exibida no Botão.
     * @param  sUrlImage Imagem a ser exibida no Botão.
     * @return JButton
     */
    protected JButton createButton(String sMessage, String sUrlImage) {
        JButton jButton = new JButton(new FunctFrame().createImage("buttons/" + sUrlImage));
                jButton.setText(sMessage);
                jButton.addActionListener(this.controller);
        return  jButton;
    }
    
    /**
     * <p>Metodo responsavel por instanciar e retornar um <b>JMenuItem</b>.</p>
     * <p>Adiciona um listener da biblioteca como padrao.</p>
     * @since  10/10/2015
     * @param  sTitle     Título a ser exibido no Item do Menu.
     * @param  sUrlImage  Imagem a ser exibida no Item do Menu.
     * @return JMenuItem
     */
    protected JMenuItem createMenuItem(String sTitle, String sUrlImage) {
        JMenuItem jMenuItem = new JMenuItem(sTitle, new FunctFrame().createImage("icones/" + sUrlImage));
                  jMenuItem.addActionListener(this.controller);
        return    jMenuItem;
    }
}