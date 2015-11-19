/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 05/08/2015                                                         *
 * Classe: visao.pesquisa.FramePesquisarCliente                               *
 * Coment: Classe responsavel por representar o Frame de Pesquisa de Clientes.*
 *         Subclasse da Classe Abstrata FramePesquisar.                       *
 * ========================================================================== */

package visao.pesquisa;

import controllers.ControllerCliente;
import modelo.cadastrais.Cliente;
import visao.FrameModal;
import visao.operacoes.FrameOperacoesEfetuarVenda;
import visao.operacoes.FrameOperacoesRealizarNotificacoes;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JLabel;

public class FramePesquisarCliente extends FramePesquisar {
    private FrameModal    oFrameParent;
    private List<Cliente> oListClientes;
    
    public FramePesquisarCliente(FrameModal oFrame) {
        super(oFrame);
        this.oFrameParent  = oFrame;
        this.oListClientes = ControllerCliente.getClientesByNome("");
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Pesquisar Cliente");
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        
        this.add(new JLabel("Nome: "));
        this.addSearchField();
        
        this.addLine(1);
        
        this.addTable();
        String[] sColunas = {"Documento", "Nome"};
        this.addColumns(sColunas);
        this.atualizarDados();
        
        this.addLine(1);
        
        this.addButtons();
    }
    
    private void atualizarDados() {
        String[][] sDadosCliente = new String[this.oListClientes.size()][2];
        for (int i = 0; i < this.oListClientes.size(); ++i) {
            sDadosCliente[i][0] = this.oListClientes.get(i).getDocumento();
            sDadosCliente[i][1] = this.oListClientes.get(i).getNome();
        }
        this.addRows(sDadosCliente);
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonUpdate)) {
            this.oListClientes = ControllerCliente.getClientesByNome(this.oTextFieldSearch.getText().toUpperCase());
            this.atualizarDados();
        }else if (oEvento.getSource().equals(this.oButtonOk)) {
            if ((this.oTable.getSelectedRow() > -1)
                   && (this.oListClientes.size() - 1 >= this.oTable.getSelectedRow())) {
                Cliente oCliente = this.oListClientes.get(this.oTable.getSelectedRow());
                
                if (this.oFrameParent instanceof FrameOperacoesEfetuarVenda) {
                    ((FrameOperacoesEfetuarVenda) this.oFrameParent).addCliente(oCliente);
                }else if (this.oFrameParent instanceof FrameOperacoesRealizarNotificacoes) {
                    ((FrameOperacoesRealizarNotificacoes) this.oFrameParent).addCliente(oCliente);
                }
                this.dispose();
            }
        }else if (oEvento.getSource().equals(this.oButtonCancel)) {
            this.dispose();
        }
    }
}