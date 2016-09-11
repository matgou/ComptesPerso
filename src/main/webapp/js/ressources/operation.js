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
			isArray : false
		},
		remove: {
			method : 'DELETE',
            params: {operationId: '@id'},
            interceptor : {responseError : resourceErrorHandler}
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