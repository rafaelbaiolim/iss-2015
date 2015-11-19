/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 06/08/2015                                                         *
 * Classe: visao.estruturais.FrameMenu                                        *
 * Coment: Classe de Interface com o Usuario.                                 *
 *         Classe responsavel pelo Frame de Menu do Sistema.                  *
 * ========================================================================== */

package visao.estruturais;

import modelo.internos.Usuario;
import visao.Frame;
import visao.cadastros.FrameCadastroCidade;
import visao.cadastros.FrameCadastroClienteFisico;
import visao.cadastros.FrameCadastroClienteJuridico;
import visao.cadastros.FrameCadastroDespesa;
import visao.cadastros.FrameCadastroFornecedor;
import visao.cadastros.FrameCadastroFuncionario;
import visao.cadastros.FrameCadastroProduto;
import visao.cadastros.FrameCadastroUsuario;
import visao.consultas.FrameConsultaCidade;
import visao.consultas.FrameConsultaCliente;
import visao.consultas.FrameConsultaDespesa;
import visao.consultas.FrameConsultaFornecedor;
import visao.consultas.FrameConsultaFuncionario;
import visao.consultas.FrameConsultaProduto;
import visao.consultas.FrameConsultaUsuario;
import visao.operacoes.FrameOperacoesEfetuarDevolucao;
import visao.operacoes.FrameOperacoesEfetuarVenda;
import visao.operacoes.FrameOperacoesExibirFluxoDeCaixa;
import visao.operacoes.FrameOperacoesGerenciarEncomendas;
import visao.operacoes.FrameOperacoesGerenciarProduto;
import visao.operacoes.FrameOperacoesGerenciarUsuario;
import visao.operacoes.FrameOperacoesOrganizarHorarios;
import visao.operacoes.FrameOperacoesRealizarNotificacoes;
import visao.operacoes.FrameOperacoesRegistrarEntrada;
import visao.operacoes.FrameOperacoesRegistrarPedido;
import visao.sobre.FrameLogoff;
import visao.sobre.FrameSair;
import visao.sobre.FrameSobre;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public final class FrameMenu extends Frame {
    private JPanel    oPanel;
    
    private JMenuBar  oMenuBar;
    
    private JMenu     oMenuCadastros;
    private JMenu     oMenuConsultas;
    private JMenu     oMenuOperacoes;
    private JMenu     oMenuUtilitarios;
    
    // Menu Cadastros:
    private JMenuItem oMenuItemCadastrosCidade;
    private JMenuItem oMenuItemCadastrosClienteFisico;
    private JMenuItem oMenuItemCadastrosClienteJuridico;
    private JMenuItem oMenuItemCadastrosProduto;
    private JMenuItem oMenuItemCadastrosDespesa;
    private JMenuItem oMenuItemCadastrosFornecedor;
    private JMenuItem oMenuItemCadastrosFuncionario;
    private JMenuItem oMenuItemCadastrosUsuario;
    
    // Menu Consultas:
    private JMenuItem oMenuItemConsultasCidade;
    private JMenuItem oMenuItemConsultasCliente;
    private JMenuItem oMenuItemConsultasProduto;
    private JMenuItem oMenuItemConsultasDespesa;
    private JMenuItem oMenuItemConsultasFornecedor;
    private JMenuItem oMenuItemConsultasFuncionario;
    private JMenuItem oMenuItemConsultasUsuario;
        
    // Menu Operacoes:
    private JMenuItem oMenuItemOperacoesRegistrarPedido;
    private JMenuItem oMenuItemOperacoesRegistrarEntrada;
    private JMenuItem oMenuItemOperacoesEfetuarVenda;
    private JMenuItem oMenuItemOperacoesEfetuarDevolucao;
    private JMenuItem oMenuItemOperacoesGerenciarEncomenda;
    private JMenuItem oMenuItemOperacoesOrganizarHorarios;
    private JMenuItem oMenuItemOperacoesRealizarNotificacoes;
    private JMenuItem oMenuItemOperacoesGerenciarProduto;
    private JMenuItem oMenuItemOperacoesGerenciarUsuario;
    private JMenuItem oMenuItemOperacoesFluxoDeCaixa;
    
    // Menu Utilitarios:
    private JMenuItem oMenuItemUtilitariosSobre;
    private JMenuItem oMenuItemUtilitariosLogoff;
    private JMenuItem oMenuItemUtilitariosSair;
    
    
    private final Usuario oUsuario;
    
    public FrameMenu(Usuario oUsuario) {
        super();
        this.oUsuario = oUsuario;
        this.initComponents();
    }
   
    @Override
    public void initComponents() {
        this.setTitle("Mercado - Menu");
        this.addComponents();
    }

    @Override
    public void addComponents() {
        this.addLine(5);
        this.addHeader();
        this.add(new JLabel(this.createImage("logo.jpg")));
    }
    
    @Override
    public void addHeader() {
        this.oPanel   = new JPanel();
        this.oMenuBar = new JMenuBar();
        
        this.addMenuCadastros();
        this.addMenuConsultas();
        this.addMenuOperacoes();
        this.addMenuUtilitarios();
        
        this.oMenuBar.add(this.oMenuCadastros);
        this.oMenuBar.add(this.oMenuConsultas);
        this.oMenuBar.add(this.oMenuOperacoes);
        this.oMenuBar.add(this.oMenuUtilitarios);
        
        this.setJMenuBar(this.oMenuBar);
        this.getContentPane().add(this.oPanel);
    }
    
    private void addMenuCadastros() {
        this.oMenuCadastros = new JMenu("Cadastros");
        
        this.oMenuItemCadastrosCidade          = this.createMenuItem("Cidade"          , "icone_cidade.jpg");
        this.oMenuItemCadastrosClienteFisico   = this.createMenuItem("Cliente Físico"  , "icone_cliente_fisico.jpg");
        this.oMenuItemCadastrosClienteJuridico = this.createMenuItem("Cliente Jurídico", "icone_cliente_juridico.jpg");
        this.oMenuItemCadastrosProduto         = this.createMenuItem("Produto"         , "icone_produto.jpg");
        this.oMenuItemCadastrosDespesa         = this.createMenuItem("Despesa"         , "icone_despesa.jpg");
        this.oMenuItemCadastrosFornecedor      = this.createMenuItem("Fornecedor"      , "icone_fornecedor.jpg");
        this.oMenuItemCadastrosFuncionario     = this.createMenuItem("Funcionário"     , "icone_funcionario.jpg");
        this.oMenuItemCadastrosUsuario         = this.createMenuItem("Usuário"         , "icone_usuario.jpg");
        
        this.oMenuCadastros.add(this.oMenuItemCadastrosCidade);
        this.oMenuCadastros.add(this.oMenuItemCadastrosClienteFisico);
        this.oMenuCadastros.add(this.oMenuItemCadastrosClienteJuridico);
        this.oMenuCadastros.add(this.oMenuItemCadastrosProduto);
        this.oMenuCadastros.add(this.oMenuItemCadastrosDespesa);
        this.oMenuCadastros.add(this.oMenuItemCadastrosFornecedor);
        this.oMenuCadastros.add(this.oMenuItemCadastrosFuncionario);
        this.oMenuCadastros.add(this.oMenuItemCadastrosUsuario);
    }
    
    private void addMenuConsultas() {
        this.oMenuConsultas = new JMenu("Consultas");
        
        this.oMenuItemConsultasCidade      = this.createMenuItem("Cidade"     , "icone_cidade.jpg");
        this.oMenuItemConsultasCliente     = this.createMenuItem("Cliente"    , "icone_cliente_fisico.jpg");
        this.oMenuItemConsultasProduto     = this.createMenuItem("Produto"    , "icone_produto.jpg");
        this.oMenuItemConsultasDespesa     = this.createMenuItem("Despesa"    , "icone_despesa.jpg");
        this.oMenuItemConsultasFornecedor  = this.createMenuItem("Fornecedor" , "icone_fornecedor.jpg");
        this.oMenuItemConsultasFuncionario = this.createMenuItem("Funcionario", "icone_funcionario.jpg");
        this.oMenuItemConsultasUsuario     = this.createMenuItem("Usuario"    , "icone_usuario.jpg");
        
        this.oMenuConsultas.add(this.oMenuItemConsultasCidade);
        this.oMenuConsultas.add(this.oMenuItemConsultasCliente);
        this.oMenuConsultas.add(this.oMenuItemConsultasProduto);
        this.oMenuConsultas.add(this.oMenuItemConsultasDespesa);
        this.oMenuConsultas.add(this.oMenuItemConsultasFornecedor);
        this.oMenuConsultas.add(this.oMenuItemConsultasFuncionario);
        this.oMenuConsultas.add(this.oMenuItemConsultasUsuario);
    }

    private void addMenuOperacoes() {
        this.oMenuOperacoes = new JMenu("Operacoes");
        
        this.oMenuItemOperacoesRegistrarPedido      = this.createMenuItem("Registrar Pedido"     , "registrar_pedido.jpg");    
        this.oMenuItemOperacoesRegistrarEntrada     = this.createMenuItem("Registrar Entrada"    , "registrar_entrada.jpg");
        this.oMenuItemOperacoesEfetuarVenda         = this.createMenuItem("Efetuar Venda"        , "efetuar_venda.jpg");
        this.oMenuItemOperacoesEfetuarDevolucao     = this.createMenuItem("Efetuar Devolucao"    , "efetuar_devolucao.jpg");
        this.oMenuItemOperacoesGerenciarEncomenda   = this.createMenuItem("Gerenciar Encomenda"  , "gerenciar_encomenda.jpg");
        this.oMenuItemOperacoesOrganizarHorarios    = this.createMenuItem("Organizar Horarios"   , "organizar_horarios.jpg");
        this.oMenuItemOperacoesRealizarNotificacoes = this.createMenuItem("Realizar Notificacoes", "realizar_notificacoes.jpg");
        this.oMenuItemOperacoesGerenciarProduto     = this.createMenuItem("Gerenciar Produto"    , "icone_produto.jpg");
        this.oMenuItemOperacoesGerenciarUsuario     = this.createMenuItem("Gerenciar Usuario"    , "icone_usuario.jpg");
        this.oMenuItemOperacoesFluxoDeCaixa         = this.createMenuItem("Fluxo de Caixa"       , "fluxo_caixa.jpg");
        
        
        this.oMenuOperacoes.add(this.oMenuItemOperacoesRegistrarPedido);
        this.oMenuOperacoes.add(this.oMenuItemOperacoesRegistrarEntrada);
        this.oMenuOperacoes.add(this.oMenuItemOperacoesEfetuarVenda);
        this.oMenuOperacoes.add(this.oMenuItemOperacoesEfetuarDevolucao);
        this.oMenuOperacoes.add(this.oMenuItemOperacoesGerenciarEncomenda);
        this.oMenuOperacoes.add(this.oMenuItemOperacoesOrganizarHorarios);
        this.oMenuOperacoes.add(this.oMenuItemOperacoesRealizarNotificacoes);
        this.oMenuOperacoes.add(this.oMenuItemOperacoesGerenciarProduto);
        this.oMenuOperacoes.add(this.oMenuItemOperacoesGerenciarUsuario);
        this.oMenuOperacoes.add(this.oMenuItemOperacoesFluxoDeCaixa);
    }
    
    private void addMenuUtilitarios() {
        this.oMenuUtilitarios = new JMenu("Utilitarios");
        
        this.oMenuItemUtilitariosSobre  = this.createMenuItem("Sobre" , "sobre.jpg");    
        this.oMenuItemUtilitariosLogoff = this.createMenuItem("Logoff", "trocar_usuario.jpg");
        this.oMenuItemUtilitariosSair   = this.createMenuItem(" Sair ", "sair.jpg");
        
        this.oMenuUtilitarios.add(this.oMenuItemUtilitariosSobre);
        this.oMenuUtilitarios.addSeparator();
        this.oMenuUtilitarios.add(this.oMenuItemUtilitariosLogoff);
        this.oMenuUtilitarios.add(this.oMenuItemUtilitariosSair);
    }
    
    @Override
    public void addButtons() {}

    @Override
    public void clear() {}
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oMenuItemCadastrosCidade)) {
            new FrameCadastroCidade(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemCadastrosClienteFisico)) {
            new FrameCadastroClienteFisico(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemCadastrosClienteJuridico)) {
            new FrameCadastroClienteJuridico(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemCadastrosProduto)) {
            new FrameCadastroProduto(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemCadastrosDespesa)) {
            new FrameCadastroDespesa(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemCadastrosFornecedor)) {
            new FrameCadastroFornecedor(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemCadastrosFuncionario)) {
            new FrameCadastroFuncionario(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemCadastrosUsuario)) {
            new FrameCadastroUsuario(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemConsultasCidade)) {
            new FrameConsultaCidade(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemConsultasCliente)) {
            new FrameConsultaCliente(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemConsultasProduto)) {
            new FrameConsultaProduto(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemConsultasDespesa)) {
            new FrameConsultaDespesa(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemConsultasFornecedor)) {
            new FrameConsultaFornecedor(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemConsultasFuncionario)) {
            new FrameConsultaFuncionario(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemConsultasUsuario)) {
            new FrameConsultaUsuario(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemOperacoesRegistrarPedido)) {
            new FrameOperacoesRegistrarPedido(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemOperacoesRegistrarEntrada)) {
            new FrameOperacoesRegistrarEntrada(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemOperacoesEfetuarVenda)) {
            new FrameOperacoesEfetuarVenda(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemOperacoesEfetuarDevolucao)) {
            new FrameOperacoesEfetuarDevolucao(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemOperacoesGerenciarEncomenda)) {
            new FrameOperacoesGerenciarEncomendas(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemOperacoesOrganizarHorarios)) {
            new FrameOperacoesOrganizarHorarios(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemOperacoesRealizarNotificacoes)) {
            new FrameOperacoesRealizarNotificacoes(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemOperacoesGerenciarProduto)) {
            new FrameOperacoesGerenciarProduto(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemOperacoesGerenciarUsuario)) {
            new FrameOperacoesGerenciarUsuario(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemOperacoesFluxoDeCaixa)) {
            new FrameOperacoesExibirFluxoDeCaixa(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemUtilitariosSobre)) {
            new FrameSobre(this).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemUtilitariosLogoff)) {
            new FrameLogoff(this, this.oUsuario).setVisible(true);
        }else if (oEvento.getSource().equals(this.oMenuItemUtilitariosSair)) {
            new FrameSair(this, this.oUsuario).setVisible(true);
        }
    }
}