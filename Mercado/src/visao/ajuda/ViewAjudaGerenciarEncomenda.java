package visao.ajuda;

import javax.swing.JLabel;
import visao.ViewModal;

/**
 * @author Vanessa Nakahara
 * <p>Classe responsavel por definir a Interface de Ajuda na View de Gerenciar Encomenda.</p>
 * <p>Subclasse da classe abstrata ViewAjuda.</p>
 */
public class ViewAjudaGerenciarEncomenda extends ViewAjuda {

    public ViewAjudaGerenciarEncomenda(ViewModal oView) {
        super(oView);
        this.setTitle("Mercado - Ajuda Gerenciar Encomenda");
        this.setSize(340, 320);
        this.setLocation(420, 210);
    }

    @Override
    protected void addComponents() {
        this.addLinhas(1);
        this.add(new JLabel("1 - Selecione uma Venda"));
        this.addLinhas(1);
        this.add(new JLabel("2 - Para Confirmar a Entrega da Encomenda, Clique em Ok"));
        this.addLinhas(1);
        this.add(new JLabel("3 - Para Voltar ao Menu, Clique em Cancelar"));
    }    
}