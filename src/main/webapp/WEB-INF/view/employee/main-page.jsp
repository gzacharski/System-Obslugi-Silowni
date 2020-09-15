<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="pl">
	<head>
		<title>Strefa Pracownika</title>
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
							<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-person-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
							  <path d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z"/>
							  <path fill-rule="evenodd" d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
							  <path fill-rule="evenodd" d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z"/>
							</svg>
							<span>Witaj, jesteś zalogowany/a jako <security:authentication property="principal.username"/> na koncie pracownika.</span>
						</figure>
					</div>
				</div>
				
				<div class="row">
				
					<div class="col-12 col-md-6 col-lg-4">
						<figure class="buttonWrapper">
							<form:form action="${pageContext.request.contextPath}/user/employee/function" method="get"> 
								<input type="submit" value="Funkcja 1" class="tileButton">
							</form:form>
						</figure>
					</div>
					
					<div class="col-12 col-md-6 col-lg-4">
						<figure class="buttonWrapper">
							<form:form action="${pageContext.request.contextPath}/user/employee/function" method="get"> 
								<input type="submit" value="Funkcja 2" class="tileButton">
							</form:form>
						</figure>
					</div>
					
					<div class="col-12 col-md-6 col-lg-4">
						<figure class="buttonWrapper">
							<form:form action="${pageContext.request.contextPath}/user/employee/function" method="get"> 
								<input type="submit" value="Funkcja 3" class="tileButton">
							</form:form>
						</figure>
					</div>
					
					<div class="col-12 col-md-6 col-lg-4">
						<figure class="buttonWrapper">
							<form:form action="${pageContext.request.contextPath}/user/employee/function" method="get"> 
								<input type="submit" value="Funkcja 4" class="tileButton">
							</form:form>
						</figure>
					</div>
					
					<div class="col-12 col-md-6 col-lg-4">
						<figure class="buttonWrapper">
							<form:form action="${pageContext.request.contextPath}/user/employee/function" method="get"> 
								<input type="submit" value="Funkcja 5" class="tileButton">
							</form:form>
						</figure>
					</div>
					
					<div class="col-12 col-md-6 col-lg-4">
						<figure class="buttonWrapper">
							<form:form action="${pageContext.request.contextPath}/user/employee/function" method="get"> 
								<input type="submit" value="Funkcja 6" class="tileButton">
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