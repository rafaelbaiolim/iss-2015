/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 15/07/2015                                                         *
 * Classe: dao.modelo.gerenciais.DaoFuncionario                               *
 * Coment: Classe responsavel pelas operacoes entre a Classe de Entidade      *
 *         Funcionario e o Banco de Dados.                                    *
 * ========================================================================== */

package dao.modelo.gerenciais;

import dao.Dao;
import modelo.gerenciais.Funcionario;
import java.util.List;

public class DaoFuncionario extends Dao<Funcionario> {

    public DaoFuncionario() {
        super(Funcionario.class);
    }
    
    public Funcionario getFuncionarioByCpf(String sCpf) {
        List<Funcionario> oFuncionariosEnc = acesso.createQuery("SELECT e FROM Funcionario e WHERE e.cpf = '" + sCpf.toUpperCase() + "'").getResultList();
        return (oFuncionariosEnc.isEmpty() == false) ? oFuncionariosEnc.get(0) : null;
    }
    
    public List<Funcionario> getFuncionariosByNome(String sNome) {
        return acesso.createQuery("SELECT e FROM Funcionario e WHERE e.nome LIKE '%" + sNome.toUpperCase() + "%'").getResultList();
    }
    
    public List<Funcionario> getFuncionariosByNomeTurnoSetor(String sNome, String sTurno, String sSetor) {
        return acesso.createQuery("SELECT e "
                                + "FROM Funcionario e "
                                + "WHERE e.nome LIKE '%" + sNome.toUpperCase() + "%' "
                                + "AND   e.turno LIKE '%" + sTurno.toUpperCase().trim() + "%'"
                                + "AND   e.setor LIKE '%" + sSetor.toUpperCase().trim() + "%'").getResultList();
    }
}