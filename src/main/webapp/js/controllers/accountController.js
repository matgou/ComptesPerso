/**
 * This controller for account list
 */
comptesPerso.controller('accountController', [
		'$scope',
		'Account',
		'ModalService',
		function dashboardController($scope, Account, modalService) {
			$scope.refresh=function() {
				Account.query({"page": $scope.currentPage}, function(page, getResponseHeaders){
					$scope.accounts = page.content;
					$scope.page = page;
				});
			}
			
			// Initialise controller
			initListController($scope, 'Account', Account, modalService);
			// Reload object when modal close
			$scope.$on('ModalClose', function() {
				$scope.refresh();
			});
		} ]);
