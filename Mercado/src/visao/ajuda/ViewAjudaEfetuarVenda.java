package visao.ajuda;

import javax.swing.JLabel;
import visao.ViewModal;

/**
 * <p>Classe responsavel por definir a Interface de Ajuda na View de Efetuar Venda.</p>
 * <p>Subclasse da classe abstrata ViewAjuda.</p>
 */
public class ViewAjudaEfetuarVenda extends ViewAjuda {

    public ViewAjudaEfetuarVenda(ViewModal oView) {
        super(oView);
        this.setTitle("Mercado - Ajuda Efetuar Venda");
    }

    @Override
    protected void addComponents() {
        this.addLinhas(1);
        this.add(new JLabel("1 - Selecione um Cliente"));
        this.addLinhas(1);
        this.add(new JLabel("2 - Adicione/Remova Itens da Venda"));
        this.addLinhas(1);
        this.add(new JLabel("3 - Para Gravar a Venda, Clique em Gravar"));
        this.addLinhas(1);
        this.add(new JLabel("4 - Para Voltar ao Menu, Clique em Voltar"));
    }    
}