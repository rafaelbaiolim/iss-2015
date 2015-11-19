/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 10/08/2015                                                         *
 * Classe: visao.edicao.FrameEditarProduto                                    *
 * Coment: Classe responsavel por representar o Frame de Edicao de Produtos.  *
 *         Subclasse da Classe Abstrata FrameEditar.                          *
 * ========================================================================== */

package visao.edicao;

import controllers.ControllerProduto;
import modelo.cadastrais.Produto;
import modelo.internos.Usuario;
import visao.FrameModal;
import visao.consultas.FrameConsultaProduto;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameEditarProduto extends FrameEditar {
    private FrameConsultaProduto oFrameConsultaProduto;
    private Usuario              usuario;
    private Produto              produto;
    
    private JTextField oTextFieldDescricao;
    private JTextField oTextFieldMarca;
    private JTextField oTextFieldPeso;
    private JTextField oTextFieldQuantidade;
    private JTextField oTextFieldPrecoUnitario;

    public FrameEditarProduto(FrameModal oFrame, Produto oProduto, Usuario oUsuario) {
        super(oFrame, "");
        this.oFrameConsultaProduto = (FrameConsultaProduto) oFrame;
        this.produto               = oProduto;
        this.usuario               = oUsuario;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Editar Cidade");
        this.setLocation(370, 150);
        this.setSize(400, 430);
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        this.addHeader("editar_produto.jpg");
        this.addLine(1);
        this.addBody();
        this.addLine(1);
        this.addButtons();
    }
    
    private void addBody() {
        this.oTextFieldDescricao     = new JTextField(25);
        this.oTextFieldDescricao.setText(this.produto.getDescricao());
        this.add(new JLabel("Descrição*: "));
        this.add(this.oTextFieldDescricao);
        
        this.addLine(1);
        
        this.oTextFieldMarca         = new JTextField(13);
        this.oTextFieldMarca.setText(this.produto.getMarca());
        this.add(new JLabel("Marca*: "));
        this.add(this.oTextFieldMarca);
        
        this.oTextFieldPeso          = new JTextField(5);
        this.oTextFieldPeso.setText(this.produto.getPeso());
        this.add(new JLabel("  Peso: "));
        this.add(this.oTextFieldPeso);
        
        this.addLine(1);
        
        this.oTextFieldQuantidade    = new JTextField(4);
        this.oTextFieldQuantidade.setText(Integer.toString(this.produto.getQuantidade()));
        this.add(new JLabel("Quantidade*: "));
        this.add(this.oTextFieldQuantidade);
        
        this.oTextFieldPrecoUnitario = new JTextField(8);
        this.oTextFieldPrecoUnitario.setText(Float.toString(this.produto.getPrecoUnitario()));
        this.add(new JLabel("         "));
        this.add(new JLabel("Preço Unitário*: "));
        this.add(this.oTextFieldPrecoUnitario);
        
        this.addLine(1);
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSave)) {
            String sDescricao     = this.oTextFieldDescricao.getText().toUpperCase().trim();
            String sMarca         = this.oTextFieldMarca.getText().toUpperCase().trim();
            String sPeso          = this.oTextFieldPeso.getText().trim();
            int    iQuantidade    = Integer.parseInt(this.oTextFieldQuantidade.getText().trim());
            float  fPrecoUnitario = Float.parseFloat(this.oTextFieldPrecoUnitario.getText().trim());
            ControllerProduto.gravar(this.produto, sDescricao, sMarca, sPeso, iQuantidade, fPrecoUnitario, this.usuario);
            this.oFrameConsultaProduto.clear();
            this.dispose();
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}