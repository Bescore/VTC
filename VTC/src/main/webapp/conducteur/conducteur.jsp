<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script defer src="javascript/conducteur.js"></script>
<c:import url="/header/header.jsp"></c:import>
<div id="alert_conducteur" class="alert alert-success" role="alert">
	Le conducteur a été ajouté avec succès !</div>
<br>
<br>

<div class="container">
	<form method="post">
		<c:choose>
			<c:when test="${empty list}">
       Pas de conducteur disponible !
    </c:when>
			<c:otherwise>
				<table class="table table-dark">
					<thead>
						<tr>
							<th scope="col">id_conducteur</th>
							<th scope="col">prenom</th>
							<th scope="col">nom</th>
							<th scope="col">modification</th>
							<th scope="col">suppression</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list }" var="conducteur">
							<tr>
								<td scope="row"><c:out value="${conducteur.id }" /></td>
								<td><c:out value="${conducteur.prenom }" /></td>
								<td><c:out value="${conducteur.nom }" /></td>
								<td class="modif"><a
									href="/VTC/conducteur?id=${conducteur.id }"> <i
										class="fa-solid fa-feather-pointed"></i></a></td>
								<%-- <td>
								 <a href="/VTC/conducteur?id=${conducteur.id }">
								<div> ${conducteur.id }</div>
								</a>
								</td>--%>
								<td><button type="button" id="delete"
										class="btn btn-primary" data-bs-toggle="modal"
										data-bs-target="#exampleModal">
										<i class="fa-solid fa-trash-can"></i>
									</button></td>
							</tr>
							<!-- Modal est dans le foreach -->
							<div class="modal fade" id="exampleModal" tabindex="-1"
								aria-labelledby="exampleModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">Suppression</h5>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">Voulez vous vraiment supprimer
											cette élément?</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-success "
												data-bs-dismiss="modal">NON</button>
											<button type="submit" name="submit" class="btn btn-danger"
												value="delete-${conducteur.id}">OUI</button>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>

		<br>
		<hr>
		<c:if test="${empty nom}">
			<div class="form-group">
				<label for="exampleInputEmail1">Nom</label> <input type="text"
					class="form-control" id="nom" name="nom"
					aria-describedby="emailHelp" placeholder="Entrer nom">
			</div>
		</c:if>
		<c:if test="${!empty nom}">
			<div class="form-group">
				<label for="exampleInputEmail1">Nom</label> <input type="text"
					class="form-control" id="nom" name="nom"
					aria-describedby="emailHelp" placeholder="Entrer nom"
					value="${ nom}">
			</div>
		</c:if>

		<br>
		<c:if test="${empty prenom}">
			<div class="form-group">
				<label for="exampleInputPassword1">Prenom</label> <input type="text"
					class="form-control" id="prenom" name="prenom"
					placeholder="Entrer prenom">
			</div>
		</c:if>
		<c:if test="${!empty prenom}">
			<div class="form-group">
				<label for="exampleInputPassword1">Prenom</label> <input type="text"
					class="form-control" id="prenom" name="prenom"
					placeholder="Entrer prenom" value="${prenom}">
			</div>
		</c:if>
		<br>
		<button type="submit" id="submit_conducteur" name="submit"
			class="btn btn-primary" value="add">Ajouter ce conducteur</button>
		<c:if test="${!empty prenom}">



			<!-- Button trigger update-->
			<button type="submit" id="modif_conducteur" name="submit"
				class="btn btn-primary" value="update-${id}">Modifier</button>
		</c:if>
	</form>
</div>


</body>
</html>