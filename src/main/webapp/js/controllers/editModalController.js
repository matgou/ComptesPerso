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

			/**
			 * @param strClass:
			 *          class name
			 * @param optionals:
			 *          constructor arguments
			 */
			ReflectUtilNewInstance = function(strClass) {
			    var args = Array.prototype.slice.call(arguments, 1);
			    var clsClass = eval(strClass);
			    function F() {
			        return clsClass.apply(this, args);
			    }
			    F.prototype = clsClass.prototype;
			    return new F();
			};
			
			$scope.$on('ModalBroadcast', function() {
				templateDirectory = modalService.objectType.charAt(0).toLowerCase() + modalService.objectType.substring(1);
				$scope.template = "tmpl/" + templateDirectory + "/editModal.template.html";
				$scope.object = modalService.object;
				Account.query({}, function(page, getResponseHeaders) { $scope.accounts = page.content});
				ThirdParty.query({}, function(page, getResponseHeaders) { $scope.thirdParties = page.content});
				Category.query({}, function(page, getResponseHeaders) { $scope.categories = page.content});
				
				$scope.reset = function(object) {
					modalService.closeModal();
				};

				$scope.update = function(object) {
					console.log("create/update : " + modalService.objectType);
					var instance = ReflectUtilNewInstance(modalService.objectType, object);
					
					instance.$save(function(user, putResponseHeaders) {
						$scope.object = instance;
						$.notify("Sauvegarde r\u00E9alis\u00E9e", "info");
						modalService.closeModal();
						$('#myModal').modal('hide');
					}, function() {
						if(object.id) {
							modalService.closeModal();
						}
					});
				};
				$('#myModal').modal('show');
			});
			
			$scope.$on('ModalDeleteBroadcast', function() {
				templateDirectory = modalService.objectType.charAt(0).toLowerCase() + modalService.objectType.substring(1);
				$scope.template = "tmpl/" + templateDirectory + "/delete.template.html";
				$scope.object = modalService.object;

				$scope.reset = function(object) {
					modalService.closeModal();
				};
				$scope.confirm = function(object) {
					console.log("delete : " + modalService.objectType);
					$scope.object.forEach(function(c) {
						var instance = ReflectUtilNewInstance(modalService.objectType, c);
						console.log("delete : " + c);
						instance.$remove(function(user, header) {
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