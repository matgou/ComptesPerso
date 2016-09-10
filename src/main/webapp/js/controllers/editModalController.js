/**
 * This controller for modal view
 */
comptesPerso.controller('editModalController', [
		'$scope',
		'Account',
		'Operation',
		'ThirdParty',
		'Category',
		'ModalService',
		function dashboardController($scope, Account, Operation, ThirdParty,
				Category, modalService) {
			$scope.$on('ModalBroadcast', function() {
				$scope.template = "tmpl/" + modalService.objectType
						+ "/editModal.template.html";
				$scope.object = modalService.object;
				$scope.accounts = Account.query();
				$scope.thirdParties = ThirdParty.query();
				$scope.categories = Category.query();
				$scope.reset = function(object) {
					modalService.closeModal();
				};
				$scope.update = function(object) {
					console.log("create/update : " + modalService.objectType);
					if (modalService.objectType == "account") {
						var account = new Account(object);
						account.$save(function(user, putResponseHeaders) {
							$scope.object = account;
							$.notify("Sauvegarde r\u00E9alis\u00E9e", "info");
							modalService.closeModal();
							$('#myModal').modal('hide');
						}, function() {
							if(object.id) {
								account = Account.get({accountId: object.id});
								modalService.closeModal();
							}
						});
					}
					if (modalService.objectType == "operation") {
						var operation = new Operation(object);
						operation.$save(function(user, putResponseHeaders) {
							$scope.object = operation;
							$.notify("Sauvegarde r\u00E9alis\u00E9e", "info");
							modalService.closeModal();
							$('#myModal').modal('hide');
						}, function() {
							if(object.id) {
								operation = Operation.get({operationId: object.id});
								modalService.closeModal();
							}
						});
					}
					if (modalService.objectType == "category") {
						var category = new Category(object);
						category.$save(function(user, putResponseHeaders) {
							$scope.object = category;
							$.notify("Sauvegarde r\u00E9alis\u00E9e", "info");
							modalService.closeModal();
							$('#myModal').modal('hide');
						}, function() {
							if(object.id) {
								category = Category.get({categoryId: object.id});
								modalService.closeModal();
							}
						});
					}
					if (modalService.objectType == "thirdParty") {
						var thirdParty = new ThirdParty(object);
						thirdParty.$save(function(user, putResponseHeaders) {
							$scope.object = category;
							$.notify("Sauvegarde r\u00E9alis\u00E9e", "info");
							modalService.closeModal();
							$('#myModal').modal('hide');
						}, function() {
							if(object.id) {
								thirdParty = ThirdParty.get({thirdPartyId: object.id});
								modalService.closeModal();
							}
						});
					}
				};
				$('#myModal').modal('show');
			});
			
			$scope.$on('ModalDeleteBroadcast', function() {
				$scope.template = "tmpl/" + modalService.objectType
						+ "/delete.template.html";
				$scope.object = modalService.object;

				$scope.reset = function(object) {
					modalService.closeModal();
				};
				$scope.confirm = function(object) {
					console.log("delete : " + modalService.objectType);
					$scope.object.forEach(function(c) {
						console.log("delete : " + c);

						var category = new Category(c);
						category.$remove(function(user, header) {
							$.notify("Suppression OK", "info");
							modalService.closeModal();
							$('#myModal').modal('hide');
						}, function() {
						});
					});
				};
				$('#myModal').modal('show');
			});
		} ]);