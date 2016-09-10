/**
 * This controller for operation list
 */
comptesPerso.controller('CategoryController', [
		'$scope',
		'Category',
		'ModalService',
		function dashboardController($scope, Category, modalService) {
			$scope.categories = Category.query();
			// Initialise controller
			initListController($scope, 'Category', modalService);
			// Reload object when modal close
			$scope.$on('ModalClose', function() {
				$scope.categories = Category.query();
			});
		} ]);
