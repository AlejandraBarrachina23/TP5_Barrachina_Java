<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dominio.SeguroDAO"%>
<%@page import="dominio.TipoSeguro"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="estilos.css">
<link href="https://fonts.googleapis.com/css?family=Quicksand:600&display=swap" rel="stylesheet">
</head>
<body>
<nav>
		<ul>
			<li><a href="index.jsp">Inicio</a></li>
			<li><a href="AgregarSeguro.jsp">Agregar Seguro</a></li>
			<li><a href="ListarSeguros.jsp">Listar Seguros</a></li>
		</ul>
</nav>

<h1>Agregar Seguro</h1><br>

<form class="agregar-seguro" method="post" action="ServletSeguro">
	
	<div class="form-item">
		<label>Id Seguro: <% SeguroDAO unSeguro = new SeguroDAO();%> <%=unSeguro.NuevoId()%></label><br>
	</div>
	<div class="form-item">
		<label>Descripción  </label><br><input type="text" required name="tboxDescripcion" requer><br>
	</div>
	<div class="form-item">
		<label>Tipo de Seguro </label><br>
		<select name="TipoSeguro">
			<%
		
			for(TipoSeguro unTipoSeguro : unSeguro.ListarTipoSeguro()){
			%>	
				<option value="<%=unTipoSeguro.getIdTipo()%>"><%=unTipoSeguro.getDescripcion()%></option><%
			}
			%>
			
		</select>
	</div>
	<div class="form-item">
		<label>Costo de Contratación  </label><br><input type="number" required name="tboxCostoContratacion"><br>
	</div>
	<div class="form-item">
		<label>Costo máximo asegurado  </label><br><input type="number" required name="tboxCostoMaximo"><br>
	</div>
	<div class="form-item">
		<input class="button" type="submit" value="ACEPTAR" name="btnAceptar">
	</div>
	</form>
	<img src="seguros.jpg.jpg" alt="tiposdeSeguros">
</body>
</html>