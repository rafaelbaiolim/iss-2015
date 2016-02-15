package visao.estruturais;

import funct.FunctFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import visao.View;
import controller.visao.estruturais.ControllerViewMenu;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import modelo.estruturais.Usuario;

/**
 * <p>Classe de Visao <b>ViewMenu.</b></p>
 * <p>Subclasse da classe abstrata View.</p>
 * <p>Classe responsavel por definir a Interface de Menu do Sistema.</p>
 * @author  Leandro
 * @version 1.0
 * @since   13/10/2015
 * @see     visao.View
 */
public class ViewMenu extends View {
    private JPanel    panel;
    
    private JMenuBar  menuBar;
    
    private JMenu     menuCadastro;
    private JMenu     menuConsulta;
    private JMenu     menuOperacoes;
    private JMenu     menuRelatorios;
    private JMenu     menuSistema;
    
    //Cadastrar:
    private JMenuItem menuItemCadastroUsuario;
    private JMenuItem menuItemCadastroCidade;
    private JMenuItem menuItemCadastroDespesa;
    private JMenuItem menuItemCadastroClienteFisico;
    private JMenuItem menuItemCadastroClienteJuridico;
    private JMenuItem menuItemCadastroFornecedor;
    private JMenuItem menuItemCadastroMarca;
    private JMenuItem menuItemCadastroFuncionario;
    private JMenuItem menuItemCadastroProduto;
    
    //Consultar:
    private JMenuItem menuItemConsultaUsuario;
    private JMenuItem menuItemConsultaCidade;
    private JMenuItem menuItemConsultaDespesa;
    private JMenuItem menuItemConsultaCliente;
    private JMenuItem menuItemConsultaFornecedor;
    private JMenuItem menuItemConsultaMarca;
    private JMenuItem menuItemConsultaFuncionario;
    private JMenuItem menuItemConsultaProduto;
    
    //Operacoes:
    private JMenuItem menuItemOperacoesRegistrarPedido;
    private JMenuItem menuItemOperacoesChegadaPedido;
    private JMenuItem menuItemOperacoesOrganizarHorario;
    private JMenuItem menuItemOperacoesRealizarNotificacao;
    private JMenuItem menuItemOperacoesEfetuarVenda;
    private JMenuItem menuItemOperacoesEfetuarDevolucao;
    private JMenuItem menuItemOperacoesGerenciarEncomenda;
    private JMenuItem menuItemOperacoesGerenciarProduto;
    private JMenuItem menuItemOperacoesGerenciarUsuario;
    
    //Relatorios:
    private JMenuItem menuItemRelatoriosFuncionarios;
    private JMenuItem menuItemRelatoriosDespesa;
    private JMenuItem menuItemRelatoriosProdutosEstoque;
    private JMenuItem menuItemRelatoriosProdutosMaisVendidos;
    
    //Sistema:
    private JMenuItem menuItemSistemaSobre;
    private JMenuItem menuItemSistemaTrocarSenha;
    private JMenuItem menuItemSistemaLogoff;
    private JMenuItem menuItemSistemaSair;
    
    private final Usuario usuario;
    
    /**
     * Metodo constutor padrao responsavel por inicializar os componentes.
     * @param   oUsuario Usuario logado no Sistema.
     * @since   14/10/2015
     */
    public ViewMenu(Usuario oUsuario) {
        super();
        this.controller = new ControllerViewMenu(this);
        this.usuario    = oUsuario;
        this.addKeyListener(this.controller);
        this.initComponents();
    }
    
    /**
     * Metodo responsavel por inicializar os componentes da View.
     * @since 14/10/2015
     */
    private void initComponents() {
        this.setTitle("Mercado - Menu Principal");
        this.addMenu();
        this.addLogo();
    }
    
    /**
     * Metodo responsavel por adicionar a barra de menus ao Frame.
     * @since   14/10/2015
     */
    private void addMenu() {
        this.panel   = new JPanel();
        this.menuBar = new JMenuBar();
        
        this.createMenuCadastro();
        this.createMenuConsulta();
        this.createMenuOperacoes();
        this.createMenuRelatorio();
        this.createMenuSistema();
        
        this.menuBar.add(this.menuCadastro);
        this.menuBar.add(this.menuConsulta);
        this.menuBar.add(this.menuOperacoes);
        this.menuBar.add(this.menuRelatorios);
        this.menuBar.add(this.menuSistema);
        
        this.setJMenuBar(this.menuBar);
        this.getContentPane().add(this.panel);
    }
    
    /**
     * Metodo responsavel por criar o menu de cadastro ao Frame.
     * @since 14/10/2015
     */
    private void createMenuCadastro() {
        this.menuCadastro                    = new JMenu("Cadastro");
        
        this.menuItemCadastroUsuario         = this.createMenuItem("Usuário"         , "cadastro_usuario.jpg");
        this.menuItemCadastroUsuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.ALT_MASK));
        this.menuItemCadastroFuncionario     = this.createMenuItem("Funcionário"     , "cadastro_funcionario.jpg");
        this.menuItemCadastroFuncionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.ALT_MASK));
        this.menuItemCadastroCidade          = this.createMenuItem("Cidade"          , "cadastro_cidade.jpg");
        this.menuItemCadastroCidade.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.ALT_MASK));
        this.menuItemCadastroDespesa         = this.createMenuItem("Despesa"         , "cadastro_despesa.jpg");
        this.menuItemCadastroDespesa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.ALT_MASK));
        this.menuItemCadastroClienteFisico   = this.createMenuItem("Cliente Físico"  , "cadastro_cliente_fisico.jpg");
        this.menuItemCadastroClienteFisico.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, InputEvent.ALT_MASK));
        this.menuItemCadastroClienteJuridico = this.createMenuItem("Cliente Jurídico", "cadastro_cliente_juridico.jpg");
        this.menuItemCadastroClienteJuridico.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, InputEvent.ALT_MASK));
        this.menuItemCadastroFornecedor      = this.createMenuItem("Fornecedor"      , "cadastro_fornecedor.jpg");
        this.menuItemCadastroFornecedor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_7, InputEvent.ALT_MASK));
        this.menuItemCadastroMarca           = this.createMenuItem("Marca"           , "cadastro_marca.jpg");
        this.menuItemCadastroMarca.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_8, InputEvent.ALT_MASK));
        this.menuItemCadastroProduto         = this.createMenuItem("Produto"         , "cadastro_produto.jpg");
        this.menuItemCadastroProduto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9, InputEvent.ALT_MASK));
        
        this.menuCadastro.add(this.menuItemCadastroUsuario);
        this.menuCadastro.add(this.menuItemCadastroFuncionario);
        this.menuCadastro.addSeparator();
        this.menuCadastro.add(this.menuItemCadastroCidade);
        this.menuCadastro.addSeparator();
        this.menuCadastro.add(this.menuItemCadastroDespesa);
        this.menuCadastro.addSeparator();
        this.menuCadastro.add(this.menuItemCadastroClienteFisico);
        this.menuCadastro.add(this.menuItemCadastroClienteJuridico);
        this.menuCadastro.addSeparator();
        this.menuCadastro.add(this.menuItemCadastroFornecedor);
        this.menuCadastro.add(this.menuItemCadastroMarca);
        this.menuCadastro.add(this.menuItemCadastroProduto);
    }
    
    /**
     * Metodo responsavel por criar o menu de consulta ao Frame.
     * @since 14/10/2015
     */
    private void createMenuConsulta() {
        this.menuConsulta                = new JMenu("Consulta");
        
        this.menuItemConsultaUsuario     = this.createMenuItem("Usuário"    , "search_usuario.jpg");
        this.menuItemConsultaUsuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.SHIFT_MASK));
        this.menuItemConsultaFuncionario = this.createMenuItem("Funcionário", "search_funcionario.jpg");
        this.menuItemConsultaFuncionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.SHIFT_MASK));
        this.menuItemConsultaCidade      = this.createMenuItem("Cidade"     , "search_cidade.jpg");
        this.menuItemConsultaCidade.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.SHIFT_MASK));
        this.menuItemConsultaDespesa     = this.createMenuItem("Despesa"    , "search_despesa.jpg");
        this.menuItemConsultaDespesa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.SHIFT_MASK));
        this.menuItemConsultaCliente     = this.createMenuItem("Cliente"    , "search_cliente.jpg");
        this.menuItemConsultaCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, InputEvent.SHIFT_MASK));
        this.menuItemConsultaFornecedor  = this.createMenuItem("Fornecedor" , "search_fornecedor.jpg");
        this.menuItemConsultaFornecedor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_7, InputEvent.SHIFT_MASK));
        this.menuItemConsultaMarca       = this.createMenuItem("Marca" , "search_marca.jpg");
        this.menuItemConsultaMarca.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_8, InputEvent.SHIFT_MASK));
        this.menuItemConsultaProduto     = this.createMenuItem("Produto"    , "search_produto.jpg");
        this.menuItemConsultaProduto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9, InputEvent.SHIFT_MASK));
        
        this.menuConsulta.add(this.menuItemConsultaUsuario);
        this.menuConsulta.add(this.menuItemConsultaFuncionario);
        this.menuConsulta.addSeparator();
        this.menuConsulta.add(this.menuItemConsultaCidade);
        this.menuConsulta.addSeparator();
        this.menuConsulta.add(this.menuItemConsultaDespesa);
        this.menuConsulta.addSeparator();
        this.menuConsulta.add(this.menuItemConsultaCliente);
        this.menuConsulta.addSeparator();
        this.menuConsulta.add(this.menuItemConsultaFornecedor);
        this.menuConsulta.add(this.menuItemConsultaMarca);
        this.menuConsulta.add(this.menuItemConsultaProduto);
    }
    
    /**
     * Metodo responsavel por criar o Menu de Operacoes ao Frame.
     * @since 24/12/2015
     */
    private void createMenuOperacoes() {
        this.menuOperacoes              = new JMenu("Operacoes");
        
        this.menuItemOperacoesRegistrarPedido     = this.createMenuItem("Registrar Pedido"     , "solicitar_pedido.jpg");
        this.menuItemOperacoesRegistrarPedido.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
        this.menuItemOperacoesChegadaPedido       = this.createMenuItem("Chegada Pedido"       , "chegada_pedido.jpg");
        this.menuItemOperacoesChegadaPedido.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
        this.menuItemOperacoesOrganizarHorario    = this.createMenuItem("Organizar Horarios"   , "organizar_horario.jpg");
        this.menuItemOperacoesOrganizarHorario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.ALT_MASK));
        this.menuItemOperacoesRealizarNotificacao = this.createMenuItem("Realizar Notificacoes", "realizar_notificacao.jpg");
        this.menuItemOperacoesRealizarNotificacao.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_MASK));
        this.menuItemOperacoesEfetuarVenda        = this.createMenuItem("Efetuar Venda"        , "efetuar_venda.jpg");
        this.menuItemOperacoesEfetuarVenda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.ALT_MASK));
        this.menuItemOperacoesEfetuarDevolucao    = this.createMenuItem("Efetuar Devolucao"    , "efetuar_devolucao.jpg");
        this.menuItemOperacoesEfetuarDevolucao.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_MASK));
        this.menuItemOperacoesGerenciarEncomenda  = this.createMenuItem("Gerenciar Encomenda"  , "gerenciar_encomenda.jpg");
        this.menuItemOperacoesGerenciarEncomenda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
        this.menuItemOperacoesGerenciarProduto    = this.createMenuItem("Gerenciar Produto"    , "gerenciar_produto.jpg");
        this.menuItemOperacoesGerenciarProduto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_MASK));
        this.menuItemOperacoesGerenciarUsuario    = this.createMenuItem("Gerenciar Usuario"    , "gerenciar_usuario.jpg");
        this.menuItemOperacoesGerenciarUsuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.ALT_MASK));
        
        this.menuOperacoes.add(this.menuItemOperacoesRegistrarPedido);
        this.menuOperacoes.add(this.menuItemOperacoesChegadaPedido);
        this.menuOperacoes.add(this.menuItemOperacoesOrganizarHorario);
        this.menuOperacoes.add(this.menuItemOperacoesRealizarNotificacao);
        this.menuOperacoes.add(this.menuItemOperacoesEfetuarVenda);
        this.menuOperacoes.add(this.menuItemOperacoesEfetuarDevolucao);
        this.menuOperacoes.add(this.menuItemOperacoesGerenciarEncomenda);
        this.menuOperacoes.add(this.menuItemOperacoesGerenciarProduto);
        this.menuOperacoes.add(this.menuItemOperacoesGerenciarUsuario);
    }
    
    /**
     * Metodo responsavel por criar o menu de relatorios ao Frame.
     * @since 14/10/2015
     */
    private void createMenuRelatorio() {
        this.menuRelatorios                         = new JMenu("Relatorios");
        
        this.menuItemRelatoriosProdutosMaisVendidos = this.createMenuItem("Produtos Mais Vendidos", "pdf.jpg");
        this.menuItemRelatoriosProdutosMaisVendidos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.SHIFT_MASK));
        this.menuItemRelatoriosProdutosEstoque      = this.createMenuItem("Produtos Em Estoque"   , "pdf.jpg");
        this.menuItemRelatoriosProdutosEstoque.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.SHIFT_MASK));
        this.menuItemRelatoriosFuncionarios         = this.createMenuItem("Funcionarios"          , "pdf.jpg");
        this.menuItemRelatoriosFuncionarios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.SHIFT_MASK));
        this.menuItemRelatoriosDespesa              = this.createMenuItem("Despesas"              , "pdf.jpg");
        this.menuItemRelatoriosDespesa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.SHIFT_MASK));
        
        this.menuRelatorios.add(this.menuItemRelatoriosProdutosMaisVendidos);
        this.menuRelatorios.addSeparator();
        this.menuRelatorios.add(this.menuItemRelatoriosProdutosEstoque);
        this.menuRelatorios.addSeparator();
        this.menuRelatorios.add(this.menuItemRelatoriosFuncionarios);
        this.menuRelatorios.addSeparator();
        this.menuRelatorios.add(this.menuItemRelatoriosDespesa);
    }
    
    /**
     * Metodo responsavel por criar o menu de sistema ao Frame.
     * @since 14/10/2015
     */
    private void createMenuSistema() {
        this.menuSistema                = new JMenu("Sistema");
        
        this.menuItemSistemaSobre       = this.createMenuItem("Sobre"       , "sistema_sobre.jpg");
        this.menuItemSistemaSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.SHIFT_MASK));
        this.menuItemSistemaTrocarSenha = this.createMenuItem("Trocar Senha", "sistema_password.jpg");
        this.menuItemSistemaTrocarSenha.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.SHIFT_MASK));
        this.menuItemSistemaLogoff      = this.createMenuItem("Logoff"      , "sistema_logoff.jpg");
        this.menuItemSistemaLogoff.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.SHIFT_MASK));
        this.menuItemSistemaSair        = this.createMenuItem("Sair"        , "sistema_sair.jpg");
        this.menuItemSistemaSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.SHIFT_MASK));
        
        this.menuSistema.add(this.menuItemSistemaSobre);
        this.menuSistema.addSeparator();
        this.menuSistema.add(this.menuItemSistemaTrocarSenha);
        this.menuSistema.addSeparator();
        this.menuSistema.add(this.menuItemSistemaLogoff);
        this.menuSistema.add(this.menuItemSistemaSair);
    }
    
    /**
     * Metodo responsavel por adicionar o logo ao Frame.
     * @since 14/10/2015
     */
    private void addLogo() {
        this.addLinhas(5);
        this.add(new JLabel(new FunctFrame().createImage("logo.jpg")));
        this.addLinhas(5);
    }

    public JMenuItem getMenuItemCadastroUsuario() {
        return this.menuItemCadastroUsuario;
    }

    public JMenuItem getMenuItemCadastroCidade() {
        return this.menuItemCadastroCidade;
    }

    public JMenuItem getMenuItemCadastroDespesa() {
        return this.menuItemCadastroDespesa;
    }

    public JMenuItem getMenuItemCadastroClienteFisico() {
        return this.menuItemCadastroClienteFisico;
    }

    public JMenuItem getMenuItemCadastroClienteJuridico() {
        return this.menuItemCadastroClienteJuridico;
    }

    public JMenuItem getMenuItemCadastroFornecedor() {
        return this.menuItemCadastroFornecedor;
    }

    public JMenuItem getMenuItemCadastroMarca() {
        return this.menuItemCadastroMarca;
    }

    public JMenuItem getMenuItemCadastroFuncionario() {
        return this.menuItemCadastroFuncionario;
    }

    public JMenuItem getMenuItemCadastroProduto() {
        return this.menuItemCadastroProduto;
    }

    public JMenuItem getMenuItemConsultaUsuario() {
        return this.menuItemConsultaUsuario;
    }

    public JMenuItem getMenuItemConsultaCidade() {
        return this.menuItemConsultaCidade;
    }

    public JMenuItem getMenuItemConsultaDespesa() {
        return this.menuItemConsultaDespesa;
    }

    public JMenuItem getMenuItemConsultaCliente() {
        return this.menuItemConsultaCliente;
    }

    public JMenuItem getMenuItemConsultaFornecedor() {
        return this.menuItemConsultaFornecedor;
    }

    public JMenuItem getMenuItemConsultaMarca() {
        return this.menuItemConsultaMarca;
    }
    
    public JMenuItem getMenuItemConsultaFuncionario() {
        return this.menuItemConsultaFuncionario;
    }

    public JMenuItem getMenuItemConsultaProduto() {
        return this.menuItemConsultaProduto;
    }
    
    public JMenuItem getMenuItemOperacoesRegistrarPedido() {
        return this.menuItemOperacoesRegistrarPedido;
    }

    public JMenuItem getMenuItemOperacoesChegadaPedido() {
        return this.menuItemOperacoesChegadaPedido;
    }

    public JMenuItem getMenuItemOperacoesOrganizarHorario() {
        return this.menuItemOperacoesOrganizarHorario;
    }

    public JMenuItem getMenuItemOperacoesRealizarNotificacao() {
        return this.menuItemOperacoesRealizarNotificacao;
    }

    public JMenuItem getMenuItemOperacoesEfetuarVenda() {
        return this.menuItemOperacoesEfetuarVenda;
    }

    public JMenuItem getMenuItemOperacoesEfetuarDevolucao() {
        return this.menuItemOperacoesEfetuarDevolucao;
    }

    public JMenuItem getMenuItemOperacoesGerenciarEncomenda() {
        return this.menuItemOperacoesGerenciarEncomenda;
    }

    public JMenuItem getMenuItemOperacoesGerenciarProduto() {
        return this.menuItemOperacoesGerenciarProduto;
    }

    public JMenuItem getMenuItemOperacoesGerenciarUsuario() {
        return this.menuItemOperacoesGerenciarUsuario;
    }

    public JMenuItem getMenuItemRelatoriosFuncionarios() {
        return this.menuItemRelatoriosFuncionarios;
    }

    public JMenuItem getMenuItemRelatoriosDespesa() {
        return this.menuItemRelatoriosDespesa;
    }

    public JMenuItem getMenuItemRelatoriosProdutosEstoque() {
        return this.menuItemRelatoriosProdutosEstoque;
    }

    public JMenuItem getMenuItemRelatoriosProdutosMaisVendidos() {
        return this.menuItemRelatoriosProdutosMaisVendidos;
    }
    
    public JMenuItem getMenuItemSistemaSobre() {
        return this.menuItemSistemaSobre;
    }

    public JMenuItem getMenuItemSistemaTrocarSenha() {
        return this.menuItemSistemaTrocarSenha;
    }

    public JMenuItem getMenuItemSistemaLogoff() {
        return this.menuItemSistemaLogoff;
    }

    public JMenuItem getMenuItemSistemaSair() {
        return this.menuItemSistemaSair;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }
}