package modelo.cadastrais;

import modelo.complementares.Cidade;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * <p>Classe de <b>Modelo</b> ClienteFisico.</p>
 * <p>Classe responsavel por representar os Clientes Fisicos do Mercado no Sistema.</p>
 * @author  Hadyne
 * @version 1.0
 * @since   08/11/2015
 */
@Entity
public class ClienteFisico extends Cliente implements Serializable {
    @Column (name = "rg")
    private String rg;
    @Column (name = "sexo")
    private char   sexo;

    public ClienteFisico() {
        super();
    }
    
    public ClienteFisico(String sDocumento, String sNome, String sTelefone, String sCelular, String sEmail, String sEndereco, Cidade oCidade, String sRg, char cSexo) {
        super(sDocumento, sNome, sTelefone, sCelular, sEmail, sEndereco, oCidade);
        this.rg   = sRg;
        this.sexo = cSexo;
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObject) {
        if (!(oObject instanceof ClienteFisico)) {
            return false;
        }
        ClienteFisico oClienteFisico = (ClienteFisico) oObject;
        return Objects.equals(this.getId(), oClienteFisico.getId());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}