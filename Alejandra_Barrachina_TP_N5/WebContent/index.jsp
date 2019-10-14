<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dominio.SeguroDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.swing.JOptionPane"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trabajo Práctico Nº5</title>
<link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
	<nav>
		<ul>
			<li><a href="index.jsp">Inicio</a></li>
			<li><a href="AgregarSeguro.jsp">Agregar Seguro</a></li>
			<li><a href="ListarSeguros.jsp">Listar Seguros</a></li>
		</ul>
	</nav>
	<h1>Soy la página Inicio</h1>
	<%
	
		ArrayList <String> Listado = new ArrayList<String>();
		SeguroDAO unSeguro = new SeguroDAO();
		Listado = unSeguro.ListadoTipoSeguro();
		JOptionPane.showMessageDialog(null, Listado);
				
	%>
</body>
</html>
