package visao.ajuda;

import javax.swing.JLabel;
import visao.ViewModal;

/**
 * @author Vanessa Nakahara
 * <p>Classe responsavel por definir a Interface de Ajuda na View de Registrar Pedido.</p>
 * <p>Subclasse da classe abstrata ViewAjuda.</p>
 */
public class ViewAjudaRegistrarPedido extends ViewAjuda {

    public ViewAjudaRegistrarPedido(ViewModal oView) {
        super(oView);
        this.setTitle("Mercado - Ajuda Registrar Pedido");
    }

    @Override
    protected void addComponents() {
        this.addLinhas(1);
        this.add(new JLabel("1 - Selecione um Fornecedor"));
        this.addLinhas(1);
        this.add(new JLabel("2 - Adicione/Remova Itens do Pedido"));
        this.addLinhas(1);
        this.add(new JLabel("3 - Para Gravar o Pedido, Clique em Gravar"));
        this.addLinhas(1);
        this.add(new JLabel("4 - Para Voltar ao Menu, Clique em Voltar"));
    }    
}