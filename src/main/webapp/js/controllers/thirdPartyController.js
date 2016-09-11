/**
 * This controller for operation list
 */
comptesPerso.controller('thirdPartyController', [
		'$scope',
		'ThirdParty',
		'ModalService',
		function dashboardController($scope, ThirdParty, modalService) {
			// Get all thirdParties
			$scope.refresh=function() {
				ThirdParty.query({"page": $scope.currentPage}, function(page, getResponseHeaders){
					$scope.thirdParties = page.content;
					$scope.page = page;
				});
			}
			// Initialise controller
			initListController($scope, 'ThirdParty', ThirdParty, modalService);
			// Reload object when modal close
			$scope.$on('ModalClose', function() {
				$scope.refresh();
			});
		}
]);
