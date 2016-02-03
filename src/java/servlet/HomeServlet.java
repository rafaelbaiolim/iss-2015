package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.cadastrais.Cliente;
import modelo.dao.cadastrais.DaoCliente;

public class HomeServlet extends HttpServlet {

    private final String PAGINA_SECRETARIA = "secretaria/consultasCadastrar.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
       
        PrintWriter out = response.getWriter();

        DaoCliente daoCliente = new DaoCliente();
        List<Cliente> resultado = daoCliente.findClientes("rafael");

//        if(resultado.size() > 1){
//           out.println(resultado.get(0).getNome());
//        }
        
        request.setAttribute("list",resultado);
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
