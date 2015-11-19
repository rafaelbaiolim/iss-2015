/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 07/08/2015                                                         *
 * Classe: visao.pesquisa.FramePesquisarProduto                               *
 * Coment: Classe responsavel por representar o Frame de Pesquisa de Produtos.*
 *         Subclasse da Classe Abstrata FramePesquisar.                       *
 * ========================================================================== */

package visao.pesquisa;

import controllers.ControllerProduto;
import modelo.cadastrais.Produto;
import visao.FrameModal;
import visao.operacoes.FrameOperacoesAdicionarProduto;
import visao.operacoes.FrameOperacoesGerenciarProduto;
import visao.operacoes.FrameOperacoesInserirProduto;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JLabel;

public class FramePesquisarProduto extends FramePesquisar {
    private FrameModal    oFrameParent;
    private List<Produto> oListProdutos;
    
    public FramePesquisarProduto(FrameModal oFrame) {
        super(oFrame);
        this.oFrameParent  = oFrame;
        this.oListProdutos = ControllerProduto.getProdutosByDescricao("");
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Pesquisar Produto");
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        
        this.add(new JLabel("Descrição: "));
        this.addSearchField();
        
        this.addLine(1);
        
        this.addTable();
        String[] sColunas = {"Descrição", "Marca", "Quantidade", "Preço Unitário"};
        this.addColumns(sColunas);
        this.atualizarDados();
        
        this.addLine(1);
        
        this.addButtons();
    }
    
    private void atualizarDados() {
        String[][] sDadosProduto = new String[this.oListProdutos.size()][4];
        for (int i = 0; i < this.oListProdutos.size(); ++i) {
            sDadosProduto[i][0] = this.oListProdutos.get(i).getDescricao();
            sDadosProduto[i][1] = this.oListProdutos.get(i).getMarca();
            sDadosProduto[i][2] = Integer.toString(this.oListProdutos.get(i).getQuantidade());
            sDadosProduto[i][3] = Float.toString(this.oListProdutos.get(i).getPrecoUnitario());
        }
        this.addRows(sDadosProduto);
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonUpdate)) {
            this.oListProdutos = ControllerProduto.getProdutosByDescricao(this.oTextFieldSearch.getText());
            this.atualizarDados();
        }else if (oEvento.getSource().equals(this.oButtonOk)) {
            if ((this.oTable.getSelectedRow() > -1)
                   && (this.oListProdutos.size() - 1 >= this.oTable.getSelectedRow())) {
                
                Produto oProduto = this.oListProdutos.get(this.oTable.getSelectedRow());
                
                if (this.oFrameParent instanceof FrameOperacoesInserirProduto) {
                    ((FrameOperacoesInserirProduto) oFrameParent).addProduto(oProduto);
                }else if (this.oFrameParent instanceof FrameOperacoesAdicionarProduto) {
                    ((FrameOperacoesAdicionarProduto) oFrameParent).addProduto(oProduto);
                }else if (this.oFrameParent instanceof FrameOperacoesGerenciarProduto) {
                    ((FrameOperacoesGerenciarProduto) oFrameParent).setProduto(oProduto);
                }
                this.dispose();
            }
        }else if (oEvento.getSource().equals(this.oButtonCancel)) {
            this.dispose();
        }
    }
}