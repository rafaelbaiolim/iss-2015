package visao.remover;

import controller.visao.remover.ControllerViewRemoverDespesa;
import modelo.gerenciais.Despesa;
import visao.consulta.ViewConsultaDespesa;

/**
 * Classe responsavel por definir a Interface de Remocao de uma Despesa do Sistema.
 * @author  Rafael
 * @version 1.0
 * @since   18/11/2015
 */
public class ViewRemoverDespesa extends ViewRemover {
    private final Despesa despesa;

    public ViewRemoverDespesa(ViewConsultaDespesa oView, Despesa oDespesa) {
        super(oView);
        this.controller  = new ControllerViewRemoverDespesa(this);
        this.despesa     = oDespesa;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Remover Despesa");
        this.addComponents(this.despesa.toString());
    }
    
    public Despesa getDespesa() {
        return this.despesa;
    }
}