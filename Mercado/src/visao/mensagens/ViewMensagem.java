package visao.mensagens;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import visao.View;
import visao.ViewModal;
import controller.visao.mensagens.ControllerViewMensagem;

/**
 * <p>Classe de Visao <b>ViewMensagem.</b></p>
 * <p>Subclasse da classe abstrata ViewModal.</p>
 * <p>Classe responsavel por definir a Interface de Mensagem do Sistema.</p>
 * @author  Rafael
 * @version 1.0
 * @since   14/10/2015
 * @see     visao.ViewModal
 */
public final class ViewMensagem extends ViewModal {
    private final String     mensagem;
    private       JButton    buttonOk;
    
    /**
     * Metodo construtor da Classe.
     * @param oView
     * @param sMensagem 
     */
    public ViewMensagem(View oView, String sMensagem) {
        super(oView);
        this.mensagem   = sMensagem;
        this.controller = new ControllerViewMensagem(this);
        this.initComponents();
    }
    
    /**
     * Metodo construtor da Classe.
     * @param oViewModal
     * @param sMensagem 
     */
    public ViewMensagem(ViewModal oViewModal, String sMensagem) {
        super(oViewModal);
        this.mensagem   = sMensagem;
        this.controller = new ControllerViewMensagem(this);
        this.initComponents();
    }

    /**
     * Metodo responsavel por inicializar os componentes da View.
     * @since 14/10/2015
     */
    private void initComponents() {
        this.setTitle("Mercado - Mensagem");
        this.setSize(300, 150);
        this.setLocation(445, 290);
        this.addComponents();
    }
    
    /**
     * Metodo responsavel por adicionar os componentes da View.
     * @since 14/10/2015
     */
    private void addComponents() {
        this.addLinhas(1);
        
        this.add(new JLabel(new ImageIcon(getClass().getResource("/images/estruturais/info.jpg"))));
        this.add(new JLabel(this.mensagem));
        
        this.addLinhas(1);
        
        this.buttonOk = this.createButton(" Ok ", "ok.jpg");
        this.add(this.buttonOk);
    }

    /**
     * Metodo responsavel por retornar o Botao de Ok da ViewErro.
     * @since  14/10/2015
     * @return JButton
     */
    public JButton getButtonOk() {
        return this.buttonOk;
    }
}