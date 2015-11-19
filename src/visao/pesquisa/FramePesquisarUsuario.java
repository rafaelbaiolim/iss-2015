/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 07/08/2015                                                         *
 * Classe: visao.pesquisa.FramePesquisarUsuario                               *
 * Coment: Classe responsavel por representar o Frame de Pesquisa de Usuarios.*
 *         Subclasse da Classe Abstrata FramePesquisar.                       *
 * ========================================================================== */

package visao.pesquisa;

import controllers.ControllerUsuario;
import modelo.internos.Usuario;
import visao.FrameModal;
import visao.operacoes.FrameOperacoesGerenciarUsuario;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JLabel;

public class FramePesquisarUsuario extends FramePesquisar {
    private FrameOperacoesGerenciarUsuario oFrameParent;
    private List<Usuario>         oListaUsuarios;

    public FramePesquisarUsuario(FrameModal oFrame) {
        super(oFrame);
        this.oFrameParent   = (FrameOperacoesGerenciarUsuario) oFrame;
        this.oListaUsuarios = ControllerUsuario.getUsuariosByLogin("");
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Pesquisar Usuario: ");
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        
        this.add(new JLabel("Usuario: "));
        this.addSearchField();
        
        this.addLine(1);
        
        this.addTable();
        String[] sColunas = {"Login", "Funcionario"};
        this.addColumns(sColunas);
        this.atualizarDados();
        
        this.addLine(1);
        
        this.addButtons();
    }
    
    private void atualizarDados() {
        String[][] sDadosUsuario = new String[this.oListaUsuarios.size()][2];
        for (int i = 0; i < this.oListaUsuarios.size(); ++i) {
            sDadosUsuario[i][0] = this.oListaUsuarios.get(i).getLogin();
            sDadosUsuario[i][1] = this.oListaUsuarios.get(i).getFuncionario().getNome();
        }
        this.addRows(sDadosUsuario);
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonUpdate)) {
            this.oListaUsuarios = ControllerUsuario.getUsuariosByLogin(this.oTextFieldSearch.getText().toUpperCase());
            this.atualizarDados();
        }else if (oEvento.getSource().equals(this.oButtonOk)) {
            if ((this.oTable.getSelectedRow() > -1)
                   && (this.oListaUsuarios.size() - 1 >= this.oTable.getSelectedRow())) {
                
                Usuario oUsuario = this.oListaUsuarios.get(this.oTable.getSelectedRow());
                this.oFrameParent.setFuncionario(oUsuario);
                this.dispose();
            }
        }else if (oEvento.getSource().equals(this.oButtonCancel)) {
            this.dispose();
        }
    }
}