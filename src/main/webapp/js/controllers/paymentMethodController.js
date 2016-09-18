/**
 * This controller for operation list
 */
comptesPerso.controller('PaymentMethodController', [
		'$scope',
		'PaymentMethod',
		'ModalService',
		function dashboardController($scope, PaymentMethod, modalService) {
			$scope.refresh=function() {
				PaymentMethod.query({"page": $scope.currentPage}, function(page, getResponseHeaders){
					$scope.paymentMethods = page.content;
					$scope.page = page;
				});
			};
			
			// Initialise controller
			initListController($scope, 'PaymentMethod', PaymentMethod, modalService);
			// Reload object when modal close
			$scope.$on('ModalClose', function() {
				$scope.refresh();
			});
		} ]);
