<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
* Controla os includes de "abas" para a pagina ativa.
* @since 01/02/2015
--> 
<%@ include file="/WEB-INF/jsp/includes/content.jsp" %>  
<c:choose>
    <c:when test="${pagina == 'PRODUTO'}">
        <%@ include file="/view/produto.jsp" %> 
    </c:when>
    <c:when test="${pagina == 'DESPESA'}">
        <%@ include file="/view/despesa.jsp" %> 
    </c:when>
    <c:when test="${pagina == 'CLIENTE'}">
        <%@ include file="/view/cliente.jsp" %> 
    </c:when>
    <c:when test="${pagina == 'HOME'}">
        <%@ include file="/view/home.jsp" %> 
    </c:when>
    <c:otherwise>
        <%@ include file="/index.jsp" %> 
    </c:otherwise>
</c:choose>
<%@ include file="/WEB-INF/jsp/includes/footer.jsp" %>  