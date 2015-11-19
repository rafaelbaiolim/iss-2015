/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 06/08/2015                                                         *
 * Classe: visao.pesquisa.FramePesquisarPedido                                *
 * Coment: Classe responsavel por representar o Frame de Pesquisa de Pedidos. *
 *         Subclasse da Classe Abstrata FramePesquisar.                       *
 * ========================================================================== */

package visao.pesquisa;

import controllers.ControllerPedido;
import modelo.relacionais.Pedido;
import visao.FrameModal;
import visao.operacoes.FrameOperacoesRegistrarEntrada;
import funcoes.FunctDate;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JLabel;

public class FramePesquisarPedido extends FramePesquisar {
    private FrameOperacoesRegistrarEntrada oFrameParent;
    private List<Pedido>          oListPedidos;
    
    public FramePesquisarPedido(FrameModal oFrame) {
        super(oFrame);
        this.oFrameParent = (FrameOperacoesRegistrarEntrada) oFrame;
        this.oListPedidos = ControllerPedido.getPedidos();
        
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Pesquisar Pedido");
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        
        this.add(new JLabel("Pedido: "));
        this.addSearchField();
        
        this.addLine(1);
        
        this.addTable();
        String[] sColunas = {"Data", "Hora", "Fornecedor", "Funcionario"};
        this.addColumns(sColunas);
        this.atualizarDados();
        
        this.addLine(1);
        
        this.addButtons();
    }
    
    private void atualizarDados() {
        String[][] sDadosPedidos = new String[this.oListPedidos.size()][4];
        for (int i = 0; i < this.oListPedidos.size(); ++i) {
            sDadosPedidos[i][0] = FunctDate.getFormattedDate(this.oListPedidos.get(i).getDataCadastro());
            sDadosPedidos[i][1] = this.oListPedidos.get(i).getHoraCadastro().toString();
            sDadosPedidos[i][2] = this.oListPedidos.get(i).getFornecedor().toString();
            sDadosPedidos[i][3] = this.oListPedidos.get(i).getFuncionario().toString();
        }
        this.addRows(sDadosPedidos);
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonUpdate)) {
            this.oListPedidos = ControllerPedido.getPedidos(this.oTextFieldSearch.getText());
            this.atualizarDados();
        }else if (oEvento.getSource().equals(this.oButtonOk)) {
            if ((this.oTable.getSelectedRow() > -1)
                   && (this.oListPedidos.size() - 1 >= this.oTable.getSelectedRow())) {
                
                Pedido oPedido = this.oListPedidos.get(this.oTable.getSelectedRow());
                
                oFrameParent.setPedido(oPedido);
                                        
                this.dispose();
            }
        }else if (oEvento.getSource().equals(this.oButtonCancel)) {
            this.dispose();
        }
    }
}