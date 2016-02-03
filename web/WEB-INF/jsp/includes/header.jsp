<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Aula de HTML">
        <link rel="stylesheet" href="<c:url value='/css/Estilo.css'/>">

        <title>Clínica SAÚDE & CIA</title>
    </head>
    <body>
        <header>
            <h1>Clínica SAÚDE & CIA</h1>	
        </header>

        <nav>
            <a href="<c:url value='/index.jsp'/>">DESLOGAR |</a>	
            <a href="<c:url value='/secretaria/mainSecretaria.jsp'/>">HOME |</a>	
            <a href="<c:url value='/secretaria/pacientesCadastrar.jsp'/>">PACIENTES |</a>		
            <a href="<c:url value='/secretaria/consultasCadastrar.jsp'/>">CONSULTAS |</a>
            <a href="<c:url value='/secretaria/relatoriosSecretaria.jsp'/>" >RELATÓRIOS |</a>
        </nav>
