<div class="form-group">
    <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">
        <span class="glyphicon-class"></span>
        [ ] Menu
    </a>
</div>
<c:if test="${not empty list}">
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
            <c:forEach items="${list}" var="record">

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
</c:if>