/**
 * This controller for operation list
 */
comptesPerso.controller('CategoryController', [
		'$scope',
		'Category',
		'ModalService',
		function dashboardController($scope, Category, modalService) {
			editModalTemplate = "tmpl/category/editModal.template.html";
			$scope.categories = Category.query();
			$scope.selected = new Array();
			
			// init view nothing selected
			$scope.categories.forEach(function(c) {
				$scope.selected[c.id] = false;
			});
			
			$scope.change = function(id) {
		        if($scope.selected[id]) {
		        	$scope.selected[id] = true;
		        } else {
		        	$scope.selected[id] = false;
		        }
		      };
		      
		    $scope.askDelete = function() {
				categoriesToDelete = new Array();
				$scope.categories.forEach(function(c) {
					if($scope.selected[c.id]) {
						categoriesToDelete.push(c);
					}
				});
				
		    	console.log("ModalService.callDropModal('category', " + categoriesToDelete
						+ ");")
				modalService.callDropModal('category', categoriesToDelete);
		    }
		    $scope.selectAll = function() {
				$scope.categories.forEach(function(c) {
					$scope.selected[c.id] = true;
				});
		      };
		      
		    $scope.unselectAll = function() {
		    	$scope.categories.forEach(function(c) {
		    		$scope.selected[c.id] = false;
		    	});
		    }

			$scope.handleEditClick = function(category) {
				console.log("ModalService.callModal('category', " + category
						+ ");")
				modalService.callModal('category', category);
			};
			
			$scope.handleNewClick = function() {
				category = {};
				console.log("ModalService.callModal('category', " + category
						+ ");")
				modalService.callModal('category', category);
			};
			$scope.$on('ModalClose', function() {
				$scope.categories = Category.query();
			});
		} ]);
