/** *************************************************************************** */
/**
 * This service is to access on Account business ressources via rest
 */
function resourceErrorHandler(response) {
	console.log(response.data);
	if(response.data.code == "InvalidEntity") {
		$.notify("Erreur de sauvegarde", "error");
		list = response.data.constraintList;
		$( ".modal-alert" ).remove();
		for(field in list) {
			console.log("error in : " + field + " : ");
			for (message in list[field]) {
				console.log(list[field][message]);
				$( "#input-" + field ).parent().addClass("has-error");
				$( "#input-" + field ).before(function() {
					  return "<span class=\"help-inline\">" + list[field][message] + "</span>";
					});
			}
		}
	} else {
		if(response.data.code) {
			$("#alertWindow").text(response.data.code + " : " + response.data.message);
			$("#errorContent").text(response.data.code + " : " + response.data.message);
			$("#errorModal").modal('show');
			$("#errorModal").css("z-index", "1500");
		} else {
			$("#errorContent").html("<strong>Une erreur non g&eacute;r&eacute; s'est produite, ouvrir un rapport d'erreur en copiant/collant les &eacute;l&eacute;ments suivants :</strong><br/><br/><br/><br/><pre>" + response.data + "</pre>");
			$("#errorModal").modal('show');
			$("#errorModal").css("z-index", "1500");
		}
	}
}