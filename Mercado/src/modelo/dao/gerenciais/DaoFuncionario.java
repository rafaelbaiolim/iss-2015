package modelo.dao.gerenciais;

import java.util.List;
import modelo.dao.Dao;
import modelo.gerenciais.Funcionario;

/**
 * <p>Classe Dao da Classe de Modelo <b>Funcionario</b>.</p>
 * <p>Classe responsavel pelas operacoes entre a classe Funcionario e o BD.</p>
 * @author  Leandro
 * @version 1.0
 * @since   12/11/2015
 * @see     modelo.dao.Dao
 * @see     modelo.gerenciais.Funcionario
 */
public class DaoFuncionario extends Dao<Funcionario> {

    /**
     * Metodo construtor padrão.
     * Define a Classe do Modelo Funcionario como Entidade da superclasse Dao.
     */
    public DaoFuncionario() {
        super(Funcionario.class);
    }
    
    /**
     * Metodo responsavel por retornar um Funcionario pelo cpf.
     * @param  sCpf CPF do Funcionario.
     * @return Funcionario encontrado.
     */
    public Funcionario findFuncionarioByCpf(String sCpf) {
        String            sSql          = "SELECT e FROM Funcionario e WHERE e.cpf LIKE '" + sCpf + "'";
        List<Funcionario> oFuncionarios = (List<Funcionario>) acesso.createQuery(sSql).getResultList();
        return (oFuncionarios.isEmpty() == true) ? null : oFuncionarios.get(0);
    }
    
    /**
     * Metodo responsavel por retornar um Funcionario pelo cpf e com um Id diferente.
     * @param  sCpf CPF do Funcionario.
     * @param  lId  Id do Funcionario.
     * @return Funcionario encontrado.
     */
    public Funcionario findFuncionarioByCpf(String sCpf, Long lId) {
        String            sSql          = "SELECT e FROM Funcionario e WHERE e.cpf LIKE '" + sCpf + "' ";
                          sSql         += "AND e.id <> " + lId.toString();
        List<Funcionario> oFuncionarios = (List<Funcionario>) acesso.createQuery(sSql).getResultList();
        return (oFuncionarios.isEmpty() == true) ? null : oFuncionarios.get(0);
    }
    
    /**
     * Metodo responsavel por retornar um Funcionario pelo CPF/Nome.
     * @param  sFuncionario CPF/Nome do Funcionario.
     * @return Lista de Funcionarios encontrados.
     */
    public List<Funcionario> findFuncionarios(String sFuncionario) {
        String            sSql          = "SELECT e FROM Funcionario e WHERE e.cpf LIKE '%" + sFuncionario + "%' ";
                          sSql         += "OR e.nome LIKE '%" + sFuncionario + "%'";
        List<Funcionario> oFuncionarios = (List<Funcionario>) acesso.createQuery(sSql).getResultList();
        return oFuncionarios;
    }
    
    /**
     * Metodo responsavel por retornar uma Lista de Funcionarios pelo Nome, Turno e Setor.
     * @param sNome  Nome do Funcionario.
     * @param sTurno Turno do Funcionario.
     * @param sSetor Setor do Funcionario.
     * @return Lista de Funcionarios encontrados.
     */
    public List<Funcionario> findFuncionarios(String sNome, String sTurno, String sSetor) {
        return acesso.createQuery("SELECT e "
                                + "FROM Funcionario e "
                                + "WHERE e.nome LIKE '%" + sNome.toUpperCase() + "%' "
                                + "AND   e.turno LIKE '%" + sTurno.toUpperCase().trim() + "%'"
                                + "AND   e.setor LIKE '%" + sSetor.toUpperCase().trim() + "%'").getResultList();
    }
    
    /**
     * Metodo responsavel por retornar uma Matriz com os elementos principais dos Funcionarios.
     * @param  oFuncionarios Lista de Funcionarios a serem listados.
     * @return Matriz com os dados dos Funcionarios.
     */
    public String[][] getFuncionarios(List<Funcionario> oFuncionarios) {
        String[][] sFuncionarios = new String[oFuncionarios.size()][3];
        for (int i = 0; i < oFuncionarios.size(); ++i) {
            sFuncionarios[i] = oFuncionarios.get(i).getInfo();
        }
        return sFuncionarios;
    }
}