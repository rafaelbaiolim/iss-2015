package visao.ajuda;

import javax.swing.JLabel;
import visao.ViewModal;

/**
 * <p>Classe responsavel por definir a Interface de Ajuda na View de Efetuar Venda.</p>
 * <p>Subclasse da classe abstrata ViewAjuda.</p>
 */
public class ViewAjudaRealizarNotificacoes extends ViewAjuda {

    public ViewAjudaRealizarNotificacoes(ViewModal oView) {
        super(oView);
        this.setTitle("Mercado - Ajuda Notificacoes");
    }

    @Override
    protected void addComponents() {
        this.addLinhas(1);
        this.add(new JLabel("1 - Adicione/Remova os Clientes"));
        this.addLinhas(1);
        this.add(new JLabel("2 - Escreva a Mensagem"));
        this.addLinhas(1);
        this.add(new JLabel("3 - Para Enviar a Mensagem, Clique em Notificar"));
        this.addLinhas(1);
        this.add(new JLabel("4 - Para Voltar ao Menu, Clique em Voltar"));
    }    
}