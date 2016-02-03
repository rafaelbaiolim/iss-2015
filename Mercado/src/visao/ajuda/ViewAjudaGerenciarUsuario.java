package visao.ajuda;

import javax.swing.JLabel;
import visao.ViewModal;

/**
 * <p>Classe responsavel por definir a Interface de Ajuda na View de Gerenciar Usuario.</p>
 * <p>Subclasse da classe abstrata ViewAjuda.</p>
 */
public class ViewAjudaGerenciarUsuario extends ViewAjuda {

    public ViewAjudaGerenciarUsuario(ViewModal oView) {
        super(oView);
        this.setTitle("Mercado - Ajuda Gerenciar Usuario");
        this.setSize(320, 320);
        this.setLocation(450, 210);
    }

    @Override
    protected void addComponents() {
        this.addLinhas(1);
        this.add(new JLabel("1 - Selecione um Usuario"));
        this.addLinhas(1);
        this.add(new JLabel("2 - Para Confirmar, Clique em Ok"));
        this.addLinhas(1);
        this.add(new JLabel("3 - Para Voltar ao Menu, Clique em Voltar"));
    }    
}