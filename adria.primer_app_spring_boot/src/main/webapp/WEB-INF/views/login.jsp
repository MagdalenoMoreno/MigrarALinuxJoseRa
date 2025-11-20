<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ include file="../JSPF/header.jspf" %>
<%@ include file="../JSPF/menuSuperior.jspf" %>
	<div class="container">
		<p><font color="red">${errores}</font></p>
		
		<mvc:form method="post" action="login" modelAttribute="loginEdit">
			<div class="form-row">
				<div class="col">
					<mvc:label path="nickname">Introduzca su nombre:</mvc:label>
					<mvc:input path="nickname" type="text" class="form-control"/> 
					<mvc:errors path="nickname" cssClass="text-warning"/>
				</div>
				<div class="col">
					<mvc:label path="passwd">Introduzca su contraseña:</mvc:label>
					<mvc:input path="passwd" type="password" class="form-control"/> 
					<mvc:errors path="passwd" cssClass="text-warning"/>
				</div>
				<div class="col">
					<br><input type="submit" name="enviar" class="btn btn-success">
				</div>
			</div>
		</mvc:form>
	</div>

<%@ include file="../JSPF/footer.jspf" %>