package visao.cadastro;

import controller.visao.cadastro.ControllerViewCadastroDespesa;
import funct.FunctDate;
import java.awt.Color;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Cadastro de Despesas no Sistema.
 * @author  Rafael
 * @version 1.0
 * @since   09/11/2015
 * @see     visao.cadastro.ViewCadastro
 */
public final class ViewCadastroDespesa extends ViewCadastro {
    private JTextField jTextFieldDescricao;
    private JTextField jTextFieldValor;
    private JTextField jTextFieldDataPagamento;
    private JTextArea  jTextAreaObservacao;

    public ViewCadastroDespesa(View oView) {
        super(oView);
        this.controller = new ControllerViewCadastroDespesa(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Cadastro de Despesa");
        this.setSize(400, 470);
        this.setLocation(395, 150);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }
    
    @Override
    public void addHeader() {
        this.addHeader("cadastro_despesa.jpg");
        this.message = new JLabel("Os campos com (*) sao obrigatorios!");
        this.add(this.message);
        this.addLinhas(1);
    }

    @Override
    public void addComponents() {
        this.jTextFieldDescricao     = this.createTextField(26);
        this.add(new JLabel("Descrição*: "));
        this.add(this.jTextFieldDescricao);
        
        this.addLinhas(1);
        
        this.jTextFieldValor         = this.createTextField(8);
        this.jTextFieldValor.setText("0.00");
        this.add(new JLabel("            Valor*: "));
        this.add(this.jTextFieldValor);
        
        this.add(new JLabel("    "));
        
        this.jTextFieldDataPagamento = this.createTextField(6);
        this.jTextFieldDataPagamento.setText(new FunctDate().getFormattedDate(new Date()));
        this.add(new JLabel("Data Pagamento: "));
        this.add(this.jTextFieldDataPagamento);
        
        this.addLinhas(1);
        
        this.jTextAreaObservacao     = new JTextArea(5, 26);
        this.jTextAreaObservacao.addKeyListener(this.controller);
        this.jTextAreaObservacao.setBorder(new LineBorder(Color.GRAY));
        this.add(new JLabel("Observação: "));
        this.add(this.jTextAreaObservacao);
        
        this.addLinhas(1);
    }

    @Override
    public void clear() {
        this.jTextFieldDescricao.setText("");
        this.jTextFieldValor.setText("0.00");
        this.jTextFieldDataPagamento.setText(new FunctDate().getFormattedDate(new Date()));
        this.jTextAreaObservacao.setText("");
        
        this.jTextFieldDescricao.requestFocus();
    }

    public JTextField getTextFieldDescricao() {
        return this.jTextFieldDescricao;
    }

    public JTextField getTextFieldValor() {
        return this.jTextFieldValor;
    }

    public JTextField getTextFieldDataPagamento() {
        return this.jTextFieldDataPagamento;
    }

    public JTextArea getTextAreaObservacao() {
        return this.jTextAreaObservacao;
    }
}