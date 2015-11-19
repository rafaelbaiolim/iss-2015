/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 18/08/2015                                                         *
 * Classe: visao.operacoes.FrameOperacoesInserirProduto                       *
 * Coment: Classe responsavel por representar o Frame de Inserir Produto no   *
 *         Cadastro de Venda no Sistema.                                      *
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

public class FrameOperacoesInserirProduto extends FrameModal {
    private JLabel     oLabelHeader;
    
    private JTextField oTextFieldProduto;
    private JButton    oButtonSearch;
    
    private JTextField oTextFieldQuantidadeDisponivel;
    private JTextField oTextFieldPrecoUnitario;
    
    private JTextField oTextFieldQuantidade;
    
    private JButton    oButtonOk;
    private JButton    oButtonCancel;
    
    private FrameModal oFrameParent;
    private Produto    produto;

    public FrameOperacoesInserirProduto(FrameModal oFrame) {
        super(oFrame, "Mercado");
        this.oFrameParent = oFrame;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Inserir Produto");
        this.setLocation(320, 180);
        this.setSize(450, 350);
        this.addComponents();
    }
    
    private void addComponents() {
        
        this.addLine(1);
        
        this.oLabelHeader      = new JLabel("INSERIR PRODUTO");
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
        
        this.oTextFieldPrecoUnitario        = new JTextField(5);
        this.oTextFieldPrecoUnitario.setEditable(false);
        this.add(new JLabel("Preço Unitário: "));
        this.add(this.oTextFieldPrecoUnitario);
        
        this.addLine(1);
        
        this.oTextFieldQuantidadeDisponivel = new JTextField(5);
        this.oTextFieldQuantidadeDisponivel.setEditable(false);
        this.add(new JLabel("Quantidade Em Estoque: "));
        this.add(this.oTextFieldQuantidadeDisponivel);
        
        this.addLine(1);
        
        this.oTextFieldQuantidade           = new JTextField(5);
        this.oTextFieldQuantidade.setText("0");
        this.add(new JLabel("Quantidade: "));
        this.add(this.oTextFieldQuantidade);
        
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
            this.oTextFieldPrecoUnitario.setText(Float.toString(oProduto.getPrecoUnitario()));
            this.oTextFieldQuantidadeDisponivel.setText(Integer.toString(oProduto.getQuantidade()));
        }
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSearch)) {
            new FramePesquisarProduto(this).setVisible(true);
        }else if (oEvento.getSource().equals(this.oButtonOk)) {
            int iQuantidade = Integer.parseInt(this.oTextFieldQuantidade.getText().trim());
            if ((this.produto != null)
                    && (iQuantidade <= this.produto.getQuantidade())) {
                
                if (this.oFrameParent instanceof FrameOperacoesEfetuarVenda) {
                    FrameOperacoesEfetuarVenda oFrameEfetuarVenda = (FrameOperacoesEfetuarVenda) this.oFrameParent;
                                      oFrameEfetuarVenda.addProduto(this.produto, iQuantidade);
                }
                this.dispose();
            }
        }else if (oEvento.getSource().equals(this.oButtonCancel)) {
            this.dispose();
        }
    }
}