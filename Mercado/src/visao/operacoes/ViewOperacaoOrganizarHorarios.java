package visao.operacoes;

import controller.visao.operacoes.ControllerViewOperacaoOrganizarHorarios;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.dao.gerenciais.DaoFuncionario;
import modelo.gerenciais.Funcionario;
import visao.View;

/**
 * Classe responsavel por definir a Interface para Organizar Horarios dos Funcionarios do Sistema.
 * @author  Leandro
 * @version 1.0
 * @since   14/01/2016
 */
public final class ViewOperacaoOrganizarHorarios extends ViewOperacao {
    private JTextField jTextFieldNomeFuncionario;
    private JComboBox  jComboBoxSetor;
    private JComboBox  jComboBoxTurno;
    private JButton    jButtonSearch;
    private JTextField jTextFieldTotalFuncionarios;
    private DaoFuncionario    daoFuncionario;
    private List<Funcionario> funcionarios;

    public ViewOperacaoOrganizarHorarios(View oViewParent) {
        super(oViewParent);
        this.controller = new ControllerViewOperacaoOrganizarHorarios(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Organizar Horarios");
        this.setSize(450, 540);
        this.setLocation(370, 105);
        this.addHeader();
        this.addComponents();
        this.addButtons();
        this.clear();
    }
    
    @Override
    public void addHeader() {
        super.addHeader("organizar_horario.jpg");
    }

    @Override
    public void addComponents() {
        this.jTextFieldNomeFuncionario = this.createTextField(30);
        this.add(new JLabel("Funcionario: "));
        this.add(this.jTextFieldNomeFuncionario);
        
        this.addLinhas(1);
        
        String[] sTurnos    = {"Selecione", "MANHA-TARDE", "TARDE-NOITE"};
        this.jComboBoxTurno = new JComboBox(sTurnos);
        this.jComboBoxTurno.setPreferredSize(new Dimension(125, 20));
        this.add(new JLabel("Turno: "));
        this.add(this.jComboBoxTurno);
        
        this.add(new JLabel("     "));
        
        String[] sSetores   = {"Selecione", "VENDAS", "ESTOQUE", "CONTABILIDADE", "MANUTENCAO"};
        this.jComboBoxSetor = new JComboBox(sSetores);
        this.jComboBoxSetor.setPreferredSize(new Dimension(125, 20));
        this.add(new JLabel("Setor: "));
        this.add(this.jComboBoxSetor);
        
        this.jButtonAction1 = this.createButton("", "search2.jpg");
        this.add(this.jButtonAction1);
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Nome", "Turno", "Setor"};
        int[]    iColumns = {50, 10, 10};
        this.setColumns(sColumns);
        this.setColumnSize(iColumns);
        
        this.addLinhas(1);
        
        this.jTextFieldTotalFuncionarios = this.createTextField(5);
        this.jTextFieldTotalFuncionarios.setEditable(false);
        this.jTextFieldTotalFuncionarios.setText("0");
        this.add(new JLabel("Quantidade Funcionarios: "));
        this.add(this.jTextFieldTotalFuncionarios);
        
        this.addLinhas(1);
    }
    
    @Override
    public void addButtons() {
        this.jButtonAction2 = this.createButton("  Ok  ", "ok.jpg");
        this.jButtonAction3 = this.createButton("Voltar", "back.jpg");
        
        this.add(this.jButtonAction2);
        this.add(this.jButtonAction3);
    }
    
    @Override
    public void clear() {
        this.funcionarios = this.daoFuncionario.list();
        this.jTextFieldNomeFuncionario.setText("");
        this.addRows(this.daoFuncionario.getFuncionarios(this.funcionarios));
        this.jTextFieldTotalFuncionarios.setText(Integer.toString(this.funcionarios.size()));
    }
    
    /**
     * Metodo responsavel por atualizar os Funcionarios no View.
     * @param oFuncionarios Funcionarios encontrados.
     */
    public void setFuncionarios(List<Funcionario> oFuncionarios) {
        this.daoFuncionario = new DaoFuncionario();
        this.funcionarios   = oFuncionarios;
        this.addRows(this.daoFuncionario.getFuncionarios(oFuncionarios));
        this.jTextFieldTotalFuncionarios.setText(Integer.toString(oFuncionarios.size()));
    }

    public List<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }
    
    public JTextField getTextFieldNomeFuncionario() {
        return this.jTextFieldNomeFuncionario;
    }

    public JComboBox getComboBoxSetor() {
        return this.jComboBoxSetor;
    }

    public JComboBox getComboBoxTurno() {
        return this.jComboBoxTurno;
    }
    
    public JButton getButtonSearch() {
        return this.jButtonSearch;
    }
    
    public JButton getButtonEditar() {
        return this.jButtonAction1;
    }

    public JButton getButtonOk() {
        return this.jButtonAction2;
    }

    public JButton getButtonVoltar() {
        return this.jButtonAction3;
    }
}
