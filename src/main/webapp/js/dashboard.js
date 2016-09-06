/**
 * Author: Mathieu GOULIN
 * Date : 07/08/2016 
 */

/** *************************************************************************** */
var comptesPerso = angular.module('comptesPerso', [ 'ngRoute', 'ngResource' ]);

angular
		.module('comptesPerso')
		.config(
				[
						'$locationProvider',
						'$routeProvider',
						function config($locationProvider, $routeProvider) {
							$locationProvider.hashPrefix('!');

							$routeProvider
									.when(
											'/',
											{
												controller : 'indexDashboardController',
												templateUrl : 'tmpl/dashboard/indexDashboard.template.html'
											})
									.when(
											'/accounts',
											{
												controller : 'accountController',
												templateUrl : 'tmpl/account/list.template.html'
											})
									.when(
											'/operations',
											{
												controller : 'operationController',
												templateUrl : 'tmpl/operation/list.template.html'
											})
									.when(
											'/thirdParties',
											{
												controller : 'thirdPartyController',
												templateUrl : 'tmpl/thirdParty/list.template.html'
											})
									.when(
											'/categories',
											{
												controller : 'CategoryController',
												templateUrl : 'tmpl/category/list.template.html'
											}).otherwise('/');
						} ]);


angular.module('comptesPerso').
directive('dt', function(){
  return {
    require: '?ngModel',
    restrict: 'A',
    link: function ($scope, element, attrs, controller) {
          var updateModel, onblur;

          if (controller !== null) {

              updateModel = function () {
              	if (element.data("DateTimePicker").minViewMode === element.data("DateTimePicker").viewMode) {
	                    element.data("DateTimePicker").hide();
                      element.blur();
              	}
              };

              onblur = function () {
                  var date = element.datetimepicker().data("DateTimePicker").getMoment().toDate();
                  return $scope.$apply(function () {
                      return controller.$setViewValue(date);
                  });
              };

              controller.$render = function () {
                  var date = controller.$viewValue;
                  if (angular.isDefined(date) && date != null && moment.isMoment(date)) {
          			element.datetimepicker().data("DateTimePicker").date(date);
                  } else if (angular.isDefined(date)) {
                	  console.log(element.datetimepicker().data("DateTimePicker"));
                	  element.datetimepicker().data("DateTimePicker").date(moment(date));
                  }
                  return controller.$viewValue;
              };
          }
          return attrs.$observe('dt', function (value) {
              var options;
              options = { }; //<--- insert your own defaults here!
              if (angular.isObject(value)) {
                  options = value;
              }
              if (typeof (value) === "string" && value.length > 0) {
                  options = angular.fromJson(value);
              }
              return element.datetimepicker(options).on('change.dp', updateModel).on('blur', onblur);
          });
      }
  };
});

/** *************************************************************************** */
/**
 * This service is to access on Account business ressources via rest
 */
function resourceErrorHandler(response) {
	console.log(response.data);
	if(response.data.code == "InvalidEntity") {
		$.notify("Erreur de sauvegarde", "error");
		list = response.data.constraintList;
		$( ".modal-alert" ).remove();
		for(field in list) {
			console.log("error in : " + field + " : ");
			for (message in list[field]) {
				console.log(list[field][message]);
				$( "#input-" + field ).after(function() {
					  return "<div class=\"modal-alert alert alert-warning\">" + list[field][message] + "</div>";
					});
			}
		}
	} else {
		if(response.data.code) {
			$("#alertWindow").text(response.data.code + " : " + response.data.message);
			$("#errorContent").text(response.data.code + " : " + response.data.message);
			$("#errorModal").modal('show');
			$("#errorModal").css("z-index", "1500");
		} else {
			$("#errorContent").html("<strong>Une erreur non g&eacute;r&eacute; s'est produite, ouvrir un rapport d'erreur en copiant/collant les &eacute;l&eacute;ments suivants :</strong><br/><br/><br/><br/><pre>" + response.data + "</pre>");
			$("#errorModal").modal('show');
			$("#errorModal").css("z-index", "1500");
		}
	}
}

comptesPerso.service('Account', [ '$resource', function($resource) {
	return $resource('accounts/:accountId.json', {}, {
		query : {
			method : 'GET',
			params : {
				accountId : 'accounts'
			},
            interceptor : {responseError : resourceErrorHandler},
			isArray : true
		},
        get: {
            method:'GET', 
            interceptor : {responseError : resourceErrorHandler}
  		},
          save: {
            method:'POST',
            interceptor : {responseError : resourceErrorHandler}
          },

	});
} ]);
/**
 * This service is to access on Operation business ressources via rest
 */
comptesPerso.service('Operation', [ '$resource', function($resource) {
	return $resource('operations/:operationId.json', {}, {
		query : {
			method : 'GET',
			params : {
				operationId : 'operations'
			},
			interceptor : {
				responseError : resourceErrorHandler
			},
			isArray : true
		},
		get : {
			method : 'GET',
			interceptor : {
				responseError : resourceErrorHandler
			}
		},
		save : {
			method : 'POST',
			interceptor : {
				responseError : resourceErrorHandler
			}
		},
		fromAccount : {
			method : 'GET',
			url : 'transactions/account/:accountId.json',
			isArray : true
		}

	});
} ]);
/**
 * This service is to access on ThirdParty business ressources via rest
 */
comptesPerso.service('ThirdParty', [ '$resource', function($resource) {
	return $resource('thirdParty/:thirdPartyId.json', {}, {
		query : {
			method : 'GET',
			params : {
				thirdPartyId : 'thirdParties'
			},
            interceptor : {responseError : resourceErrorHandler},
			isArray : true
		},
		get : {
			method : 'GET',
			interceptor : {
				responseError : resourceErrorHandler
			}
		},
		save : {
			method : 'POST',
			interceptor : {
				responseError : resourceErrorHandler
			}
		},
	});
} ]);

/**
 * This service is to access on Category business ressources via rest
 */
comptesPerso.service('Category', [ '$resource', function($resource) {
	return $resource('category/:categoryId.json', {}, {
		query : {
			method : 'GET',
			params : {
				categoryId : 'categories'
			},
            interceptor : {responseError : resourceErrorHandler},
			isArray : true
		},
		get : {
			method : 'GET',
			interceptor : {
				responseError : resourceErrorHandler
			}
		},
		save : {
			method : 'POST',
			interceptor : {
				responseError : resourceErrorHandler
			}
		},
	});
} ]);

/*
 * This service is for broadcast edit request to modal windows
 */
comptesPerso.service('ModalService', [ '$rootScope', function($rootScope) {
	var ModalService = {};
	ModalService.callModal = function(type, object) {
		$( ".modal-alert" ).remove();
		this.objectType = type;
		this.object = object;
		this.broadcastItem();
	};
	ModalService.closeModal = function() {
		$rootScope.$broadcast('ModalClose');
		this.object = "";
		this.objectType = "";
	};

	ModalService.broadcastItem = function() {
		$rootScope.$broadcast('ModalBroadcast');
	};

	return ModalService;
} ]);

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

/**
 * This controller for operation list
 */
comptesPerso.controller('operationController', [
		'$scope',
		'Operation',
		'Account',
		'ModalService',
		function dashboardController($scope, Operation, Account, modalService) {
			editModalTemplate = "tmpl/operation/editModal.template.html";
			$scope.operations = Operation.query();
			$scope.accounts = Account.query();

			$scope.update = function() {
				console
						.log("selected filter account="
								+ $scope.selectedAccount);
				$scope.operations = Operation.fromAccount({
					accountId : $scope.selectedAccount
				});
			};
			$scope.handleEditClick = function(operation) {
				console.log("ModalService.callModal('operation', " + operation
						+ ");")
				modalService.callModal('operation', operation);
			};
			$scope.handleNewClick = function() {
				operation = {};
				console.log("ModalService.callModal('operation', " + operation
						+ ");")
				modalService.callModal('operation', operation);
			};
			$scope.$on('ModalClose', function() {
				$scope.operation = Operation.query();
			});
		} ]);
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
					$('#myModal').modal('hide');
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
		} ]);