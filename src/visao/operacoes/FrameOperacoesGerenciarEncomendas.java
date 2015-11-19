/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 18/08/2015                                                         *
 * Classe: visao.operacoes.FrameOperacoesGerenciarEncomendas                  *
 * Coment: Classe responsavel por representar o Frame de Gerenciar Encomendas *
 *         no Sistema.                                                        *
 *         Subclasse da Classe Abstrata FrameOperacoes.                       *
 * ========================================================================== */

package visao.operacoes;

import controllers.ControllerVenda;
import modelo.internos.Usuario;
import modelo.relacionais.ItemVenda;
import modelo.relacionais.Venda;
import visao.Frame;
import visao.pesquisa.FramePesquisarVenda;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameOperacoesGerenciarEncomendas extends FrameOperacoes {
    private JLabel          oLabelHeader;
    
    private JTextField      oTextFieldFuncionario;
    
    private JTextField      oTextFieldVenda;
    private JButton         oButtonSearch;
    
    private JTextField      oTextFieldCliente;
    private JTextField      oTextFieldEndereco;
    
    private JButton         oButtonConfirmar;
    private JButton         oButtonCancelar;
    
    private Usuario         usuario;
    private Venda           venda;
    private List<ItemVenda> itensVenda;

    public FrameOperacoesGerenciarEncomendas(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario     = oUsuario;
        this.venda       = new Venda();
        this.itensVenda  = new ArrayList<>();
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Gerenciar Encomenda");
        this.setLocation(300, 80);
        this.setSize(500, 560);
        this.addComponents();
    }
    
    private void addComponents() {
        
        this.addLine(1);
        
        this.oLabelHeader      = new JLabel("GERENCIAR ENCOMENDA");
        this.oLabelHeader.setFont(new Font("Tahoma", 1, 25));
        this.add(this.oLabelHeader);
        
        this.addLine(1);
        
        this.oTextFieldFuncionario = new JTextField(25);
        this.oTextFieldFuncionario.setEditable(false);
        this.oTextFieldFuncionario.setText(this.usuario.getFuncionario().toString());
        this.add(new JLabel("Funcionario: "));
        this.add(this.oTextFieldFuncionario);
        
        this.addLine(1);
        
        this.oTextFieldVenda  = new JTextField(20);
        this.oButtonSearch     = this.createButton("", "search.jpg");
        this.oTextFieldVenda.setEditable(false);
        this.add(new JLabel("Venda: "));
        this.add(this.oTextFieldVenda);
        this.add(this.oButtonSearch);
        
        this.addLine(1);
        
        this.addTable();
        String[] sDados = {"Descrição", "Quantidade", "Preço Unitário"};
        this.addColumns(sDados);
        
        this.addLine(1);
        
        this.oTextFieldCliente  = new JTextField(25);
        this.oTextFieldCliente.setEditable(false);
        this.add(new JLabel("Cliente: "));
        this.add(this.oTextFieldCliente);
        
        this.addLine(1);
        
        this.oTextFieldEndereco  = new JTextField(25);
        this.oTextFieldEndereco.setEditable(false);
        this.add(new JLabel("Endereco: "));
        this.add(this.oTextFieldEndereco);
        
        this.addLine(1);
        
        this.oButtonConfirmar = this.createButton("Confirmar Entrega", "yes.jpg");
        this.oButtonCancelar  = this.createButton("     Cancelar    ", "no.jpg");
        
        this.add(this.oButtonConfirmar);
        this.add(this.oButtonCancelar);
    }
    
    public void setVenda(Venda oVenda) {
        this.venda      = oVenda;
        this.itensVenda = ControllerVenda.getItensVenda(oVenda);
        this.oTextFieldVenda.setText(this.venda.toString());
        this.atualizarDados();
    }
    
    private void atualizarDados() {
        this.clearTable();
        String[][] sItensVenda = new String[this.itensVenda.size()][3];
        for (int i = 0; i < this.itensVenda.size(); ++i) {                
            sItensVenda[i][0] = this.itensVenda.get(i).getProduto().getDescricao();
            sItensVenda[i][1] = Integer.toString(this.itensVenda.get(i).getQuantidade());
            sItensVenda[i][2] = Float.toString(this.itensVenda.get(i).getValorUnitario());
        }
        this.addRows(sItensVenda);
        this.oTextFieldCliente.setText(this.venda.getCliente().toString());
        this.oTextFieldEndereco.setText(this.venda.getCliente().getEndereco());
    }


    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSearch)) {
            new FramePesquisarVenda(this).setVisible(true);
        }else if (oEvento.getSource().equals(this.oButtonConfirmar)) {
            if (this.venda != null) {
                ControllerVenda.entregarEncomenda(this.venda);
                this.dispose();
            }
        }else if (oEvento.getSource().equals(this.oButtonCancelar)) {
            this.dispose();
        }
    }
}