
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

/**
 * 
 * @param scope
 * @param ressourceManager
 * @returns
 */
function previousPage(scope, ressourceManager) {
	return function() {
		p = scope.currentPage;
		if(p > 1) {
			scope.currentPage = p - 1;
			scope.refresh();
		}
	};
}

/**
 * 
 * @param scope
 * @param ressourceManager
 * @returns
 */
function nextPage(scope, ressourceManager) {
	return function() {
		scope.currentPage = scope.currentPage + 1;
		scope.refresh();
	};
}

/**
 * 
 * @param scope
 * @param ressourceManager
 * @returns
 */
function selectPage(scope, ressourceManager) {
	return function(pageNumber) {
		scope.currentPage = pageNumber;
		scope.refresh();
	};
}

function initListController(scope, type, ressourceManager, modalService) {
	scope.currentPage = 1;
	
	scope.selected = new Array();
    scope.selectAll = selectAll(scope);
    scope.unselectAll = unselectAll(scope);
    scope.askDelete = askDelete(scope, type, modalService);
	scope.handleEditClick = handleEditClick(scope, type, modalService);
	scope.handleNewClick = handleNewClick(scope, type, modalService);
	scope.previousPage = previousPage(scope, ressourceManager);
	scope.nextPage = nextPage(scope, ressourceManager);
	scope.selectPage = selectPage(scope, ressourceManager);

	scope.refresh();
}
