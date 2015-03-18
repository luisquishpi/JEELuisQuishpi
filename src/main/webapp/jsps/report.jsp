<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reportes</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<H2>Reportes</H2>
	<c:set var="rView" scope="request" value="${report}" />
	<div>${rView.update()}</div>
	<form>
		<p>Número de votos de cada tema:</p>
		<table>
			<tr>
				<th>Tema</th>
				<th>Votos</th>
			</tr>
			<c:forEach var="lista" items="${rView.listNumeroVotos}">
				<tr>
					<td>${lista[0].pregunta}</td>
					<td>${lista[1]}</td>
				</tr>
			</c:forEach>
		</table>
		<p>Votación media según nivel de estudio:</p>
		<table>
			<tr>
				<th>Nivel de educación</th>
				<th>Media de votación</th>
			</tr>
			<c:forEach var="lista" items="${rView.listVotacionMedia}">
				<tr>
					<td>${lista[0]}</td>
					<td>${lista[1]}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<p>
		<a href="/web/jsp/home">Volver a Home</a>
	</p>
</body>
</html>