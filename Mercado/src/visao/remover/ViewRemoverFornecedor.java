package visao.remover;

import controller.visao.remover.ControllerViewRemoverFornecedor;
import modelo.gerenciais.Fornecedor;
import visao.consulta.ViewConsultaFornecedor;

/**
 * Classe responsavel por definir a Interface de Remocao de um Forneedor do Sistema.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   18/11/2015
 */
public class ViewRemoverFornecedor extends ViewRemover {
    private final Fornecedor fornecedor;

    public ViewRemoverFornecedor(ViewConsultaFornecedor oView, Fornecedor oFornecedor) {
        super(oView);
        this.controller  = new ControllerViewRemoverFornecedor(this);
        this.fornecedor     = oFornecedor;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Remover Fornecedor");
        this.addComponents(this.fornecedor.toString());
    }
    
    public Fornecedor getFornecedor() {
        return this.fornecedor;
    }
}