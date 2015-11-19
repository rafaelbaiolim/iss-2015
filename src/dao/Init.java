/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 10/07/2015                                                         *
 * Classe: dao.Init                                                           *
 * Coment: Classe responsavel por carregar informacaoes basicas antes da      *
 *         Execucao da Aplicacao.                                             *
 * ========================================================================== */

package dao;

import dao.modelo.cadastrais.DaoClienteFisico;
import dao.modelo.cadastrais.DaoClienteJuridico;
import dao.modelo.cadastrais.DaoProduto;
import dao.modelo.estruturais.DaoCidade;
import dao.modelo.estruturais.DaoUF;
import dao.modelo.gerenciais.DaoFornecedor;
import dao.modelo.gerenciais.DaoFuncionario;
import dao.modelo.internos.DaoOperacao;
import dao.modelo.internos.DaoUsuario;
import modelo.cadastrais.ClienteFisico;
import modelo.cadastrais.ClienteJuridico;
import modelo.cadastrais.Produto;
import modelo.gerenciais.Fornecedor;
import modelo.gerenciais.Funcionario;

public class Init {
    public static void initDados() {
        new DaoFuncionario().insert(new Funcionario("00000000000", "MARIA GERENTE"));
        new DaoFuncionario().insert(new Funcionario("11111111111", "JOAO VENDEDOR"));
        new DaoUsuario();
        new DaoOperacao();
        new DaoUF();
        new DaoCidade();
        new DaoClienteFisico().insert(new ClienteFisico("55555555555", "1717226", "PAULO LIMA", 'M', null));
        new DaoClienteJuridico().insert(new ClienteJuridico("48769656456485", "PREFEITURA DE MARINGA", "PREFEITURA", "JOAO DA SILVA"));
        new DaoProduto().insert(new Produto("PRODUTO 1", "MARCA A", "100ml",  5, 3.52f));
        new DaoProduto().insert(new Produto("PRODUTO 2", "MARCA B", "300ml", 15, 4.20f));
        new DaoProduto().insert(new Produto("PRODUTO 3", "MARCA A", "500ml", 20, 8.22f));
        new DaoFornecedor().insert(new Fornecedor("FORNECEDOR 1", "0000000000000", "(44)3501-0101"));
        new DaoFornecedor().insert(new Fornecedor("FORNECEDOR 2", "1111111111111", "(44)3502-0202"));
        new DaoFornecedor().insert(new Fornecedor("FORNECEDOR 3", "2222222222222", "(44)3503-0303"));
    }
    
    
    public static void main(String[] args) {
        Init.initDados();
    }
}