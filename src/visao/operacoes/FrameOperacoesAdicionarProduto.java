/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 18/08/2015                                                         *
 * Classe: visao.operacoes.FrameOperacoesAdicionarProduto                     *
 * Coment: Classe responsavel por representar o Frame de Adicionar Produto no *
 *         Cadastro de um Pedido.                                             *
 *         Subclasse da Classe Abstrata FrameModal.                           *
 * ========================================================================== */

package visao.operacoes;

import visao.pesquisa.FramePesquisarProduto;
import modelo.cadastrais.Produto;
import visao.FrameModal;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameOperacoesAdicionarProduto extends FrameModal {
    private JLabel     oLabelHeader;
    private JTextField oTextFieldProduto;
    private JButton    oButtonSearch;
    private JTextField oTextFieldQuantidade;
    private JTextField oTextFieldPrecoUnitario;
    private JButton    oButtonOk;
    private JButton    oButtonCancel;
    private FrameModal oFrameParent;
    private Produto    produto;

    public FrameOperacoesAdicionarProduto(FrameModal oFrame) {
        super(oFrame, "");
        this.oFrameParent = oFrame;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Adicionar Produto");
        this.setLocation(320, 180);
        this.setSize(450, 270);
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        
        this.oLabelHeader      = new JLabel("ADICIONAR PRODUTO");
        this.oLabelHeader.setFont(new Font("Tahoma", 1, 25));
        this.add(this.oLabelHeader);
        
        this.addLine(1);
        
        this.oTextFieldProduto = new JTextField(18);
        this.oButtonSearch     = this.createButton("", "search.jpg");
        this.oTextFieldProduto.setEditable(false);
        this.add(new JLabel("Produto: "));
        this.add(this.oTextFieldProduto);
        this.add(this.oButtonSearch);
        
        this.addLine(1);
        
        this.oTextFieldQuantidade    = new JTextField(5);
        this.oTextFieldQuantidade.setText("0");
        this.add(new JLabel("Quantidade: "));
        this.add(this.oTextFieldQuantidade);
        
        this.oTextFieldPrecoUnitario = new JTextField(5);
        this.oTextFieldPrecoUnitario.setText("0.00");
        this.add(new JLabel("Preço Unitário: "));
        this.add(this.oTextFieldPrecoUnitario);
        
        this.addLine(1);
        
        this.oButtonOk     = this.createButton("Adicionar", "yes.jpg");
        this.oButtonCancel = this.createButton("Cancelar" , "no.jpg");
        
        this.add(this.oButtonOk);
        this.add(this.oButtonCancel);    
    }
    
    public void addProduto(Produto oProduto) {
        if (oProduto != null) {
            this.produto = oProduto;
            this.oTextFieldProduto.setText(oProduto.toString());
        }
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSearch)) {
            new FramePesquisarProduto(this).setVisible(true);
        }else if (oEvento.getSource().equals(this.oButtonOk)) {
            int   iQuantidade    = Integer.parseInt(this.oTextFieldQuantidade.getText().trim());
            float fPrecoUnitario = Float.parseFloat(this.oTextFieldPrecoUnitario.getText().trim());
            if ((iQuantidade > 0) 
                    && (fPrecoUnitario > 0)) {
                
                if (this.oFrameParent instanceof FrameOperacoesRegistrarPedido) {
                    ((FrameOperacoesRegistrarPedido) this.oFrameParent).addProduto(this.produto, iQuantidade, fPrecoUnitario);
                }
                this.dispose();
            }
        }else if (oEvento.getSource().equals(this.oButtonCancel)) {
            this.dispose();
        }
    }
}