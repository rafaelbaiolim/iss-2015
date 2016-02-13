<%@page import="modelo.dao.cadastrais.DaoCliente"%>
<%@page import="modelo.cadastrais.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ol class="breadcrumb">
    <li><a href="<c:url value="/clientes"/>">Home Clientes</a></li>
</ol>
<div class="form-group">
    <table class="table table-bordered" id="datatable" >
        <thead>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Endereço</th>
                <th>Celular</th>
                <th>Documento</th>
            </tr>
        </thead>
        <tbody>

            <c:forEach items="${listaClientes}" var="record">
                <tr>
                    <td>${record.id }</td>
                    <td>${record.nome}</td>
                    <td>${record.endereco}</td>
                    <td>${record.celular }</td>
                    <td>${record.documento }</td>
                </tr>

            </c:forEach>
        </tbody>
    </table>		

