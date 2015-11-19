/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 18/08/2015                                                         *
 * Classe: visao.operacoes.FrameOperacoesRealizarNotificacoes                 *
 * Coment: Classe responsavel por representar o Frame de Realizar Notificacoes*
 *         aos Clientes no Sistema.                                           *
 *         Subclasse da Classe Abstrata FrameOperacoes.                       *
 * ========================================================================== */

package visao.operacoes;

import controllers.ControllerCliente;
import controllers.ControllerMensagem;
import visao.pesquisa.FramePesquisarCliente;
import modelo.cadastrais.Cliente;
import modelo.internos.Usuario;
import visao.Frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import visao.mensagens.FrameMensagem;

public class FrameOperacoesRealizarNotificacoes extends FrameOperacoes {
    private JLabel        oLabelHeader;
    
    private JTextField    oTextFieldTotalClientes;
    
    private JTextArea     oTextAreaMensagem;
    
    private JButton       oButtonFinalizar;
    private JButton       oButtonCancelar;
    
    private Usuario       usuario;
    private List<Cliente> clientes;

    public FrameOperacoesRealizarNotificacoes(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario  = oUsuario;
        this.clientes = ControllerCliente.getClientesByNome("");
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Realizar Notificacoes");
        this.setLocation(350, 80);
        this.setSize(500, 550);
        this.addComponents();
    }
    
    private void addComponents() {
        
        this.addLine(1);
        
        this.oLabelHeader      = new JLabel("REALIZAR NOTIFICACOES");
        this.oLabelHeader.setFont(new Font("Tahoma", 1, 25));
        this.add(this.oLabelHeader);
        
        this.addLine(1);
        
        this.addTable();
        String[] sDados = {"Documento", "Nome", "Email"};
        this.addColumns(sDados);
        this.oScrollPane.setPreferredSize(new Dimension(350, 150));
        
        this.addButtons();
        this.oButtonEdit.setVisible(false);
        
        this.addLine(1);
        
        this.oTextFieldTotalClientes  = new JTextField(10);
        this.oTextFieldTotalClientes.setEditable(false);
        this.add(new JLabel("Total Clientes: "));
        this.add(this.oTextFieldTotalClientes);
        
        this.addLine(1);
        
        this.oTextAreaMensagem        = new JTextArea(5, 26);
        this.oTextAreaMensagem.setBorder(new LineBorder(Color.GRAY));
        this.add(new JLabel("Mensagem: "));
        this.add(this.oTextAreaMensagem);
        
        this.addLine(1);
        
        this.oButtonFinalizar     = this.createButton(" Enviar ", "yes.jpg");
        this.oButtonCancelar      = this.createButton("Cancelar", "no.jpg");
        this.add(this.oButtonFinalizar);
        this.add(this.oButtonCancelar);
        
        this.atualizarDados();
    }

    private void atualizarDados() {
        this.clearTable();
        String[][] sClientes = new String[this.clientes.size()][3];
        for (int i = 0; i < this.clientes.size(); ++i) {                
            sClientes[i][0] = this.clientes.get(i).getDocumento();
            sClientes[i][1] = this.clientes.get(i).getNome();
            sClientes[i][2] = this.clientes.get(i).getEmail();
        }
        this.addRows(sClientes);
        this.oTextFieldTotalClientes.setText(Integer.toString(this.clientes.size()));
    }
    
    public void addCliente(Cliente oCliente) {
        boolean bAdd = false;
        if (this.clientes.isEmpty() == false) {
            for (Cliente oCurrentCliente : this.clientes) {
                if (oCurrentCliente.equals(oCliente)) {
                    bAdd = true;
                }
            }
        }
        
        if (bAdd == false) {
            this.clientes.add(oCliente);
        }
        this.atualizarDados();
    }
    
    private void clear() {
        this.clientes = ControllerCliente.getClientesByNome("");
        this.oTextAreaMensagem.setText("");
        this.atualizarDados();
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonAdd)) {
            new FramePesquisarCliente(this).setVisible(true);
        }else if (oEvento.getSource().equals(this.oButtonRemove)) {
            if ((this.oTable.getSelectedRow() > -1) 
                    && (this.oTable.getSelectedRows().length == 1)) {
                this.clientes.remove(this.oTable.getSelectedRow());
                this.atualizarDados();
            }
        }else if (oEvento.getSource().equals(this.oButtonFinalizar)) {
            String sMensagem = this.oTextAreaMensagem.getText().trim();
            if ((sMensagem.equals("") == false) && (this.clientes.isEmpty() == false)) {
                ControllerMensagem.enviarMensagem(sMensagem, this.clientes, this.usuario);
                new FrameMensagem(this, "Mensagem Enviada com Sucesso!").setVisible(true);
                this.dispose();
            }
        }else if (oEvento.getSource().equals(this.oButtonCancelar)) {
            this.dispose();
        }
    }
}