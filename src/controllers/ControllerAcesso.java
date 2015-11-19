/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 17/06/2015                                                         *
 * Classe: controllers.ControllerAcesso                                       *
 * Coment: Classe responsavel pelas regras de negocios da Classe de Entidade  *
 *         Acesso.                                                            *
 * ========================================================================== */

package controllers;

import dao.modelo.internos.DaoAcesso;
import dao.modelo.internos.DaoOperacao;
import modelo.internos.Acesso;
import modelo.internos.Usuario;
import java.util.List;

public class ControllerAcesso {
    private static DaoAcesso   oDaoAcesso   = new DaoAcesso();
    private static DaoOperacao oDaoOperacao = new DaoOperacao();
    
    public static void registrarAcesso(Usuario oUsuario) {
        oDaoAcesso.insert(new Acesso("LOGIN NO SISTEMA", oDaoOperacao.getOperacaoByDescricao("LOGIN"), oUsuario));
    }
    
    public static void registrarLogoff(Usuario oUsuario) {
        oDaoAcesso.insert(new Acesso("LOGOFF NO SISTEMA", oDaoOperacao.getOperacaoByDescricao("LOGOFF"), oUsuario));
    }
    
    public static void registrarSaida(Usuario oUsuario) {
        oDaoAcesso.insert(new Acesso("LOGOFF NO SISTEMA", oDaoOperacao.getOperacaoByDescricao("LOGOFF"), oUsuario));
        oDaoAcesso.insert(new Acesso("SAIDA DO SISTEMA" , oDaoOperacao.getOperacaoByDescricao("SAIR")  , oUsuario));
    }
    
    public static List<Acesso> getAcessos(Usuario oUsuario) {
        return oDaoAcesso.getAcessosByUsuario(oUsuario);
    }
}