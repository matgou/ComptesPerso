/**
 * This controller for operation list
 */
comptesPerso.controller('operationController', [
		'$scope',
		'Operation',
		'Account',
		'ModalService',
		function dashboardController($scope, Operation, Account, modalService) {
			$scope.refresh=function() {
				Operation.query({"page": $scope.currentPage}, function(page, getResponseHeaders){
					$scope.operations = page.content;
					$scope.page = page;
				});
			};
			Account.query({}, function(page, getResponseHeaders) {
				$scope.accounts = page.content;
			});
			$scope.update = function() {
				console.log("selected filter account="+ $scope.selectedAccount);
				$scope.operations = Operation.fromAccount({
					accountId : $scope.selectedAccount
				});
			};
			
			// Initialise controller
			initListController($scope, 'Operation', Operation, modalService);
			// Reload object when modal close
			$scope.$on('ModalClose', function() {
				$scope.refresh();
			});
		} ]);