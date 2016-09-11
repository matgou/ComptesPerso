/**
 * This controller for operation list
 */
comptesPerso.controller('thirdPartyController', [
		'$scope',
		'ThirdParty',
		'ModalService',
		function dashboardController($scope, ThirdParty, modalService) {
			// Get all thirdParties
			$scope.thirdParties = ThirdParty.query();
			// Initialise controller
			initListController($scope, 'ThirdParty', ThirdParty, modalService);
			// Reload object when modal close
			$scope.$on('ModalClose', function() {
				$scope.thirdParties = ThirdParty.query();
			});
		}
]);
