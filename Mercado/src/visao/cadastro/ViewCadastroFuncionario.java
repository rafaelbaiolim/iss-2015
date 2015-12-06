package visao.cadastro;

import controller.visao.cadastro.ControllerViewCadastroFuncionario;
import funct.FunctDate;
import java.awt.Dimension;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Cadastro de Funcionários no Sistema.
 * @author  Leandro
 * @version 1.0
 * @since   09/11/2015
 * @see     visao.cadastro.ViewCadastro
 */
public final class ViewCadastroFuncionario extends ViewCadastro {
    private JTextField jTextFieldNome;
    private JTextField jTextFieldCpf;
    private JComboBox  jComboBoxTurno;
    private JTextField jTextFieldCargo;
    private JComboBox  jComboBoxSetor;
    private JTextField jTextFieldCargaHoraria;
    private JTextField jTextFieldSalario;
    private JTextField jTextFieldDataAdmissao;

    public ViewCadastroFuncionario(View oView) {
        super(oView);
        this.controller = new ControllerViewCadastroFuncionario(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Cadastro de Funcionário");
        this.setSize(400, 455);
        this.setLocation(400, 150);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }

    @Override
    public void addHeader() {
        this.addHeader("cadastro_funcionario.jpg");
        this.message = new JLabel("Os campos com (*) sao obrigatorios!");
        this.add(this.message);
        this.addLinhas(1);
    }
    
    @Override
    public void addComponents() {
        this.jTextFieldNome         = this.createTextField(30);
        this.add(new JLabel("Nome*: "));
        this.add(this.jTextFieldNome);
        
        this.addLinhas(1);
        
        this.jTextFieldCpf          = this.createTextField(12);
        this.add(new JLabel("CPF*: "));
        this.add(this.jTextFieldCpf);
        
        this.add(new JLabel("   "));
        
        String[] oTurnos            = {"Selecione", "MANHA-TARDE", "TARDE-NOITE"};
        this.jComboBoxTurno         = new JComboBox(oTurnos);
        this.jComboBoxTurno.addKeyListener(this.controller);
        this.jComboBoxTurno.setPreferredSize(new Dimension(125, 20));
        this.add(new JLabel("Turno: "));
        this.add(this.jComboBoxTurno);
        
        this.addLinhas(1);
        
        this.jTextFieldCargo        = this.createTextField(9);
        this.add(new JLabel("Cargo: "));
        this.add(this.jTextFieldCargo);
        
        String[] sSetores           = {"Selecione", "VENDAS", "ESTOQUE", "CONTABILIDADE", "MANUTENCAO"};
        this.jComboBoxSetor         = new JComboBox(sSetores);
        this.jComboBoxSetor.addKeyListener(this.controller);
        this.jComboBoxSetor.setPreferredSize(new Dimension(125, 20));
        this.add(new JLabel("Setor: "));
        this.add(this.jComboBoxSetor);
        
        this.jTextFieldCargaHoraria = this.createTextField(2);
        this.jTextFieldCargaHoraria.setText("0");
        this.add(new JLabel("CH: "));
        this.add(this.jTextFieldCargaHoraria);
        
        this.addLinhas(1);
        
        this.jTextFieldSalario      = this.createTextField(6);
        this.jTextFieldSalario.setText("0.00");
        this.add(new JLabel("Salário: "));
        this.add(this.jTextFieldSalario);
        
        this.add(new JLabel("                         "));
        
        this.jTextFieldDataAdmissao = this.createTextField(7);
        this.jTextFieldDataAdmissao.setText(new FunctDate().getFormattedDate(new Date()));
        this.add(new JLabel("Data Admissão: "));
        this.add(this.jTextFieldDataAdmissao);
        
        this.addLinhas(1);
    }

    @Override
    public void clear() {
        this.jTextFieldNome.setText("");
        this.jTextFieldCpf.setText("");
        this.jComboBoxTurno.setSelectedIndex(0);
        this.jTextFieldCargo.setText("");
        this.jComboBoxSetor.setSelectedIndex(0);
        this.jTextFieldCargaHoraria.setText("0");
        this.jTextFieldSalario.setText("0.00");
        this.jTextFieldDataAdmissao.setText(new FunctDate().getFormattedDate(new Date()));
        
        this.jTextFieldNome.requestFocus();
    }

    public JTextField getTextFieldNome() {
        return this.jTextFieldNome;
    }

    public JTextField getTextFieldCpf() {
        return this.jTextFieldCpf;
    }

    public JComboBox getComboBoxTurno() {
        return this.jComboBoxTurno;
    }

    public JTextField getTextFieldCargo() {
        return this.jTextFieldCargo;
    }

    public JComboBox getComboBoxSetor() {
        return this.jComboBoxSetor;
    }

    public JTextField getTextFieldCargaHoraria() {
        return this.jTextFieldCargaHoraria;
    }

    public JTextField getTextFieldSalario() {
        return this.jTextFieldSalario;
    }

    public JTextField getTextFieldDataAdmissao() {
        return this.jTextFieldDataAdmissao;
    }
}