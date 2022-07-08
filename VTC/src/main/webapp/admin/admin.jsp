<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="/header/header.jsp"></c:import>
<div class="container">
	<br> <b>Afficher le nombre de conducteur :
		${valeur_conducteur}</b> <br> <b>Afficher le nombre de véhicule :
		${valeur_vehicule}</b> <br> <b>Afficher le nombre d’association :
		${valeur_asso}</b> <br> <b>Afficher les véhicules n’ayant pas de
		conducteur : ${no_cond }</b> <br>
	<b>Afficher les conducteurs n’ayant pas de
		véhicules : ${no_vehi }</b>
</div>
</body>
</html>