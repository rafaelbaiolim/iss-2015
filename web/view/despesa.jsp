<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ol class="breadcrumb">
    <li><a href="<c:url value="/clientes"/>">Home</a></li>
    <li class="active">Despesas</li>
</ol>

<div class="form-group">
    <table class="table table-bordered" id="datatable" >
        <thead>
            <tr>
                <th>Id</th>
                <th>Descrição</th>
                <th>Data de Cadastro</th>
                <th>Data de Pagamento</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listaDespesas}" var="record">
                <tr>
                    <td>${record.id }</td>
                    <td>${record.descricao}</td>
                    <td>
            <fmt:formatDate value="${record.dataCadastro}" pattern="yy-MM-dd"/>
            </td>
            <td>${record.dataPagamento}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>		





