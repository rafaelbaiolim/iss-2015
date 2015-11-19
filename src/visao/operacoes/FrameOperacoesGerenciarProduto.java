/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 18/08/2015                                                         *
 * Classe: visao.operacoes.FrameOperacoesGerenciarProduto                     *
 * Coment: Classe responsavel por representar o Frame de Gerenciar Produtos   *
 *         no Sistema.                                                        *
 *         Subclasse da Classe Abstrata FrameOperacoes.                       *
 * ========================================================================== */


package visao.operacoes;

import controllers.ControllerProduto;
import modelo.cadastrais.Produto;
import modelo.internos.Usuario;
import visao.Frame;
import visao.pesquisa.FramePesquisarProduto;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameOperacoesGerenciarProduto extends FrameOperacoes {
    private JLabel          oLabelHeader;
    
    private JTextField      oTextFieldProduto;
    private JButton         oButtonSearch;
    
    private JTextField      oTextFieldQuantidadeComprada;
    private JTextField      oTextFieldQuantidadeEstoque;
    private JTextField      oTextFieldQuantidadeVendida;
    
    private JButton         oButtonFinalizar;
    private JButton         oButtonCancelar;
    
    private Usuario         usuario;
    private Produto         produto;

    public FrameOperacoesGerenciarProduto(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario    = oUsuario;
        this.produto    = null;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Gerenciar Produto");
        this.setLocation(300, 170);
        this.setSize(500, 350);
        this.addComponents();
    }
    
    private void addComponents() {
        
        this.addLine(1);
        
        this.oLabelHeader      = new JLabel("GERENCIAR PRODUTO");
        this.oLabelHeader.setFont(new Font("Tahoma", 1, 25));
        this.add(this.oLabelHeader);
        
        this.addLine(1);
        
        this.oTextFieldProduto     = new JTextField(25);
        this.oButtonSearch         = this.createButton("", "search.jpg");
        this.oTextFieldProduto.setEditable(false);
        this.add(new JLabel("Produto: "));
        this.add(this.oTextFieldProduto);
        this.add(this.oButtonSearch);
        
        this.addLine(1);
        
        this.oTextFieldQuantidadeComprada  = new JTextField(10);
        this.oTextFieldQuantidadeComprada.setEditable(false);
        this.add(new JLabel("Quantidade Comprada: "));
        this.add(this.oTextFieldQuantidadeComprada);
        this.addLine(1);
        
        this.oTextFieldQuantidadeEstoque  = new JTextField(10);
        this.oTextFieldQuantidadeEstoque.setEditable(false);
        this.add(new JLabel("Quantidade Em Estoque: "));
        this.add(this.oTextFieldQuantidadeEstoque);
        
        this.addLine(1);
        
        this.oTextFieldQuantidadeVendida  = new JTextField(10);
        this.oTextFieldQuantidadeVendida.setEditable(false);
        this.add(new JLabel("Quantidade Vendida: "));
        this.add(this.oTextFieldQuantidadeVendida);
        
        this.addLine(1);
        
        this.oButtonFinalizar     = this.createButton("Finalizar", "yes.jpg");
        this.oButtonCancelar     = this.createButton(" Cancelar", "no.jpg");
        this.add(this.oButtonFinalizar);
        this.add(this.oButtonCancelar);
    }

    public void setProduto(Produto oProduto) {
        this.produto = (oProduto);
        this.oTextFieldProduto.setText(this.produto.getDescricao());
        this.atualizarDados();
    }
    
    private void atualizarDados() {
        this.oTextFieldQuantidadeComprada.setText(Integer.toString(ControllerProduto.getQuantidadeComprada(this.produto)));
        this.oTextFieldQuantidadeEstoque.setText(Integer.toString(this.produto.getQuantidade()));
        this.oTextFieldQuantidadeVendida.setText(Integer.toString(ControllerProduto.getQuantidadeVendida(this.produto)));
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSearch)) {
            new FramePesquisarProduto(this).setVisible(true);
        }else if (oEvento.getSource().equals(this.oButtonFinalizar)) {
            this.dispose();
        }else if (oEvento.getSource().equals(this.oButtonCancelar)) {
            this.dispose();
        }
    }
}