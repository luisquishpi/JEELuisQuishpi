<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reportes</title>
</head>
<body>
<H2>Reportes</H2>
    <c:set var="rView" scope="request" value="${report}" />
    <div>${vView.update()}</div>
    <form>
       <p> Número de votos de cada tema:</p>
       <p>
        <select name="numVoto">
                <c:forEach var="nivel" items="${rView.listNumeroVotos}">
                    <option value="${nivel}">${nivel}</option>
                </c:forEach>
        </select>
        </p>
        <p> Votaciómn media según nivel de estudio:</p>
        
    </form>
    <p>
        <a href="/web/jsp/home">Volver a Home</a>
    </p>
</body>
</html>