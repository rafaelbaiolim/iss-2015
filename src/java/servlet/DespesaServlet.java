package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.gerenciais.DaoDespesa;
import modelo.gerenciais.Despesa;

public class DespesaServlet extends HttpServlet {

    private DaoDespesa daoDespesa;
    private List<Despesa> despesas;
    private final String pagina;

    /**
     * <p>
     * Metodo construtor para o Servlet. </p>
     * <p>
     * Acrescenta informações sobre a pagina que esta sendo manipulada. </p>
     */
    public DespesaServlet() {
        this.pagina = "DESPESA";
    }

    /**
     * <p>
     * Metodo responsavel por preencher a lista de Produtos cadastrados a cada
     * requisição direta [ GET ] ao servidor</p>
     *
     * @version 1.0
     * @since 05/02/2016
     */
    protected void initial() {
        this.daoDespesa = new DaoDespesa();
        this.despesas = this.daoDespesa.list();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        response.setContentType("text/html");
        this.initial();
        this.daoDespesa.getDespesas(this.despesas);

        request.setAttribute("listaDespesas", despesas);
        request.setAttribute("pagina", this.pagina);
        RequestDispatcher rd = request.getRequestDispatcher("/controller/viewPaginas/controllerMenu.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
