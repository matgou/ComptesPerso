/**
 * This service manipulate Account ressouces 
 */
comptesPerso.service('Account', [ '$resource', function($resource) {
	return $resource('accounts/:accountId.json', {}, {
		query : {
			method : 'GET',
			params : {
				accountId : 'accounts'
			},
            interceptor : {responseError : resourceErrorHandler},
			isArray : false
		},
		remove: {
			method : 'DELETE',
            params: {accountId: '@id'},
            interceptor : {responseError : resourceErrorHandler}
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