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
</head>
<body>

<h1>Agregar Usuario</h1>

<form method="post" action="ServletSeguro">
	
	<label>Id Seguro</label><br> <%%>
	<label>Descripción  </label><input type="text" name="tboxDescripcion"><br>
	<label>Tipo de Seguro </label><br>
	<select name="TipoSeguro">
		<%
		SeguroDAO unSeguro = new SeguroDAO();
		for(TipoSeguro unTipoSeguro : unSeguro.ListarTipoSeguro()){
		%>	
			<option value="<%=unTipoSeguro.getIdTipo()%>"><%=unTipoSeguro.getDescripcion()%></option><%
		}
		%>
	</select>
	<label>Costo de Contratación  </label><input type="text" name="tboxCostoContratacion"><br>
	<label>Costo máximo asegurado  </label><input type="text" name="tboxCostoMaximo"><br>
	<input type="submit" value="Aceptar" name="btnAceptar">
	</form>
</body>
</html>