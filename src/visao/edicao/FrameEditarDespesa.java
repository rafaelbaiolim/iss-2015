/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 07/08/2015                                                         *
 * Classe: visao.edicao.FrameEditarDespesa                                    *
 * Coment: Classe responsavel por representar o Frame de Edicao de Despesas.  *
 *         Subclasse da Classe Abstrata FrameEditar.                          *
 * ========================================================================== */

package visao.edicao;

import controllers.ControllerDespesa;
import modelo.gerenciais.Despesa;
import modelo.internos.Usuario;
import visao.FrameModal;
import visao.consultas.FrameConsultaDespesa;
import funcoes.FunctDate;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class FrameEditarDespesa extends FrameEditar {
    private JTextField oTextFieldDescricao;
    private JTextField oTextFieldValor;
    private JTextField oTextFieldDataPagamento;
    private JTextArea  oTextAreaObservacao;
    private FrameConsultaDespesa oFrameConsultaDespesa;
    private Despesa              despesa;
    private Usuario              usuario;
    

    public FrameEditarDespesa(FrameModal oFrame, Despesa oDespesa, Usuario oUsuario) {
        super(oFrame, "");
        this.oFrameConsultaDespesa = (FrameConsultaDespesa) oFrame;
        this.despesa               = oDespesa;
        this.usuario               = oUsuario;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Editar Despesa");
        this.setLocation(390, 130);
        this.setSize(400, 475);
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        this.addHeader("editar_despesa.jpg");
        this.addLine(1);
        this.addBody();
        this.addLine(1);
        this.addButtons();
    }
    
    private void addBody() {
        this.oTextFieldDescricao     = new JTextField(26);
        this.oTextFieldDescricao.setText(this.despesa.getDescricao());
        this.add(new JLabel("Descrição*: "));
        this.add(this.oTextFieldDescricao);
        
        this.addLine(1);
        
        this.oTextFieldValor         = new JTextField(8);
        this.oTextFieldValor.setText(Float.toString(this.despesa.getValor()));
        this.add(new JLabel("            Valor*: "));
        this.add(this.oTextFieldValor);
        
        this.add(new JLabel("   "));
        
        this.oTextFieldDataPagamento = new JTextField(6);
        this.oTextFieldDataPagamento.setText(FunctDate.getFormattedDate(this.despesa.getDataPagamento()));
        this.add(new JLabel("Data Pagamento: "));
        this.add(this.oTextFieldDataPagamento);
        
        this.addLine(1);
        
        this.oTextAreaObservacao     = new JTextArea(5, 26);
        this.oTextAreaObservacao.setBorder(new LineBorder(Color.GRAY));
        this.oTextAreaObservacao.setText(this.despesa.getObservacao());
        this.add(new JLabel("Observação: "));
        this.add(this.oTextAreaObservacao);
        
        this.addLine(1);
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSave)) {
            String sDescricao     = this.oTextFieldDescricao.getText().toUpperCase().trim();
            float  fValor         = Float.parseFloat(this.oTextFieldValor.getText().trim());
            Date   dDataPagamento = FunctDate.createDate(this.oTextFieldDataPagamento.getText().trim());
            String sObservacao    = this.oTextAreaObservacao.getText().toUpperCase().trim();
            ControllerDespesa.gravar(this.despesa, sDescricao, fValor, dDataPagamento, sObservacao, this.usuario);
            this.oFrameConsultaDespesa.clear();
            this.dispose();
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}