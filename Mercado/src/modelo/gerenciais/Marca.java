package modelo.gerenciais;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * <p>Classe de <b>Modelo</b> Marca.</p>
 * <p>Classe responsavel por representar as Marcas do Sistema.</p>
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   03/12/2015
 */
@Entity
@Table (name = "marca")
@TableGenerator (name = "marca_generator", table = "generator_id", pkColumnName = "id", valueColumnName = "valor", pkColumnValue = "marca", allocationSize = 1)
public class Marca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "marca_generator")
    @Column (name = "id")
    private Long   id;
    @Column (name = "nome")
    private String nome;
    @Column (name = "sigla")
    private String sigla;

    public Marca() {
        this.id    = null;
    }

    public Marca(String sNome, String sSigla) {
        this.id    = null;
        this.nome  = sNome.toUpperCase().trim();
        this.sigla = sSigla.toUpperCase().trim();
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long lId) {
        this.id = lId;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String sNome) {
        this.nome = sNome.toUpperCase().trim();
    }

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(String sSigla) {
        this.sigla = sSigla.toUpperCase().trim();
    }

    public String[] getInfo() {
        String[] sMarca    = new String[3];
                 sMarca[0] = this.id.toString();
                 sMarca[1] = this.nome;
                 sMarca[2] = this.sigla;
        return   sMarca;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObject) {
        if (!(oObject instanceof Marca)) {
            return false;
        }
        Marca oMarca = (Marca) oObject;
        return Objects.equals(this.id, oMarca.getId());
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.sigla;
    }
}