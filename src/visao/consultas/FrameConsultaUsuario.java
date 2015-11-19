/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 12/08/2015                                                         *
 * Classe: visao.consultas.FrameConsultaUsuario                               *
 * Coment: Classe responsavel pela Frame de Consulta de Usuario.              *
 *         Subclasse da Classe Abstrata FrameConsulta.                        *
 * ========================================================================== */

package visao.consultas;

import controllers.ControllerUsuario;
import modelo.internos.Usuario;
import visao.Frame;
import visao.remover.FrameRemoverUsuario;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameConsultaUsuario extends FrameConsulta {
    private List<Usuario> usuarios;
    
    private Usuario       usuario;

    public FrameConsultaUsuario(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario = oUsuario;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Consulta de Usuarios");
        this.setSize(450, 520);
        this.usuarios = ControllerUsuario.getUsuariosByLogin("");
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        this.addHeader("consulta_usuario.jpg");
        this.addLine(1);
        this.addBody();
        this.addLine(1);
        this.addButtons();
        this.oButtonEdit.setVisible(false);
    }

    private void addBody() {
        this.oTextFieldSearch = new JTextField(15);
        this.add(new JLabel("Usuario: "));
        this.add(this.oTextFieldSearch);
        this.oButtonSearch    = this.createButton("Atualizar", "update.jpg");
        this.add(this.oButtonSearch);
        
        this.addLine(1);
        
        this.addTable();
        this.oScrollPane.setPreferredSize(new Dimension(350, 150));
        this.addColumns(new String[]{"Login", "Funcionario"});
        this.addRows(ControllerUsuario.getUsuarios(this.usuarios));
    }
    
    public void clear() {
        this.oTextFieldSearch.setText("");
        this.usuarios = ControllerUsuario.getUsuariosByLogin("");
        this.addRows(ControllerUsuario.getUsuarios(this.usuarios));
        this.oTextFieldSearch.requestFocus();
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSearch)) {
            this.usuarios = ControllerUsuario.getUsuariosByLogin(this.oTextFieldSearch.getText());
            this.addRows(ControllerUsuario.getUsuarios(this.usuarios));
        }else if (oEvento.getSource().equals(this.oButtonRemove)) {
            if ((this.oTable.getSelectedRow() > -1) 
                    && (this.oTable.getSelectedRow() < this.usuarios.size())) {
                new FrameRemoverUsuario(this, this.usuarios.get(this.oTable.getSelectedRow()), this.usuario).setVisible(true);
            }
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}