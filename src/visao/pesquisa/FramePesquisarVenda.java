/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 07/08/2015                                                         *
 * Classe: visao.pesquisa.FramePesquisarVenda                                 *
 * Coment: Classe responsavel por representar o Frame de Pesquisa de Vendas.  *
 *         Subclasse da Classe Abstrata FramePesquisar.                       *
 * ========================================================================== */

package visao.pesquisa;

import controllers.ControllerVenda;
import modelo.relacionais.Venda;
import visao.FrameModal;
import visao.operacoes.FrameOperacoesEfetuarDevolucao;
import visao.operacoes.FrameOperacoesGerenciarEncomendas;
import funcoes.FunctDate;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JLabel;

public class FramePesquisarVenda extends FramePesquisar {
    private FrameModal  oFrameParent;
    private List<Venda> oListVendas;
    
    public FramePesquisarVenda(FrameModal oFrame) {
        super(oFrame);
        this.oFrameParent = oFrame;
        
        if (this.oFrameParent instanceof FrameOperacoesEfetuarDevolucao) {
            this.oListVendas = ControllerVenda.getVendas("");
        }else {
            this.oListVendas = ControllerVenda.getEncomendas("");
        }

        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Pesquisar Venda");
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        
        this.add(new JLabel("Venda: "));
        this.addSearchField();
        
        this.addLine(1);
        
        this.addTable();
        String[] sColunas = {"Data", "Hora", "Cliente", "Funcionario"};
        this.addColumns(sColunas);
        this.atualizarDados();
        
        this.addLine(1);
        
        this.addButtons();
    }
    
    private void atualizarDados() {
        String[][] sDadosVendas = new String[this.oListVendas.size()][4];
        for (int i = 0; i < this.oListVendas.size(); ++i) {
            sDadosVendas[i][0] = FunctDate.getFormattedDate(this.oListVendas.get(i).getDataCadastro());
            sDadosVendas[i][1] = this.oListVendas.get(i).getHoraCadastro().toString();
            sDadosVendas[i][2] = this.oListVendas.get(i).getCliente().toString();
            sDadosVendas[i][3] = this.oListVendas.get(i).getFuncionario().toString();
        }
        this.addRows(sDadosVendas);
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonUpdate)) {
            
            if (this.oFrameParent instanceof FrameOperacoesEfetuarDevolucao) {
                this.oListVendas = ControllerVenda.getVendas(this.oTextFieldSearch.getText().toUpperCase());
            }else {
                this.oListVendas = ControllerVenda.getEncomendas(this.oTextFieldSearch.getText().toUpperCase());
            }
            
            this.atualizarDados();
        }else if (oEvento.getSource().equals(this.oButtonOk)) {
            if ((this.oTable.getSelectedRow() > -1)
                   && (this.oListVendas.size() - 1 >= this.oTable.getSelectedRow())) {
                
                Venda oVenda = this.oListVendas.get(this.oTable.getSelectedRow());
                
                if (this.oFrameParent instanceof FrameOperacoesEfetuarDevolucao) {
                    ((FrameOperacoesEfetuarDevolucao) this.oFrameParent).setVenda(oVenda);
                }else if (this.oFrameParent instanceof FrameOperacoesGerenciarEncomendas) {
                    ((FrameOperacoesGerenciarEncomendas) this.oFrameParent).setVenda(oVenda);
                }                       
                this.dispose();
            }
        }else if (oEvento.getSource().equals(this.oButtonCancel)) {
            this.dispose();
        }
    }
}