<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Eliminar Tema</h2>
    <c:set var="tView" scope="request" value="${removeTema}" />
    <div>${tView.update()}</div>
    <form action="/web/jsp/removeTema" method="post">
        <p>
            Temas: <select name="tema">
                <c:forEach var="tema" items="${tView.listaTema}">
                    <option value="${tema.id}">${tema.nombre}</option>
                </c:forEach>
            </select>
        </p>
        <p>
            Clave: <input name="clave" type="text"/>${tView.errorMsg}</p>
        <p>
        <p>
            <input type="submit" value="Eliminar" />
        </p>
    </form>
    <a href="/web/jsp/home">Volver a Home</a>
</body>
</html>