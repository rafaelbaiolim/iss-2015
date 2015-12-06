package visao.editar;

import controller.visao.editar.ControllerViewEditarDespesa;
import funct.FunctDate;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import modelo.gerenciais.Despesa;
import visao.consulta.ViewConsultaDespesa;

/**
 * Classe responsavel por definir a Interface de Edicao de Despesass no Sistema.
 * @author  Rafael
 * @version 1.0
 * @since   18/11/2015
 * @see     visao.editar.ViewEditar
 */
public final class ViewEditarDespesa extends ViewEditar {
    private       JTextField          jTextFieldDescricao;
    private       JTextField          jTextFieldValor;
    private       JTextField          jTextFieldDataPagamento;
    private       JTextArea           jTextAreaObservacao;
    private final ViewConsultaDespesa viewConsultaDespesa;
    private final Despesa             despesa;

    /**
     * Metodo constrututor herdado da superclasse.
     * @since  30/10/2015
     * @param oView
     * @param oDespesa 
     */
    public ViewEditarDespesa(ViewConsultaDespesa oView, Despesa oDespesa) {
        super(oView);
        this.controller          = new ControllerViewEditarDespesa(this);
        this.viewConsultaDespesa = oView;
        this.despesa             = oDespesa;
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Editar Despesa");
        this.setSize(400, 400);
        this.setLocation(397, 180);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }

    @Override
    public void addHeader() {
        super.addHeader("editar_despesa.jpg");
    }
    
    @Override
    public void addComponents() {
        this.jTextFieldDescricao     = this.createTextField(26);
        this.jTextFieldDescricao.setText(this.despesa.getDescricao());
        this.add(new JLabel("Descrição*: "));
        this.add(this.jTextFieldDescricao);
        
        this.addLinhas(1);
        
        this.jTextFieldValor         = this.createTextField(8);
        this.jTextFieldValor.setText(Float.toString(this.despesa.getValor()));
        this.add(new JLabel("            Valor*: "));
        this.add(this.jTextFieldValor);
        
        this.add(new JLabel("    "));
        
        this.jTextFieldDataPagamento = this.createTextField(6);
        this.jTextFieldDataPagamento.setText(new FunctDate().getFormattedDate(this.despesa.getDataPagamento()));
        this.add(new JLabel("Data Pagamento: "));
        this.add(this.jTextFieldDataPagamento);
        
        this.addLinhas(1);
        
        this.jTextAreaObservacao     = new JTextArea(5, 26);
        this.jTextAreaObservacao.addKeyListener(this.controller);
        this.jTextAreaObservacao.setText(this.despesa.getObservacao());
        this.jTextAreaObservacao.setBorder(new LineBorder(Color.GRAY));
        this.add(new JLabel("Observação: "));
        this.add(this.jTextAreaObservacao);
        
        this.addLinhas(1);
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

    public ViewConsultaDespesa getViewConsultaDespesa() {
        return this.viewConsultaDespesa;
    }
    
    public Despesa getDespesa() {
        return this.despesa;
    }
}