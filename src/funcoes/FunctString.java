/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 20/08/2015                                                         *
 * Classe: funcoes.FunctString                                                *
 * Coment: Classe de Funcoes para Strings.                                    *
 * ========================================================================== */

package funcoes;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FunctString {
    
    public static String md5(String sString) {
        try {
            MessageDigest oMessageDigest = MessageDigest.getInstance("MD5");
                          oMessageDigest.update(sString.getBytes(), 0, sString.length());
            return new BigInteger(1, oMessageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(FunctString.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static String getEspacos(int iSize) {
        String sEspacos = "";
        for (int i = 0; i < iSize; ++i) {
            sEspacos += " ";
        }
        return sEspacos;
    }
}