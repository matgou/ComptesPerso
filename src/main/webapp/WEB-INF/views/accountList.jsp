<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="header.jsp" />

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h1 class="page-header">Comptes</h1>

	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>#</th>
					<th>Libell&eacute;</th>
					<th>Actif</th>
					<th>Type</th>
					<th>Solde Initial</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${list}" var="item">
					<tr>
						<td><c:out value="${item.id}" /></td>
						<td><c:out value="${item.label}" /></td>
						<td><c:out value="${item.enable}" /></td>
						<td><c:out value="${item.type}" /></td>
						<td><c:out value="${item.intialValue}" /> &euro;</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<jsp:include page="footer.jsp" />