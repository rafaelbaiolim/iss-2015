/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 20/07/2015                                                         *
 * Classe: dao.modelo.internos.DaoUsuario                                     *
 * Coment: Classe responsavel pelas operacoes entre a Classe de Entidade      *
 *         Usuario e o Banco de Dados.                                        *
 * ========================================================================== */

package dao.modelo.internos;

import dao.Dao;
import dao.modelo.gerenciais.DaoFuncionario;
import modelo.internos.Usuario;
import java.util.List;

public class DaoUsuario extends Dao<Usuario> {
    
    public DaoUsuario() {
        super(Usuario.class);
        this.loadUsuarios();
    }

    private void loadUsuarios() {
        if (this.size() == 0) {
            this.insert(new Usuario("adm"     , "root"    , true , new DaoFuncionario().getFuncionarioByCpf("00000000000")));
            this.insert(new Usuario("vendedor", "vendedor", false, new DaoFuncionario().getFuncionarioByCpf("11111111111")));
        }
    }
    
    public Usuario getUsuarioByLogin(String sLogin) {
        List<Usuario> oUsuarios = this.list();
        if (oUsuarios.isEmpty() == false) {
            for (Usuario oCurrentUsuario : oUsuarios) {
                if (oCurrentUsuario.getLogin().equals(sLogin)) {
                    return oCurrentUsuario;
                }
            }
        }
        return null;
    }
    
    public List<Usuario> getUsuariosByLogin(String sLogin) {
        return acesso.createQuery("SELECT e FROM Usuario e WHERE e.login LIKE '%" + sLogin.toUpperCase() + "%'").getResultList();
    }
}