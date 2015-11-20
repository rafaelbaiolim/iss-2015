package visao.cadastro;

import funct.FunctFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import visao.InterfaceView;
import visao.View;
import visao.ViewModal;

/**
 * Classe responsavel por definir a Interface de Cadastro do Sistema.
 * @author  Leandro
 * @version 1.0
 * @since   19/10/2015
 */
public abstract class ViewCadastro extends ViewModal implements InterfaceView {
    private   JLabel header;
    protected JLabel message;

    /**
     * Metodo construtor, que recebe como parametro a View Parent.
     * @since   19/10/2015
     * @param   oView View Parent
     */
    public ViewCadastro(View oView) {
        super(oView);
    }
    
    /**
     * Metodo responsavel por adicionar o cabecalho padrao a um Frame de Cadastro.
     * @since   19/10/2015
     * @param   sUrlImage URL do Arquivo.
     */
    protected void addHeader(String sUrlImage) {
        this.addLinhas(1);
        this.header  = new JLabel(new FunctFrame().createImage("cadastro/" + sUrlImage));
        this.add(this.header);
        this.addLinhas(1);
        this.message = new JLabel();
        this.add(this.message);
        this.addLinhas(1);
    }
    
    /**
     * Metodo responsavel por adicionar uma Mensagem no cabecalho da View.
     * @since   19/10/2015
     * @param   sMessage Mensagem a ser exibida.
     */
    public void setMessage(String sMessage) {
        this.message.setText(sMessage);
        this.message.setForeground(Color.black);
    }
    
    /**
     * Metodo responsavel por adicionar uma Mensagem no cabecalho da View.
     * @since   30/10/2015
     * @param   sMessage Mensagem a ser exibida.
     */
    public void setErro(String sMessage) {
        this.message.setText(sMessage);
        this.message.setForeground(Color.red);
    }
    
    /**
     * Metodo responsavel por adicionar os botoes padroes para a View de Cadastro.
     * @since   19/10/2015
     */
    @Override
    public void addButtons() {
        this.jButtonAction1 = this.createButton(" Inserir ", "add.jpg");
        this.jButtonAction2 = this.createButton("  Limpar ", "clear.png");
        this.jButtonAction3 = this.createButton("  Voltar ", "back.jpg");
        
        this.add(this.jButtonAction1);
        this.add(this.jButtonAction2);
        this.add(this.jButtonAction3);
    }
    
    @Override
    public abstract void initComponents();
    
    @Override
    public abstract void addComponents();
    
    /**
     * Metodo responsavel por limpar os componentes da View.
     * @since   19/10/2015
     */
    public abstract void clear();
    
    /**
     * Metodo responsavel por retornar o Botao Inserir da View Cadastro.
     * @since   19/10/2015
     * @return  JButton
     */
    public JButton getButtonInserir() {
        return this.jButtonAction1;
    }
    
    /**
     * Metodo responsavel por retornar o Botao Limpar da View Cadastro.
     * @since   19/10/2015
     * @return  JButton
     */
    public JButton getButtonClear() {
        return this.jButtonAction2;
    }
    
    /**
     * Metodo responsavel por retornar o Botao Voltar da View Cadastro.
     * @since   19/10/2015
     * @return  JButton
     */
    public JButton getButtonBack() {
        return this.jButtonAction3;
    }
}