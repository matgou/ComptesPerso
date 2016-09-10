/**
 * This controller for account list
 */
comptesPerso.controller('accountController', [
		'$scope',
		'Account',
		'ModalService',
		function dashboardController($scope, Account, modalService) {
			$scope.accounts = Account.query();
			// Initialise controller
			initListController($scope, 'Account', modalService);
			// Reload object when modal close
			$scope.$on('ModalClose', function() {
				$scope.accounts = Account.query();
			});
		} ]);
