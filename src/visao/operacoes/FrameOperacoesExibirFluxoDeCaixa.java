/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 18/08/2015                                                         *
 * Classe: visao.operacoes.FrameOperacoesExibirFluxoDeCaixa                   *
 * Coment: Classe responsavel por representar o Frame de Fluxo de Caixa no    *
 *         Sistema.                                                           *
 *         Subclasse da Classe Abstrata FrameModal.                           *
 * ========================================================================== */

package visao.operacoes;

import controllers.ControllerDespesa;
import controllers.ControllerPedido;
import controllers.ControllerVenda;
import modelo.internos.Usuario;
import visao.FrameModal;
import visao.estruturais.FrameMenu;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class FrameOperacoesExibirFluxoDeCaixa extends FrameModal {
    private JLabel  oLabelHeader;
    private JLabel  oLabelPedidos;
    private JLabel  oLabelDespesas;
    private JLabel  oLabelVendas;
    private JButton oButtonOk;
    private JButton oButtonBack;
    private final Usuario usuario;
    
    public FrameOperacoesExibirFluxoDeCaixa(FrameMenu oFrameMenu, Usuario oUsuario) {
        super(oFrameMenu);
        this.usuario = oUsuario;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Fluxo de Caixa");
        this.setSize(350, 560);
        this.setLocation(400, 80);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        
        this.oLabelHeader      = new JLabel("FLUXO DE CAIXA");
        this.oLabelHeader.setFont(new Font("Tahoma", 1, 25));
        this.add(this.oLabelHeader);
        
        this.addLine(1);
        
        this.oLabelPedidos     = new JLabel("PEDIDOS");
        this.oLabelPedidos.setFont(new Font("Tahoma", 1, 20));
        this.add(this.oLabelPedidos);
        
        this.addLine(1);
        
        this.add(new JLabel("Quantidade: "  + ControllerPedido.totalPedidos()));
        this.addLine(1);
        this.add(new JLabel("Valor Total: " + ControllerPedido.valorTotalPedidos()));
        
        this.addLine(1);
        
        this.oLabelDespesas     = new JLabel("DESPESAS");
        this.oLabelDespesas.setFont(new Font("Tahoma", 1, 20));
        this.add(this.oLabelDespesas);
        
        this.addLine(1);
        
        this.add(new JLabel("Quantidade: "  + ControllerDespesa.totalDespesas()));
        this.addLine(1);
        this.add(new JLabel("Valor Total: " + ControllerDespesa.valorTotalDespesas()));
        
        this.addLine(1);
        
        this.oLabelVendas     = new JLabel("VENDAS");
        this.oLabelVendas.setFont(new Font("Tahoma", 1, 20));
        this.add(this.oLabelVendas);
        
        this.addLine(1);
        
        this.add(new JLabel("Quantidade: "  + ControllerVenda.totalVendas()));
        this.addLine(1);
        this.add(new JLabel("Valor Total: " + ControllerVenda.valorTotalVendas()));
        
        this.addLine(1);
        
        this.oButtonOk    = this.createButton("  Ok  ", "ok.jpg");
        this.oButtonBack  = this.createButton("Voltar", "back.jpg");
        this.add(this.oButtonOk);
        this.add(new JLabel("   "));
        this.add(this.oButtonBack);
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonOk)) {
            this.dispose();
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}