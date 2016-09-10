/**
 * This controller for operation list
 */
comptesPerso.controller('thirdPartyController', [
		'$scope',
		'ThirdParty',
		'ModalService',
		function dashboardController($scope, ThirdParty, modalService) {
			editModalTemplate = "tmpl/thirdParty/editModal.template.html";
			$scope.thirdParties = ThirdParty.query();

			$scope.update = function() {
				console
						.log("selected filter account="
								+ $scope.selectedAccount);
				$scope.operations = Operation.fromAccount({
					accountId : $scope.selectedAccount
				});
			};
			$scope.handleEditClick = function(thirdParty) {
				console.log("ModalService.callModal('thirdParty', " + thirdParty
						+ ");")
				modalService.callModal('thirdParty', thirdParty);
			};
			
			 $scope.askDelete = function() {
					thirdPartiesToDelete = new Array();
					$scope.thirdParties.forEach(function(t) {
						if($scope.selected[t.id]) {
							thirdPartiesToDelete.push(t);
						}
					});
					
			    	console.log("ModalService.callDropModal('thirdParty', " + thirdPartiesToDelete
							+ ");")
					modalService.callDropModal('thirdParty', thirdPartiesToDelete);
			    }
			 
			$scope.handleNewClick = function() {
				thirdParty = {};
				console.log("ModalService.callModal('thirdParty', " + thirdParty
						+ ");")
						
				modalService.callModal('thirdParty', thirdParty);
			};
			$scope.$on('ModalClose', function() {
				$scope.thirdParties = ThirdParty.query();
			});
		} ]);
