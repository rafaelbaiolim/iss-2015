package visao.ajuda;

import javax.swing.JLabel;
import visao.ViewModal;

/**
 * <p>Classe responsavel por definir a Interface de Ajuda nas Views de Cadastro no Sistema.</p>
 * <p>Subclasse da classe abstrata ViewAjuda.</p>
 */
public class ViewAjudaCadastro extends ViewAjuda {

    public ViewAjudaCadastro(ViewModal oView) {
        super(oView);
        this.setTitle("Mercado - Ajuda Cadastro");
    }

    @Override
    protected void addComponents() {
        this.addLinhas(1);
        this.add(new JLabel("1 - Preencha os Campos Obrigatorios(*)"));
        this.addLinhas(1);
        this.add(new JLabel("2 - Apos Preencher Campos, Clique em Inserir"));
        this.addLinhas(1);
        this.add(new JLabel("3 - Para Limpar o Formulario, Clique em Limpar"));
        this.addLinhas(1);
        this.add(new JLabel("4 - Para Voltar ao Menu, Clique em Voltar"));
    }    
}