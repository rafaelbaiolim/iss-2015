/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 17/06/2015                                                         *
 * Classe: controlers.ControllerCliente                                       *
 * Coment: Classe responsavel pelas regras de negocios da Classe de Entidade  *
 *         Cliente.                                                           *
 * ========================================================================== */

package controllers;

import dao.modelo.cadastrais.DaoCliente;
import dao.modelo.cadastrais.DaoClienteFisico;
import dao.modelo.cadastrais.DaoClienteJuridico;
import dao.modelo.estruturais.DaoCidade;
import dao.modelo.internos.DaoAcesso;
import dao.modelo.internos.DaoOperacao;
import modelo.cadastrais.Cliente;
import modelo.cadastrais.ClienteFisico;
import modelo.cadastrais.ClienteJuridico;
import modelo.estruturais.Cidade;
import modelo.internos.Acesso;
import modelo.internos.Usuario;
import java.util.Date;
import java.util.List;

public class ControllerCliente {
    private static DaoCliente         oDaoCliente         = new DaoCliente();
    private static DaoClienteFisico   oDaoClienteFisico   = new DaoClienteFisico();
    private static DaoClienteJuridico oDaoClienteJuridico = new DaoClienteJuridico();
    
    public static boolean nomeIsAble(String sNome) {
        return sNome.trim().length() > 2;
    }
    
    public static boolean cpfIsAble(String sCpf) {
        return sCpf.trim().length() == 11;
    }
    
    public static boolean cnpjIsAble(String sCnpj) {
        return sCnpj.trim().length() == 14;
    }
    
    public static boolean documentIsAble(String sDocumento) {
        return oDaoCliente.getClienteByDocumento(sDocumento) == null;
    }
    
    public static List<Cliente> getClientesByNome(String sNome) {
        return oDaoCliente.getClientesByNome(sNome);
    }
    
    public static void createClienteFisico(String sDocumento, String sRg, String sNome, char cSexo, Date dDataNascimento, String sEndereco, String sCpf, String sCidade, String sTelefone, String sEmail, Usuario oUsuario) {
        Cidade oCidade = new DaoCidade().getCidade(sCidade);
        ClienteFisico oClienteFisico = new ClienteFisico(sDocumento, sRg, sNome, cSexo, dDataNascimento, sEndereco, sCpf, oCidade, sTelefone, sEmail);
        oDaoClienteFisico.insert(oClienteFisico);
        new DaoAcesso().insert(new Acesso("Cliente = " + oClienteFisico.toString(), new DaoOperacao().getOperacaoByDescricao("CADASTRO DE CLIENTE"), oUsuario));
    }
    
    public static void createClienteJuridico(String sDocumento, String sRazaoSocial, String sNome, String sResponsavel, String sEndereco, String sCep, String sCidade, String sTelefone, String sEmail, Usuario oUsuario) {
        Cidade oCidade = new DaoCidade().getCidade(sCidade);
        ClienteJuridico oClienteJuridico = new ClienteJuridico(sDocumento, sNome, sRazaoSocial, sResponsavel, sEndereco, sCep, oCidade, sTelefone, sEmail);
        oDaoClienteJuridico.insert(oClienteJuridico);
        new DaoAcesso().insert(new Acesso("Cliente = " + oClienteJuridico.toString(), new DaoOperacao().getOperacaoByDescricao("CADASTRO DE CLIENTE"), oUsuario));
    }
    
    public static void remove(Cliente oCliente, Usuario oUsuario) {
        if (oCliente instanceof ClienteFisico) {
            oDaoClienteFisico.remove(oCliente.getId());
        }else if (oCliente instanceof ClienteJuridico) {
            oDaoClienteJuridico.remove(oCliente.getId());
        }
        new DaoAcesso().insert(new Acesso("Cliente = " + oCliente.toString(), new DaoOperacao().getOperacaoByDescricao("REMOCAO DE CLIENTE"), oUsuario));
    }
    
    public static String[][] getClientes(List<Cliente> oClientes) {
        String[][] sClientes = new String[oClientes.size()][3];
        for (int i = 0; i < oClientes.size(); ++i) {
            sClientes[i][0] = oClientes.get(i).getDocumento();
            sClientes[i][1] = oClientes.get(i).getNome();
            sClientes[i][2] = oClientes.get(i).getEmail();
        }
        return sClientes;
    }
    
    public static String[][] getClientes2(List<Cliente> oClientes) {
        String[][] sClientes = new String[oClientes.size()][2];
        for (int i = 0; i < oClientes.size(); ++i) {
            sClientes[i][0] = oClientes.get(i).getDocumento();
            sClientes[i][1] = oClientes.get(i).getNome();
        }
        return sClientes;
    }
}