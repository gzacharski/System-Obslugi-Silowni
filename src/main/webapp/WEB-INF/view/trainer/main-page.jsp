<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="pl">
	<head>
		<title>Strefa Trenera</title>
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
							<span>Witaj Trenerze: <security:authentication property="principal.username"/></span>
							<br>
							<span>Jaki plan treningowy na dziś?</span>
						</figure>
					</div>
				</div>

				<div class="row">
					
					<div class="col-12 col-md-6 col-lg-4">
						<figure class="buttonWrapper">
							<form:form action="${pageContext.request.contextPath}/user/trainer/function" method="get"> 
								<input type="submit" value="Funkcja 1" class="tileButton">
							</form:form>
						</figure>
					</div>
					
					<div class="col-12 col-md-6 col-lg-4">
						<figure class="buttonWrapper">
							<form:form action="${pageContext.request.contextPath}/user/trainer/function" method="get"> 
								<input type="submit" value="Funkcja 2" class="tileButton">
							</form:form>
						</figure>
					</div>
					
					<div class="col-12 col-md-6 col-lg-4">
						<figure class="buttonWrapper">
							<form:form action="${pageContext.request.contextPath}/user/trainer/function" method="get"> 
								<input type="submit" value="Funkcja 3" class="tileButton">
							</form:form>
						</figure>
					</div>

					<div class="col-12 col-md-6 col-lg-4">
						<figure class="buttonWrapper">
							<form:form action="${pageContext.request.contextPath}/user/trainer/function" method="get"> 
								<input type="submit" value="Funkcja 4" class="tileButton">
							</form:form>
						</figure>
					</div>
					
					<div class="col-12 col-md-6 col-lg-4">
						<figure class="buttonWrapper">
							<form:form action="${pageContext.request.contextPath}/user/trainer/function" method="get"> 
								<input type="submit" value="Funkcja 5" class="tileButton">
							</form:form>
						</figure>
					</div>
					
					<div class="col-12 col-md-6 col-lg-4">
						<figure class="buttonWrapper">
							<form:form action="${pageContext.request.contextPath}/user/trainer/function" method="get"> 
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