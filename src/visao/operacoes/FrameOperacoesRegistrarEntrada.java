/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 18/08/2015                                                         *
 * Classe: visao.operacoes.FrameOperacoesRegistrarEntrada                     *
 * Coment: Classe responsavel por representar o Frame de Registrar Entrada de *
 *         Produtos no Sistema.                                               *
 *         Subclasse da Classe Abstrata FrameOperacoes.                       *
 * ========================================================================== */

package visao.operacoes;

import controllers.ControllerEntrada;
import controllers.ControllerPedido;
import modelo.internos.Usuario;
import modelo.relacionais.Entrada;
import modelo.relacionais.ItemPedido;
import modelo.relacionais.Pedido;
import visao.Frame;
import visao.mensagens.FrameMensagem;
import visao.pesquisa.FramePesquisarPedido;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameOperacoesRegistrarEntrada extends FrameOperacoes {
    private JLabel            oLabelHeader;
    
    private JTextField        oTextFieldFuncionario;
    
    private JTextField        oTextFieldPedido;
    private JButton           oButtonSearch;
    
    private JTextField        oTextFieldFornecedor;
    
    private JTextField        oTextFieldTotalItens;
    private JTextField        oTextFieldValorTotal;
    
    private JTextField        oTextFieldNotaFiscal;
    
    private JButton           oButtonConfirmar;
    private JButton           oButtonCancelar;
    
    private Usuario           usuario;
    private Pedido            pedido;
    private List<ItemPedido>  itensPedido;
    private Entrada           entrada;

    public FrameOperacoesRegistrarEntrada(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario     = oUsuario;
        this.pedido      = new Pedido();
        this.entrada     = new Entrada();
        this.itensPedido = new ArrayList<>();
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Registrar Entrada");
        this.setLocation(300, 50);
        this.setSize(500, 600);
        this.addComponents();
    }
    
    private void addComponents() {
        
        this.addLine(1);
        
        this.oLabelHeader      = new JLabel("REGISTRAR ENTRADA");
        this.oLabelHeader.setFont(new Font("Tahoma", 1, 25));
        this.add(this.oLabelHeader);
        
        this.addLine(1);
        
        this.oTextFieldFuncionario = new JTextField(25);
        this.oTextFieldFuncionario.setEditable(false);
        this.oTextFieldFuncionario.setText(this.usuario.getFuncionario().toString());
        this.add(new JLabel("Funcionario: "));
        this.add(this.oTextFieldFuncionario);
        
        this.addLine(1);
        
        this.oTextFieldPedido  = new JTextField(20);
        this.oButtonSearch     = this.createButton("", "search.jpg");
        this.oTextFieldPedido.setEditable(false);
        this.add(new JLabel("Pedido: "));
        this.add(this.oTextFieldPedido);
        this.add(this.oButtonSearch);
        
        this.addLine(1);
        
        this.addTable();
        String[] sDados = {"Descrição", "Quantidade", "Preço Compra"};
        this.addColumns(sDados);
        
        this.addLine(1);
        
        this.oTextFieldFornecedor  = new JTextField(25);
        this.oTextFieldFornecedor.setEditable(false);
        this.add(new JLabel("Fornecedor: "));
        this.add(this.oTextFieldFornecedor);
        
        this.addLine(1);
        
        this.oTextFieldTotalItens  = new JTextField(10);
        this.oTextFieldTotalItens.setEditable(false);
        this.add(new JLabel("Total Itens: "));
        this.add(this.oTextFieldTotalItens);
        
        this.oTextFieldValorTotal  = new JTextField(10);
        this.oTextFieldValorTotal.setEditable(false);
        this.add(new JLabel("Valor Total: "));
        this.add(this.oTextFieldValorTotal);
        
        this.addLine(1);

        this.oTextFieldNotaFiscal  = new JTextField(10);
        this.add(new JLabel("Nota Fiscal: "));
        this.add(this.oTextFieldNotaFiscal);
       
        this.addLine(1);
        
        this.oButtonConfirmar = this.createButton("Confirmar", "yes.jpg");
        this.oButtonCancelar  = this.createButton(" Cancelar", "no.jpg");
        
        this.add(this.oButtonConfirmar);
        this.add(this.oButtonCancelar);
    }
    
    public void setPedido(Pedido oPedido) {
        this.pedido      = oPedido;
        this.itensPedido = ControllerPedido.getItensPedido(oPedido);
        this.entrada.setPedido(this.pedido);
        this.oTextFieldPedido.setText(this.pedido.toString());
        this.atualizarDados();
    }
    
    private void atualizarDados() {
        this.clearTable();
        String[][] sItensPedido = new String[this.itensPedido.size()][3];
        float      fValorTotal  = 0.0f;
        int        iTotalItens  = 0;
        for (int i = 0; i < this.itensPedido.size(); ++i) {                
            sItensPedido[i][0] = this.itensPedido.get(i).getProduto().getDescricao();
            sItensPedido[i][1] = Integer.toString(this.itensPedido.get(i).getQuantidade());
            sItensPedido[i][2] = Float.toString(this.itensPedido.get(i).getPrecoUnitario());
            iTotalItens      += this.itensPedido.get(i).getQuantidade();
            fValorTotal      += this.itensPedido.get(i).getPrecoUnitario() * this.itensPedido.get(i).getQuantidade();
        }
        this.addRows(sItensPedido);
        this.oTextFieldFornecedor.setText(this.pedido.getFornecedor().toString());
        this.oTextFieldTotalItens.setText(Integer.toString(iTotalItens));
        this.oTextFieldValorTotal.setText(Float.toString(fValorTotal));
        this.pedido.setTotalItens(iTotalItens);
        this.pedido.setValorTotal(fValorTotal);
    }


    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSearch)) {
            new FramePesquisarPedido(this).setVisible(true);
        }else if (oEvento.getSource().equals(this.oButtonConfirmar)) {
            
            if ((this.pedido == null)
                    || (this.entrada == null)
                        || (this.itensPedido.isEmpty() == true)) {
                return;
            }
            
            ControllerPedido.desativaPedido(this.pedido);
            ControllerEntrada.adicionar(this.oTextFieldNotaFiscal.getText().trim(), this.pedido, this.usuario);
            ControllerEntrada.atualizarEstoque(this.itensPedido);
            
            new FrameMensagem(this, "Entrada Registrada com Sucesso!").setVisible(true);
            this.dispose();
            
        }else if (oEvento.getSource().equals(this.oButtonCancelar)) {
            this.dispose();
        }
    }
}