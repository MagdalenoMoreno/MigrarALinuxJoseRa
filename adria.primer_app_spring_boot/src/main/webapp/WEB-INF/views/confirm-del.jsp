<%@ include file="../JSPF/header.jspf" %>
<%@ include file="../JSPF/menuSuperior.jspf" %>
	<div class="container">
	<h1>Alumno a borrar:</h1>
		<table class="table table-striped" modelAttribute="alumno">
			<thead>
				<th>Dni</th>
				<th>Nombre</th>
				<th>Ciclo</th>
				<th>Curso</th>
			</thead>
			<tbody>
				<tr>
					<td>&nbsp;${alumno.getDni()}&nbsp;</td>
					<td>&nbsp;${alumno.getNombre()}&nbsp;</td>
					<td>&nbsp;${alumno.getCiclo()}&nbsp;</td>
					<td>&nbsp;${alumno.getCurso()}&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<p>Si quieres borrar este alumno pulsa en "Borrar", si no pulsa "Volver"</p>
		<a class="btn btn-danger" href="del-alumno?dni=${alumno.getDni()}">Borrar</a>
		<a class="btn btn-success" href="list-alumnos">Volver</a>
		
		
	</div>
<%@ include file="../JSPF/footer.jspf" %>