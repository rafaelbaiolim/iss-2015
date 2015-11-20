package visao.remover;

import controller.visao.remover.ControllerViewRemoverUsuario;
import modelo.estruturais.Usuario;
import visao.consulta.ViewConsultaUsuario;

/**
 * Classe responsavel por definir a Interface de Remocao de um Usuario do Sistema.
 * @author  Leandro Flores
 * @version 1.0
 * @since   03/11/2015
 */
public class ViewRemoverUsuario extends ViewRemover {
    private final Usuario usuario;

    public ViewRemoverUsuario(ViewConsultaUsuario oView, Usuario oUsuario) {
        super(oView);
        this.usuario    = oUsuario;
        this.controller = new ControllerViewRemoverUsuario(this);
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("UEM/ASP - Remover Usuário");
        this.setSize(400, 150);
        this.setLocation(380, 270);
        this.addComponents(this.usuario.toString());
    }
    
    public Usuario getUsuario() {
        return this.usuario;
    }
}