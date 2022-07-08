
//desactive le bouton
$("#submit_conducteur").prop("disabled", true)

//listener sur les 2 champs
$("input:text").keyup(function() {
	if ($("#nom").val().length > 0 && $("#prenom").val().length > 0) {
		$("#submit_conducteur").prop("disabled", false)
	} else {
		$("#submit_conducteur").prop("disabled", true)
	}
})
//confirmation
$("#submit_conducteur").click(function() {
	$("#alert_conducteur").show()
})






