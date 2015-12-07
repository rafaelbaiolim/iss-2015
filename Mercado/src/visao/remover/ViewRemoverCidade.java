package visao.remover;

import controller.visao.remover.ControllerViewRemoverCidade;
import modelo.complementares.Cidade;
import visao.consulta.ViewConsultaCidade;

/**
 * Classe responsavel por definir a Interface de Remocao de uma Cidade do Sistema.
 * @author  Leandro
 * @version 1.0
 * @since   18/11/2015
 */
public class ViewRemoverCidade extends ViewRemover {
    private final Cidade cidade;

    public ViewRemoverCidade(ViewConsultaCidade oView, Cidade oCidade) {
        super(oView);
        this.controller = new ControllerViewRemoverCidade(this);
        this.cidade     = oCidade;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Remover Cidade");
        this.addComponents(this.cidade.toString());
    }
    
    public Cidade getCidade() {
        return this.cidade;
    }
}