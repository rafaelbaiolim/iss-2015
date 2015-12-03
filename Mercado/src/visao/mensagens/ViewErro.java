package visao.mensagens;

import funct.FunctFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import visao.View;
import visao.ViewModal;
import controller.visao.mensagens.ControllerViewErro;

/**
 * <p>Classe de Visao <b>ViewErro.</b></p>
 * <p>Subclasse da classe abstrata ViewModal.</p>
 * <p>Classe responsavel por definir a Interface de Erro do Sistema.</p>
 * @author  Vanessa
 * @version 1.0
 * @since   14/10/2015
 * @see     visao.ViewModal
 */
public final class ViewErro extends ViewModal {
    private final String     mensagem;
    private       JButton    buttonOk;
    
    /**
     * Metodo construtor da Classe.
     * @param oView
     * @param sMensagem 
     */
    public ViewErro(View oView, String sMensagem) {
        super(oView);
        this.mensagem   = sMensagem;
        this.controller = new ControllerViewErro(this);
        this.initComponents();
    }
    
    /**
     * Metodo construtor da Classe.
     * @param oViewModal
     * @param sMensagem 
     */
    public ViewErro(ViewModal oViewModal, String sMensagem) {
        super(oViewModal);
        this.mensagem   = sMensagem;
        this.controller = new ControllerViewErro(this);
        this.initComponents();
    }

    /**
     * Metodo responsavel por inicializar os componentes da View.
     * @since 14/10/2015
     */
    private void initComponents() {
        this.setTitle("Mercado - Erro");
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
        
        this.add(new JLabel(new FunctFrame().createImage("buttons/erro.jpg")));
        this.add(new JLabel(this.mensagem));
        
        this.addLinhas(1);
        
        this.buttonOk   = this.createButton("   Ok   ", "ok.jpg");
        
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