<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ include file="../JSPF/header.jspf" %>
<%@ include file="../JSPF/menuSuperior.jspf" %>

	<div class="container">
		<h1>Documentación del alumno:</h1>
		<p>
			<font color="red">${errores}</font>
		</p>
		<table class="table table-striped" modelAttribute="alumno">
			<thead>
				<th>Dni</th>
				<th>Nombre</th>
				<th>Edad</th>
				<th>Ciclo</th>
				<th>Curso</th>
			</thead>
			<tbody>
				<tr>
					<td>&nbsp;${alumno.getDni()}&nbsp;</td>
					<td>&nbsp;${alumno.getNombre()}&nbsp;</td>
					<td>&nbsp;${alumno.getEdad()}&nbsp;</td>
					<td>&nbsp;${alumno.getCiclo()}&nbsp;</td>
					<td>&nbsp;${alumno.getCurso()}&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<p>Si deseas añadir nueva documentación introduzca los datos:</p>
		<mvc:form method="post" action="add-docAlumno" modelAttribute="docAlumno">
		<mvc:errors path="*" cssClass="text-warning"/>
		<input name="dni" type="hidden" value="${alumno.getDni()}">
			<div class="form-row">
				<div class="col">
					<mvc:label path="comentario">Comentario:</mvc:label>
					<mvc:textarea path="comentario" rows="2" cols="70"/>
				</div>
				<div class="col">
					<mvc:label path="tipo">Tipo:</mvc:label>
					<ul>
						<mvc:radiobuttons path="tipo" items="${opcionesTipoDoc}" element="p"/>
					</ul>
				</div>
				<div class="col">
					<br><br>
					<input type="submit" value="Añadir" class="btn btn-success">
				</div>
			</div>	
		</mvc:form>
	<br>
		<table class="table table-striped">
			<thead>
				<th>Id</th>
				<th>Tipo</th>
				<th>Comentario</th>
			</thead>
			<tbody>
				<c:forEach items="${docsAlumnos}" var="docAlumno">
					<tr>
						<td>&nbsp;${docAlumno.getId()}&nbsp;</td>
						<td>&nbsp;${docAlumno.getTipo()}&nbsp;</td>
						<td>&nbsp;${docAlumno.getComentario()}&nbsp;</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
	</div>
<%@ include file="../JSPF/footer.jspf" %>