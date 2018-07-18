<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<h1>Veuillez répodre à la question suivante:</h1>
<p>l'enigme: <c:out value="${enigme.question}" /></p>
<form action="#" method="post">
<label for="lreponse"> Votre réponse</label>
<input type="text" name="treponse" id="treponse"/>
<button type="submit">Valider</button><br />
</form>
</body>
</html>