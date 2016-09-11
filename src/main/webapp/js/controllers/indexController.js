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
			Account.query({}, function(data, request){$scope.accounts = data.content});
			$scope.handleEditClick = function(account) {
				console.log("ModalService.callModal('account', " + account
						+ ");")
				modalService.callModal('account', account);
				$('#myModal').modal('show');
			};
		} ]);