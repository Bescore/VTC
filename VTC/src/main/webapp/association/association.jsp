<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script defer src="javascript/association.js"></script>
<c:import url="/header/header.jsp"></c:import>
<div  class="alert alert-success ala" id="association" role="alert">
	L'association a été ajoutée avec succès !</div>
<br>
<br>
<div class="container">
	<c:choose>
		<c:when test="${empty list_asso}">
       Pas d'associations disponible !
    </c:when>
		<c:otherwise>
			<table class="table table-dark">
				<thead>
					<tr>
						<th scope="col">id_association</th>
						<th scope="col">Conducteur</th>
						<th scope="col">Véhicule</th>
						<th scope="col">couleur</th>
						<th scope="col">Modification</th>
						<th scope="col">Suppression</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list_asso}" var="association">
						<tr>
							<td scope="row"><c:out
									value="${association.id_association }" /></td>
							<td><c:out
									value="${association.asso_conducteur.prenom } ${association.asso_conducteur.nom }" />
							</td>
							<td><c:out
									value="${association.vehicule.marque } ${association.vehicule.modele }" />
							</td>
							<td><c:out value="${association.vehicule.couleur }" /></td>
							<td><i class="fa-solid fa-feather-pointed"></i></td>
							<td><i class="fa-solid fa-trash-can"></i></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>

	<form method="post">
		<select id="cond" name="conducteur" class="form-select w-25"
			aria-label="Default select example">
			<option selected>Choisir le conducteur</option>
			<c:forEach items="${list_cond}" var="conducteur">
				<option value="${conducteur.id}">${conducteur.prenom}
					${conducteur.nom}</option>
			</c:forEach>
		</select> <br> <br> <select id="vehi" name="vehicule"
			class="form-select w-25" aria-label="Default select example">
			<option selected>Choisir le véhicule</option>
			<c:forEach items="${list_Vehicule}" var="vehicule">
				<option value="${vehicule.id_vehicule}">${vehicule.marque}
					${vehicule.modele}</option>
			</c:forEach>
		</select> <br>
		<button type="submit" id="submit_asso" class="btn btn-primary">Ajouter
			ce conducteur</button>
	</form>
</div>
</body>
</html>