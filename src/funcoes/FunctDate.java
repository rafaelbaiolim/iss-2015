/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 20/08/2015                                                         *
 * Classe: funcoes.FunctDate                                                  *
 * Coment: Classe de Funcoes para Data e Hora.                                *
 * ========================================================================== */

package funcoes;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FunctDate {
    
    public static Date getCurrentDate() {
        return new Date();
    }
    
    public static Time getCurrentTime() {
        return new Time(FunctDate.getCurrentDate().getTime());
    }
    
    public static Date createDate(String sDate) {
        try {
            return new Date(new SimpleDateFormat("dd/MM/yyyy").parse(sDate).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(FunctDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static String getFormattedDate(Date dDate) {
        return (dDate != null) ? new SimpleDateFormat("dd/MM/yyyy").format(dDate) : null;
    }
}