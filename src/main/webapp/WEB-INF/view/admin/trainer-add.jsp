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
						Dodaj nowego trenera<br/>
					</div>
					
					<c:choose>
						<c:when test="${trainersToBe.size()!=0}">
							<form:form id="saveForm" action="${pageContext.request.contextPath}/user/admin/trainers/add" 
										modelAttribute="newTrainer" method="post" cssClass="form-group col-sm-12 col-4">
								<jsp:include page="/WEB-INF/view/components/trainer/info-add.jsp"/>
							</form:form>
						</c:when>
						<c:otherwise>
							<div class="alert alert-info alert-dismissible fade show mx-auto" role="alert" >
								Brak nowych użytkowników z przyznanymi uprawnieniami trenera.
							</div>
						</c:otherwise>
					</c:choose>
				</div>
				
				 <div class="row">
			       <div class="d-flex justify-content-between col-12 my-2">
			       
				       	<form:form action="${pageContext.request.contextPath}/user/admin/trainers" method="get"> 
							<button type="submit" class="btn btn-secondary float-left">Powrót</button>
						</form:form>
				     	
				     	<c:if test="${trainersToBe.size()!=0}">
							<form:form>
								<button type="submit" class="btn btn-secondary float-right" form="saveForm">Zapisz zmiany</button> 
							</form:form>
						</c:if>
					</div>
				</div>
				
			</div>
		</main>
		
		<jsp:include page="/WEB-INF/view/components/footer.jsp"/>
		<jsp:include page="/WEB-INF/view/components/scripts.jsp"/>
	</body>
</html>