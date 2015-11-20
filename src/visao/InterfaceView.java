package visao;

/**
 * <p>Interface View.</p>
 * <p>Define as Operacoes Principais das Classes de Visao modais.</p>
 * <p>Todos os metodos possuem uma especificacao acima da assinatura.</p>
 * @author  Leandro
 * @version 1.0
 * @since   13/10/2015
 */
public interface InterfaceView {
    
    /**
     * Metodo responsavel por definir configuracoes adicionais a View e chamar 
     * os metodos responsaveis por carregar os elementos da View.
     * @version 1.0
     * @since   13/10/2015
     */
    public void initComponents();
     
    /**
     * Metodo responsavel por adicionar o cabecalho de uma View.
     * @version 1.0
     * @since   13/10/2015
     */
    public void addHeader();
    
    /**
     * Metodo responsavel por adicionar os componentes de uma View.
     * @version 1.0
     * @since   13/10/2015
     */
    public void addComponents();
    
    /**
     * Metodo responsavel por adicionar os botoes de uma View.
     * @version 1.0
     * @since   13/10/2015
     */
    public void addButtons();
}