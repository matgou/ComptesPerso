<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="comptesPerso">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ComptesPerso Webapp</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
	
<!-- Custom styles -->
<link href="<%=request.getContextPath()%>/css/dashboard.css"
	rel="stylesheet">
	
<base href="${req.scheme}://${fn:substring(url, fn:indexOf(url, ":")+3, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
<script type="text/javascript"> appliContext="<%=request.getContextPath()%>"; </script>
</head>

<body>

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
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#!/">ComptesPerso</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Configuration <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                  	<li class="dropdown-header">COMPTES</li>
                    <li><a href="#!/accounts">Liste des comptes</a></li>
                    <li><a href="#">Moyens de paiement</a></li>
                    <li><a href="#">Rapprochements</a></li> 
                    <li role="separator" class="divider"></li>
                    <li class="dropdown-header">APPLICATION</li>
                    <li><a href="#!/categories">Catégories</a></li>
                    <li><a href="#">Mod&egrave;les d'op&eacute;ration</a></li>                                     
                  </ul>
                </li>
				<li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Mon profil <span class="caret"></span></a>
                  <ul class="dropdown-menu">
					<li><a href="#">Aide</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="#!/accounts">Paramètres</a></li>
					<li><a href="#">Se déconnecter</a></li>
                  </ul>
                </li>

			</ul>
		</div>
	</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#!/">Synthèse<span
							class="sr-only">(current)</span></a></li>
					<li><a href="#!/operations">Opérations</a></li>
					<li><a href="#">Echéances</a></li>
					<li><a href="#!/thirdParties">Tiers</a></li>
				</ul>		
			</div>
			