package visao.ajuda;

import javax.swing.JLabel;
import visao.ViewModal;

/**
 * <p>Classe responsavel por definir a Interface de Ajuda na View de Organizar Horario.</p>
 * <p>Subclasse da classe abstrata ViewAjuda.</p>
 */
public class ViewAjudaOrganizarHorario extends ViewAjuda {

    public ViewAjudaOrganizarHorario(ViewModal oView) {
        super(oView);
        this.setTitle("Mercado - Ajuda Organizar Horario");
    }

    @Override
    protected void addComponents() {
        this.addLinhas(1);
        this.add(new JLabel("1 - Procure Funcionario Utilizando os Filtros"));
        this.addLinhas(1);
        this.add(new JLabel("2 - Para Alterar Funcionario, Clique em Editar"));
        this.addLinhas(1);
        this.add(new JLabel("3 - Para Confirmar as Alteracoes, Clique em Ok"));
        this.addLinhas(1);
        this.add(new JLabel("4 - Para Voltar ao Menu, Clique em Voltar"));
    }    
}