package visao.editar;

import controller.visao.editar.ControllerViewEditarFuncionario;
import funct.FunctDate;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.gerenciais.Funcionario;
import visao.consulta.ViewConsultaFuncionario;

/**
 * Classe responsavel por definir a Interface de Edicao de Funcionarios no Sistema.
 * @author  Leandro
 * @version 1.0
 * @since   18/11/2015
 * @see     visao.editar.ViewEditar
 */
public final class ViewEditarFuncionario extends ViewEditar {
    private       JTextField              jTextFieldNome;
    private       JTextField              jTextFieldCpf;
    private       JComboBox               jComboBoxTurno;
    private       JTextField              jTextFieldCargo;
    private       JComboBox               jComboBoxSetor;
    private       JTextField              jTextFieldCargaHoraria;
    private       JTextField              jTextFieldSalario;
    private       JTextField              jTextFieldDataAdmissao;
    private final ViewConsultaFuncionario viewConsultaFuncionario;
    private final Funcionario             funcionario;

    /**
     * Metodo constrututor herdado da superclasse.
     * @param oView
     * @param oFuncionario 
     */
    public ViewEditarFuncionario(ViewConsultaFuncionario oView, Funcionario oFuncionario) {
        super(oView);
        this.controller              = new ControllerViewEditarFuncionario(this);
        this.viewConsultaFuncionario = oView;
        this.funcionario             = oFuncionario;
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Editar Funcionário");
        this.setSize(400, 390);
        this.setLocation(395, 180);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }

    @Override
    public void addHeader() {
        super.addHeader("editar_funcionario.jpg");
    }
    
    @Override
    public void addComponents() {
        this.jTextFieldNome = this.createTextField(30);
        this.jTextFieldNome.setText(this.funcionario.getNome());
        this.add(new JLabel("Nome*: "));
        this.add(this.jTextFieldNome);
        
        this.addLinhas(1);
        
        this.jTextFieldCpf = this.createTextField(12);
        this.jTextFieldCpf.setText(this.funcionario.getCpf());
        this.add(new JLabel("CPF*: "));
        this.add(this.jTextFieldCpf);
        
        this.add(new JLabel("   "));
        
        String[] oTurnos = {"Selecione", "MANHA-TARDE", "TARDE-NOITE"};
        this.jComboBoxTurno  = new JComboBox(oTurnos);
        this.jComboBoxTurno.addKeyListener(this.controller);
        this.jComboBoxTurno.setSelectedItem(this.funcionario.getTurno());
        this.jComboBoxTurno.setPreferredSize(new Dimension(125, 20));
        this.add(new JLabel("Turno: "));
        this.add(this.jComboBoxTurno);
        
        this.addLinhas(1);
        
        this.jTextFieldCargo = this.createTextField(9);
        this.jTextFieldCargo.setText(this.funcionario.getCargo());
        this.add(new JLabel("Cargo: "));
        this.add(this.jTextFieldCargo);
        
        String[] sSetores = {"Selecione", "VENDAS", "ESTOQUE", "CONTABILIDADE", "MANUTENCAO"};
        this.jComboBoxSetor = new JComboBox(sSetores);
        this.jComboBoxSetor.addKeyListener(this.controller);
        this.jComboBoxSetor.setSelectedItem(this.funcionario.getSetor());
        this.jComboBoxSetor.setPreferredSize(new Dimension(125, 20));
        this.add(new JLabel("Setor: "));
        this.add(this.jComboBoxSetor);
        
        this.jTextFieldCargaHoraria = this.createTextField(2);
        this.jTextFieldCargaHoraria.setText(Integer.toString(this.funcionario.getCargaHoraria()));
        this.add(new JLabel("CH: "));
        this.add(this.jTextFieldCargaHoraria);
        
        this.addLinhas(1);
        
        this.jTextFieldSalario = this.createTextField(6);
        this.jTextFieldSalario.setText(Float.toString(this.funcionario.getSalario()));
        this.add(new JLabel("Salário: "));
        this.add(this.jTextFieldSalario);
        
        this.add(new JLabel("                         "));
        
        this.jTextFieldDataAdmissao = this.createTextField(7);
        this.jTextFieldDataAdmissao.setText(new FunctDate().getFormattedDate(this.funcionario.getDataAdmissao()));
        this.add(new JLabel("Data Admissão: "));
        this.add(this.jTextFieldDataAdmissao);
        
        this.addLinhas(1);
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

    public ViewConsultaFuncionario getViewConsultaFuncionario() {
        return this.viewConsultaFuncionario;
    }
    
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
}