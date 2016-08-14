/**
 * Author: Mathieu GOULIN
 * Date : 07/08/2016 
 */

/******************************************************************************/
var comptesPerso = angular.module('comptesPerso', ['ngRoute', 'ngResource']);

angular.module('comptesPerso').
config(['$locationProvider', '$routeProvider',
  function config($locationProvider, $routeProvider) {
    $locationProvider.hashPrefix('!');

    $routeProvider.
      when('/', {
        controller: 'indexDashboardController',
        templateUrl: 'tmpl/dashboard/indexDashboard.template.html'
      }).
      when('/accounts', {
          controller: 'accountController',
          templateUrl: 'tmpl/account/list.template.html'
      }).
      when('/operations', {
          templateUrl: 'tmpl/operation/list.template.html'
      }).
      when('/thirdParties', {
          templateUrl: 'tmpl/thirdParty/list.template.html'
      }).
      otherwise('/');
  }
]);

/******************************************************************************/
/**
 * This service is to access on Account business ressources via rest
 */
comptesPerso.service('Account', ['$resource', function($resource) {
	return $resource('accounts/:accountId.json', {}, {
        query: {
          method: 'GET',
          params: {accountId: 'accounts'},
          isArray: true
        }
	
      });	
}]);
/*
 * This service is for broadcast edit request to modal windows
 */
comptesPerso.service('ModalService', ['$rootScope', function($rootScope) {
	var ModalService = {};
	ModalService.callModal = function(type, object) {
		this.objectType = type;
		this.object = object;
	    this.broadcastItem();
	};
	ModalService.closeModal = function() {
	    $rootScope.$broadcast('ModalClose');
	};

	ModalService.broadcastItem = function() {
	    $rootScope.$broadcast('ModalBroadcast');
	};
	
	return ModalService;
}]);

/******************************************************************************/
/**
 * This controller for index view
 */
comptesPerso.controller('indexDashboardController', [ '$scope','Account', 'ModalService', function dashboardController($scope, Account, modalService) {
	editModalTemplate="tmpl/account/editModal.template.html";
    $scope.accounts = Account.query();
    $scope.handleEditClick = function(account) {
    	console.log("ModalService.callModal('account', " + account + ");")
    	modalService.callModal('account', account);
    	$('#myModal').modal('show');
    };
}]);
/**
 * This controller for account list
 */
comptesPerso.controller('accountController', [ '$scope','Account', 'ModalService', function dashboardController($scope, Account, modalService) {
	editModalTemplate="tmpl/account/editModal.template.html";
    $scope.accounts = Account.query();
    $scope.handleEditClick = function(account) {
    	console.log("ModalService.callModal('account', " + account + ");")
    	modalService.callModal('account', account);
    	$('#myModal').modal('show');
    };
    $scope.handleNewClick = function() {
    	account = {};
    	console.log("ModalService.callModal('account', " + account + ");")
    	modalService.callModal('account', account);
    	$('#myModal').modal('show');
    };
    $scope.$on('ModalClose', function() { 
    	$scope.accounts = Account.query();
    });
}]);
/**
 * This controller for modal view
 */
comptesPerso.controller('editModalController', [ '$scope', 'Account', 'ModalService', function dashboardController($scope, Account, modalService) {
	$scope.$on('ModalBroadcast', function() {
		$scope.template="tmpl/" + modalService.objectType + "/editModal.template.html";
		$scope.object=modalService.object;
		$scope.update = function(object) {
			console.log("create/update : " + modalService.objectType);
			if(modalService.objectType == "account") {
				var account = new Account(object);
				account.$save(function(user, putResponseHeaders) {
					$scope.object=account;
					modalService.closeModal();
					$('#myModal').modal('hide');
				});
			}
			
		};
		
	});
}]);