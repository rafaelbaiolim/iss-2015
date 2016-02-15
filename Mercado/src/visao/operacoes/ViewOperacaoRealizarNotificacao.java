package visao.operacoes;

import controller.visao.operacoes.ControllerViewOperacaoRealizarNotificacao;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import modelo.cadastrais.Cliente;
import modelo.dao.cadastrais.DaoCliente;
import modelo.estruturais.Usuario;
import visao.View;
import visao.estruturais.ViewMenu;

/**
 * Classe responsavel por definir a Interface para Realizar Notificacoes aos Clientes do Sistema.
 * @author  Leandro
 * @version 1.0
 * @since   14/01/2016
 */
public final class ViewOperacaoRealizarNotificacao extends ViewOperacao {
    private JButton    jButtonAddClientes;
    private JButton    jButtonAddCliente;
    private JButton    jButtonRemoveCliente;
    private JButton    jButtonRemoveClientes;
    private JTextField jTextFieldTotalClientes;
    private JTextArea  jTextAreaMensagem;
    private final DaoCliente daoCliente;
    private List<Cliente>    clientes;
    private final ViewMenu   viewMenu;

    public ViewOperacaoRealizarNotificacao(View oViewParent) {
        super(oViewParent);
        this.viewMenu   = (ViewMenu) oViewParent;
        this.controller = new ControllerViewOperacaoRealizarNotificacao(this);
        this.daoCliente = new DaoCliente();
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Realizar Notificacoes");
        this.setLocation(320, 80);
        this.setSize(500, 590);
        this.addHeader();
        this.addComponents();
        this.addButtons();
        this.clear();
    }
    
    @Override
    public void addHeader() {
        super.addHeader("realizar_notificacao.jpg");
    }

    @Override
    public void addComponents() {
        
        this.addTable();
        String[] sDados = {"Id", "Documento", "Nome"};
        this.setColumns(sDados);
        this.jScrollPane.setPreferredSize(new Dimension(350, 150));
        
        int[]    iColumns = {75, 175, 175};
        this.setColumnSize(iColumns);
        
        this.jButtonAddClientes    = this.createButton("", "add_clientes.jpg");
        this.add(this.jButtonAddClientes);
        this.jButtonAddCliente     = this.createButton("Adicionar", "add.jpg");
        this.add(this.jButtonAddCliente);
        this.jButtonRemoveCliente  = this.createButton(" Remover ", "exit.jpg");
        this.add(this.jButtonRemoveCliente);
        this.jButtonRemoveClientes = this.createButton("", "remove_clientes.jpg");
        this.add(this.jButtonRemoveClientes);
        
        this.addLinhas(1);
        
        this.jTextFieldTotalClientes  = new JTextField(10);
        this.jTextFieldTotalClientes.setEditable(false);
        this.add(new JLabel("Total Clientes: "));
        this.add(this.jTextFieldTotalClientes);
        
        this.addLinhas(1);
        
        this.jTextAreaMensagem        = new JTextArea(5, 26);
        this.jTextAreaMensagem.setBorder(new LineBorder(Color.GRAY));
        this.add(new JLabel("Mensagem: "));
        this.add(this.jTextAreaMensagem);
        
        this.addLinhas(1);
    }
    
    @Override
    public void addButtons() {
        this.jButtonAction1 = this.createButton("Notificar", "email.jpg");
        this.jButtonAction2 = this.createButton(" Cancelar", "back.jpg");
        this.jButtonAction3 = this.createButton(""         , "help.jpg");
        
        this.add(this.jButtonAction1);
        this.add(this.jButtonAction2);
        this.add(this.jButtonAction3);
    }

    @Override
    public void clear() {
        this.addClientes();
        this.jTextAreaMensagem.setText("");
    }

    /**
     * Metodo responsavel por adicionar todos os Clientes a Tabela.
     */
    public void addClientes() {
        this.clientes = this.daoCliente.list();
        this.addRows(this.daoCliente.getClientes(this.clientes));
        this.jTextFieldTotalClientes.setText(Integer.toString(this.clientes.size()));
    }
    
    /**
     * Metodo responsavel por adicionar um Cliente a Tabela.
     * @param oCliente Cliente.
     */
    public void addCliente(Cliente oCliente) {
        if (this.clientes.contains(oCliente) == false) {
            this.clientes.add(oCliente);
        }
        this.addRows(this.daoCliente.getClientes(this.clientes));
        this.jTextFieldTotalClientes.setText(Integer.toString(this.clientes.size()));
    }
    
    /**
     * Metodo responsavel por remover um Cliente da Tabela.
     * @param iIndex Indice da Tabela.
     */
    public void removeCliente(int iIndex) {
        this.clientes.remove(iIndex);
        this.addRows(this.daoCliente.getClientes(this.clientes));
        this.jTextFieldTotalClientes.setText(Integer.toString(this.clientes.size()));
    }
    
    /**
     * Metodo responsavel por remover todos os Clientes da Tabela.
     */
    public void removeClientes() {
        this.clientes = new ArrayList<>();
        this.addRows(this.daoCliente.getClientes(this.clientes));
        this.jTextFieldTotalClientes.setText(Integer.toString(this.clientes.size()));
    }
    
    public void setMessage(String sMessage) {
        this.jTextAreaMensagem.setText(sMessage);
    }

    public void setClientes(List<Cliente> oClientes) {
        this.clientes = oClientes;
    }
    
    public List<Cliente> getClientes() {
        return this.clientes;
    }
    
    public JButton getButtonAddClientes() {
        return this.jButtonAddClientes;
    }

    public JButton getButtonAddCliente() {
        return this.jButtonAddCliente;
    }

    public JButton getButtonRemoveCliente() {
        return this.jButtonRemoveCliente;
    }

    public JButton getButtonRemoveClientes() {
        return this.jButtonRemoveClientes;
    }

    public JTextArea getTextAreaMensagem() {
        return this.jTextAreaMensagem;
    }

    public JButton getButtonNotificar() {
        return this.jButtonAction1;
    }

    public JButton getButtonCancelar() {
        return this.jButtonAction2;
    }
    
    public JButton getButtonAjuda() {
        return this.jButtonAction3;
    }
    
    public Usuario getUsuario() {
        return this.viewMenu.getUsuario();
    }
}