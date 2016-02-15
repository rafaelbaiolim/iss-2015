package relatorios;

import java.io.IOException;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;

/**
 * Classe responsavel por definir os parametros do Relatorio de Funcionarios.
 * @author Leandro
 * @since  10/02/2016
 */
public class RelatorioFuncionarios extends Relatorio {
    
    public RelatorioFuncionarios() throws JRException, SQLException, IOException {
        super();
        this.relatorio += "relatorioFuncionarios.jrxml";
        this.gerarRelatorio();
    }
}
