/**
 * This controller for operation list
 */
comptesPerso.controller('operationController', [
		'$scope',
		'Operation',
		'Account',
		'ModalService',
		function dashboardController($scope, Operation, Account, modalService) {
			editModalTemplate = "tmpl/operation/editModal.template.html";
			$scope.operations = Operation.query();
			$scope.accounts = Account.query();

			$scope.update = function() {
				console
						.log("selected filter account="
								+ $scope.selectedAccount);
				$scope.operations = Operation.fromAccount({
					accountId : $scope.selectedAccount
				});
			};
			$scope.handleEditClick = function(operation) {
				console.log("ModalService.callModal('operation', " + operation
						+ ");")
				modalService.callModal('operation', operation);
			};
			$scope.handleNewClick = function() {
				operation = {};
				console.log("ModalService.callModal('operation', " + operation
						+ ");")
				modalService.callModal('operation', operation);
			};
			$scope.$on('ModalClose', function() {
				$scope.operation = Operation.query();
			});
		} ]);