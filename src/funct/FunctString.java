package funct;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe responsavel pelas operacoes envolvendo <b>Strings</b>.
 * @author  Leandro
 * @version 1.0
 * @since   07/02/2015
 */
public class FunctString {
    
    /**
     * Metodo responsavel por retornar uma String contendo espacos com um determinado tamanho.
     * @since  07/02/2015
     * @param  iSize Tamanho esperado.
     * @return String contendo espaços.
     */
    public String getEspacos(int iSize) {
        String sEspacos = "";
        for (int i = 0; i < iSize; ++i) {
            sEspacos += " ";
        }
        return sEspacos;
    }
    
    /**
     * Metodo responsavel por retornar uma String alinhada a direita.
     * @since  07/02/2015
     * @param  sString Cadeia de caracteres inicial.
     * @param  iSize   Tamanho desejado.
     * @return String alinhada a direita.
     */
    public String toRight(String sString, int iSize) {
        if (sString.length() > iSize) return sString;
        String sRight  = this.getEspacos(iSize - sString.length());
               sRight += sString;
        return sRight;
    }
    
    /**
     * Metodo responsavel por retornar uma String alinhada a esquerda.
     * @since  07/02/2015
     * @param  sString Cadeia de caracteres inicial.
     * @param  iSize   Tamanho desejado.
     * @return String alinhada a esquerda.
     */
    public String toLeft(String sString, int iSize) {
        if (sString.length() > iSize) return sString;
        String sLeft  = sString;
               sLeft += this.getEspacos(iSize - sString.length());
        return sLeft;
    }
    
    /**
     * Metodo responsavel por retornar uma String centralizada.
     * @since  07/02/2015
     * @param  sString Cadeia de caracteres inicial.
     * @param  iSize   Tamanho desejado.
     * @return String centralizada.
     */
    public String toCenter(String sString, int iSize) {
        if (sString.length() > iSize) return sString;
        String sCenter  = this.getEspacos((iSize - sString.length()) / 2);
               sCenter += sString;
               sCenter += this.getEspacos((iSize - sString.length()) / 2);
        return sCenter;
    }
    
    /**
     * Metodo responsavel por retornar contar os caracteres em uma String.
     * @since  07/02/2015
     * @param  sString Cadeia de caracteres.
     * @param  cChar   Caracter.
     * @return Numero de ocorrencias de um char em uma String.
     */
    public int countChar(String sString, char cChar) {
        int iCount = 0;
        for (int i = 0; i < sString.length(); ++i) {
            if (sString.charAt(i) == cChar) {
                iCount += 1;
            }
        }
        return iCount;
    }
    
    /**
     * Metodo responsavel por retornar uma String ordenada inversamente.
     * @since  07/02/2015
     * @param  sString Cadeia de caracteres.
     * @return Cadeia de caracteres em ordem inversa.
     */
    public String reverse(String sString) {
        String sReverse = "";
        for (int i = sString.length() - 1; i >= 0; --i) {
            sReverse += sString.charAt(i);
        }
        return sReverse;
    }
    
    /**
     * Metodo responsavel por retornar uma String com um determinado tamanho.
     * @since  07/02/2015
     * @param  cChar Caracter que compoe a String.
     * @param  iSize Tamanho da String a ser gerada.
     * @return String com o tamanho desejado, sendo formada pelo caracter especificado.
     * 
     * 
     */
    public String getString(char cChar, int iSize) {
        String sString = "";
        for (int i = 0; i < iSize; ++i) {
            sString += cChar;
        }
        return sString;
    }
    
    /**
     * Metodo responsavel por retornar uma String com o primeiro char maiusculo.
     * @since  07/02/2015
     * @param  sString Cadeia de caracteres.
     * @return String com o primeiro caracter maiusculo.
     */
    public String initUpperCase(String sString) {
        if (sString.length() == 0) return "";
        if (sString.length() == 1) return sString.toUpperCase();
        String sInitUpper  = sString.substring(0, 1).toUpperCase();
               sInitUpper += sString.substring(1).toLowerCase();
        return sInitUpper;
    }
    
    /**
     * Metodo responsavel por retornar as iniciais maiusculas de uma String.
     * @since  07/02/2015
     * @param  sString Cadeia de caracteres.
     * @return String com os primeiros caracteres maiusculos.
     */
    public String getInitUpperCase(String sString) {
        String   sInitUpper = "";
        String[] sWords     = sString.split(" ");
        for (int i = 0; i < sWords.length; ++i) {
            sInitUpper += this.initUpperCase(sWords[i]) + " ";
        }
        return sInitUpper.trim();
    }
    
    /**
     * Metodo responsavel por remover os char especiais de uma String.
     * @since  17/03/2015
     * @param  sString Cadeia de caracteres.
     * @return String sem os caracteres especiais.
     */
    public String removeCharEspeciais(String sString) {
        String sReturn = "";
        for (int i = 0; i < sString.length(); ++i) {
            sReturn += this.replaceChar(sString.charAt(i));
        }
        return sReturn;
    }
    
    /**
     * Metodo responsavel por trocar um char especial pelo seu respectivo nao especial.
     * @since  17/03/2015
     * @param  cChar Caracter inicial.
     * @return Caracter Original.
     */
    public char replaceChar(char cChar) {
        switch(cChar) {
            case 'á':
            case 'à':
            case 'â':
            case 'ã':
            case 'ä':
                return 'a';
            case 'é':
            case 'è':
            case 'ê':
            case 'ë':
                return 'e';
            case 'í':
            case 'ì':
            case 'î':
            case 'ï':
                return 'i';
            case 'ó':
            case 'ò':
            case 'ô':
            case 'õ':
            case 'ö':
                return 'o';
            case 'ú':
            case 'ù':
            case 'û':
            case 'ü':
                return 'u';
            case 'Á':
            case 'À':
            case 'Â':
            case 'Ã':
            case 'Ä':
                return 'A';
            case 'É':
            case 'È':
            case 'Ê':
            case 'Ë':
                return 'E';
            case 'Í':
            case 'Ì':
            case 'Î':
            case 'Ï':
                return 'I';
            case 'Ó':
            case 'Ò':
            case 'Ô':
            case 'Õ':
            case 'Ö':
                return 'O';
            case 'Ú':
            case 'Ù':
            case 'Û':
            case 'Ü':
                return 'U';
            default:
                return cChar;
        }
    }
    
    /**
     * Metodo responsavel por checar se uma mascara e valida em uma String.
     * @since  30/10/2015
     * @param  sString String a ser verificada.
     * @param  sMask   Mascara definida.
     * @return String respeita a Mascara.
     */
    public boolean checkMask(String sString, String sMask) {
        for (int i = 0; i < sString.length(); ++i) {
            if (sMask.contains(Character.toString(sString.charAt(i))) == false) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Metodo responsavel por retornar uma String criptografada, utilizando o algoritmo MD5.
     * @since  17/03/2015
     * @param  sString Cadeia de caracteres.
     * @return String criptografada com o algoritmo MD5.
     */
    public String md5(String sString) {
        try {
            MessageDigest oMessageDigest = MessageDigest.getInstance("MD5");
                          oMessageDigest.update(sString.getBytes(), 0, sString.length());
            return new BigInteger(1, oMessageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(FunctString.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}