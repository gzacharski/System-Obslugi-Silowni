<%@	page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="pl">
	<head>
		<title>Strefa Admina</title>
		<jsp:include page="/WEB-INF/view/components/metadata.jsp"/>
		<jsp:include page="/WEB-INF/view/components/stylesheets.jsp"/>
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/strefa-klienta-zalogowany-user.css" type="text/css" />
	</head>
	<body>
		<jsp:include page="/WEB-INF/view/components/header.jsp"/>
		
		<main>
			<div class="container">
			
				<div class="row">
				
					<div class="headerTile col-12 my-2">
						Dodaj miejce treningowe
					</div>	
				
					<form:form id="saveForm" action="${pageContext.request.contextPath}/user/admin/trainingRooms/add" 
						modelAttribute="place" method="post" cssClass="form-group col-sm-12 col-4">
						<jsp:include page="/WEB-INF/view/components/trainingRoom/info.jsp"/>
					</form:form>
				</div>
				
				<div class="row">
			       <div class="d-flex justify-content-between col-12 my-2">
				       	<form:form action="${pageContext.request.contextPath}/user/admin/trainingRooms" method="get"> 
							<button type="submit" class="btn btn-secondary float-left">Powrót</button>
						</form:form>
				     	
						<form:form>
							<button type="submit" class="btn btn-secondary float-right" form="saveForm">Dodaj</button> 
						</form:form>
					</div>
				</div>
						
			</div>
		</main>
		
		<jsp:include page="/WEB-INF/view/components/footer.jsp"/>
		<jsp:include page="/WEB-INF/view/components/scripts.jsp"/>
	</body>
</html>