<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="dominio.SeguroDAO"%>
<%@page import="dominio.TipoSeguro"%>
<%@page import="dominio.Seguro"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trabajo Práctico Nº5</title>
</head>
<link rel="stylesheet" type="text/css" href="estilos.css">
<link href="https://fonts.googleapis.com/css?family=Quicksand:600&display=swap" rel="stylesheet">
<body>

<h1>Tipo de Seguros de la base de datos</h1><br>
<nav>
		<ul>
			<li><a href="index.jsp">Inicio</a></li>
			<li><a href="AgregarSeguro.jsp">Agregar Seguro</a></li>
			<li><a href="ListarSeguros.jsp">Listar Seguros</a></li>
		</ul>
</nav>

<form method="get" action="ServletSeguro">	
	
	<div class="content-filter">
		<label>Busqueda por tipo de Seguros: </label>
			
			<select name="TipoSeguro">
				<%
				SeguroDAO unSeguro = new SeguroDAO();
				for(TipoSeguro unTipoSeguro : unSeguro.ListarTipoSeguro()){
				%>	
					<option value="<%=unTipoSeguro.getIdTipo()%>"><%=unTipoSeguro.getDescripcion()%></option><%
				}
				
				%>
			</select>
		<input class="button" type="submit" name="btnFiltrar" value="FILTRAR">
	</div>
		<table class="content-table">
		<tr>
			<th>ID Seguro</th>
			<th>Descripcion Seguro</th>
			<th>Descripcion Tipo Seguro</th>
			<th>ID Costo de Contratación</th>
			<th>Costo máximo del asegurado</th>
		</tr>
		<% 
			ArrayList<Seguro>ListadeSeguros = new ArrayList<Seguro>();
			if(request.getAttribute("ListadoSeguros")!=null) ListadeSeguros = (ArrayList<Seguro>)request.getAttribute("ListadoSeguros");			
			else ListadeSeguros = unSeguro.ListarSeguros();	
		%>		
		<%for(Seguro seguro : ListadeSeguros){ 
		
			%>
				<tr>  
					  <td><%= seguro.getIdSeguro() %></td>
					  <td><%= seguro.getDescripcion() %></td>
					  <td><%= seguro.getTipoSeguro().getDescripcion() %></td>
					  <td><%= seguro.getCostoContratacion() %></td>
					  <td><%= seguro.getCostoAsegurado() %></td>
				</tr>
					  
					  <%	
			}
			
		%>
		
		
		</table>
</form>
<img src="seguros.jpg.jpg" alt="tiposdeSeguros">
</body>
</html>