/* ========================================================================= /*
 * Grupo....: Hadyne, Leandro, Rafael e Vanessa                               *
 * Data.....: 05/08/2015                                                      *
 * Interface: frames.OperacoesFrame                                           *
 * Coment...: Interface responsavel por definir os metodos que devem ser      *
 *         implementados por classes que implementam um Frame.                *
 * ========================================================================== */

package visao;

public interface OperacoesFrame {
    
     public void initComponents();
     
     public void addHeader();
     
     public void addComponents();
     
     public void addButtons();
     
     public void clear();
}