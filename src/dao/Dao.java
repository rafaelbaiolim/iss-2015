/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 10/07/2015                                                         *
 * Classe: dao.Dao                                                            *
 * Coment: Classe responsavel pelas operacoes de persistencia das Entidades.  *
 *         Todas as Classes de Entidade possuem um Dao para conectar ao BD.   *
 * ========================================================================== */

package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Dao<Entidade> {
    protected static EntityManager acesso = Persistence.createEntityManagerFactory("UP").createEntityManager();
    protected final Class classe;
    
    public Dao(Class oClasse) {
        this.classe = oClasse;
    }
    
    /*
     * Grupo: Hadyne, Leandro, Rafael e Vanessa
     * Data.: 10/07/2015
     * [+] insert(Entidade) -> boolean
     * Metodo responsavel por inserir um Objeto no Banco de Dados.
     * Exemplos:
     *     [+] insert(Entidade) -> true
     *     [+] insert(null)     -> false
     */
    public boolean insert(Entidade oObjeto) {
        if (oObjeto != null) {
            acesso.getTransaction().begin();
                acesso.persist(oObjeto);
            acesso.getTransaction().commit();
            return true;
        }
        return false;
    }
    
    /*
     * Grupo: Hadyne, Leandro, Rafael e Vanessa
     * Data.: 10/07/2015
     * [+] update(Entidade) -> boolean
     * Metodo responsavel por atualizar um Objeto no Banco de Dados.
     * Exemplos:
     *     [+] update(Entidade) -> true
     *     [+] update(null)     -> false
     */
    public boolean update(Entidade oObjeto) {
        if (oObjeto != null) {
            acesso.getTransaction().begin();
                acesso.merge(oObjeto);
            acesso.getTransaction().commit();
            return true;
        }
        return false;
    }
    
    /*
     * Grupo: Hadyne, Leandro, Rafael e Vanessa
     * Data.: 10/07/2015
     * [+] remove(Long) -> boolean
     * Metodo responsavel por remover um Objeto no Banco de Dados.
     * Exemplos:
     *     [+] remove(-1L) -> false
     *     [+] remove(1L)  -> true
     */
    public boolean remove(Long lId) {
        Entidade oObjeto = this.get(lId);
        if (oObjeto != null) {
            acesso.getTransaction().begin();
                acesso.remove(oObjeto);
            acesso.getTransaction().commit();
            return true;
        }
        return false;
    }
    
    /*
     * Grupo: Hadyne, Leandro, Rafael e Vanessa
     * Data.: 10/07/2015
     * [+] get(Long) -> Entidade
     * Metodo responsavel por buscar um Objeto no Banco de Dados.
     * Caso nao encontre um Objeto pelo Id, retorna null.
     * Exemplos:
     *     [+] get(1L) -> Entidade
     *     [+] get(0L) -> null
     */
    public Entidade get(Long lId) {
        return (Entidade) acesso.find(this.classe, lId);
    }
    
    /*
     * Grupo: Hadyne, Leandro, Rafael e Vanessa
     * Data.: 10/07/2015
     * [+] list() -> List<Entidade>
     * Metodo responsavel por retornar uma Lista com os Objetos do Banco de Dados.
     */
    public List<Entidade> list() {
        return (List<Entidade>) acesso.createQuery("SELECT e FROM " + this.classe.getSimpleName() + " e").getResultList();
    }
    
    /*
     * Grupo: Hadyne, Leandro, Rafael e Vanessa
     * Data.: 10/07/2015
     * [+] size() -> int
     * Metodo responsavel por retornar o numero de Objetos presentes no Banco de Dados.
     */
    public int size() {
        return this.list().size();
    }
}