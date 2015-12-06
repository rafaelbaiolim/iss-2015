package visao.cadastro;

import controller.visao.cadastro.ControllerViewCadastroProduto;
import javax.swing.JLabel;
import javax.swing.JTextField;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Cadastro de Produtos no Sistema.
 * @author  Vanessa
 * @version 1.0
 * @since   10/11/2015
 * @see     visao.cadastro.ViewCadastro
 */
public final class ViewCadastroProduto extends ViewCadastro {
    private JTextField jTextFieldDescricao;
    private JTextField jTextFieldMarca;
    private JTextField jTextFieldPeso;
    private JTextField jTextFieldQuantidade;
    private JTextField jTextFieldPrecoUnitario;

    public ViewCadastroProduto(View oView) {
        super(oView);
        this.controller = new ControllerViewCadastroProduto(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Cadastro de Produto");
        this.setSize(400, 405);
        this.setLocation(400, 175);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }
    
    @Override
    public void addHeader() {
        this.addHeader("cadastro_produto.jpg");
        this.message = new JLabel("Os campos com (*) sao obrigatorios!");
        this.add(this.message);
        this.addLinhas(1);
    }

    @Override
    public void addComponents() {
        this.jTextFieldDescricao     = this.createTextField(25);
        this.add(new JLabel("Descrição*: "));
        this.add(this.jTextFieldDescricao);
        
        this.addLinhas(1);
        
        this.jTextFieldMarca         = this.createTextField(13);
        this.add(new JLabel("Marca*: "));
        this.add(this.jTextFieldMarca);
        
        this.jTextFieldPeso          = this.createTextField(5);
        this.add(new JLabel("  Peso: "));
        this.add(this.jTextFieldPeso);
        
        this.addLinhas(1);
        
        this.jTextFieldQuantidade    = this.createTextField(4);
        this.jTextFieldQuantidade.setText("0");
        this.add(new JLabel("Quantidade*: "));
        this.add(this.jTextFieldQuantidade);
        
        this.jTextFieldPrecoUnitario = this.createTextField(8);
        this.jTextFieldPrecoUnitario.setText("0.00");
        this.add(new JLabel("         "));
        this.add(new JLabel("Preço Unitário*: "));
        this.add(this.jTextFieldPrecoUnitario);
        
        this.addLinhas(1);
    }

    @Override
    public void clear() {
        this.jTextFieldDescricao.setText("");
        this.jTextFieldMarca.setText("");
        this.jTextFieldPeso.setText("");
        this.jTextFieldQuantidade.setText("0");
        this.jTextFieldPrecoUnitario.setText("0.00");
        
        this.jTextFieldDescricao.requestFocus();
    }

    public JTextField getTextFieldDescricao() {
        return this.jTextFieldDescricao;
    }

    public JTextField getTextFieldMarca() {
        return this.jTextFieldMarca;
    }

    public JTextField getTextFieldPeso() {
        return this.jTextFieldPeso;
    }

    public JTextField getTextFieldQuantidade() {
        return this.jTextFieldQuantidade;
    }

    public JTextField getTextFieldPrecoUnitario() {
        return this.jTextFieldPrecoUnitario;
    }
}