/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 01/05/2015                                                         *
 * Classe: modelo.gerenciais.Funcionario                                      *
 * Coment: Classe de Entidade Funcionario.                                    *
 *         Classe responsavel por representar o Funcionario no Sistema.       *
 * ========================================================================== */

package modelo.gerenciais;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;
    private String  cpf;
    private String  nome;
    private String  turno;
    private String  cargo;
    private String  setor;
    private boolean ativo;
    private int     cargaHoraria;
    private float   salario;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date    dataAdmissao;
    
    public Funcionario() {
        this.id    = null;
        this.turno = "";
        this.cargo = "";
        this.setor = "";
        this.ativo = true;
    }
    
    public Funcionario(String sCpf, String sNome) {
        this();
        this.cpf  = sCpf;
        this.nome = sNome;
    }
    
    public Funcionario(String sCpf, String sNome, String sTurno, String sCargo, String sSetor, int iCargaHoraria, float fSalario, Date dDataAdmissao) {
        this(sCpf, sNome);
        this.turno        = sTurno.toUpperCase().trim();
        this.cargo        = sCargo.toUpperCase().trim();
        this.setor        = sSetor.toUpperCase().trim();
        this.cargaHoraria = iCargaHoraria;
        this.salario      = fSalario;
        this.dataAdmissao = dDataAdmissao;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long lId) {
        this.id = lId;
    }
    
    public String getCpf() {
        return this.cpf;
    }
    
    public void setCpf(String sCpf) {
        this.cpf = sCpf;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String sNome) {
        this.nome = sNome.toUpperCase().trim();
    }
    
    public String getTurno() {
        return this.turno;
    }
    
    public void setTurno(String sTurno) {
        this.turno = sTurno.toUpperCase().trim();
    }
    
    public String getSetor() {
        return this.setor;
    }
    
    public void setSetor(String sSetor) {
        this.setor = sSetor.toUpperCase().trim();
    }
    
    public String getCargo() {
        return this.cargo;
    }
    
    public void setCargo(String sCargo) {
        this.cargo = sCargo.toUpperCase().trim();
    }
    
    public boolean isAtivo() {
        return this.ativo;
    }
    
    public void setAtivo(boolean bAtivo) {
        this.ativo = bAtivo;
    }
    
    public int getCargaHoraria() {
        return this.cargaHoraria;
    }
    
    public void setCargaHoraria(int iCargaHoraria) {
        this.cargaHoraria = iCargaHoraria;
    }
    
    public float getSalario() {
        return this.salario;
    }
    
    public void setSalario(float fSalario) {
        this.salario = fSalario;
    }
    
    public Date getDataAdmissao() {
        return this.dataAdmissao;
    }
    
    public void setDataAdmissao(Date dDataAdmissao) {
        this.dataAdmissao = dDataAdmissao;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObjeto) {
        if (!(oObjeto instanceof Funcionario)) {
            return false;
        }
        Funcionario oFuncionario = (Funcionario) oObjeto;
        return Objects.equals(this.id, oFuncionario.getId());
    }

    @Override
    public String toString() {
        return this.cpf + " - " + this.nome;
    }
}