package modelo.gerenciais;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;

/**
 * <p>Classe de <b>Modelo</b> Funcionario.</p>
 * <p>Classe responsavel por representar os Funcionarios do Sistema.</p>
 * @author  Leandro
 * @version 1.0
 * @since   07/11/2015
 */
@Entity
@Table (name = "funcionario")
@TableGenerator (name = "funcionario_generator", table = "generator_id", pkColumnName = "id", valueColumnName = "valor", pkColumnValue = "funcionario", allocationSize = 1)
public class Funcionario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "funcionario_generator")
    @Column (name = "id")
    private Long    id;
    @Column (name = "cpf")
    private String  cpf;
    @Column (name = "nome")
    private String  nome;
    @Column (name = "turno")
    private String turno;
    @Column (name = "cargo")
    private String cargo;
    @Column (name = "setor")
    private String setor;
    @Column (name = "fl_ativo")
    private boolean ativo;
    @Column (name = "carga_horaria")
    private int     cargaHoraria;
    @Column (name = "salario")
    private float   salario;
    @Column (name = "data_admissao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date    dataAdmissao;
    @Column (name = "data_saida")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date    dataSaida;

    public Funcionario() {
        this.id        = null;
        this.ativo     = true;
        this.dataSaida = null;
    }

    public Funcionario(String sCpf, String sNome) {
        this();
        this.cpf  = sCpf;
        this.nome = sNome.toUpperCase().trim();
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

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String sCargo) {
        this.cargo = sCargo.toUpperCase().trim();
    }

    public String getSetor() {
        return this.setor;
    }

    public void setSetor(String sSetor) {
        this.setor = sSetor.toUpperCase().trim();
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

    public Date getDataSaida() {
        return this.dataSaida;
    }

    public void setDataSaida(Date dDataSaida) {
        this.dataSaida = dDataSaida;
    }
    
    public String[] getInfo() {
        String[] sFuncionario    = new String[3];
                 sFuncionario[0] = this.id.toString();
                 sFuncionario[1] = this.cpf;
                 sFuncionario[2] = this.nome;
        return   sFuncionario;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObject) {
        if (!(oObject instanceof Funcionario)) {
            return false;
        }
        Funcionario oFuncionario = (Funcionario) oObject;
        return Objects.equals(this.id, oFuncionario.getId());
    }

    @Override
    public String toString() {
        return this.cpf + " - " + this.nome ;
    }
}