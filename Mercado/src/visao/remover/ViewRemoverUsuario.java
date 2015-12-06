package visao.remover;

import controller.visao.remover.ControllerViewRemoverUsuario;
import modelo.estruturais.Usuario;
import visao.consulta.ViewConsultaUsuario;

/**
 * Classe responsavel por definir a Interface de Remocao de um Usuario do Sistema.
 * @author  Rafael
 * @version 1.0
 * @since   03/11/2015
 */
public class ViewRemoverUsuario extends ViewRemover {
    private final Usuario usuario;

    public ViewRemoverUsuario(ViewConsultaUsuario oView, Usuario oUsuario) {
        super(oView);
        this.controller = new ControllerViewRemoverUsuario(this);
        this.usuario    = oUsuario;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Remover Usuário");
        this.addComponents(this.usuario.toString());
    }
    
    public Usuario getUsuario() {
        return this.usuario;
    }
}