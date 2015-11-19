/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 01/05/2015                                                         *
 * Classe: modelo.cadastrais.ClienteFisico                                    *
 * Coment: Classe de Entidade Cliente Fisico.                                 *
 *         Classe responsavel por representar o Cliente Fisico no Sistema.    *
 * ========================================================================== */

package modelo.cadastrais;

import modelo.estruturais.Cidade;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Temporal;

@Entity
public class ClienteFisico extends Cliente implements Serializable {
    private String rg;
    private char   sexo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date   dataNascimento;

    public ClienteFisico() {
        super();
    }
    
    public ClienteFisico(String sDocumento, String sRg, String sNome, char cSexo, Date dDataNascimento) {
        super(sDocumento, sNome);
        this.rg             = sRg;
        this.sexo           = cSexo;
        this.dataNascimento = dDataNascimento;
    }
    
    public ClienteFisico(String sDocumento, String sRg, String sNome, char cSexo, Date dDataNascimento, String sEndereco, String sCep, Cidade oCidade, String sTelefone, String sEmail) {
        super(sDocumento, sNome, sEndereco, sCep, oCidade, sTelefone, sEmail);
        this.rg             = sRg;
        this.sexo           = cSexo;
        this.dataNascimento = dDataNascimento;
        
    }

    public String getRg() {
        return this.rg;
    }
    
    public void setRg(String sRg) {
        this.rg = sRg;
    }
    
    public char getSexo() {
        return this.sexo;
    }
    
    public void setSexo(char cSexo) {
        this.sexo = cSexo;
    }
    
    public Date getDataNascimento() {
        return this.dataNascimento;
    }
    
    public void setDataNascimento(Date dDataNascimento) {
        this.dataNascimento = dDataNascimento;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObjeto) {
        if (!(oObjeto instanceof ClienteFisico)) {
            return false;
        }
        ClienteFisico oClienteFisico = (ClienteFisico) oObjeto;
        return Objects.equals(this.getId(), oClienteFisico.getId());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}