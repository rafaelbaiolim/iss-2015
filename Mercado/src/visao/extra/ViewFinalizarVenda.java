package visao.extra;

import controller.visao.extra.ControllerViewFinalizarVenda;
import funct.FunctDate;
import funct.FunctFrame;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.relacionais.saida.ItemVenda;
import modelo.relacionais.saida.Venda;
import visao.InterfaceView;
import visao.ViewModal;
import visao.operacoes.ViewOperacaoEfetuarVenda;

/**
 * <p>Classe de Visao <b>ViewFinalizarVenda.</b></p>
 * <p>Subclasse da classe abstrata ViewModal.</p>
 * <p>Classe responsavel por definir a Interface para Finalizar uma Venda.</p>
 * @author  Hadyne
 * @version 1.0
 * @since   20/01/2016
 * @see     visao.ViewModal
 */
public final class ViewFinalizarVenda extends ViewModal implements InterfaceView {
    private JTextField jTextCliente;
    private JComboBox  jComboBoxFormaPagamento;
    private JTextField jTextFieldValorTotal;
    private JTextField jTextFieldValorDesconto;
    private JTextField jTextFieldValorPago;
    private JTextField jTextFieldValorTroco;
    private JCheckBox  jCheckBoxEncomenda;
    private JTextField jTextFieldDataEncomenda;
    private final Venda           venda;
    private final List<ItemVenda> itensVenda;
    private final ViewOperacaoEfetuarVenda viewParent;
    

    public ViewFinalizarVenda(ViewModal oView, Venda oVenda, List<ItemVenda> oItensVenda) {
        super(oView);
        this.controller = new ControllerViewFinalizarVenda(this);
        this.viewParent = (ViewOperacaoEfetuarVenda) oView;
        this.venda      = oVenda;
        this.itensVenda = oItensVenda;
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Finalizar Venda");
        this.setSize(370, 530);
        this.setLocation(400, 100);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }

    @Override
    public void addHeader() {
        this.addLinhas(1);
        this.add(new JLabel(new FunctFrame().createImage("extra/finalizar_venda.jpg")));
        this.addLinhas(1);
    }

    @Override
    public void addComponents() {
        this.jTextCliente            = this.createTextField(20);
        this.jTextCliente.setEditable(false);
        this.jTextCliente.setText(this.venda.getCliente().toString());
        this.add(new JLabel("Cliente: "));
        this.add(this.jTextCliente);
        
        this.addLinhas(1);
        
        String[] sFormasPagamento    = {"Selecione", "DINHEIRO", "CHEQUE", "CREDITO", "DEBITO"};
        this.jComboBoxFormaPagamento = new JComboBox(sFormasPagamento);
        this.jComboBoxFormaPagamento.addKeyListener(this.controller);
        this.add(new JLabel("Forma: "));
        this.add(this.jComboBoxFormaPagamento);
        
        this.addLinhas(1);
        
        this.jTextFieldValorTotal = this.createTextField(5);
        this.jTextFieldValorTotal.setText(Float.toString(this.venda.getValorTotal()));
        this.jTextFieldValorTotal.setEditable(false);
        this.add(new JLabel("      Valor Total: "));
        this.add(this.jTextFieldValorTotal);
        
        this.addLinhas(1);
        
        this.jTextFieldValorPago     = this.createTextField(5);
        this.jTextFieldValorPago.setText(Float.toString(this.venda.getValorTotal()));
        this.add(new JLabel("       Valor Pago: "));
        this.add(this.jTextFieldValorPago);
        
        this.addLinhas(1);
        
        this.jTextFieldValorDesconto = this.createTextField(5);
        this.jTextFieldValorDesconto.setText("0.00");
        this.add(new JLabel("Valor Desconto: "));
        this.add(this.jTextFieldValorDesconto);
        
        this.addLinhas(1);
        
        this.jTextFieldValorTroco    = this.createTextField(5);
        this.jTextFieldValorTroco.setEditable(false);
        this.jTextFieldValorTroco.setText("0.00");
        this.add(new JLabel("       Valor Troco: "));
        this.add(this.jTextFieldValorTroco);
        
        this.addLinhas(1);
        
        this.jCheckBoxEncomenda      = new JCheckBox("");
        this.jCheckBoxEncomenda.setSelected(false);
        this.jTextFieldDataEncomenda = this.createTextField(6);
        this.jTextFieldDataEncomenda.setText(new FunctDate().getFormattedDate(new Date()));
        this.add(this.jCheckBoxEncomenda);
        
        this.add(new JLabel("Encomenda? "));
        this.add(this.jCheckBoxEncomenda);
        this.add(this.jTextFieldDataEncomenda);
        
        this.addLinhas(1);
    }

    @Override
    public void addButtons() {
        this.jButtonAction1 = this.createButton("Finalizar", "add.jpg");
        this.jButtonAction2 = this.createButton(" Cancelar", "exit.jpg");
        
        this.add(this.jButtonAction1);
        this.add(this.jButtonAction2);
    }

    public JComboBox getComboBoxFormaPagamento() {
        return this.jComboBoxFormaPagamento;
    }

    public JTextField getTextFieldValorTotal() {
        return this.jTextFieldValorTotal;
    }

    public JTextField getTextFieldValorDesconto() {
        return this.jTextFieldValorDesconto;
    }

    public JTextField getTextFieldValorPago() {
        return this.jTextFieldValorPago;
    }

    public JTextField getTextFieldValorTroco() {
        return this.jTextFieldValorTroco;
    }

    public JCheckBox getCheckBoxEncomenda() {
        return this.jCheckBoxEncomenda;
    }

    public JTextField getTextFieldDataEncomenda() {
        return this.jTextFieldDataEncomenda;
    }

    public Venda getVenda() {
        return this.venda;
    }

    public List<ItemVenda> getItensVenda() {
        return this.itensVenda;
    }

    public JButton getButtonFinalizar() {
        return this.jButtonAction1;
    }
    
    public JButton getButtonCancelar() {
        return this.jButtonAction2;
    }

    public ViewOperacaoEfetuarVenda getViewParent() {
        return this.viewParent;
    }
}