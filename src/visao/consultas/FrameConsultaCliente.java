/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 05/08/2015                                                         *
 * Classe: visao.consultas.FrameConsultaCliente                               *
 * Coment: Classe responsavel pela Frame de Consulta de Cliente.              *
 *         Subclasse da Classe Abstrata FrameConsulta.                        *
 * ========================================================================== */

package visao.consultas;

import controllers.ControllerCliente;
import modelo.cadastrais.Cliente;
import modelo.internos.Usuario;
import visao.Frame;
import visao.remover.FrameRemoverCliente;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameConsultaCliente extends FrameConsulta {
    private List<Cliente> clientes;
    
    private Usuario       usuario;

    public FrameConsultaCliente(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario = oUsuario;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Consulta de Clientes");
        this.setSize(450, 520);
        this.clientes = ControllerCliente.getClientesByNome("");
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        this.addHeader("consulta_cliente.jpg");
        this.addLine(1);
        this.addBody();
        this.addLine(1);
        this.addButtons();
        this.oButtonEdit.setVisible(false);
    }

    private void addBody() {
        this.oTextFieldSearch = new JTextField(15);
        this.add(new JLabel("Cliente: "));
        this.add(this.oTextFieldSearch);
        this.oButtonSearch    = this.createButton("Atualizar", "update.jpg");
        this.add(this.oButtonSearch);
        
        this.addLine(1);
        
        this.addTable();
        this.oScrollPane.setPreferredSize(new Dimension(350, 150));
        this.addColumns(new String[]{"Documento", "Nome"});
        this.addRows(ControllerCliente.getClientes2(this.clientes));
    }
    
    public void clear() {
        this.oTextFieldSearch.setText("");
        this.clientes = ControllerCliente.getClientesByNome("");
        this.addRows(ControllerCliente.getClientes2(this.clientes));
        this.oTextFieldSearch.requestFocus();
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSearch)) {
            this.clientes = ControllerCliente.getClientesByNome(this.oTextFieldSearch.getText());
            this.addRows(ControllerCliente.getClientes2(this.clientes));
        }else if (oEvento.getSource().equals(this.oButtonRemove)) {
            if ((this.oTable.getSelectedRow() > -1) 
                    && (this.oTable.getSelectedRow() < this.clientes.size())) {
                new FrameRemoverCliente(this, this.clientes.get(this.oTable.getSelectedRow()), this.usuario).setVisible(true);
            }
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}