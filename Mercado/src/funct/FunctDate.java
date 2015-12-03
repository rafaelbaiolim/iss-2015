package funct;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe responsavel pelas operacoes envolvendo <b>Datas</b> e <b>Times</b>.
 * @author  Leandro
 * @version 1.0
 * @since   17/03/2015
 * @see     java.util.Date
 * @see     java.sql.Time
 */
public class FunctDate {
    private final String[] oMonthNames = {"JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL", 
                                                 "MAIO", "JUNHO", "JULHO", "AGOSTO", 
                                                 "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO"};
    private final String[] oDayNames   = {"DOMINGO", "SEGUNDA-FEIRA", "TERÇA-FEIRA", "QUARTA-FEIRA",
                                                 "QUINTA-FEIRA", "SEXTA-FEIRA", "SÁBADO"};
    
    /**
     * Metodo responsavel por retornar a data corrente do Sistema.
     * @since  17/03/2015
     * @return Date
     */
    public Date getCurrentDate() {
        return new Date();
    }
    
    /**
     * Metodo responsavel por retornar a hora corrente do Sistema.
     * @since  17/03/2015
     * @return Time
     */
    public Time getCurrentTime() {
        return new Time(this.getCurrentDate().getTime());
    }
    
    /**
     * Metodo responsavel por criar um objeto Date no formato "dd/MM/yyyy".
     * @since  18/03/2015
     * @param  sDate Data em formato "dd/MM/yyyy".
     * @return Date
     */
    public Date createDate(String sDate) {
        try {
            return new Date(new SimpleDateFormat("dd/MM/yyyy").parse(sDate).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(FunctDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Metodo responsavel por criar um objeto Date no formato "dd/MM/yy"
     * @since  18/03/2015
     * @param  sDate Data em formato "dd/MM/yy".
     * @return Date
     */
    public Date createDate2(String sDate) {
        try {
            return new Date(new SimpleDateFormat("dd/MM/yy").parse(sDate).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(FunctDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Metodo responsavel por criar um objeto Time com os parametros horas, minutos e segundos.
     * @since  18/03/2015
     * @param  iHours   Hora (0 - 23)
     * @param  iMinutes Minuto (0 - 59)
     * @param  iSeconds Segundo (0 - 59)
     * @return Time
     */
    public Time createTime(int iHours, int iMinutes, int iSeconds) {
        return new Time(iHours, iMinutes, iSeconds);
    }
    
    /**
     * Metodo responsavel por retornar uma String com a data no formato "dd/MM/yyyy".
     * @since  17/03/2015
     * @param  dDate Data a ser formatada.
     * @return String
     */
    public String getFormattedDate(Date dDate) {
        return new SimpleDateFormat("dd/MM/yyyy").format(dDate);
    }
    
    /**
     * Metodo responsavel por retornar uma String com a data no formato "dd/MM/yy".
     * @since  17/03/2015
     * @param  dDate  Data a ser formatada.
     * @return String
     */
    public String getFormattedDate2(Date dDate) {
        return new SimpleDateFormat("dd/MM/yy").format(dDate);
    }
    
    /**
     * Metodo responsavel por retornar a data por extenso.
     * @since  17/03/2015
     * @param  dDate Data a ser escrita por extenso.
     * @return String
     */
    public String getDateName(Date dDate) {
        String sDate  = this.getDayName(dDate.getDay()) + ", ";
               sDate += dDate.getDate() + " DE ";
               sDate += this.getMonthName(dDate.getMonth()) + " DE ";
               sDate += dDate.getYear();
        return sDate;
    }
    
    /**
     * Metodo responsavel por retornar o nome do dia por extenso.
     * @since  17/03/2015
     * @param  iDay Dia da Semana (0 - 6)
     * @return String
     */
    public String getDayName(int iDay) {
        if ((iDay >= 0) && (iDay <= 6)) {
            return oDayNames[iDay];
        }
        return "";
    }
    
    /**
     * Metodo responsavel por retornar o nome por extenso do mes.
     * @since  17/03/2015
     * @param  iMonth Mes do Ano (0 - 11)
     * @return String
     */
    public String getMonthName(int iMonth) {
        if ((iMonth >= 0) && (iMonth <= 11)) {
           return oMonthNames[iMonth]; 
        }
        return "";
    }
}