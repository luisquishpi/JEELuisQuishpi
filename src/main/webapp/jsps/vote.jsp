<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votar</title>
</head>
<body>
	<H2>Votar</H2>
	<c:set var="vView" scope="request" value="${vote}" />
	<div>${vView.update()}</div>
	<form action="/web/jsp/vote" method="post">
	   <p> Nivel de estudio:
        <select name="nivelEstudio">
                <c:forEach var="nivel" items="${vView.listaNivelEstudio}">
                    <option value="${nivel}">${nivel}</option>
                </c:forEach>
        </select>
        </p>
		<p> Tema:
		<select name="idTema">
                <c:forEach var="tema" items="${vView.listaTema}">
                    <option value="${tema.id}">${tema.nombre}: ${tema.pregunta}</option>
                </c:forEach>
        </select>
		</p>
		<p> Valora:
        <select name="valor">
                <c:forEach var="valor" items="${vView.listaValorVoto}">
                    <option value="${valor}">${valor}</option>
                </c:forEach>
        </select>
        </p>
		<p>
            <input type="submit" value="Votar" />
        </p>
	</form>
	<p>
		<a href="/web/jsp/home">Volver a Home</a>
	</p>
</body>
</html>