//desactive le bouton d'ajout associations'
$("#submit_asso").prop("disabled", true)


//listener sur les 2 champs select
$("select").change(function() {
	// si l'un des boutons ne contient aucune selection, le bouton submit se désactive'		
	if ($("#cond").val() != "Choisir le conducteur" && $("#vehi").val() != "Choisir le véhicule") {
		$("#submit_asso").prop("disabled", false)
	} else {
		$("#submit_asso").prop("disabled", true)
	}
})

$("#submit_asso").click(function(){
	$("#association").show()
});