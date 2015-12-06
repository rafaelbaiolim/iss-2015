package visao.remover;

import controller.visao.remover.ControllerViewRemoverCliente;
import modelo.cadastrais.Cliente;
import visao.consulta.ViewConsultaCliente;

/**
 * Classe responsavel por definir a Interface de Remocao de um Cliente do Sistema.
 * @author  Hadyne
 * @version 1.0
 * @since   18/11/2015
 */
public class ViewRemoverCliente extends ViewRemover {
    private final Cliente cliente;

    public ViewRemoverCliente(ViewConsultaCliente oView, Cliente oCliente) {
        super(oView);
        this.controller = new ControllerViewRemoverCliente(this);
        this.cliente     = oCliente;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Remover Cliente");
        this.setSize(550, 150);
        this.setLocation(330, 290);
        this.addComponents(this.cliente.toString());
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }
}