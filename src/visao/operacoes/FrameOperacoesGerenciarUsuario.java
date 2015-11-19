/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 18/08/2015                                                         *
 * Classe: visao.operacoes.FrameOperacoesGerenciarUsuario                     *
 * Coment: Classe responsavel por representar o Frame de Gerenciar Usuarios   *
 *         no Sistema.                                                        *
 *         Subclasse da Classe Abstrata FrameOperacoes.                       *
 * ========================================================================== */

package visao.operacoes;

import controllers.ControllerAcesso;
import modelo.internos.Acesso;
import modelo.internos.Usuario;
import visao.Frame;
import visao.pesquisa.FramePesquisarUsuario;
import funcoes.FunctDate;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameOperacoesGerenciarUsuario extends FrameOperacoes {
    private JLabel       oLabelHeader;
    
    private JTextField   oTextFieldFuncionario;
    
    private JTextField   oTextFieldUsuario;
    private JButton      oButtonSearch;
    
    private JButton      oButtonFinalizar;
    private JButton      oButtonCancelar;
    
    private Usuario      funcionario;
    private Usuario      usuario;
    private List<Acesso> acessos;

    public FrameOperacoesGerenciarUsuario(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario = oUsuario;
        this.acessos = new ArrayList<>();
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Gerenciar Usuario");
        this.setLocation(300, 140);
        this.setSize(500, 455);
        this.addComponents();
    }
    
    private void addComponents() {
        
        this.addLine(1);
        
        this.oLabelHeader      = new JLabel("GERENCIAR USUARIO");
        this.oLabelHeader.setFont(new Font("Tahoma", 1, 25));
        this.add(this.oLabelHeader);
        
        this.addLine(1);
        
        this.oTextFieldFuncionario = new JTextField(30);
        this.oTextFieldFuncionario.setEditable(false);
        this.oTextFieldFuncionario.setText(this.usuario.getFuncionario().toString());
        this.add(new JLabel("Funcionario: "));
        this.add(this.oTextFieldFuncionario);
        
        this.addLine(1);
        
        this.oTextFieldUsuario     = new JTextField(25);
        this.oButtonSearch         = this.createButton("", "search.jpg");
        this.oTextFieldUsuario.setEditable(false);
        this.add(new JLabel("Usuario: "));
        this.add(this.oTextFieldUsuario);
        this.add(this.oButtonSearch);
        
        this.addLine(1);
        
        this.addTable();
        String[] sDados = {"Data", "Hora", "Operacao"};
        this.addColumns(sDados);
        this.oScrollPane.setPreferredSize(new Dimension(350, 150));
        
        this.addLine(1);
        
        this.oButtonFinalizar = this.createButton("   Ok   ", "yes.jpg");
        this.oButtonCancelar  = this.createButton("Cancelar", "no.jpg");
        this.add(this.oButtonFinalizar);
        this.add(this.oButtonCancelar);
    }
    
    public void setFuncionario(Usuario oUsuario) {
        this.funcionario = oUsuario;
        this.acessos     = ControllerAcesso.getAcessos(this.funcionario);
        this.atualizarDados();
    }
    
    private void atualizarDados() {
        this.clearTable();
        String[][] sOperacoes = new String[this.acessos.size()][3];
        for (int i = 0; i < this.acessos.size(); ++i) {                
            sOperacoes[i][0] = FunctDate.getFormattedDate(this.acessos.get(i).getDia());
            sOperacoes[i][1] = this.acessos.get(i).getHora().toString();
            sOperacoes[i][2] = acessos.get(i).getOperacao().getDescricao();
        }
        this.oTextFieldUsuario.setText(this.usuario.getLogin());
        this.addRows(sOperacoes);
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSearch)) {
            new FramePesquisarUsuario(this).setVisible(true);
        }else if (oEvento.getSource().equals(this.oButtonFinalizar)) {
            this.dispose();
        }else if (oEvento.getSource().equals(this.oButtonCancelar)) {
            this.dispose();
        }
    }
}