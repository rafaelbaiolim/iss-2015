<%@page import="br.com.clinica.model.Paciente" %>

<c:if test="${sessionScope.login == 'secretaria'}">
    <section>
        <div class="caixa-botao">	
            <a href="<c:url value='/secretaria/pacientesCadastrar.jsp'/>"><button class="botoes-nav"> Cadastrar Pacientes</button></a>
            <a href="<c:url value='/secretaria/pacientesBuscar.jsp'/>"><button class="botoes-nav"> Buscar Pacientes</button></a>    
            <a href= "<c:url value='/secretaria/pacientesAlterar.jsp'/>"><button class="botoes-nav"> Alterar Pacientes</button></a>   
        </div>				
    </section>
</c:if>

<c:if test="${sessionScope.login == 'medico'}">
    <section>
        <div class="caixa-botao">	
            <a href="<c:url value='/medico/pacientesCadastrar.jsp'/>"><button class="botoes-nav"> Cadastrar Pacientes</button></a>
            <a href="<c:url value='/medico/pacientesBuscar.jsp'/>"><button class="botoes-nav"> Buscar Pacientes</button></a>    
            <a href= "<c:url value='/medico/pacientesAlterar.jsp'/>"><button class="botoes-nav"> Alterar Pacientes</button></a>   
        </div>				
    </section>
</c:if>