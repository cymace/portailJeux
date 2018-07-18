
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<style>
img {
    display: block;
    margin-left: auto;
    margin-right: auto;
}
</style>
</head>
<body>
<img class="center" alt="Vache Toureau" src="fichiers/homepage.png">
	<h1>Règles du jeu</h1>
	<p>Le but de ce jeu est d'essayer de déviner un nombre de 4
		chiffres. A chaque proposition le
		serveur vous fournit une réponse contenant les lettres V et T:</p>
	<p>Si un chiffre existe et dans sa place ==> T</p>
	<p>Si un chiffre existe et n'est pas dans sa place ==> V</p>
	<form method="post">
		Proposez un nombre:<input placeholder="Nombre de 4 chiffres..."
			type="text" name="proposition" /> <input name="envoyer"
			type="submit" value="Envoyer"> <input name="recommencer"
			type="submit" value="Initialiser">
		<table>
			<c:forEach items="${ nombres }" var="nombre">
				<tr>
					<td>${nombre}
					</td>
				</tr>
				<c:if test="${nombre.value.equals('TTTT')}">
					<script type="text/javascript">
    				var msg = "T'as gagné ! Le nombre est "+${nombre.key};
    				alert(msg);
					</script>
				</c:if>
			</c:forEach>

		</table>
	</form>
</body>
</html>
