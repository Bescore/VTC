//desactive le bouton
$("#submit_vehicule").prop("disabled", true)


//listener sur les 2 champs
$("input:text").keyup(function() {
	if ($("#marque").val().length > 0 && $("#modele").val().length > 0 &&
		$("#couleur").val().length > 0 && $("#immatriculation").val().length > 0) {
		$("#submit_vehicule").prop("disabled", false)
	} else {
		$("#submit_vehicule").prop("disabled", true)
	}
})
//confirmation
$("#submit_vehicule").click(function() {
	$("#alert_vehicule").show()
})