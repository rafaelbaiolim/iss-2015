/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 18/08/2015                                                         *
 * Classe: visao.operacoes.FrameOperacoesFinalizarVenda                       *
 * Coment: Classe responsavel por representar o Frame de Finalizar Venda no   *
 *         Sistema.                                                           *
 *         Subclasse da Classe Abstrata FrameModal.                           *
 * ========================================================================== */

package visao.operacoes;

import controllers.ControllerVenda;
import modelo.internos.Usuario;
import modelo.relacionais.ItemVenda;
import modelo.relacionais.Venda;
import visao.FrameModal;
import funcoes.FunctDate;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import visao.mensagens.FrameMensagem;

public class FrameOperacoesFinalizarVenda extends FrameModal {
    private JLabel            oLabelHeader;
    private JTextField        oTextFieldTotalItens;
    private JTextField        oTextFieldValorTotal;
    private JComboBox         oComboBoxTipo;
    private JTextField        oTextFieldValorPago;
    private JCheckBox         oCheckBoxEncomenda;
    private JTextField        oTextFieldDataEntrega;
    private JButton           oButtonFinalizar;
    private JButton           oButtonCancelar;
    private FrameOperacoesEfetuarVenda oFrameParent;
    private Venda             venda;
    private List<ItemVenda>   itensVenda;
    private Usuario           usuario;

    public FrameOperacoesFinalizarVenda(FrameModal oFrameParent, Venda oVenda, List<ItemVenda> oItensVenda, Usuario oUsuario) {
        super(oFrameParent, "");
        this.oFrameParent = (FrameOperacoesEfetuarVenda) oFrameParent;
        this.venda        = oVenda;
        this.itensVenda   = oItensVenda;
        this.usuario      = oUsuario;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Finalizar Venda");
        this.setLocation(400, 180);
        this.setSize(300, 400);
        this.addComponents();
    }
    
    private void addComponents() {
        
        this.addLine(1);
        
        this.oLabelHeader      = new JLabel("FINALIZAR VENDA");
        this.oLabelHeader.setFont(new Font("Tahoma", 1, 25));
        this.add(this.oLabelHeader);
        
        this.addLine(1);
        
        this.oTextFieldTotalItens = new JTextField(12);
        this.oTextFieldTotalItens.setEditable(false);
        this.oTextFieldTotalItens.setText(Float.toString(this.venda.getNumeroItens()));
        this.add(new JLabel("Total Itens: "));
        this.add(this.oTextFieldTotalItens);
        
        this.addLine(1);
        
        this.oTextFieldValorTotal = new JTextField(12);
        this.oTextFieldValorTotal.setEditable(false);
        this.oTextFieldValorTotal.setText(Float.toString(this.venda.getValorTotal()));
        this.add(new JLabel("Valor Total: "));
        this.add(this.oTextFieldValorTotal);
        
        this.addLine(1);
        
        String[] sTipos           = {"DINHEIRO", "CREDITO", "DEBITO"};
        this.oComboBoxTipo        = new JComboBox(sTipos);
        this.add(new JLabel("Tipo de Pagamento: "));
        this.add(this.oComboBoxTipo);

        this.addLine(1);
        
        this.oCheckBoxEncomenda   = new JCheckBox();
        this.add(new JLabel("Encomenda: "));
        this.add(this.oCheckBoxEncomenda);
        
        this.oTextFieldDataEntrega = new JTextField(7);
        this.oTextFieldDataEntrega.setText(FunctDate.getFormattedDate(new Date()));
        this.add(new JLabel("Data Entrega: "));
        this.add(this.oTextFieldDataEntrega);
        
        this.addLine(1);
        
        this.oTextFieldValorPago     = new JTextField(12);
        this.oTextFieldValorPago.setText("0.00");
        this.oTextFieldValorPago.requestFocus();
        this.add(new JLabel("Valor Pago: "));
        this.add(this.oTextFieldValorPago);
        
        this.addLine(1);
        
        this.oButtonFinalizar     = this.createButton("Cadastrar", "yes.jpg");
        this.oButtonCancelar      = this.createButton("Cancelar ", "no.jpg");
        
        this.add(this.oButtonFinalizar);
        this.add(this.oButtonCancelar);
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonFinalizar)) {
            float  fValorPago     = Float.parseFloat(this.oTextFieldValorPago.getText().trim());
            String sTipoPagamento = this.oComboBoxTipo.getSelectedItem().toString();
            if (fValorPago >= this.venda.getValorTotal()) {
                this.venda.setFormaPagamento(sTipoPagamento);
                this.venda.setValorPago(fValorPago);
                this.venda.setValorTroco(fValorPago - this.venda.getValorTotal());
                this.venda.setEncomenda(this.oCheckBoxEncomenda.isSelected());
                this.venda.setDataEntrega(FunctDate.createDate(this.oTextFieldDataEntrega.getText().trim()));
                
                ControllerVenda.adicionar(this.venda, this.usuario);
                ControllerVenda.adicionarItens(this.itensVenda);
                
                new FrameMensagem(this, "Venda Realizada com Sucesso!").setVisible(true);
                this.dispose();
                this.oFrameParent.dispose();
            }
        }else if (oEvento.getSource().equals(this.oButtonCancelar)) {
            this.dispose();
        }
    }
}