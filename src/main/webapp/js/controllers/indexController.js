/** *************************************************************************** */
/**
 * This controller for index view
 */
comptesPerso.controller('indexDashboardController', [
		'$scope',
		'Account',
		'ModalService',
		function dashboardController($scope, Account, modalService) {
			$scope.disableEditMode = true;
			editModalTemplate = "tmpl/account/editModal.template.html";
			$scope.accounts = Account.query();
			$scope.handleEditClick = function(account) {
				console.log("ModalService.callModal('account', " + account
						+ ");")
				modalService.callModal('account', account);
				$('#myModal').modal('show');
			};
		} ]);