/* ============================================================================ /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                     *
 * Data..: 06/08/2015                                                            *
 * Classe: visao.pesquisa.FramePesquisarFuncionario                              *
 * Coment: Classe responsavel por representar o Frame de Pesquisa de Funcionario *
 *         Subclasse da Classe Abstrata FramePesquisar.                          *
 * ============================================================================= */

package visao.pesquisa;

import controllers.ControllerFuncionario;
import modelo.gerenciais.Funcionario;
import visao.FrameModal;
import visao.cadastros.FrameCadastroUsuario;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JLabel;

public class FramePesquisarFuncionario extends FramePesquisar {
    private FrameCadastroUsuario oFrameParent;
    private List<Funcionario>    oListaFuncionarios;

    public FramePesquisarFuncionario(FrameModal oFrame) {
        super(oFrame);
        this.oFrameParent       = (FrameCadastroUsuario) oFrame;
        this.oListaFuncionarios = ControllerFuncionario.getFuncionariosByNome("");
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Pesquisar Funcionário: ");
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        
        this.add(new JLabel("Nome: "));
        this.addSearchField();
        
        this.addLine(1);
        
        this.addTable();
        String[] sColunas = {"Nome", "CPF"};
        this.addColumns(sColunas);
        this.atualizarDados();
        
        this.addLine(1);
        
        this.addButtons();
    }
    
    private void atualizarDados() {
        String[][] sDadosFuncionario = new String[this.oListaFuncionarios.size()][2];
        for (int i = 0; i < this.oListaFuncionarios.size(); ++i) {
            sDadosFuncionario[i][0] = this.oListaFuncionarios.get(i).getNome();
            sDadosFuncionario[i][1] = this.oListaFuncionarios.get(i).getCpf();
        }
        this.addRows(sDadosFuncionario);
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonUpdate)) {
            this.oListaFuncionarios = ControllerFuncionario.getFuncionariosByNome(this.oTextFieldSearch.getText().toUpperCase());
            this.atualizarDados();
        }else if (oEvento.getSource().equals(this.oButtonOk)) {
            if ((this.oTable.getSelectedRow() > -1)
                   && (this.oListaFuncionarios.size() - 1 >= this.oTable.getSelectedRow())) {
                
                Funcionario oFuncionario = this.oListaFuncionarios.get(this.oTable.getSelectedRow());
                this.oFrameParent.setFuncionario(oFuncionario);
                this.dispose();
            }
        }else if (oEvento.getSource().equals(this.oButtonCancel)) {
            this.dispose();
        }
    }
}