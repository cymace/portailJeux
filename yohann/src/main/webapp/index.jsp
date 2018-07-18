<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jeu du pendu</title>
</head>
<body>
	<h1>Quel est le mot suivant ? (en MAJUSCULE) </h1>
	<h1>_ _ _ _ _ _ _ _ _</h1>
	<form name="myForm" action="ServletPendu" method="get">
		Mot à trouver: <input type="text" name="reponse"> 
		<input type="submit" value="Vérifier">
	</form>

</body>
</html>