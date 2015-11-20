package visao;

import controller.Controller;
import funct.FunctFrame;
import funct.FunctString;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

/**
 * <p><b>Classe Abstrata View.</b></p> 
 * <p>Classe de referencia para as Interfaces do Sistema.</p>
 * <p>Classe abstrata, que deve ser especificada para suas subclasses.</p>
 * @author  Leandro
 * @version 1.0
 * @since   06/10/2015
 */
public abstract class View extends JFrame {
    protected Controller controller;
    
    /**
     * Metodo contrutor padrão.
     * @version 1.0
     * @since   06/10/2015
     */
    public View() {
        super();
        this.setSettings();
    }
    
    /**
     * Metodo responsavel por definir propriedades padrao para a View.
     * @version 1.0
     * @since   06/10/2015
     */
    private void setSettings() {
        this.setSize(800, 550);
        this.setLocation(200, 100);
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icone.png")).getImage());
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    /**
     * Metodo responsavel por adicionar linhas em uma Frame.
     * @version 1.0
     * @since   06/10/2015
     * @param   iLinhas Número de Linhas a serem adicionadas.
     */
    protected void addLinhas(int iLinhas) {
        for (int i = 0; i < iLinhas; ++i) {
            this.add(new JLabel(new FunctString().getEspacos(300)));
        }
    }
    
    /**
     * <p>Metodo responsavel por instanciar e retornar um <b>JButton</b>.</p>
     * <p>Adiciona um listener da biblioteca como padrao.</p>
     * @version 1.0
     * @since   08/10/2015
     * @param   sMessage  Mensagem a ser exibida no Botão.
     * @param   sUrlImage Imagem a ser exibida no Botão.
     * @return  JButton
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
     * @version 1.0
     * @since   10/10/2015
     * @param   sTitle     Título a ser exibido no Item do Menu.
     * @param   sUrlImage  Imagem a ser exibida no Item do Menu.
     * @return  JMenuItem
     */
    protected JMenuItem createMenuItem(String sTitle, String sUrlImage) {
        JMenuItem jMenuItem = new JMenuItem(sTitle, new FunctFrame().createImage("icones/" + sUrlImage));
                  jMenuItem.addActionListener(this.controller);
        return    jMenuItem;
    }
}