/**
 * This controller for operation list
 */
comptesPerso.controller('operationController', [
		'$scope',
		'Operation',
		'Account',
		'ModalService',
		function dashboardController($scope, Operation, Account, modalService) {
			$scope.operations = Operation.query();
			$scope.accounts = Account.query();
			$scope.update = function() {
				console.log("selected filter account="+ $scope.selectedAccount);
				$scope.operations = Operation.fromAccount({
					accountId : $scope.selectedAccount
				});
			};
			
			// Initialise controller
			initListController($scope, 'Opperation', Operation, modalService);
			// Reload object when modal close
			$scope.$on('ModalClose', function() {
				$scope.operation = Operation.query();
			});
		} ]);