/* =========================================================================== /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                    *
 * Data..: 06/08/2015                                                           *
 * Classe: visao.pesquisa.FramePesquisarFornecedor                              *
 * Coment: Classe responsavel por representar o Frame de Pesquisa de Fornecedor *
 *         Subclasse da Classe Abstrata FramePesquisar.                         *
 * ============================================================================ */

package visao.pesquisa;

import controllers.ControllerFornecedor;
import modelo.gerenciais.Fornecedor;
import visao.FrameModal;
import visao.operacoes.FrameOperacoesRegistrarPedido;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JLabel;

public class FramePesquisarFornecedor extends FramePesquisar {
    private FrameOperacoesRegistrarPedido oFrameParent;
    private List<Fornecedor>     oListaFornecedores;

    public FramePesquisarFornecedor(FrameModal oFrame) {
        super(oFrame);
        this.oFrameParent       = (FrameOperacoesRegistrarPedido) oFrame;
        this.oListaFornecedores = ControllerFornecedor.getFornecedoresByNome("");
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Pesquisar Fornecedor");
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        
        this.add(new JLabel("Nome: "));
        this.addSearchField();
        
        this.addLine(1);
        
        this.addTable();
        String[] sColunas = {"Nome", "CNPJ"};
        this.addColumns(sColunas);
        this.atualizarDados();
        
        this.addLine(1);
        
        this.addButtons();
    }
    
    private void atualizarDados() {
        String[][] sDadosFornecedor = new String[this.oListaFornecedores.size()][2];
        for (int i = 0; i < this.oListaFornecedores.size(); ++i) {
            sDadosFornecedor[i][0] = this.oListaFornecedores.get(i).getNome();
            sDadosFornecedor[i][1] = this.oListaFornecedores.get(i).getCnpj();
        }
        this.addRows(sDadosFornecedor);
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonUpdate)) {
            this.oListaFornecedores = ControllerFornecedor.getFornecedoresByNome(this.oTextFieldSearch.getText().toUpperCase());
            this.atualizarDados();
        }else if (oEvento.getSource().equals(this.oButtonOk)) {
            if ((this.oTable.getSelectedRow() > -1)
                   && (this.oListaFornecedores.size() - 1 >= this.oTable.getSelectedRow())) {
                Fornecedor oFornecedor = this.oListaFornecedores.get(this.oTable.getSelectedRow());
                this.oFrameParent.setFornecedor(oFornecedor);
                this.dispose();
            }
        }else if (oEvento.getSource().equals(this.oButtonCancel)) {
            this.dispose();
        }
    }
}