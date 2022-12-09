<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script defer src="javascript/test.js"></script>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
	integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
	crossorigin="anonymous"></script>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<p style="text-align:center;">Après avoir écrit quelque chose et valider, vérifie la base de donnée 😀</p>
	<br>
	<br>
	<div style="display: flex; justify-content:center">
		<input id="input" type="text" placeholder="écris ce que tu veux ici">
		<button id="valider" type="button" name="valider">valider</button>
	</div>
	<br>
	<br>
	<br>
	<div style="display: flex; justify-content: center;" id="conteneur">
		<c:if test="${!empty testtab }">
			<c:forEach items="${ testtab}" var="element">
			 ${element.test }
			</c:forEach>
		</c:if>
	</div>
	<br>
	<br>
	<br>
	<div  style="display: flex; justify-content: center; align-items:center;" id ="bart"></div>
</body>
</html>