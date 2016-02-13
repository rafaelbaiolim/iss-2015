<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/jsp/includes/header-login.jsp" %>  
<div class="container">

    <div class="row" id="pwd-container">
        <div class="col-md-4"></div>

        <div class="col-md-4">
            <section class="login-form">
                <c:if test="${!empty error}">
                    <div class="alert alert-danger alert-dismissible fade in" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <strong>Error!</strong> <c:out value="${error}"></c:out>.
                    </div>
                </c:if>
                <form method="post" action="${pageContext.request.contextPath}/home" role="login">
                    <img style="margin: 0 auto" class="img-responsive" 
                         src="<c:url value="../mercado/images/logo.png" />"
                         width="180px" height="80px" alt="SPM Super Barato"/>

                    <input type="text" name="login" 
                           placeholder="Login" 
                           required class="form-control input-lg" 
                           placeholder="Login" />

                    <input type="password" name="senha" 
                           class="form-control input-lg" 
                           id="senha" placeholder="Senha" 
                           required="" />

                    <div class="pwstrength_viewport_progress"></div>
                    <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Logar</button>

                </form>

            </section>  
        </div>


    </div>


</div>

<%@ include file="/WEB-INF/jsp/includes/footer-login.jsp" %>



