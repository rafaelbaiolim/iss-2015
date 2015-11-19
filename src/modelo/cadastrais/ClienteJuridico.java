/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 01/05/2015                                                         *
 * Classe: modelo.cadastrais.ClienteJuridico                                  *
 * Coment: Classe de Entidade Cliente Juridico.                               *
 *         Classe responsavel por representar o Cliente Juridico no Sistema.  *
 * ========================================================================== */

package modelo.cadastrais;

import modelo.estruturais.Cidade;
import java.util.Objects;
import javax.persistence.Entity;

@Entity
public class ClienteJuridico extends Cliente {
    private String razaoSocial;
    private String responsavel;
    
    public ClienteJuridico() {
        super();
    }

    public ClienteJuridico(String sDocumento, String sNome, String sRazaoSocial, String sResponsavel) {
        super(sDocumento, sNome);
        this.razaoSocial = sRazaoSocial.toUpperCase().trim();
        this.responsavel = sResponsavel.toUpperCase().trim();
    }
    
    public ClienteJuridico(String sDocumento, String sNome, String sRazaoSocial, String sResponsavel, String sEndereco, String sCep, Cidade oCidade, String sTelefone, String sEmail) {
        super(sDocumento, sNome, sEndereco, sCep, oCidade, sTelefone, sEmail);
        this.razaoSocial = sRazaoSocial.toUpperCase().trim();
        this.responsavel = sResponsavel.toUpperCase().trim();
    }
    
    public String getRazaoSocial() {
        return this.razaoSocial;
    }
    
    public void setRazaoSocial(String sRazaoSocial) {
        this.razaoSocial = sRazaoSocial.toUpperCase().trim();
    }
    
    public String getResponsavel() {
        return this.responsavel;
    }
    
    public void setResponsavel(String sResponsavel) {
        this.responsavel = sResponsavel.toUpperCase().trim();
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObjeto) {
        if (!(oObjeto instanceof ClienteJuridico)) {
            return false;
        }
        ClienteJuridico oClienteJuridico = (ClienteJuridico) oObjeto;
        return Objects.equals(this.getId(), oClienteJuridico.getId());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}