package visao.estruturais;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import visao.View;
import modelo.dao.estruturais.DaoUsuario;
import modelo.estruturais.Usuario;

/**
 * <p>
 * Classe de Visao <b>ViewMenu.</b></p>
 * <p>
 * Subclasse da classe abstrata View.</p>
 * <p>
 * Classe responsavel por definir a Interface de Menu do Sistema</p>
 *
 * @version 1.0
 * @since 13/10/2015
 * @see visao.View
 */
public class ViewMenu extends View {

    private JPanel panel;

    private JMenu menuCadastro;
    private JMenu menuConsulta;

    //Cadastrar:
    private JMenuItem menuItemCadastroUsuario;

    //Consultar:
    private JMenuItem menuItemConsultaUsuario;

    private final Usuario usuario;

    /**
     * Metodo constutor padrao responsavel por inicializar os componentes. com o
     * usuario logado no sistema.
     *
     * @param oUsuario Usuario logado no Sistema.
     * @since 14/10/2015
     */
    public ViewMenu(Usuario oUsuario) {
        super();
//        this.controller = new ControllerViewMenu(this);
        this.usuario = oUsuario;
        this.initComponents();
    }

    /**
     * Metodo constutor padrao para teste de modulos unitarios responsavel por
     * inicializar os componentes.
     *
     * @since 14/10/2015
     */
    public ViewMenu() {
        super();
        this.usuario = DaoUsuario.getUsuarioTeste("adminTeste");
        this.initComponents();
    }

    /**
     * Metodo responsavel por inicializar os componentes da View.
     *
     * @since 14/10/2015
     */
    private void initComponents() {
        this.addMenu();
    }

    /**
     * Metodo responsavel por adicionar a barra de menus ao Frame.
     *
     * @since 14/10/2015
     */
    private void addMenu() {
        this.panel = new JPanel();

        this.createMenuCadastro();
        this.createMenuConsulta();

        this.getContentPane().add(this.panel);
    }

    /**
     * Metodo responsavel por criar o menu de cadastro ao Frame.
     *
     * @since 14/10/2015
     */
    private void createMenuCadastro() {
        this.menuCadastro = new JMenu("Cadastro");

        this.menuItemCadastroUsuario = this.createMenuItem("Usuário", "cadastro_usuario.jpg");

        this.menuCadastro.add(this.menuItemCadastroUsuario);

    }

    /**
     * Metodo responsavel por criar o menu de consulta ao Frame.
     *
     * @since 14/10/2015
     */
    private void createMenuConsulta() {
        this.menuConsulta = new JMenu("Consulta");
        this.menuItemConsultaUsuario = this.createMenuItem("Usuário", "search_usuario.jpg");

    }

    /**
     * Getter criado para acessar usuario logado
     *
     * @return
     * @since 19/11/2015
     */
    public Usuario getUsuario() {
        return this.usuario;
    }
}
