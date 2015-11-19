/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 17/06/2015                                                         *
 * Classe: controllers.ControllerUF                                           *
 * Coment: Classe responsavel pelas regras de negocios da Classe de Entidade  *
 *         UF.                                                                *
 * ========================================================================== */

package controllers;

import dao.modelo.estruturais.DaoUF;

public class ControllerUF {
    private static DaoUF oDaoUF = new DaoUF();
    
    public static Object[] getSiglas() {
        return oDaoUF.getSiglas().toArray();
    }
}
