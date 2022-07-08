<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script defer src="javascript/vehicule.js"></script>
<c:import url="/header/header.jsp"></c:import>
<div id="alert_vehicule" class="alert alert-success" role="alert">
	Le vehicule a été ajouté avec succès !</div>
<br>
<br>
<div class="container">
	<form method="post">
		<c:choose>
			<c:when test="${empty listOfVehicule}">
       Pas de contenu disponible !
    </c:when>
			<c:otherwise>
				<table class="table table-dark">
					<thead>
						<tr>
							<th scope="col">id_vehicule</th>
							<th scope="col">marque</th>
							<th scope="col">modèle</th>
							<th scope="col">couleur</th>
							<th scope="col">immatriculation</th>
							<th scope="col">modification</th>
							<th scope="col">suppression</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listOfVehicule}" var="vehi">
							<tr>
								<td scope="row"><c:out value="${vehi.id_vehicule }" /></td>
								<td><c:out value="${vehi.marque }" /></td>
								<td><c:out value="${vehi.modele }" /></td>
								<td><c:out value="${vehi.couleur }" /></td>
								<td><c:out value="${vehi.immatriculation }" /></td>
								<td class="modif"><a
									href="/VTC/vehicule?id=${vehi.id_vehicule}"> <i
										class="fa-solid fa-feather-pointed"></i></a></td>
								<td><button type="submit" id="delete" name="submit"
										class="btn btn-primary" value="delete-${vehi.id_vehicule }">
										<i class="fa-solid fa-trash-can"></i>
									</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>


		<br>
		<hr>
		<c:if test="${empty marque}">
			<div class="form-group">
				<label for="exampleInputEmail1">Marque</label> <input type="text"
					class="form-control" id="marque" name="marque"
					aria-describedby="emailHelp" placeholder="marque">
			</div>
		</c:if>
		<c:if test="${!empty marque}">
			<div class="form-group">
				<label for="exampleInputEmail1">Marque</label> <input type="text"
					class="form-control" id="marque" name="marque"
					aria-describedby="emailHelp" placeholder="marque"
					value="${marque }">
			</div>
		</c:if>
		<br>
		<c:if test="${empty modele}">
			<div class="form-group">
				<label for="exampleInputPassword1">Modele</label> <input type="text"
					class="form-control" id="modele" name="modele" placeholder="modele">
			</div>
		</c:if>
		<c:if test="${!empty modele}">
			<div class="form-group">
				<label for="exampleInputPassword1">Modele</label> <input type="text"
					class="form-control" id="modele" name="modele" placeholder="modele"
					value="${modele }">
			</div>
		</c:if>
		<br>
		<c:if test="${empty couleur}">
			<div class="form-group">
				<label for="exampleInputPassword1">couleur</label> <input
					type="text" class="form-control" id="couleur" name="couleur"
					placeholder="couleur" value="">
			</div>
		</c:if>
		<c:if test="${!empty couleur}">
			<div class="form-group">
				<label for="exampleInputPassword1">couleur</label> <input
					type="text" class="form-control" id="couleur" name="couleur"
					placeholder="couleur" value="${couleur }">
			</div>
		</c:if>
		<br>
		<c:if test="${empty couleur}">
			<div class="form-group">
				<label for="exampleInputPassword1">immatriculation</label> <input
					type="text" class="form-control" id="immatriculation"
					name="immatriculation" placeholder="immatriculation">
			</div>
		</c:if>
		<c:if test="${!empty couleur}">
			<div class="form-group">
				<label for="exampleInputPassword1">immatriculation</label> <input
					type="text" class="form-control" id="immatriculation"
					name="immatriculation" placeholder="immatriculation"
					value="${couleur }">
			</div>
		</c:if>
		<br>
		<button type="submit" id="submit_assoc" name="submit"
			class="btn btn-primary" value="add">Ajouter cette
			association</button>
		<c:if test="${!empty couleur}">
			<button type="submit" id="modif_conducteur" name="submit"
				class="btn btn-primary" value="update-${id_vehi }">Modifier</button>
		</c:if>
	</form>
</div>
</body>
</html>