/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 18/08/2015                                                         *
 * Classe: visao.operacoes.FrameOperacoesFinalizarPedido                      *
 * Coment: Classe responsavel por representar o Frame de Finalizar Pedido no  *
 *         Sistema.                                                           *
 *         Subclasse da Classe Abstrata FrameModal.                           *
 * ========================================================================== */

package visao.operacoes;

import controllers.ControllerPedido;
import modelo.internos.Usuario;
import modelo.relacionais.ItemPedido;
import modelo.relacionais.Pedido;
import visao.FrameModal;
import visao.mensagens.FrameMensagem;
import funcoes.FunctDate;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameOperacoesFinalizarPedido extends FrameModal {
    private JLabel           oLabelHeader;
    private JTextField       oTextFieldTotalItens;
    
    private JTextField       oTextFieldValorTotal;
    
    private JTextField       oTextFieldDataPagamento;
    
    private JButton          oButtonFinalizar;
    private JButton          oButtonCancelar;
    
    private FrameOperacoesRegistrarPedido oFrameParent;
    
    private Usuario          usuario;
    private Pedido           pedido;
    private List<ItemPedido> itensPedido;

    public FrameOperacoesFinalizarPedido(FrameModal oFrameParent, Usuario oUsuario, Pedido oPedido, List<ItemPedido> oItensPedido) {
        super(oFrameParent, "");
        this.oFrameParent  = (FrameOperacoesRegistrarPedido) oFrameParent;
        this.usuario       = oUsuario;
        this.pedido        = oPedido;
        this.itensPedido   = oItensPedido;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Finalizar Pedido");
        this.setLocation(390, 180);
        this.setSize(300, 320);
        this.addComponents();
    }
    
    private void addComponents() {
        
        this.addLine(1);
        
        this.oLabelHeader      = new JLabel("FINALIZAR PEDIDO");
        this.oLabelHeader.setFont(new Font("Tahoma", 1, 25));
        this.add(this.oLabelHeader);
        
        this.addLine(1);
        
        this.oTextFieldTotalItens  = new JTextField(12);
        this.oTextFieldTotalItens.setEditable(false);
        this.oTextFieldTotalItens.setText(Integer.toString(this.pedido.getTotalItens()));
        this.add(new JLabel("Total Itens: "));
        this.add(this.oTextFieldTotalItens);
        
        this.addLine(1);
        
        this.oTextFieldValorTotal  = new JTextField(12);
        this.oTextFieldValorTotal.setEditable(false);
        this.oTextFieldValorTotal.setText(Float.toString(this.pedido.getValorTotal()));
        this.add(new JLabel("Valor Total: "));
        this.add(this.oTextFieldValorTotal);
        
        this.addLine(1);
        
        this.oTextFieldDataPagamento  = new JTextField(12);
        this.oTextFieldDataPagamento.setText(FunctDate.getFormattedDate(new Date()));
        this.oTextFieldDataPagamento.requestFocus();
        this.add(new JLabel("Data Pagamento: "));
        this.add(this.oTextFieldDataPagamento);
        
        this.addLine(1);
        
        this.oButtonFinalizar     = this.createButton("Cadastrar", "yes.jpg");
        this.oButtonCancelar      = this.createButton("Cancelar ", "no.jpg");
        
        this.add(this.oButtonFinalizar);
        this.add(this.oButtonCancelar);
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonFinalizar)) {
            float fValorTotal    = Float.parseFloat(this.oTextFieldValorTotal.getText().trim());
            Date  dDataPagamento = FunctDate.createDate(this.oTextFieldDataPagamento.getText().trim());
            
            if (fValorTotal >= this.pedido.getValorTotal()) {
                
                this.pedido.setValorTotal(fValorTotal);
                this.pedido.setDataPagamento(dDataPagamento);
                this.pedido.setFuncionario(this.usuario);
                
                ControllerPedido.adicionar(this.pedido, this.usuario);
                ControllerPedido.adicionarItens(this.itensPedido);
                
                new FrameMensagem(this, "Pedido Cadastrado com Sucesso!").setVisible(true);
                this.dispose();
                this.oFrameParent.dispose();
            }
        }else if (oEvento.getSource().equals(this.oButtonCancelar)) {
            this.dispose();
        }
    }
}