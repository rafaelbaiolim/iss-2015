package visao.operacoes;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.estruturais.Operacao;
import modelo.estruturais.Usuario;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Gerenciamento de Usuarios do Sistema.
 * @author  Rafael
 * @version 1.0
 * @since   28/12/2015
 */
public final class ViewOperacaoGerenciarUsuario extends ViewOperacao {
    private JTextField jTextFieldUsuario;
    private JButton    jButtonSearchUsuario;
    
    private Usuario    usuario;
    
    private List<Operacao> operacaos;
    
    public ViewOperacaoGerenciarUsuario(View oViewParent) {
        super(oViewParent);
        //this.controller = ;
        this.initComponents();
        this.operacaos = new ArrayList<>();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Gerenciar Usuario");
        this.setSize(450, 450);
        this.setLocation(370, 155);
        this.addHeader();
        this.addComponents();
        this.addButtons();
        this.clear();
    }
    
    @Override
    public void addHeader() {
        super.addHeader("gerenciar_usuario.jpg");
    }

    @Override
    public void addComponents() {
        this.jTextFieldUsuario    = this.createTextField(25);
        this.jTextFieldUsuario.setEditable(false);
        this.jButtonSearchUsuario = this.createButton("", "search2.jpg");
        this.add(new JLabel("Usuario: "));
        this.add(this.jTextFieldUsuario);
        this.add(this.jButtonSearchUsuario);
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Data", "Hora", "Operacao"};
        this.setColumns(sColumns);
        this.jScrollPane.setPreferredSize(new Dimension(350, 150));
        
        int[]    iColumns = {20, 10, 40};
        this.setColumnSize(iColumns);
        
        this.addLinhas(1);
    }
    
    @Override
    public void addButtons() {
        this.jButtonAction1 = this.createButton("   Ok   ", "ok.jpg");
        this.jButtonAction2 = this.createButton(" Voltar ", "back.jpg");
        
        this.add(this.jButtonAction1);
        this.add(this.jButtonAction2);
    }

    @Override
    public void clear() {
        this.usuario = null;
        this.operacaos      = new ArrayList<>();
        
        this.jTextFieldUsuario.setText("");
        this.clearTable();
    }

    public JButton getButtonSearchFornecedor() {
        return this.jButtonSearchUsuario;
    }

    public JButton getButtonOk() {
        return this.jButtonAction1;
    }

    @Override
    public JButton getButtonBack() {
        return this.jButtonAction2;
    }
    
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario oUsuario) {
        this.usuario = oUsuario;
        this.jTextFieldUsuario.setText(this.usuario.toString());
    }
}