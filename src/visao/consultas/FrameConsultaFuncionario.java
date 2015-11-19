/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 11/08/2015                                                         *
 * Classe: visao.consultas.FrameConsultaFuncionario                           *
 * Coment: Classe responsavel pela Frame de Consulta de Funcionario.          *
 *         Subclasse da Classe Abstrata FrameConsulta.                        *
 * ========================================================================== */

package visao.consultas;

import controllers.ControllerFuncionario;
import modelo.gerenciais.Funcionario;
import modelo.internos.Usuario;
import visao.Frame;
import visao.edicao.FrameEditarFuncionario;
import visao.remover.FrameRemoverFuncionario;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameConsultaFuncionario extends FrameConsulta {
    private List<Funcionario> funcionarios;
    
    private Usuario           usuario;

    public FrameConsultaFuncionario(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario = oUsuario;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Consulta de Funcionario");
        this.setSize(450, 520);
        this.funcionarios = ControllerFuncionario.getFuncionariosByNome("");
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        this.addHeader("consulta_funcionario.jpg");
        this.addLine(1);
        this.addBody();
        this.addLine(1);
        this.addButtons();
    }

    private void addBody() {
        this.oTextFieldSearch = new JTextField(15);
        this.add(new JLabel("Funcionario: "));
        this.add(this.oTextFieldSearch);
        this.oButtonSearch    = this.createButton("Atualizar", "update.jpg");
        this.add(this.oButtonSearch);
        
        this.addLine(1);
        
        this.addTable();
        this.oScrollPane.setPreferredSize(new Dimension(350, 150));
        this.addColumns(new String[]{"Nome", "CPF"});
        this.addRows(ControllerFuncionario.getFuncionarios(this.funcionarios));
    }
    
    public void clear() {
        this.oTextFieldSearch.setText("");
        this.funcionarios = ControllerFuncionario.getFuncionariosByNome("");
        this.addRows(ControllerFuncionario.getFuncionarios(this.funcionarios));
        this.oTextFieldSearch.requestFocus();
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSearch)) {
            this.funcionarios = ControllerFuncionario.getFuncionariosByNome(this.oTextFieldSearch.getText());
            this.addRows(ControllerFuncionario.getFuncionarios(this.funcionarios));
        }else if (oEvento.getSource().equals(this.oButtonEdit)) {
            if ((this.oTable.getSelectedRow() > -1) 
                    && (this.oTable.getSelectedRow() < this.funcionarios.size())) {
                new FrameEditarFuncionario(this, this.funcionarios.get(this.oTable.getSelectedRow()), this.usuario).setVisible(true);
            }
        }else if (oEvento.getSource().equals(this.oButtonRemove)) {
            if ((this.oTable.getSelectedRow() > -1) 
                    && (this.oTable.getSelectedRow() < this.funcionarios.size())) {
                new FrameRemoverFuncionario(this, this.funcionarios.get(this.oTable.getSelectedRow()), this.usuario).setVisible(true);
            }
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}