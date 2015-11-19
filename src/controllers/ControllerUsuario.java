/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 17/06/2015                                                         *
 * Classe: controllers.ControllerUsuario                                      *
 * Coment: Classe responsavel pelas regras de negocios da Classe de Entidade  *
 *         Usuario.                                                           *
 * ========================================================================== */

package controllers;

import dao.modelo.internos.DaoAcesso;
import dao.modelo.internos.DaoOperacao;
import dao.modelo.internos.DaoUsuario;
import modelo.gerenciais.Funcionario;
import modelo.internos.Acesso;
import modelo.internos.Usuario;
import java.util.List;

public class ControllerUsuario {
    private static DaoUsuario oDaoUsuario = new DaoUsuario();
    
    public static boolean checkLogin(String sLogin) {
        return sLogin.length() > 1;
    }
    
    public static boolean loginIsAble(String sLogin) {
        return oDaoUsuario.getUsuarioByLogin(sLogin) == null;
    }
    
    public static Usuario getUsuario(String sLogin) {
        return oDaoUsuario.getUsuarioByLogin(sLogin);
    }
    
    public static List<Usuario> getUsuariosByLogin(String sLogin) {
        return oDaoUsuario.getUsuariosByLogin(sLogin);
    }
    
    public static String[][] getUsuarios(List<Usuario> oUsuarios) {
        String[][] sUsuarios = new String[oUsuarios.size()][2];
        for (int i = 0; i < oUsuarios.size(); ++i) {
            sUsuarios[i][0] = oUsuarios.get(i).getLogin();
            sUsuarios[i][1] = oUsuarios.get(i).getFuncionario().getNome();
        }
        return sUsuarios;
    }
    
    public static void adicionar(String sLogin, String sSenha1, boolean bAdm, Funcionario oFuncionario, Usuario oUsuario) {
        Usuario oUsuarioAdd = new Usuario(sLogin, sSenha1, bAdm, oFuncionario);
        oDaoUsuario.insert(oUsuarioAdd);
        new DaoAcesso().insert(new Acesso("Usuario = " + oUsuarioAdd.toString(), new DaoOperacao().getOperacaoByDescricao("CADASTRO DE USUARIO"), oUsuario));
        
    }
    
    public static void remover(Usuario oUsuarioRemove, Usuario oUsuario) {
        new DaoAcesso().insert(new Acesso("Usuario = " + oUsuarioRemove.toString(), new DaoOperacao().getOperacaoByDescricao("REMOCAO DE USUARIO"), oUsuario));
        oDaoUsuario.remove(oUsuarioRemove.getId());
    }
    
    public static void gravar(Usuario oUsuarioUpdate, String sLogin, String sSenha1, boolean bAdm, boolean bAtivo, Funcionario oFuncionario, Usuario oUsuario) {
        oUsuarioUpdate.setLogin(sLogin);
        oUsuarioUpdate.setSenha(sSenha1);
        oUsuarioUpdate.setAdm(bAdm);
        oUsuarioUpdate.setAtivo(bAtivo);
        oUsuarioUpdate.setFuncionario(oFuncionario);
        oDaoUsuario.update(oUsuarioUpdate);
        new DaoAcesso().insert(new Acesso("Usuario = " + oUsuarioUpdate.toString(), new DaoOperacao().getOperacaoByDescricao("ALTERACAO DE USUARIO"), oUsuario));
    }
}