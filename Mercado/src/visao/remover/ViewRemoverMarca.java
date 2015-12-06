package visao.remover;

import modelo.gerenciais.Marca;
import visao.consulta.ViewConsultaMarca;

/**
 * Classe responsavel por definir a Interface de Remocao de uma Marca do Sistema.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   18/11/2015
 */
public class ViewRemoverMarca extends ViewRemover {
    private final Marca marca;

    public ViewRemoverMarca(ViewConsultaMarca oView, Marca oMarca) {
        super(oView);
        //this.controller  = new ControllerViewRemoverFornecedor(this);
        this.marca     = oMarca;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Remover Marca");
        this.addComponents(this.marca.toString());
    }
    
    public Marca getMarca() {
        return this.marca;
    }
}