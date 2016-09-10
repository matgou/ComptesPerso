/**
 * This controller for account list
 */
comptesPerso.controller('accountController', [
		'$scope',
		'Account',
		'ModalService',
		function dashboardController($scope, Account, modalService) {
			editModalTemplate = "tmpl/account/editModal.template.html";
			$scope.accounts = Account.query();
			$scope.handleEditClick = function(account) {
				console.log("ModalService.callModal('account', " + account
						+ ");")
				modalService.callModal('account', account);
			};
			$scope.handleNewClick = function() {
				account = {};
				console.log("ModalService.callModal('account', " + account
						+ ");")
				modalService.callModal('account', account);
			};
			$scope.$on('ModalClose', function() {
				$scope.accounts = Account.query();
			});
		} ]);
