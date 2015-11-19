/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 12/08/2015                                                         *
 * Classe: visao.consultas.FrameConsultaProduto                               *
 * Coment: Classe responsavel pela Frame de Consulta de Produto.              *
 *         Subclasse da Classe Abstrata FrameConsulta.                        *
 * ========================================================================== */

package visao.consultas;

import controllers.ControllerProduto;
import modelo.cadastrais.Produto;
import modelo.internos.Usuario;
import visao.Frame;
import visao.edicao.FrameEditarProduto;
import visao.remover.FrameRemoverProduto;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameConsultaProduto extends FrameConsulta {
    private List<Produto> produtos;
    
    private Usuario      usuario;

    public FrameConsultaProduto(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario = oUsuario;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Consulta de Produtos");
        this.setSize(450, 520);
        this.produtos = ControllerProduto.getProdutosByDescricao("");
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        this.addHeader("consulta_produto.jpg");
        this.addLine(1);
        this.addBody();
        this.addLine(1);
        this.addButtons();
    }

    private void addBody() {
        this.oTextFieldSearch = new JTextField(15);
        this.add(new JLabel("Produto: "));
        this.add(this.oTextFieldSearch);
        this.oButtonSearch    = this.createButton("Atualizar", "update.jpg");
        this.add(this.oButtonSearch);
        
        this.addLine(1);
        
        this.addTable();
        this.oScrollPane.setPreferredSize(new Dimension(350, 150));
        this.addColumns(new String[]{"Descricao", "Marca"});
        this.addRows(ControllerProduto.getProdutos(this.produtos));
    }
    
    public void clear() {
        this.oTextFieldSearch.setText("");
        this.produtos = ControllerProduto.getProdutosByDescricao("");
        this.addRows(ControllerProduto.getProdutos(this.produtos));
        this.oTextFieldSearch.requestFocus();
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSearch)) {
            this.produtos = ControllerProduto.getProdutosByDescricao(this.oTextFieldSearch.getText());
            this.addRows(ControllerProduto.getProdutos(this.produtos));
        }else if (oEvento.getSource().equals(this.oButtonEdit)) {
            if ((this.oTable.getSelectedRow() > -1) 
                    && (this.oTable.getSelectedRow() < this.produtos.size())) {
                new FrameEditarProduto(this, this.produtos.get(this.oTable.getSelectedRow()), this.usuario).setVisible(true);
            }
        }else if (oEvento.getSource().equals(this.oButtonRemove)) {
            if ((this.oTable.getSelectedRow() > -1) 
                    && (this.oTable.getSelectedRow() < this.produtos.size())) {
                new FrameRemoverProduto(this, this.produtos.get(this.oTable.getSelectedRow()), this.usuario).setVisible(true);
            }
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}