/**
 * This controller for operation list
 */
comptesPerso.controller('CategoryController', [
		'$scope',
		'Category',
		'ModalService',
		function dashboardController($scope, Category, modalService) {
			$scope.refresh=function() {
				Category.query({"page": $scope.currentPage}, function(page, getResponseHeaders){
					$scope.categories = page.content;
					$scope.page = page;
				});
			};
			
			// Initialise controller
			initListController($scope, 'Category', Category, modalService);
			// Reload object when modal close
			$scope.$on('ModalClose', function() {
				$scope.refresh();
			});
		} ]);
