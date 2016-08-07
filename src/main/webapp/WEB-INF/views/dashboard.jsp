<jsp:include page="header.jsp" />

<div ng-controller="editModalController"><div ng-include="template"></div></div>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" ng-view>
</div>
<jsp:include page="footer.jsp" />