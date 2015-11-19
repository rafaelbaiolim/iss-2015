/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 02/08/2015                                                         *
 * Classe: visao.consultas.FrameConsultaCidade                                *
 * Coment: Classe responsavel pela Frame de Consulta de Cidade.               *
 *         Subclasse da Classe Abstrata FrameConsulta.                        *
 * ========================================================================== */

package visao.consultas;

import controllers.ControllerCidade;
import modelo.estruturais.Cidade;
import modelo.internos.Usuario;
import visao.Frame;
import visao.edicao.FrameEditarCidade;
import visao.remover.FrameRemoverCidade;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameConsultaCidade extends FrameConsulta {
    private List<Cidade> cidades;
    
    private Usuario      usuario;

    public FrameConsultaCidade(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario = oUsuario;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Consulta de Cidades");
        this.setSize(450, 520);
        this.cidades = ControllerCidade.getCidadesByNome("");
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        this.addHeader("consulta_cidade.jpg");
        this.addLine(1);
        this.addBody();
        this.addLine(1);
        this.addButtons();
    }

    private void addBody() {
        this.oTextFieldSearch = new JTextField(15);
        this.add(new JLabel("Cidade: "));
        this.add(this.oTextFieldSearch);
        this.oButtonSearch    = this.createButton("Atualizar", "update.jpg");
        this.add(this.oButtonSearch);
        
        this.addLine(1);
        
        this.addTable();
        this.oScrollPane.setPreferredSize(new Dimension(350, 150));
        this.addColumns(new String[]{"Nome", "UF"});
        this.addRows(ControllerCidade.getCidades(this.cidades));
    }
    
    public void clear() {
        this.oTextFieldSearch.setText("");
        this.cidades = ControllerCidade.getCidadesByNome("");
        this.addRows(ControllerCidade.getCidades(this.cidades));
        this.oTextFieldSearch.requestFocus();
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSearch)) {
            this.cidades = ControllerCidade.getCidadesByNome(this.oTextFieldSearch.getText());
            this.addRows(ControllerCidade.getCidades(this.cidades));
        }else if (oEvento.getSource().equals(this.oButtonEdit)) {
            if ((this.oTable.getSelectedRow() > -1) 
                    && (this.oTable.getSelectedRow() < this.cidades.size())) {
                new FrameEditarCidade(this, this.cidades.get(this.oTable.getSelectedRow()), this.usuario).setVisible(true);
            }
        }else if (oEvento.getSource().equals(this.oButtonRemove)) {
            if ((this.oTable.getSelectedRow() > -1) 
                    && (this.oTable.getSelectedRow() < this.cidades.size())) {
                new FrameRemoverCidade(this, this.cidades.get(this.oTable.getSelectedRow()), this.usuario).setVisible(true);
            }
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}