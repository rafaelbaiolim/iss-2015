/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 11/08/2015                                                         *
 * Classe: visao.edicao.FrameEditarUsuario                                    *
 * Coment: Classe responsavel por representar o Frame de Edicao de Usuarios.  *
 *         Subclasse da Classe Abstrata FrameEditar.                          *
 * ========================================================================== */

package visao.edicao;

import controllers.ControllerFuncionario;
import modelo.gerenciais.Funcionario;
import modelo.internos.Usuario;
import visao.FrameModal;
import visao.consultas.FrameConsultaFuncionario;
import funcoes.FunctDate;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameEditarUsuario extends FrameEditar {
    private JTextField oTextFieldNome;
    private JTextField oTextFieldCpf;
    private JComboBox  oListTurno;
    private JTextField oTextFieldCargo;
    private JComboBox  oListSetor;
    private JTextField oTextFieldCargaHoraria;
    private JTextField oTextFieldSalario;
    private JTextField oTextFieldDataAdmissao;
    private FrameConsultaFuncionario oFrameConsultaFuncionario;
    private Funcionario              funcionario;
    private Usuario                  usuario;
    

    public FrameEditarUsuario(FrameModal oFrame, Funcionario oFuncionario, Usuario oUsuario) {
        super(oFrame, "");
        this.oFrameConsultaFuncionario = (FrameConsultaFuncionario) oFrame;
        this.funcionario               = oFuncionario;
        this.usuario                   = oUsuario;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Editar Funcionario");
        this.setLocation(370, 150);
        this.setSize(400, 450);
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        this.addHeader("editar_usuario.jpg");
        this.addLine(1);
        this.addBody();
        this.addLine(1);
        this.addButtons();
    }
    
    private void addBody() {
        this.oTextFieldNome = new JTextField(30);
        this.oTextFieldNome.setText(this.funcionario.getNome());
        this.add(new JLabel("Nome*: "));
        this.add(this.oTextFieldNome);
        
        this.addLine(1);
        
        this.oTextFieldCpf = new JTextField(12);
        this.oTextFieldCpf.setText(this.funcionario.getCpf());
        this.add(new JLabel("CPF*: "));
        this.add(this.oTextFieldCpf);
        
        this.add(new JLabel("   "));
        
        String[] oTurnos = {"Selecione", "Manha-Tarde", "Tarde-Noite"};
        this.oListTurno  = new JComboBox(oTurnos);
        this.oListTurno.setPreferredSize(new Dimension(125, 20));
        if (this.funcionario.getTurno().equals("") == false) {
            this.oListTurno.setSelectedItem(this.funcionario.getTurno());
        }else {
            this.oListTurno.setSelectedIndex(0);
        }
        this.add(new JLabel("Turno: "));
        this.add(this.oListTurno);
        
        this.addLine(1);
        
        this.oTextFieldCargo = new JTextField(9);
        this.oTextFieldCargo.setText(this.funcionario.getCargo());
        this.add(new JLabel("Cargo: "));
        this.add(this.oTextFieldCargo);
        
        String[] sSetores = {"Selecione", "VENDAS", "ESTOQUE", "CONTABILIDADE", "MANUTENCAO"};
        this.oListSetor = new JComboBox(sSetores);
        
        if (this.funcionario.getSetor().equals("") == false) {
            this.oListSetor.setSelectedItem(this.funcionario.getSetor());
        }else {
            this.oListSetor.setSelectedIndex(0);
        }
        
        this.add(new JLabel("Setor: "));
        this.add(this.oListSetor);
        
        this.oTextFieldCargaHoraria = new JTextField(2);
        this.oTextFieldCargaHoraria.setText(Integer.toString(this.funcionario.getCargaHoraria()));
        this.add(new JLabel("CH: "));
        this.add(this.oTextFieldCargaHoraria);
        
        this.addLine(1);
        
        this.oTextFieldSalario = new JTextField(6);
        this.oTextFieldSalario.setText(Float.toString(this.funcionario.getSalario()));
        this.add(new JLabel("Salário: "));
        this.add(this.oTextFieldSalario);
        
        this.add(new JLabel("                         "));
        
        this.oTextFieldDataAdmissao = new JTextField(7);
        
        if (this.funcionario.getDataAdmissao() != null) {
            this.oTextFieldDataAdmissao.setText(FunctDate.getFormattedDate(this.funcionario.getDataAdmissao()));
        }else {
            this.oTextFieldDataAdmissao.setText(FunctDate.getFormattedDate(new Date()));
        }
        
        this.add(new JLabel("Data Admissão: "));
        this.add(this.oTextFieldDataAdmissao);
        
        this.addLine(1);
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSave)) {
            String sNome         = this.oTextFieldNome.getText().toUpperCase().trim();
            String sCpf          = this.oTextFieldCpf.getText().trim();
            String sTurno        = this.oListTurno.getSelectedItem().toString();
            String sCargo        = this.oTextFieldCargo.getText().toUpperCase().trim();
            String sSetor        = this.oListSetor.getSelectedItem().toString();
            int    iCargaHoraria = Integer.parseInt(this.oTextFieldCargaHoraria.getText().trim());
            float  fSalario      = Float.parseFloat(this.oTextFieldSalario.getText().trim());
            Date   dDataAdmissao = FunctDate.createDate(this.oTextFieldDataAdmissao.getText().trim());
            ControllerFuncionario.gravar(this.funcionario, sCpf, sNome, sTurno, sCargo, sSetor, iCargaHoraria, fSalario, dDataAdmissao, this.usuario);
            this.oFrameConsultaFuncionario.clear();
            this.dispose();
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}