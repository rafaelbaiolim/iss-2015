package relatorios;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * <p>Classe responsavel por configurar o BD com os Relatorios.</p>
 * @author Leandro
 * @since  13/02/2016
 */
public class Relatorio {
    private   static final String     url            = "jdbc:mysql://localhost:3306/mercado";
    private   static final String     user           = "root";
    private   static final String     password       = "root"; 
    protected              String     relatorio      = "src/relatorios/jasper/";
    private   HashMap<String, Object> parametros = new HashMap<>();
    
    /**
     * Metodo responsavel por retornar a Conexao com o BD.
     * @return Connection.
     * @throws SQLException 
     */
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
    
    protected void addParametro(String sKey, Object oObject) {
        this.parametros.put(sKey, oObject);
    }
    
    public void gerarRelatorio() throws JRException, SQLException, IOException {
	JasperReport            jasperReport = JasperCompileManager.compileReport(this.relatorio);
	JasperPrint jasperPrint              = JasperFillManager.fillReport(jasperReport, this.parametros, this.getConnection());
        JasperViewer.viewReport(jasperPrint);
    }
    
}
