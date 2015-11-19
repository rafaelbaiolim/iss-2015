/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 20/07/2015                                                         *
 * Classe: dao.modelo.internos.DaoAcesso                                      *
 * Coment: Classe responsavel pelas operacoes entre a Classe de Entidade      *
 *         Acesso e o Banco de Dados.                                         *
 * ========================================================================== */

package dao.modelo.internos;

import dao.Dao;
import modelo.internos.Acesso;
import modelo.internos.Usuario;
import java.util.ArrayList;
import java.util.List;

public class DaoAcesso extends Dao<Acesso> {
    
    public DaoAcesso() {
        super(Acesso.class);
    }
    
    public List<Acesso> getAcessosByUsuario(Usuario oUsuario) {
        List<Acesso> oAcessos          = this.list();
        List<Acesso> oAcessosByUsuario = new ArrayList<>();
        if (oAcessos.isEmpty() == false) {
            for (Acesso oCurrentAcesso : oAcessos) {
                if (oCurrentAcesso.getUsuario().equals(oUsuario)) {
                    oAcessosByUsuario.add(oCurrentAcesso);
                }
            }
        }
        return oAcessosByUsuario;
    }
}