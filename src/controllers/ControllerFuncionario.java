/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 17/06/2015                                                         *
 * Classe: controllers.ControllerFuncionario                                  *
 * Coment: Classe responsavel pelas regras de negocios da Classe de Entidade  *
 *         Funcionario.                                                       *
 * ========================================================================== */

package controllers;

import dao.modelo.gerenciais.DaoFuncionario;
import dao.modelo.internos.DaoAcesso;
import dao.modelo.internos.DaoOperacao;
import modelo.gerenciais.Funcionario;
import modelo.internos.Acesso;
import modelo.internos.Usuario;
import java.util.Date;
import java.util.List;

public class ControllerFuncionario {
    private static DaoFuncionario oDaoFuncionario = new DaoFuncionario();
    
    public static boolean checkNome(String sNome) {
        return sNome.length() > 2;
    }
    
    public static boolean checkCpf(String sCpf) {
        return sCpf.length() == 11;
    }
    
    public static boolean cpfIsAble(String sCpf) {
        return oDaoFuncionario.getFuncionarioByCpf(sCpf) == null;
    }
    
    public static List<Funcionario> getFuncionariosByNome(String sNome) {
        return oDaoFuncionario.getFuncionariosByNome(sNome);
    }
    
    public static List<Funcionario> getFuncionarios(String sNome, String sTurno, String sSetor) {
        return oDaoFuncionario.getFuncionariosByNomeTurnoSetor(sNome, sTurno, sSetor);
    }
    
    public static String[][] getFuncionarios(List<Funcionario> oFuncionarios) {
        String[][] sFuncionarios = new String[oFuncionarios.size()][2];
        for (int i = 0; i < oFuncionarios.size(); ++i) {
            sFuncionarios[i][0] = oFuncionarios.get(i).getNome();
            sFuncionarios[i][1] = oFuncionarios.get(i).getCpf();
        }
        return sFuncionarios;
    }
    
    public static void adicionar(String sCpf, String sNome, String sTurno, String sCargo, String sSetor, int iCargaHoraria, float fSalario, Date dDataAdmissao, Usuario oUsuario) {
        Funcionario oFuncionario = new Funcionario(sCpf, sNome, sTurno, sCargo, sSetor, iCargaHoraria, fSalario, dDataAdmissao);
        oDaoFuncionario.insert(oFuncionario);
        new DaoAcesso().insert(new Acesso("Funcionario = " + oFuncionario.toString(), new DaoOperacao().getOperacaoByDescricao("CADASTRO DE FUNCIONARIO"), oUsuario));
    }
    
    public static void gravar(Funcionario oFuncionario, String sCpf, String sNome, String sTurno, String sCargo, String sSetor, int iCargaHoraria, float fSalario, Date dDataAdmissao, Usuario oUsuario) {
        oFuncionario.setCpf(sCpf);
        oFuncionario.setNome(sNome);
        oFuncionario.setTurno(sTurno);
        oFuncionario.setCargo(sCargo);
        oFuncionario.setSetor(sSetor);
        oFuncionario.setCargaHoraria(iCargaHoraria);
        oFuncionario.setSalario(fSalario);
        oFuncionario.setDataAdmissao(dDataAdmissao);
        oDaoFuncionario.update(oFuncionario);
        new DaoAcesso().insert(new Acesso("Funcionario = " + oFuncionario.toString(), new DaoOperacao().getOperacaoByDescricao("ALTERACAO DE FUNCIONARIO"), oUsuario));
    }
    
    public static void remover(Funcionario oFuncionario, Usuario oUsuario) {
        oDaoFuncionario.remove(oFuncionario.getId());
        new DaoAcesso().insert(new Acesso("Funcionario = " + oFuncionario.toString(), new DaoOperacao().getOperacaoByDescricao("REMOCAO DE FUNCIONARIO"), oUsuario));
    }
}