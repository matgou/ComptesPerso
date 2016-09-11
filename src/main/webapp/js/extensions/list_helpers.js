
/**
 * Return a function to modify scope and select all 
 * @param scope
 * @returns
 */
function selectAll(scope) {
	return function(objects) {
		objects.forEach(function(c) {
			scope.selected[c.id] = true;
		});
	};
}

/**
 * Return a function to modify scope and unselect all
 * @param scope
 * @returns
 */
function unselectAll(scope) {
	return function(objects) {
		objects.forEach(function(c) {
			scope.selected[c.id] = false;
		});
	};
}

/**
 * 
 * @param scope
 * @param type
 * @param modalService
 * @returns
 */
function askDelete(scope, type, modalService) {
	return function(objects) {
		elementsToDelete = new Array();
		objects.forEach(function(c) {
			if(scope.selected[c.id]) {
				elementsToDelete.push(c);
			}
		});

    	console.log("ModalService.callDropModal(" + type + ", " + elementsToDelete + ");")
		modalService.callDropModal(type, elementsToDelete);
	}
}

/**
 * 
 * @param scope
 * @param type
 * @param modalService
 * @returns
 */
function handleNewClick(scope, type, modalService) {
	return function() {
		object = {};
		console.log("ModalService.callModal('" + type + "', " + object + ");")
		modalService.callModal(type, object);
	};
};

/**
 * 
 * @param scope
 * @param type
 * @param modalService
 * @returns
 */
function handleEditClick(scope, type, modalService) {
	return function(object) {
		console.log("ModalService.callModal('" + type + "', " + object + ");")
		modalService.callModal(type, object);
	};
};


function initListController(scope, type, modalService) {
	scope.selected = new Array();
    scope.selectAll = selectAll(scope);
    scope.unselectAll = unselectAll(scope);
    scope.askDelete = askDelete(scope, type, modalService);
	scope.handleEditClick = handleEditClick(scope, type, modalService);
	scope.handleNewClick = handleNewClick(scope, type, modalService);
}
