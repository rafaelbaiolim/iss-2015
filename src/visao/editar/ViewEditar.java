package visao.editar;

import funct.FunctFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import visao.InterfaceView;
import visao.ViewModal;

/**
 * Classe responsavel por definir a Interface de Edicao do Sistema.
 * @author  Leandro
 * @version 1.0
 * @since   29/10/2015
 */
public abstract class ViewEditar extends ViewModal implements InterfaceView {
    private JLabel header;

    /**
     * Metodo construtor, que recebe como parametro a View Parent.
     * @since   29/10/2015
     * @param   oView View Parent
     */
    public ViewEditar(ViewModal oView) {
        super(oView);
    }
    
    /**
     * Metodo responsavel por adicionar o cabecalho padrao a um Frame de Cadastro.
     * @since   29/10/2015
     * @param   sUrlImage URL do Arquivo.
     */
    protected void addHeader(String sUrlImage) {
        this.addLinhas(1);
        this.header  = new JLabel(new FunctFrame().createImage("editar/" + sUrlImage));
        this.add(this.header);
        this.addLinhas(1);
    }
    
    /**
     * Metodo responsavel por adicionar os botoes padroes para a View de Cadastro.
     * @since   29/10/2015
     */
    @Override
    public void addButtons() {
        this.jButtonAction1 = this.createButton("  Gravar  ", "save.jpg");
        this.jButtonAction2 = this.createButton(" Cancelar ", "exit.jpg");
        
        this.add(this.jButtonAction1);
        this.add(this.jButtonAction2);
    }
    
    @Override
    public abstract void initComponents();
    
    @Override
    public abstract void addComponents();
    
    /**
     * Metodo responsavel por limpar os componentes da View.
     * @since   29/10/2015
     */
    public void clear() {}
    
    /**
     * Metodo responsavel por retornar o Botao Salvar da View Editar.
     * @since   29/10/2015
     * @return  JButton
     */
    public JButton getButtonSave() {
        return this.jButtonAction1;
    }
    
    /**
     * Metodo responsavel por retornar o Botao Cancelar da View Editar.
     * @since   29/10/2015
     * @return  JButton
     */
    public JButton getButtonCancel() {
        return this.jButtonAction2;
    }
}