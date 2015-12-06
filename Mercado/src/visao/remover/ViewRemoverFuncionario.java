package visao.remover;

import controller.visao.remover.ControllerViewRemoverFuncionario;
import modelo.gerenciais.Funcionario;
import visao.consulta.ViewConsultaFuncionario;

/**
 * Classe responsavel por definir a Interface de Remocao de um Funcionario do Sistema.
 * @author  Leandro
 * @version 1.0
 * @since   18/11/2015
 */
public class ViewRemoverFuncionario extends ViewRemover {
    private final Funcionario funcionario;

    public ViewRemoverFuncionario(ViewConsultaFuncionario oView, Funcionario oFuncionario) {
        super(oView);
        this.controller  = new ControllerViewRemoverFuncionario(this);
        this.funcionario     = oFuncionario;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Remover Funcionario");
        this.addComponents(this.funcionario.toString());
    }
    
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
}