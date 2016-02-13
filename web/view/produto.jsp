<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<ol class="breadcrumb">
    <li><a href="<c:url value="/clientes"/>">Home</a></li>
    <li class="active">Produtos</li>
</ol>



<div class="form-group">
    <table class="table table-bordered" id="datatable" >
        <thead>
            <tr>
                <th>Id</th>
                <th>Descricao</th>
                <th>Marca</th>
                <th>Peso</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listaProdutos}" var="record">
                <tr>
                    <td>${record.id }</td>
                    <td>${record.descricao}</td>
                    <td>${record.marca}</td>
                    <td>${record.peso}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>		

    <div class="col-sm-12 text-center">
        <div id="canvas-holder">
            <canvas id="myChart2" height="300" width="500"></canvas>
        </div>
    </div>





