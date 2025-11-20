<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ include file="../JSPF/header.jspf" %>
<%@ include file="../JSPF/menuSuperior.jspf" %>
	<div class="container">
		<h1>Nuevo modulo:</h1>
		<p>
			<font color="red">${errores}</font>
		</p>
		<table class="table table-striped">
			<thead>
				<td>Id</td>
				<td>Nombre</td>
				<td>Horas</td>
				<td>Abreviaturas</td>
			</thead>
			<tbody>
				<c:forEach items="${moduloList}" var="modulo">
					<tr>
						<td>&nbsp;${modulo.getId()}&nbsp;</td>
						<td>&nbsp;${modulo.getNombre()}&nbsp;</td>
						<td>&nbsp;${modulo.getHoras()}&nbsp;</td>
						<td>&nbsp;${modulo.getAbreviatura()}&nbsp;</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<mvc:form method="post" action="add-modulo" modelAttribute="moduloEdit">
			<div class="form-row">
				<div class="col">
					<mvc:label path="nombre">Nombre:</mvc:label>
					<mvc:input path="nombre" type="text" class="form-control"/> 
					<mvc:errors path="nombre" cssClass="text-warning"/>
				</div>
				<div class="col">
					<mvc:label path="horas">Horas:</mvc:label>
					<mvc:input path="horas" type="text" class="form-control"/> 
					<mvc:errors path="horas" cssClass="text-warning"/>
				</div>
				<div class="col">
					<mvc:label path="abreviatura">Abreviatura:</mvc:label>
					<mvc:input path="abreviatura" type="text" class="form-control"/> 
					<mvc:errors path="abreviatura" cssClass="text-warning"/>
				</div>
			</div>
			<br><input type="submit" value="Añadir" class="btn btn-success"/>
		</mvc:form>
	</div>
<%@ include file="../JSPF/footer.jspf" %>