package modelo.dao.estruturais;

import modelo.dao.Dao;
import java.util.List;
import modelo.estruturais.Usuario;

/**
 * <p>
 * Classe responsavel pelas operacoes entre a Classe de Entidade <b>Usuario</b>
 * e a Persitencia.</p>
 *
 * @author Leandro
 * @version 1.0
 * @since 30/10/2015
 * @see modelo.dao.Dao
 * @see modelo.estruturais.Usuario
 */
public class DaoUsuario extends Dao<Usuario> {

    /**
     * Metodo estatico responsavel para utilização dos testes de CRUD
     *
     * @return Usuario teste.
     */
    public static Usuario getUsuarioTeste(String sLogin) {
        String sSql = "SELECT e FROM Usuario e WHERE e.login LIKE '" + sLogin + "'";
        List<Usuario> oUsuarios = (List<Usuario>) acesso.createQuery(sSql).getResultList();
        return (oUsuarios.isEmpty() == true) ? null : oUsuarios.get(0);
    }

    /**
     * <p>
     * Metodo construtor padrão.</p>
     * <p>
     * Define a Classe de Entidade Usuario como Entidade da superclasse Dao.</p>
     */
    public DaoUsuario() {
        super(Usuario.class);
    }

    /**
     * Metodo responsavel por retornar um Usuario pelo login.
     *
     * @param sLogin Login do Usuario.
     * @return Usuario encontrado.
     */
    public Usuario findUsuarioByLogin(String sLogin) {
        String sSql = "SELECT e FROM Usuario e WHERE e.login LIKE '" + sLogin + "'";
        List<Usuario> oUsuarios = (List<Usuario>) acesso.createQuery(sSql).getResultList();
        return (oUsuarios.isEmpty() == true) ? null : oUsuarios.get(0);
    }

    /**
     * Metodo responsavel por retornar um Usuario com um Id diferente.
     *
     * @param sLogin Login do Usuario.
     * @param lId Id do Usuario.
     * @return Usuario encontrado.
     */
    public Usuario findUsuarioByLogin(String sLogin, Long lId) {
        String sSql = "SELECT e FROM Usuario e WHERE e.login LIKE '" + sLogin + "' ";
        sSql += "AND e.id <> " + lId;
        List<Usuario> oUsuarios = (List<Usuario>) acesso.createQuery(sSql).getResultList();
        return (oUsuarios.isEmpty() == true) ? null : oUsuarios.get(0);
    }

    /**
     * Metodo responsavel por retornar uma lista de Usuarios pelo login.
     *
     * @param sLogin Login dos Usuarios.
     * @return Lista de Usuarios encontrados.
     */
    public List<Usuario> findUsuariosByLogin(String sLogin) {
        String sSql = "SELECT e FROM Usuario e WHERE e.login LIKE '%" + sLogin + "%'";
        List<Usuario> oUsuarios = acesso.createQuery(sSql).getResultList();
        return oUsuarios;
    }

    /**
     * Metodo responsavel por retornar uma Matriz com os elementos principais
     * dos Usuarios.
     *
     * @param oUsuarios Listas de Usuarios a serem listados.
     * @return Matriz com os dados dos Usuarios.
     */
    public String[][] getUsuarios(List<Usuario> oUsuarios) {
        String[][] sUsuarios = new String[oUsuarios.size()][3];
        for (int i = 0; i < oUsuarios.size(); ++i) {
            sUsuarios[i] = oUsuarios.get(i).getInfo();
        }
        return sUsuarios;
    }
}
