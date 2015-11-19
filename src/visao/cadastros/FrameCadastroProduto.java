/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 20/08/2015                                                         *
 * Classe: visao.cadastros.FrameCadastroProduto                               *
 * Coment: Classe responsavel pela Frame de Cadastro de Produto.              *
 *         Subclasse da Classe Abstrata FrameModal.                           *
 * ========================================================================== */

package visao.cadastros;

import controllers.ControllerProduto;
import modelo.internos.Usuario;
import visao.Frame;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public final class FrameCadastroProduto extends FrameCadastro {
    private JTextField oTextFieldDescricao;
    
    private JTextField oTextFieldMarca;
    private JTextField oTextFieldPeso;
    
    private JTextField oTextFieldQuantidade;
    private JTextField oTextFieldPrecoUnitario;
    
    private Usuario    usuario;

    public FrameCadastroProduto(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario = oUsuario;
        this.initComponents();
    }

    @Override
    protected void initComponents() {
        this.setTitle("Mercado - Cadastro de Produto");
        this.setLocation(370, 150);
        this.setSize(400, 430);
        this.addHeader("cadastro_produto.jpg");
        this.setInitialMessage("Os Campos (*) sao Obrigatorios");
        this.addComponents();
        this.addButtons();
    }

    @Override
    protected void addComponents() {
        this.oTextFieldDescricao     = new JTextField(25);
        this.add(new JLabel("Descrição*: "));
        this.add(this.oTextFieldDescricao);
        
        this.addLine(1);
        
        this.oTextFieldMarca         = new JTextField(13);
        this.add(new JLabel("Marca*: "));
        this.add(this.oTextFieldMarca);
        
        this.oTextFieldPeso          = new JTextField(5);
        this.add(new JLabel("  Peso: "));
        this.add(this.oTextFieldPeso);
        
        this.addLine(1);
        
        this.oTextFieldQuantidade    = new JTextField(4);
        this.oTextFieldQuantidade.setText("0");
        this.add(new JLabel("Quantidade*: "));
        this.add(this.oTextFieldQuantidade);
        
        this.oTextFieldPrecoUnitario = new JTextField(8);
        this.oTextFieldPrecoUnitario.setText("0.00");
        this.add(new JLabel("         "));
        this.add(new JLabel("Preço Unitário*: "));
        this.add(this.oTextFieldPrecoUnitario);
        
        this.addLine(1);
    }

    @Override
    protected void clear() {
        this.oTextFieldDescricao.setText("");
        
        this.oTextFieldMarca.setText("");
        this.oTextFieldPeso.setText("");
        
        this.oTextFieldQuantidade.setText("0");
        this.oTextFieldPrecoUnitario.setText("0.00");
        
        this.oTextFieldDescricao.requestFocus();
    }

    private boolean checkParameters(String sDescricao, String sMarca) {
        if (ControllerProduto.checkDescricao(sDescricao) == false) {
            this.setError("Descricao Invalida!");
            return false;
        }else if (ControllerProduto.descricaoIsAble(sDescricao) == false) {
            this.setError("Descricao ja Cadastrada!");
            return false;
        }else if (ControllerProduto.checkMarca(sMarca) == false) {
            this.setError("Marca Inválida!");
            return false;
        }
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonAdd)) {
            String sDescricao     = this.oTextFieldDescricao.getText().toUpperCase().trim();
            String sMarca         = this.oTextFieldMarca.getText().toUpperCase().trim();
            String sPeso          = this.oTextFieldPeso.getText().trim();
            int    iQuantidade    = Integer.parseInt(this.oTextFieldQuantidade.getText().trim());
            float  fPrecoUnitario = Float.parseFloat(this.oTextFieldPrecoUnitario.getText().trim());
            if (this.checkParameters(sDescricao, sMarca) == true) {
                ControllerProduto.adicionar(sDescricao, sMarca, sPeso, iQuantidade, fPrecoUnitario, this.usuario);
                this.clear();
                this.setMessage("Produto Cadastrado com Sucesso!");
            }
        }else if (oEvento.getSource().equals(this.oButtonClear)) {
            this.clear();
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}