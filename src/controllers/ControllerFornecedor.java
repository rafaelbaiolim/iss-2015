/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 17/06/2015                                                         *
 * Classe: controllers.ControllerFornecedor                                   *
 * Coment: Classe responsavel pelas regras de negocios da Classe de Entidade  *
 *         Fornecedor.                                                        *
 * ========================================================================== */

package controllers;

import dao.modelo.gerenciais.DaoFornecedor;
import dao.modelo.internos.DaoAcesso;
import dao.modelo.internos.DaoOperacao;
import modelo.gerenciais.Fornecedor;
import modelo.internos.Acesso;
import modelo.internos.Usuario;
import java.util.List;

public class ControllerFornecedor {
    private static DaoFornecedor oDaoFornecedor = new DaoFornecedor();
    
    public static boolean nomeIsAble(String sNome) {
        return (sNome.trim().length() > 3);
    }
    
    public static boolean checkNome(String sNome) {
        return (oDaoFornecedor.getFornecedorByNome(sNome) == null);
    }
    
    public static boolean cnpjIsAble(String sCnpj) {
        return sCnpj.length() == 14;
    }
    
    public static boolean checkCnpj(String sCnpj) {
        return (oDaoFornecedor.getFornecedorByCNPJ(sCnpj) == null);
    }
    
    public static List<Fornecedor> getFornecedoresByNome(String sNome) {
        return oDaoFornecedor.getFornecedoresByNome(sNome);
    }
    
    public static String[][] getFornecedores(List<Fornecedor> oFornecedores) {
        String[][] sFornecedores = new String[oFornecedores.size()][2];
        for (int i = 0; i < oFornecedores.size(); ++i) {
            sFornecedores[i][0] = oFornecedores.get(i).getNome();
            sFornecedores[i][1] = oFornecedores.get(i).getCnpj();
        }
        return sFornecedores;
    }
    
    public static void adicionar(String sNome, String sCnpj, String sTelefone, Usuario oUsuario) {
        Fornecedor oFornecedor = new Fornecedor(sNome, sCnpj, sTelefone);
        oDaoFornecedor.insert(oFornecedor);
        new DaoAcesso().insert(new Acesso("Fornecedor = " + oFornecedor.toString(), new DaoOperacao().getOperacaoByDescricao("CADASTRO DE FORNECEDOR"), oUsuario));
    }
    
    public static void gravar(Fornecedor oFornecedor, String sNome, String sCnpj, String sTelefone, Usuario oUsuario) {
        oFornecedor.setNome(sNome);
        oFornecedor.setCnpj(sCnpj);
        oFornecedor.setTelefone(sTelefone);
        oDaoFornecedor.update(oFornecedor);
        new DaoAcesso().insert(new Acesso("Fornecedor = " + oFornecedor.toString(), new DaoOperacao().getOperacaoByDescricao("ALTERACAO DE FORNECEDOR"), oUsuario));
    }
    
    public static void remover(Fornecedor oFornecedor, Usuario oUsuario) {
        oDaoFornecedor.remove(oFornecedor.getId());
        new DaoAcesso().insert(new Acesso("Fornecedor = " + oFornecedor.toString(), new DaoOperacao().getOperacaoByDescricao("REMOCAO DE FORNECEDOR"), oUsuario));
    }
    
}