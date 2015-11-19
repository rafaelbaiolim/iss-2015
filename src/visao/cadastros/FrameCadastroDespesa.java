/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 21/08/2015                                                         *
 * Classe: visao.cadastros.FrameCadastroDespesa                               *
 * Coment: Classe responsavel pela Frame de Cadastro de Despesa.              *
 *         Subclasse da Classe Abstrata FrameModal.                           *
 * ========================================================================== */

package visao.cadastros;

import controllers.ControllerDespesa;
import modelo.internos.Usuario;
import visao.Frame;
import funcoes.FunctDate;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public final class FrameCadastroDespesa extends FrameCadastro {
    private JTextField oTextFieldDescricao;
    
    private JTextField oTextFieldValor;
    private JTextField oTextFieldDataPagamento;
    
    private JTextArea  oTextAreaObservacao;
    
    private Usuario    usuario;

    public FrameCadastroDespesa(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario = oUsuario;
        this.initComponents();
    }

    @Override
    protected void initComponents() {
        this.setTitle("Mercado - Cadastro de Despesa");
        this.setLocation(370, 130);
        this.setSize(400, 470);
        this.addHeader("cadastro_despesa.jpg");
        this.setInitialMessage("Os Campos (*) sao Obrigatorios");
        this.addComponents();
        this.addButtons();
    }

    @Override
    protected void addComponents() {
        this.oTextFieldDescricao     = new JTextField(26);
        this.add(new JLabel("Descrição*: "));
        this.add(this.oTextFieldDescricao);
        
        this.addLine(1);
        
        this.oTextFieldValor         = new JTextField(8);
        this.oTextFieldValor.setText("0.00");
        this.add(new JLabel("            Valor*: "));
        this.add(this.oTextFieldValor);
        
        this.add(new JLabel("   "));
        
        this.oTextFieldDataPagamento = new JTextField(6);
        this.oTextFieldDataPagamento.setText(FunctDate.getFormattedDate(new Date()));
        this.add(new JLabel("Data Pagamento: "));
        this.add(this.oTextFieldDataPagamento);
        
        this.addLine(1);
        
        this.oTextAreaObservacao     = new JTextArea(5, 26);
        this.oTextAreaObservacao.setBorder(new LineBorder(Color.GRAY));
        this.add(new JLabel("Observação: "));
        this.add(this.oTextAreaObservacao);
        
        this.addLine(1);
    }

    @Override
    protected void clear() {
        this.oTextFieldDescricao.setText("");
        
        this.oTextFieldValor.setText("");
        this.oTextFieldDataPagamento.setText("");
        
        this.oTextAreaObservacao.setText("");
        
        this.oTextFieldDescricao.requestFocus();
    }

    private boolean checkParameters(String sDescricao) {
        if (ControllerDespesa.checkDescricao(sDescricao) == false) {
            this.setError("Descricao Invalida!");
            return false;
        }
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonAdd)) {
            String sDescricao     = this.oTextFieldDescricao.getText().toUpperCase().trim();
            float  fValor         = Float.parseFloat(this.oTextFieldValor.getText().trim());
            Date   dDataPagamento = FunctDate.createDate(this.oTextFieldDataPagamento.getText().trim());
            String sObservacao    = this.oTextAreaObservacao.getText().toUpperCase().trim();
            if (this.checkParameters(sDescricao) == true) {
                ControllerDespesa.adicionar(sDescricao, fValor, dDataPagamento, sObservacao, this.usuario);
                this.setMessage("Despesa Cadastrada com Sucesso!");
                this.clear();
            }
        }else if (oEvento.getSource().equals(this.oButtonClear)) {
            this.clear();
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}