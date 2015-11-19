/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 17/06/2015                                                         *
 * Classe: controllers.ControllerMensagem                                     *
 * Coment: Classe responsavel pelas regras de negocios envolvendo a operacao  *
 *         Enviar Mensagem.                                                   *
 * ========================================================================== */

package controllers;

import dao.modelo.internos.DaoAcesso;
import dao.modelo.internos.DaoOperacao;
import modelo.cadastrais.Cliente;
import modelo.internos.Acesso;
import modelo.internos.Usuario;
import java.util.List;

public class ControllerMensagem {
    
    public static void enviarMensagem(String sMensagem, List<Cliente> oClientes, Usuario oUsuario) {
        new DaoAcesso().insert(new Acesso("Mensagem = " + sMensagem + " - Para " + oClientes, new DaoOperacao().getOperacaoByDescricao("ENVIO DE MENSAGEM"), oUsuario));
        System.out.println("ENVIANDO MENSAGEM");
        for (int i = 0; i < oClientes.size(); ++i) {
            System.out.println("PARA: " + oClientes.get(i).getEmail() + "(" + oClientes.get(i).getNome() + ")");
        }
        System.out.println(sMensagem);
    }
}