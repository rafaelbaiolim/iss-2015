/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 18/08/2015                                                         *
 * Classe: visao.operacoes.FrameOperacoesOrganizarHorarios                    *
 * Coment: Classe responsavel por representar o Frame de Organizar Horarios   *
 *         no Sistema.                                                        *
 *         Subclasse da Classe Abstrata FrameOperacoes.                       *
 * ========================================================================== */

package visao.operacoes;

import controllers.ControllerFuncionario;
import modelo.gerenciais.Funcionario;
import modelo.internos.Usuario;
import visao.Frame;
import visao.edicao.FrameEditarFuncionario;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameOperacoesOrganizarHorarios extends FrameOperacoes {
    private JLabel            oLabelHeader;
    
    private JTextField        oTextFieldFuncionario;
    private JComboBox         oListTurno;
    private JComboBox         oListSetor;
    private JButton           oButtonSearch;
    
    private JTextField        oTextFieldQuantidadeFuncionarios;
    
    private JButton           oButtonOk;
    private JButton           oButtonCancelar;
    
    private Usuario           usuario;
    private List<Funcionario> funcionarios;

    public FrameOperacoesOrganizarHorarios(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario    = oUsuario;
        this.funcionarios = ControllerFuncionario.getFuncionariosByNome("");
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Organizar Horarios");
        this.setLocation(350, 80);
        this.setSize(500, 550);
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        
        this.oLabelHeader      = new JLabel("ORGANIZAR HORARIOS");
        this.oLabelHeader.setFont(new Font("Tahoma", 1, 25));
        this.add(this.oLabelHeader);
        
        this.addLine(1);
        
        this.oTextFieldFuncionario = new JTextField(30);
        this.add(new JLabel("Funcionario: "));
        this.add(this.oTextFieldFuncionario);
        
        this.addLine(1);
        
        String[] oTurnos = {"Selecione", "MANHA-TARDE", "TARDE-NOITE"};
        this.oListTurno  = new JComboBox(oTurnos);
        this.oListTurno.setPreferredSize(new Dimension(125, 20));
        this.add(new JLabel("Turno: "));
        this.add(this.oListTurno);
        
        String[] sSetores = {"Selecione", "VENDAS", "ESTOQUE", "CONTABILIDADE", "MANUTENCAO"};
        this.oListSetor = new JComboBox(sSetores);
        this.add(new JLabel("Setor: "));
        this.add(this.oListSetor);
        
        this.oButtonSearch = this.createButton("", "search.jpg");
        this.add(this.oButtonSearch);
        
        this.addLine(1);
        
        this.addTable();
        String[] sDados = {"Nome", "CPF"};
        this.addColumns(sDados);
        this.oScrollPane.setPreferredSize(new Dimension(350, 150));
        
        this.addButtons();
        this.oButtonAdd.setVisible(false);
        this.oButtonRemove.setVisible(false);
                
        this.addLine(1);
        
        this.oTextFieldQuantidadeFuncionarios  = new JTextField(10);
        this.oTextFieldQuantidadeFuncionarios.setEditable(false);
        this.oTextFieldQuantidadeFuncionarios.setText(Integer.toString(this.funcionarios.size()));
        this.add(new JLabel("Quantidade Funcionarios: "));
        this.add(this.oTextFieldQuantidadeFuncionarios);
        
        this.addLine(1);        
        
        this.oButtonOk        = this.createButton("   Ok   ", "yes.jpg");
        this.oButtonCancelar  = this.createButton("Cancelar", "no.jpg");
        this.add(this.oButtonOk);
        this.add(this.oButtonCancelar);
        
        this.atualizarDados();
    }

    private void atualizarDados() {
        this.clearTable();
        String[][] sFuncionarios = new String[this.funcionarios.size()][2];
        for (int i = 0; i < this.funcionarios.size(); ++i) {                
            sFuncionarios[i][0] = this.funcionarios.get(i).getNome();
            sFuncionarios[i][1] = this.funcionarios.get(i).getCpf();
        }
        this.addRows(sFuncionarios);
        this.oTextFieldQuantidadeFuncionarios.setText(Integer.toString(this.funcionarios.size()));
    }
        
    public void clear() {
        this.oTextFieldFuncionario.setText("");
        this.oListTurno.setSelectedIndex(0);
        this.oListSetor.setSelectedIndex(0);
        this.funcionarios = ControllerFuncionario.getFuncionariosByNome("");
        this.atualizarDados();
    }
     
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSearch)) {
            String sFuncionario = this.oTextFieldFuncionario.getText();
            String sTurno       = (this.oListTurno.getSelectedItem().toString().equals("Selecione") == true) ? "" : this.oListTurno.getSelectedItem().toString();
            String sSetor       = (this.oListSetor.getSelectedItem().toString().equals("Selecione") == true) ? "" : this.oListSetor.getSelectedItem().toString();
            this.funcionarios   = ControllerFuncionario.getFuncionarios(sFuncionario, sTurno, sSetor);
            this.atualizarDados();
        }else if (oEvento.getSource().equals(this.oButtonEdit)) {
            if ((this.oTable.getSelectedRow() > -1) 
                    && (this.oTable.getSelectedRow() < this.funcionarios.size())) {
                new FrameEditarFuncionario(this, this.funcionarios.get(this.oTable.getSelectedRow()), this.usuario).setVisible(true);
            }
        }else if (oEvento.getSource().equals(this.oButtonOk)) {
            this.dispose();
        }else if (oEvento.getSource().equals(this.oButtonCancelar)) {
            this.dispose();
        }
    }
}