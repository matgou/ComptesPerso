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
			isArray : false
		},
		queryAll : {
			method : 'GET',
			params : {
				thirdPartyId : 'allThirdParties'
			},
            interceptor : {responseError : resourceErrorHandler},
			isArray : true
		},
		remove: {
			method : 'DELETE',
            params: {thirdPartyId: '@id'},
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