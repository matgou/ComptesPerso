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
			isArray : false
		},
		queryRoot: {
			method : 'GET',
			params : {
				categoryId : 'categoriesRoot'
			},
            interceptor : {responseError : resourceErrorHandler},
			isArray : true
		},
		remove: {
			method : 'DELETE',
            params: {categoryId: '@id'},
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
	});
} ]);