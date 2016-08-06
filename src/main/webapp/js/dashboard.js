/**
 * 
 */
// Define the `comptesPerso` module

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
          templateUrl: 'tmpl/crud/list.template.html'
      }).
      when('/accounts/:accountId', {
          templateUrl: 'tmpl/crud/detail-edit.template.html'
      }).
      otherwise('/');
  }
]);
comptesPerso.service('Account', ['$resource', function($resource) {
	return $resource('accounts/:accountId.json', {}, {
        query: {
          method: 'GET',
          params: {accountId: 'accounts'},
          isArray: true
        }
      });
}]);
comptesPerso.controller('indexDashboardController', [ '$scope','Account', function dashboardController($scope, Account) {
    $scope.accounts = Account.query();
}]);