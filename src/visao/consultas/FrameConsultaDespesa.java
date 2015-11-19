/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 10/08/2015                                                         *
 * Classe: visao.consultas.FrameConsultaDespesa                               *
 * Coment: Classe responsavel pela Frame de Consulta de Despesa.              *
 *         Subclasse da Classe Abstrata FrameConsulta.                        *
 * ========================================================================== */

package visao.consultas;

import controllers.ControllerDespesa;
import modelo.gerenciais.Despesa;
import modelo.internos.Usuario;
import visao.Frame;
import visao.edicao.FrameEditarDespesa;
import visao.remover.FrameRemoverDespesa;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameConsultaDespesa extends FrameConsulta {
    private List<Despesa> despesas;
    
    private Usuario       usuario;

    public FrameConsultaDespesa(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario = oUsuario;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Consulta de Despesas");
        this.setSize(450, 520);
        this.despesas = ControllerDespesa.getDespesasByDescricao("");
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        this.addHeader("consulta_despesa.jpg");
        this.addLine(1);
        this.addBody();
        this.addLine(1);
        this.addButtons();
    }

    private void addBody() {
        this.oTextFieldSearch = new JTextField(15);
        this.add(new JLabel("Despesa: "));
        this.add(this.oTextFieldSearch);
        this.oButtonSearch    = this.createButton("Atualizar", "update.jpg");
        this.add(this.oButtonSearch);
        
        this.addLine(1);
        
        this.addTable();
        this.oScrollPane.setPreferredSize(new Dimension(350, 150));
        this.addColumns(new String[]{"Descricao", "Valor", "Data Pagamento"});
        this.addRows(ControllerDespesa.getDespesas(this.despesas));
    }
    
    public void clear() {
        this.oTextFieldSearch.setText("");
        this.despesas = ControllerDespesa.getDespesasByDescricao("");
        this.addRows(ControllerDespesa.getDespesas(this.despesas));
        this.oTextFieldSearch.requestFocus();
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSearch)) {
            this.despesas = ControllerDespesa.getDespesasByDescricao(this.oTextFieldSearch.getText());
            this.addRows(ControllerDespesa.getDespesas(this.despesas));
        }else if (oEvento.getSource().equals(this.oButtonEdit)) {
            if ((this.oTable.getSelectedRow() > -1) 
                    && (this.oTable.getSelectedRow() < this.despesas.size())) {
                new FrameEditarDespesa(this, this.despesas.get(this.oTable.getSelectedRow()), this.usuario).setVisible(true);
            }
        }else if (oEvento.getSource().equals(this.oButtonRemove)) {
            if ((this.oTable.getSelectedRow() > -1) 
                    && (this.oTable.getSelectedRow() < this.despesas.size())) {
                new FrameRemoverDespesa(this, this.despesas.get(this.oTable.getSelectedRow()), this.usuario).setVisible(true);
            }
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}