/**
 * test
 */

// onclick du bouton valider
$("#valider").click(function validate() {

	$.ajax({
		type: 'POST',  // http method
		data: { myData: $("#input").val()/*, hello:"salut"*/ },  // ici tu rajoute autant de data que tu veux tu les separe par une virgule
		url: 'test',//adresse du servlet ici,
		success: function(data, status, xhr) {
			console.log(status);
			console.log(xhr);
			$("#conteneur").load(location.href + " #conteneur");
			//$('#example').load(document.URL + ' #example');//tu peux aussi faire ça mais c'est pareil
		},
		error: function(errorMessage) {
			console.log(errorMessage);
		}
	});

});

/* image qui apparaît après x secondes */
setTimeout(function() {
	$("#bart").html("<div style='width:18rem; display:flex; justify-content:center; flex-direction:column;'><p style='text-align:center'>ken apparaît après 3 secondes si il disparaît c'est que la page a été rechargé</p><img src='https://i.pinimg.com/originals/4e/cb/66/4ecb66caf4f056611766abfb2aaabfa1.gif' alt='bart'/></div>")

}, 3000)
