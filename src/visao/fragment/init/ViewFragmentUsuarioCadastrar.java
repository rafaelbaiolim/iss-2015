package visao.fragment.init;

import visao.cadastro.ViewCadastroUsuario;
import visao.estruturais.ViewMenu;

public class ViewFragmentUsuarioCadastrar {

    /**
     * <p>
     * Classe de execussão para cadastro de usuarios</p>
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ViewMenu viewMenu = new ViewMenu();
        new ViewCadastroUsuario(viewMenu).setVisible(true);
    }

}
