/**
 * This controller for operation list
 */
comptesPerso.controller('CategoryController', [
		'$scope',
		'Category',
		'ModalService',
		function dashboardController($scope, Category, modalService) {
			$scope.currentPage = 1;
			$scope.categories = Category.query({"page": $scope.currentPage});
			// Initialise controller
			initListController($scope, 'Category', Category, modalService);
			// Reload object when modal close
			$scope.$on('ModalClose', function() {
				$scope.categories = Category.query();
			});
		} ]);
