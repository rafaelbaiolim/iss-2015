package visao.editar;

import controller.visao.editar.ControllerViewEditarProduto;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.cadastrais.Produto;
import visao.consulta.ViewConsultaProduto;

/**
 * Classe responsavel por definir a Interface de Edicao de Produtos no Sistema.
 * @author  Vanessa
 * @version 1.0
 * @since   18/11/2015
 * @see     visao.editar.ViewEditar
 */
public final class ViewEditarProduto extends ViewEditar {
    private       JTextField          jTextFieldDescricao;
    private       JTextField          jTextFieldMarca;
    private       JTextField          jTextFieldPeso;
    private       JTextField          jTextFieldQuantidade;
    private       JTextField          jTextFieldPrecoUnitario;
    private final ViewConsultaProduto viewConsultaProduto;
    private final Produto             produto;

    /**
     * Metodo constrututor herdado da superclasse.
     * @param oView
     * @param oProduto 
     */
    public ViewEditarProduto(ViewConsultaProduto oView, Produto oProduto) {
        super(oView);
        this.controller          = new ControllerViewEditarProduto(this);
        this.viewConsultaProduto = oView;
        this.produto             = oProduto;
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Editar Produto");
        this.setSize(400, 340);
        this.setLocation(395, 200);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }

    @Override
    public void addHeader() {
        super.addHeader("editar_produto.jpg");
    }
    
    @Override
    public void addComponents() {
        this.jTextFieldDescricao     = this.createTextField(25);
        this.jTextFieldDescricao.setText(this.produto.getDescricao());
        this.add(new JLabel("Descrição*: "));
        this.add(this.jTextFieldDescricao);
        
        this.addLinhas(1);
        
        this.jTextFieldMarca         = this.createTextField(13);
        this.jTextFieldMarca.setText(this.produto.getMarca());
        this.add(new JLabel("Marca*: "));
        this.add(this.jTextFieldMarca);
        
        this.jTextFieldPeso          = this.createTextField(5);
        this.jTextFieldPeso.setText(this.produto.getPeso());
        this.add(new JLabel("  Peso: "));
        this.add(this.jTextFieldPeso);
        
        this.addLinhas(1);
        
        this.jTextFieldQuantidade    = this.createTextField(4);
        this.jTextFieldQuantidade.setText(Integer.toString(this.produto.getQuantidade()));
        this.add(new JLabel("Quantidade*: "));
        this.add(this.jTextFieldQuantidade);
        
        this.jTextFieldPrecoUnitario = this.createTextField(8);
        this.jTextFieldPrecoUnitario.setText(Float.toString(this.produto.getPrecoUnitario()));
        this.add(new JLabel("         "));
        this.add(new JLabel("Preço Unitário*: "));
        this.add(this.jTextFieldPrecoUnitario);
        
        this.addLinhas(1);
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

    public ViewConsultaProduto getViewConsultaProduto() {
        return this.viewConsultaProduto;
    }
    
    public Produto getProduto() {
        return this.produto;
    }
}