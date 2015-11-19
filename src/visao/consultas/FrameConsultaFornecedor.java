/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 09/08/2015                                                         *
 * Classe: visao.consultas.FrameConsultaFornecedor                            *
 * Coment: Classe responsavel pela Frame de Consulta de Fornecedor.           *
 *         Subclasse da Classe Abstrata FrameConsulta.                        *
 * ========================================================================== */

package visao.consultas;

import controllers.ControllerFornecedor;
import modelo.gerenciais.Fornecedor;
import modelo.internos.Usuario;
import visao.Frame;
import visao.edicao.FrameEditarFornecedor;
import visao.remover.FrameRemoverFornecedor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameConsultaFornecedor extends FrameConsulta {
    private List<Fornecedor> fornecedores;
    
    private Usuario          usuario;

    public FrameConsultaFornecedor(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario = oUsuario;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Consulta de Fornecedor");
        this.setSize(450, 520);
        this.fornecedores = ControllerFornecedor.getFornecedoresByNome("");
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        this.addHeader("consulta_fornecedor.jpg");
        this.addLine(1);
        this.addBody();
        this.addLine(1);
        this.addButtons();
    }

    private void addBody() {
        this.oTextFieldSearch = new JTextField(15);
        this.add(new JLabel("Fornecedor: "));
        this.add(this.oTextFieldSearch);
        this.oButtonSearch    = this.createButton("Atualizar", "update.jpg");
        this.add(this.oButtonSearch);
        
        this.addLine(1);
        
        this.addTable();
        this.oScrollPane.setPreferredSize(new Dimension(350, 150));
        this.addColumns(new String[]{"Nome", "CNPJ"});
        this.addRows(ControllerFornecedor.getFornecedores(this.fornecedores));
    }
    
    public void clear() {
        this.oTextFieldSearch.setText("");
        this.fornecedores = ControllerFornecedor.getFornecedoresByNome("");
        this.addRows(ControllerFornecedor.getFornecedores(this.fornecedores));
        this.oTextFieldSearch.requestFocus();
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSearch)) {
            this.fornecedores = ControllerFornecedor.getFornecedoresByNome(this.oTextFieldSearch.getText());
            this.addRows(ControllerFornecedor.getFornecedores(this.fornecedores));
        }else if (oEvento.getSource().equals(this.oButtonEdit)) {
            if ((this.oTable.getSelectedRow() > -1) 
                    && (this.oTable.getSelectedRow() < this.fornecedores.size())) {
                new FrameEditarFornecedor(this, this.fornecedores.get(this.oTable.getSelectedRow()), this.usuario).setVisible(true);
            }
        }else if (oEvento.getSource().equals(this.oButtonRemove)) {
            if ((this.oTable.getSelectedRow() > -1) 
                    && (this.oTable.getSelectedRow() < this.fornecedores.size())) {
                new FrameRemoverFornecedor(this, this.fornecedores.get(this.oTable.getSelectedRow()), this.usuario).setVisible(true);
            }
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}