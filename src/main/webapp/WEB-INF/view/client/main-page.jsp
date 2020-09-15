<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="pl">
	<head>
		<title>Strefa Klienta</title>
		<jsp:include page="/WEB-INF/view/components/metadata.jsp"/>
		<jsp:include page="/WEB-INF/view/components/stylesheets.jsp"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/strefa-klienta-zalogowany-user.css" type="text/css" />
	</head>

	<body>
		<jsp:include page="/WEB-INF/view/components/header.jsp"/>
		
		<main>
			<div class="container">

				<div class="row">
				
					<div class="col-12 mt-3">
						<figure class="headerTile">
							<jsp:include page="/WEB-INF/view/components/bootstrap-icons/person-circle.jsp"/>
							<span>Witaj <security:authentication property="principal.username"/></span>
							<br>
							<span>Jaki plan treningowy na dziś?</span>
						</figure>
					</div>
				</div>
				
				<div class="row">
				
					<div class="col-12 col-md-6 col-lg-4">
						<figure class="buttonWrapper">
							<form:form id="userAccounts" action="${pageContext.request.contextPath}/user/client/editUser" method="get"> 
								<button type="submit" class="tileButton" form="userAccounts">
									<span class="text-center">Zarządzaj moim kontem</span>
									<svg width="1.2em" height="1.2em" viewBox="0 0 16 16" class="bi bi-people-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
									  <path fill-rule="evenodd" d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm-5.784 6A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216zM4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5z"/>
									</svg>
								</button>
							</form:form>
						</figure>
					</div>
					
					<div class="col-12 col-md-6 col-lg-4">
						<figure class="buttonWrapper">
							<form:form id="fitnessEvents" action="${pageContext.request.contextPath}/user/client/events" method="get"> 
								<button type="submit" class="tileButton" form="fitnessEvents">
									<span class="text-center">Zarządzaj moimi zajęciami</span>
									<svg width="1.2em" height="1.2em" viewBox="0 0 16 16" class="bi bi-list-check" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
									  <path fill-rule="evenodd" d="M5 11.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zM3.854 2.146a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0l-.5-.5a.5.5 0 1 1 .708-.708L2 3.293l1.146-1.147a.5.5 0 0 1 .708 0zm0 4a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0l-.5-.5a.5.5 0 1 1 .708-.708L2 7.293l1.146-1.147a.5.5 0 0 1 .708 0zm0 4a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0l-.5-.5a.5.5 0 0 1 .708-.708l.146.147 1.146-1.147a.5.5 0 0 1 .708 0z"/>
									</svg>
								</button>
							</form:form>
						</figure>
					</div>
					
					<div class="col-12 col-md-6 col-lg-4">
						<figure class="buttonWrapper">
							<form:form action="${pageContext.request.contextPath}/user/client/function" method="get"> 
								<input type="submit" value="Zarządzaj rezerwacjami sprzętu" class="tileButton">
							</form:form>
						</figure>
					</div>
					
					<div class="col-12 col-md-6 col-lg-4">
						<figure class="buttonWrapper">
							<form:form action="${pageContext.request.contextPath}/user/client/function" method="get"> 
								<input type="submit" value="Funkcja 1" class="tileButton">
							</form:form>
						</figure>
					</div>
					
					<div class="col-12 col-md-6 col-lg-4">
						<figure class="buttonWrapper">
							<form:form action="${pageContext.request.contextPath}/user/client/function" method="get"> 
								<input type="submit" value="Funkcja 2" class="tileButton">
							</form:form>
						</figure>
					</div>
					
					<div class="col-12 col-md-6 col-lg-4">
						<figure class="buttonWrapper">
							<form:form action="${pageContext.request.contextPath}/user/client/function" method="get"> 
								<input type="submit" value="Funkcja 3" class="tileButton">
							</form:form>
						</figure>
					</div>
					
				</div>
			</div>
		</main>
		
		<jsp:include page="/WEB-INF/view/components/footer.jsp"/>
		<jsp:include page="/WEB-INF/view/components/scripts.jsp"/>
	</body>
</html>