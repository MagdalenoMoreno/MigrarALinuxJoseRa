<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ include file="../JSPF/header.jspf" %>
<%@ include file="../JSPF/menuSuperior.jspf" %>
	<div class="container">
		<h1>Nuevo alumno:</h1>
		<p>
			<font color="red">${errores}</font>
		</p>
		<p>Introduzca los datos del nuevo alumno: </p>
		
		<mvc:form method="post" action="add-alumno" modelAttribute="alumnoEdit">
			<div class="form-row">
				<div class="col">
					<mvc:label path="dni">Dni:</mvc:label>
					<mvc:input path="dni" type="text" class="form-control"/> 
					<mvc:errors path="dni" cssClass="text-warning"/>
				</div>
				<div class="col">
					<mvc:label path="nombre">Nombre:</mvc:label>
					<mvc:input path="nombre" type="text" class="form-control"/> 
					<mvc:errors path="nombre" cssClass="text-warning"/>
				</div>
			</div>
			
			<div class="form-row">
				<div class="col">
					<mvc:label path="edad">Edad:</mvc:label>
					<mvc:input path="edad" type="number" class="form-control"/> 
					<mvc:errors path="edad" cssClass="text-warning"/>
				</div>
				<div class="col">
					<mvc:label path="ciclo">Ciclo:</mvc:label>
					<mvc:input path="ciclo" type="text" class="form-control"/> 
					<mvc:errors path="ciclo" cssClass="text-warning"/>
				</div>
				<div class="col">
					<mvc:label path="curso">Curso:</mvc:label>
					<mvc:input path="curso" type="text" class="form-control"/> 
					<mvc:errors path="curso" cssClass="text-warning"/>
				</div>
			</div>
			
			<br><input type="submit" value="Añadir" class="btn btn-success"/>
		
		</mvc:form>
	</div>
<%@ include file="../JSPF/footer.jspf" %>