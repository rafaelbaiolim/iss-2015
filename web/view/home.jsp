<%@page import="modelo.dao.cadastrais.DaoCliente"%>
<%@page import="modelo.cadastrais.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ol class="breadcrumb">
    <li><a href="<c:url value="/home"/>">Home</a></li>
</ol>
<c:out value="${usuario}"/>
