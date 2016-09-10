
		</div>
	</div>


	<div class="modal modal-message" id="errorModal">
		<div class="modal-dialog">
			<div class="modal-content">
                <div class="modal-header modal-danger">
                	<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title"><i class="glyphicon glyphicon-fire"></i> Oup's une erreur est survenue !</h4>                
                </div>
				<div class="container"></div>
				<div class="modal-body" id="errorContent">Content for the
					dialog / modal goes here.</div>
				<div class="modal-footer">
					<a href="#" data-dismiss="modal" class="btn">Close</a>
				</div>
			</div>
		</div>
	</div>

	<div ng-controller="editModalController"><div ng-include="template"></div></div>
	
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<script
		src="https://rawgit.com/notifyjs/notifyjs/master/dist/notify.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular-route.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular-resource.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.14.1/moment-with-locales.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
		
	<!-- Main Angular definition -->
	<script src="<%=request.getContextPath()%>/js/config/routing.js"></script>
	
	<!-- Application spécific extention -->
	<script src="<%=request.getContextPath()%>/js/extensions/dt_timepicker.js"></script>
	<script src="<%=request.getContextPath()%>/js/extensions/ModalService.js"></script>
	<script src="<%=request.getContextPath()%>/js/extensions/resourceErrorHandler.js"></script>
	<script src="<%=request.getContextPath()%>/js/extensions/list_helpers.js"></script>
	
	<!-- Ressources -->
	<script src="<%=request.getContextPath()%>/js/ressources/account.js"></script>
	<script src="<%=request.getContextPath()%>/js/ressources/category.js"></script>
	<script src="<%=request.getContextPath()%>/js/ressources/operation.js"></script>
	<script src="<%=request.getContextPath()%>/js/ressources/thirdParty.js"></script>
	
	<!-- Controllers -->
	<script src="<%=request.getContextPath()%>/js/controllers/accountController.js"></script>
	<script src="<%=request.getContextPath()%>/js/controllers/categoryController.js"></script>
	<script src="<%=request.getContextPath()%>/js/controllers/editModalController.js"></script>
	<script src="<%=request.getContextPath()%>/js/controllers/indexController.js"></script>
	<script src="<%=request.getContextPath()%>/js/controllers/mainController.js"></script>
	<script src="<%=request.getContextPath()%>/js/controllers/operationController.js"></script>
	<script src="<%=request.getContextPath()%>/js/controllers/thirdPartyController.js"></script>
	
	
	<script src="<%=request.getContextPath()%>/js/all.js"></script>
	
	
	
	
	<script>
	$('#errorModal').on('shown.bs.modal', function() {
		  console.log("errorModal => hide");
		  //Make sure the modal and backdrop are siblings (changes the DOM)
		  $(this).before($('.modal-backdrop'));
		  //Make sure the z-index is higher than the backdrop
		  $(this).css("z-index", parseInt($('.modal-backdrop').css('z-index')) + 1);
		});
	</script>
</body>	
</html>