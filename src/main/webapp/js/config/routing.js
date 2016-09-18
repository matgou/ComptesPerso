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
												templateUrl : 'tmpl/dashboard/indexDashboard.template.html',
												activetab: 'dashboard'
											})
									.when(
											'/accounts',
											{
												controller : 'accountController',
												templateUrl : 'tmpl/account/list.template.html',
												activetab: 'account'
											})
									.when(
											'/operations',
											{
												controller : 'operationController',
												templateUrl : 'tmpl/operation/list.template.html',
												activetab: 'operation'
											})
									.when(
											'/thirdParties',
											{
												controller : 'thirdPartyController',
												templateUrl : 'tmpl/thirdParty/list.template.html',
												activetab: 'thirdParty'
											})
									.when(
											'/categories',
											{
												controller : 'CategoryController',
												templateUrl : 'tmpl/category/list.template.html',
												activetab: 'category'
											})
											.when(
											'/paymentMethods',
											{
												controller : 'PaymentMethodController',
												templateUrl : 'tmpl/paymentMethod/list.template.html',
												activetab: 'paymentMethod'
											}).otherwise('/');
						} ]);

