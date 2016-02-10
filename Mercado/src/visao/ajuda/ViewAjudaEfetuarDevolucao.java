package visao.ajuda;

import javax.swing.JLabel;
import visao.ViewModal;

/**
 * <p>Classe responsavel por definir a Interface de Ajuda na View de Efetuar Devolucao.</p>
 * <p>Subclasse da classe abstrata ViewAjuda.</p>
 */
public class ViewAjudaEfetuarDevolucao extends ViewAjuda {

    public ViewAjudaEfetuarDevolucao(ViewModal oView) {
        super(oView);
        this.setTitle("Mercado - Ajuda Efetuar Devolucao");
        this.setSize(320, 320);
        this.setLocation(450, 210);
    }

    @Override
    protected void addComponents() {
        this.addLinhas(1);
        this.add(new JLabel("1 - Selecione uma Venda"));
        this.addLinhas(1);
        this.add(new JLabel("2 - Para Confirmar a Devolucao, Clique em Confirmar"));
        this.addLinhas(1);
        this.add(new JLabel("3 - Para Voltar ao Menu, Clique em Cancelar"));
    }    
}