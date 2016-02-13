package servlet;

import funct.FunctString;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dao.estruturais.DaoUsuario;
import modelo.estruturais.Usuario;

public class HomeServlet extends HttpServlet {

    private final String pagina;
    private final String paginaHome;
    private DaoUsuario daoUsuario;
    private final FunctString functString;

    public HomeServlet() {
        this.pagina = "AUTENTICAR";
        this.paginaHome = "HOME";
        this.functString = new FunctString();
    }

    protected void initial() {
        this.daoUsuario = new DaoUsuario();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession(true);
        String isUsuarioLogado = (String) session.getAttribute("usuarioLogado");
        PrintWriter out = response.getWriter();
        out.print(isUsuarioLogado);

        if (isUsuarioLogado == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
            return;
        } else {
            request.setAttribute("pagina", this.paginaHome);
            RequestDispatcher rd = request.getRequestDispatcher("/controller/viewPaginas/controllerMenu.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.initial();
        String senhaMD5 = "";
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Usuario oUsuario = this.daoUsuario.findUsuarioByLogin(login);
        senhaMD5 = this.functString.md5(senha);

        if (oUsuario != null) {
            if (senhaMD5.equals(oUsuario.getSenha())) {

                HttpSession session = request.getSession(true);
                session.setAttribute("usuarioLogado", oUsuario.getLogin());
                request.setAttribute("pagina", this.paginaHome);
                RequestDispatcher rd = request.getRequestDispatcher("/controller/viewPaginas/controllerMenu.jsp");
                rd.forward(request, response);

            } else {
                request.setAttribute("error", "Senha Incorreta!");
                request.setAttribute("pagina", this.pagina);
                RequestDispatcher rd = request.getRequestDispatcher("/controller/viewPaginas/controllerMenu.jsp");
                rd.forward(request, response);
            }

        } else {
            request.setAttribute("error", "Usuário não encontrado!");
            request.setAttribute("pagina", this.pagina);
            RequestDispatcher rd = request.getRequestDispatcher("/controller/viewPaginas/controllerMenu.jsp");
            rd.forward(request, response);
        }

    }
}
