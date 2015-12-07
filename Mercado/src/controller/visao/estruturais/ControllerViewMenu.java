package controller.visao.estruturais;

import java.awt.event.ActionEvent;
import controller.visao.ControllerView;
import java.awt.event.KeyEvent;
import visao.cadastro.ViewCadastroCidade;
import visao.cadastro.ViewCadastroClienteFisico;
import visao.cadastro.ViewCadastroClienteJuridico;
import visao.cadastro.ViewCadastroDespesa;
import visao.cadastro.ViewCadastroFornecedor;
import visao.cadastro.ViewCadastroFuncionario;
import visao.cadastro.ViewCadastroMarca;
import visao.cadastro.ViewCadastroProduto;
import visao.cadastro.ViewCadastroUsuario;
import visao.consulta.ViewConsultaCidade;
import visao.consulta.ViewConsultaCliente;
import visao.consulta.ViewConsultaDespesa;
import visao.consulta.ViewConsultaFornecedor;
import visao.consulta.ViewConsultaFuncionario;
import visao.consulta.ViewConsultaMarca;
import visao.consulta.ViewConsultaProduto;
import visao.consulta.ViewConsultaUsuario;
import visao.estruturais.ViewMenu;
import visao.sistema.ViewSistemaLogoff;
import visao.sistema.ViewSistemaSair;
import visao.sistema.ViewSistemaSobre;
import visao.sistema.ViewSistemaTrocarSenha;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewMenu.
 * @author  Leandro
 * @version 1.0
 * @since   13/10/2015
 * @see     controller.visao.ControllerView
 */
public class ControllerViewMenu extends ControllerView {
    private final ViewMenu viewMenu;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewMenu(ViewMenu oView) {
        super(oView);
        this.viewMenu = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.viewMenu.getMenuItemCadastroUsuario())) {
            new ViewCadastroUsuario(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemCadastroFuncionario())) {
            new ViewCadastroFuncionario(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemCadastroCidade())) {
            new ViewCadastroCidade(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemCadastroDespesa())) {
            new ViewCadastroDespesa(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemCadastroClienteFisico())) {
            new ViewCadastroClienteFisico(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemCadastroClienteJuridico())) {
            new ViewCadastroClienteJuridico(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemCadastroFornecedor())) {
            new ViewCadastroFornecedor(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemCadastroMarca())) {
            new ViewCadastroMarca(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemCadastroProduto())) {
            new ViewCadastroProduto(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemConsultaUsuario())) {
            new ViewConsultaUsuario(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemConsultaFuncionario())) {
            new ViewConsultaFuncionario(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemConsultaCidade())) {
            new ViewConsultaCidade(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemConsultaDespesa())) {
            new ViewConsultaDespesa(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemConsultaCliente())) {
            new ViewConsultaCliente(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemConsultaFornecedor())) {
            new ViewConsultaFornecedor(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemConsultaMarca())) {
            new ViewConsultaMarca(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemConsultaProduto())) {
            new ViewConsultaProduto(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemSistemaSobre())) {
            new ViewSistemaSobre(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemSistemaTrocarSenha())) {
            new ViewSistemaTrocarSenha(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemSistemaLogoff())) {
            new ViewSistemaLogoff(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemSistemaSair())) {
            new ViewSistemaSair(this.viewMenu).setVisible(true);
        }
    }
    
    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        if (oKeyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
            new ViewSistemaSair(this.viewMenu).setVisible(true);
        }else if (oKeyEvent.getKeyCode() == KeyEvent.VK_F9) {
            new ViewSistemaSobre(this.viewMenu).setVisible(true);
        }else if (oKeyEvent.getKeyCode() == KeyEvent.VK_F10) {
            new ViewSistemaTrocarSenha(this.viewMenu).setVisible(true);
        }else if (oKeyEvent.getKeyCode() == KeyEvent.VK_F11) {
            new ViewSistemaLogoff(this.viewMenu).setVisible(true);
        }else if (oKeyEvent.getKeyCode() == KeyEvent.VK_F12) {
            new ViewSistemaSair(this.viewMenu).setVisible(true);
        }
    }
}