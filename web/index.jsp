<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Supermercado Super Barato</title>

        <link rel="stylesheet" href="<c:url value="mercado/css/bootstrap.min.css" />" />
        <link rel="stylesheet" href="<c:url value="mercado/css/bootstrap.min.css" />" />
        <link rel="stylesheet" href="<c:url value="mercado/css/simple-sidebar.css" />" />
        <link rel="stylesheet" href="<c:url value="mercado/css/datatables.css" />" />
        <link rel="stylesheet" href="<c:url value="mercado/css/estilo.css" />" />


    </head>

    <body>

        <div id="wrapper">

            <!-- Sidebar -->
            <div id="sidebar-wrapper">
                <ul class="sidebar-nav">
                    <li>
                        <a href="#">
                            <img style="margin: 0 auto" class="img-responsive" 
                                 src="<c:url value="mercado/images/logo.png" />"
                                 width="180px" height="80px" alt="SPM Super Barato"/>
                        </a>
                    </li>
                    <li>
                        <a href="#">Produtos</a>
                    </li>
                    <li>
                        <a href="#">Clientes</a>
                    </li>
                    <li>
                        <a href="#">Despesas</a>
                    </li>
                </ul>
            </div>
            <!-- /#sidebar-wrapper -->

            <!-- Page Content -->
            <div id="page-content-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <%@ include file="./consultas/cliente.jsp" %>  
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
    </div>

</body>
<%@ include file="/WEB-INF/jsp/includes/footer.jsp" %>  

</html>


