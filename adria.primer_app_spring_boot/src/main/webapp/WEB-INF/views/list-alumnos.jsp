<%@ include file="../JSPF/header.jspf" %>
<%@ include file="../JSPF/menuSuperior.jspf" %>
	<div class="container">
		<p>Bienvenido ${Nombre}</p>
		<p>
			<font color="red">${errores}</font>
		</p>
		<table class="table table-striped">
			<thead>
				<th>Dni</th>
				<th>Nombre</th>
				<th>Edad</th>
				<th>Ciclo</th>
				<th>Curso</th>
				<th>Acción</th>
			</thead>
			<tbody>
			<c:forEach items="${alumnosList}" var="alumno">
				<tr>
					<td>&nbsp;${alumno.getDni()}&nbsp;</td>
					<td>&nbsp;${alumno.getNombre()}&nbsp;</td>
					<td>&nbsp;${alumno.getEdad()}&nbsp;</td>
					<td>&nbsp;${alumno.getCiclo()}&nbsp;</td>
					<td>&nbsp;${alumno.getCurso()}&nbsp;</td>
					<td><a class="btn btn-success" href="mod-alumno?dni=${alumno.getDni()}">Modificar</a></td>
					<td><a class="btn btn-danger" href="confirm-del?dni=${alumno.getDni()}">Borrar</a></td>
					<td><a class="btn btn-success" href="doc-alumno?dni=${alumno.getDni()}">Documentación</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<p><a class="btn btn-success" href="add-alumno">Añadir alumno</a></p>
		
	</div>
<%@ include file="../JSPF/footer.jspf" %>