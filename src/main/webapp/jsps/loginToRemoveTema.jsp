<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acceso para eliminar tema</title>
</head>
<body>
<h2>Acceso para eliminar tema</h2>
<c:set var="tView" scope="request" value="${loginToRemoveTema}" />
<form action="/web/jsp/loginToRemoveTema" method="post">
        <p>
            Clave: <input name="clave" type="password"/>${tView.errorMsg}
        </p>
        <p>
            <input type="submit" value="Entrar" />
        </p>
</form>
<a href="/web/jsp/home">Volver a Home</a>


</body>
</html>