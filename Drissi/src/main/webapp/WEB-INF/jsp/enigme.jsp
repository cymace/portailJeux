<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>On est dans la page Enigme</h1>
	<h2>${msg}</h2>
	<c:choose>
	<c:when test="${msg=='Madrid'}">Bonne réponse Bravo!</c:when>
	<c:otherwise>
           Mauvaise Réponse
         </c:otherwise>
	</c:choose>
</body>
</html>