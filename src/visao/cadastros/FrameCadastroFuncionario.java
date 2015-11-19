/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 26/08/2015                                                         *
 * Classe: visao.cadastros.FrameCadastroFuncionario                           *
 * Coment: Classe responsavel pela Frame de Cadastro de Funcionario.          *
 *         Subclasse da Classe Abstrata FrameModal.                           *
 * ========================================================================== */

package visao.cadastros;

import controllers.ControllerFuncionario;
import modelo.internos.Usuario;
import visao.Frame;
import funcoes.FunctDate;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public final class FrameCadastroFuncionario extends FrameCadastro {
    private JTextField oTextFieldNome;
    
    private JTextField oTextFieldCpf;
    private JComboBox  oListTurno;
    
    private JTextField oTextFieldCargo;
    private JComboBox  oListSetor;
    private JTextField oTextFieldCargaHoraria;
    
    private JTextField oTextFieldSalario;
    private JTextField oTextFieldDataAdmissao;
    
    private Usuario    usuario;
    
    public FrameCadastroFuncionario(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario = oUsuario;
        this.initComponents();
    }

    @Override
    protected void initComponents() {
        this.setTitle("Mercado - Cadastro de Funcionário");
        this.setLocation(360, 130);
        this.setSize(400, 450);
        this.addHeader("cadastro_funcionario.jpg");
        this.setInitialMessage("Os Campos (*) sao Obrigatorios");
        this.addComponents();
        this.addButtons();
    }

    @Override
    protected void addComponents() {
        this.oTextFieldNome = new JTextField(30);
        this.add(new JLabel("Nome*: "));
        this.add(this.oTextFieldNome);
        
        this.addLine(1);
        
        this.oTextFieldCpf = new JTextField(12);
        this.add(new JLabel("CPF*: "));
        this.add(this.oTextFieldCpf);
        
        this.add(new JLabel("   "));
        
        String[] oTurnos = {"Selecione", "Manha-Tarde", "Tarde-Noite"};
        this.oListTurno  = new JComboBox(oTurnos);
        this.oListTurno.setPreferredSize(new Dimension(125, 20));
        this.add(new JLabel("Turno: "));
        this.add(this.oListTurno);
        
        this.addLine(1);
        
        this.oTextFieldCargo = new JTextField(9);
        this.add(new JLabel("Cargo: "));
        this.add(this.oTextFieldCargo);
        
        String[] sSetores = {"Selecione", "VENDAS", "ESTOQUE", "CONTABILIDADE", "MANUTENCAO"};
        this.oListSetor = new JComboBox(sSetores);
        this.add(new JLabel("Setor: "));
        this.add(this.oListSetor);
        
        this.oTextFieldCargaHoraria = new JTextField(2);
        this.oTextFieldCargaHoraria.setText("0");
        this.add(new JLabel("CH: "));
        this.add(this.oTextFieldCargaHoraria);
        
        this.addLine(1);
        
        this.oTextFieldSalario = new JTextField(6);
        this.oTextFieldSalario.setText("0.00");
        this.add(new JLabel("Salário: "));
        this.add(this.oTextFieldSalario);
        
        this.add(new JLabel("                         "));
        
        this.oTextFieldDataAdmissao = new JTextField(7);
        this.oTextFieldDataAdmissao.setText(FunctDate.getFormattedDate(new Date()));
        this.add(new JLabel("Data Admissão: "));
        this.add(this.oTextFieldDataAdmissao);
        
        this.addLine(1);
    }

    @Override
    protected void clear() {
        this.oTextFieldNome.setText("");
        this.oTextFieldCpf.setText("");
        this.oListTurno.setSelectedIndex(0);
        this.oTextFieldCargo.setText("");
        this.oListSetor.setSelectedIndex(0);
        this.oTextFieldCargaHoraria.setText("0");
        this.oTextFieldSalario.setText("0.00");
        this.oTextFieldDataAdmissao.setText(FunctDate.getFormattedDate(new Date()));
        
        this.oTextFieldNome.requestFocus();
    }
    
    private boolean checkParameters(String sNome, String sCpf) {
        if (ControllerFuncionario.checkNome(sNome) == false) {
            this.setError("Nome Invalido!");
            this.oTextFieldNome.requestFocus();
            return false;
        }else if (ControllerFuncionario.checkCpf(sCpf) == false) {
            this.setError("CPF Invalido - Digite Apenas Numeros!");
            this.oTextFieldCpf.requestFocus();
            return false;
        }else if (ControllerFuncionario.cpfIsAble(sCpf) == false) {
            this.setError("CPF ja Cadastrado!");
            this.oTextFieldCpf.requestFocus();
            return false;
        }else if (this.oListSetor.getSelectedIndex() == 0) {
            this.setError("Selecione um Setor!");
            this.oListSetor.requestFocus();
            return false;
        }else if (this.oListTurno.getSelectedIndex() == 0) {
            this.setError("Selecione um Turno!");
            this.oListTurno.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonAdd)) {
            String sNome         = this.oTextFieldNome.getText().toUpperCase().trim();
            String sCpf          = this.oTextFieldCpf.getText().trim();
            String sTurno        = this.oListTurno.getSelectedItem().toString();
            String sCargo        = this.oTextFieldCargo.getText().toUpperCase().trim();
            String sSetor        = this.oListSetor.getSelectedItem().toString();
            int    iCargaHoraria = Integer.parseInt(this.oTextFieldCargaHoraria.getText().trim());
            float  fSalario      = Float.parseFloat(this.oTextFieldSalario.getText().trim());
            Date   dDataAdmissao = FunctDate.createDate(this.oTextFieldDataAdmissao.getText().trim());
            if (this.checkParameters(sNome, sCpf) == true) {
                ControllerFuncionario.adicionar(sCpf, sNome, sTurno, sCargo, sSetor, iCargaHoraria, fSalario, dDataAdmissao, this.usuario);
                this.setMessage("Funcionario Cadastrado com Sucesso!");
                this.clear();
            }
        }else if (oEvento.getSource().equals(this.oButtonClear)) {
            this.clear();
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}