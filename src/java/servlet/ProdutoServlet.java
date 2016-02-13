package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.cadastrais.Produto;
import modelo.dao.cadastrais.DaoProduto;

/**
 * <p>Servlet responsável por processar as requisições ao servidor envolvendo
 * operações ligadas a produto.</p>
 * @version 1.0
 * @since 05/02/2016
 */
public class ProdutoServlet extends HttpServlet {

    private DaoProduto daoProduto;
    private List<Produto> produtos;
    private final String pagina;
    
    /**
    * <p>Metodo construtor para o Servlet. </p>
    * <p>Acrescenta informações sobre a pagina que esta sendo manipulada. </p>
    */
    public ProdutoServlet() {
        this.pagina = "PRODUTO";
    }
    
    /**
    * <p>Metodo responsavel por preencher a lista de Produtos cadastrados
    * a cada requisição direta [ GET ] ao servidor</p>
    * @version 1.0
    * @since   05/02/2016
    */
    protected void initial() {
        this.daoProduto = new DaoProduto();
        this.produtos = this.daoProduto.list();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        this.initial();
        this.daoProduto.getProdutos(this.produtos);

        request.setAttribute("listaProdutos", produtos);
        request.setAttribute("pagina", this.pagina);
        RequestDispatcher rd = request.getRequestDispatcher("/controller/viewPaginas/controllerMenu.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
