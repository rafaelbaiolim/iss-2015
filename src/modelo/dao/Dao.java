package modelo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * <p>Classe responsavel pelas operacoes envolvendo a Persistencia de Dados.</p>
 * <p>Superclasse utilizada de modelo para as Classes de Entidade.</p>
 * @author  Leandro
 * @version 1.0
 * @since   06/10/2015
 * @param   <Entidade> Classe de Entidade
 */
public class Dao<Entidade> {
    protected static EntityManager acesso = Persistence.createEntityManagerFactory("UP").createEntityManager();
    private final Class classe;
    
    /**
     * Metodo construtor da Classe.
     * @param oClasse Classe a ser mapeada no Banco de Dados.
     */
    public Dao(Class oClasse) {
        this.classe = oClasse;
    }
    
    /**
     * Metodo responsavel por inserir um Objeto no Banco de Dados.
     * @version 1.0
     * @since   06/10/2015
     * @param   oObjeto Objeto a ser persistido.
     * @return  boolean
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
    
    /**
     * Metodo responsavel por atualizar um Objeto no Banco de Dados.
     * @version 1.0
     * @since   06/10/2015
     * @param   oObjeto Objeto a ser atualizado.
     * @return  boolean
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
    
    /**
     * Metodo responsavel por remover um Objeto do Banco de Dados.
     * @version 1.0
     * @since   06/10/2015
     * @param   lId Id do Objeto a ser removido.
     * @return  boolean
     */
    public boolean remove(Long lId) {
        Entidade oObjetoEnc = this.get(lId);
        if (oObjetoEnc != null) {
            acesso.getTransaction().begin();
                acesso.remove(oObjetoEnc);
            acesso.getTransaction().commit();
            return true;
        }
        return false;
    }
    
    /**
     * Metodo responsavel por buscar um Objeto no Banco de Dados pela sua chave primaria.
     * @version 1.0
     * @since   06/10/2015
     * @param   lId Id Objeto a ser retornado.
     * @return  Entidade
     */
    public Entidade get(Long lId) {
        return (Entidade) acesso.find(this.classe, lId);
    }
    
    /**
     * Metodo responsavel por listar os Objetos cadastrados no Banco de Dados.
     * @version 1.0
     * @since   06/10/2015
     * @return  List
     */
    public List<Entidade> list() {
        String         sSql       = "SELECT e FROM " + this.classe.getSimpleName() + " e";
        List<Entidade> oEntidades = acesso.createQuery(sSql).getResultList();
        return oEntidades;
    }
    
    /**
     * Metodo responsavel por retonar a quantidade de Objetos cadastrados no Banco de Dados.
     * @version 1.0
     * @since   06/10/2015
     * @return  int
     */
    public int size() {
        return this.list().size();
    }
}