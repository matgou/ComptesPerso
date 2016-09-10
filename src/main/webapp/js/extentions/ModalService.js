/*
 * This service is for broadcast edit request to modal windows
 */
comptesPerso.service('ModalService', [ '$rootScope', function($rootScope) {
	var ModalService = {};
	ModalService.callModal = function(type, object) {
		$( ".modal-alert" ).remove();
		this.objectType = type;
		this.object = object;
		this.broadcastItem();
	};
	ModalService.closeModal = function() {
		$rootScope.$broadcast('ModalClose');
		this.object = "";
		this.objectType = "";

		console.log("force modal => hide");
		
		//Make sure the z-index is higher than the backdrop
		$('.modal-backdrop').remove();
		
	};

	ModalService.broadcastItem = function() {
		$rootScope.$broadcast('ModalBroadcast');
	};
	
	ModalService.callDropModal = function (type, objectsToDelete) {
		this.objectType = type;
		this.object = objectsToDelete;
		$rootScope.$broadcast('ModalDeleteBroadcast');
	}

	return ModalService;
} ]);
