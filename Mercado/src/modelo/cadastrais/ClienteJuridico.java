package modelo.cadastrais;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import modelo.complementares.Cidade;

/**
 * <p>Classe de <b>Modelo</b> ClienteJuridico.</p>
 * <p>Classe responsavel por representar os Clientes Juridicos do Mercado no Sistema.</p>
 * @author  Hadyne
 * @version 1.0
 * @since   08/11/2015
 */
@Entity
public class ClienteJuridico extends Cliente implements Serializable {
    @Column (name = "razao_social")
    private String razaoSocial;
    @Column (name = "responsavel")
    private String responsavel;

    public ClienteJuridico() {
        super();
    }
    
    public ClienteJuridico(String sDocumento, String sNome, String sTelefone, String sCelular, String eEmail, String sEndereco, Cidade oCidade, String sRazaoSocial, String sResponsavel) {
        super(sDocumento, sNome, sTelefone, sCelular, eEmail, sEndereco, oCidade);
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
    public boolean equals(Object oObject) {
        if (!(oObject instanceof ClienteJuridico)) {
            return false;
        }
        ClienteJuridico oClienteJuridico = (ClienteJuridico) oObject;
        return Objects.equals(this.getId(), oClienteJuridico.getId());
    }

    @Override
    public String toString() {
        return super.toString();
    }    
}