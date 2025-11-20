<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ include file="../JSPF/header.jspf" %>
<%@ include file="../JSPF/menuSuperior.jspf" %>
	<div class="container">
	<h1>Alumno a borrar:</h1>
		<table class="table table-striped">
			<thead>
				<th>Dni</th>
				<th>Nombre</th>
				<th>Ciclo</th>
				<th>Curso</th>
			</thead>
			<tbody>
				<tr>
					<td>&nbsp;${alumnoEdit.getDni()}&nbsp;</td>
					<td>&nbsp;${alumnoEdit.getNombre()}&nbsp;</td>
					<td>&nbsp;${alumnoEdit.getCiclo()}&nbsp;</td>
					<td>&nbsp;${alumnoEdit.getCurso()}&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<mvc:form method="post" action="confirm-modi" modelAttribute="alumnoEdit">
			<div class="form-row" style="display: none;">
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
			
			<div class="form-row" style="display: none;">
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
			
		<p>Si quieres modificar este alumno pulsa en "Modificar", si no pulsa "Volver"</p>
		<input type="submit" value="Modificar" class="btn btn-danger">
		<a class="btn btn-success" href="list-alumnos">Volver</a>
	</mvc:form>	
		
	</div>
<%@ include file="../JSPF/footer.jspf" %>