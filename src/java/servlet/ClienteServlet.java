package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.cadastrais.Cliente;
import modelo.dao.cadastrais.DaoCliente;

public class ClienteServlet extends HttpServlet {
    
    private final DaoCliente daoCliente;
    private List<Cliente> clientes;
    private String[][] dadosClientes;
    private final String pagina = "CLIENTE";
    
    public ClienteServlet() {
        this.daoCliente = new DaoCliente();
        this.clientes = this.daoCliente.list();
        dadosClientes = null;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        HttpSession session = request.getSession(true);
        String param = (String) session.getAttribute("usuarioLogado");
        
        PrintWriter out = response.getWriter();
        out.print(param);
        
        this.dadosClientes = daoCliente.getClientes(clientes);
        
        request.setAttribute("listaClientes", clientes);
        request.setAttribute("pagina", this.pagina);
        RequestDispatcher rd = request.getRequestDispatcher("/controller/viewPaginas/controllerMenu.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
