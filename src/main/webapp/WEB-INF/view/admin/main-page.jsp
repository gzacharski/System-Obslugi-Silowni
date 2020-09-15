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
				<article>
					<section>

						<div class="row">

							<div class="col-12 mt-2">
								<figure class="headerTile">
									<jsp:include page="/WEB-INF/view/components/bootstrap-icons/person-circle.jsp"/>
									<span>Witaj Adminie</span>
									<br>
									<security:authentication property="principal.username"/><br/>
								</figure>
							</div>
						</div>

						<div class="row">

							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
								
									<form:form id="userAccounts" action="${pageContext.request.contextPath}/user/admin/users" method="get"> 
										<button type="submit" class="tileButton" form="userAccounts">
											<span class="text-center">Zarządzaj kontami</span>
											<span style="font-size: 1.2em;">
												<jsp:include page="/WEB-INF/view/components/bootstrap-icons/people-fill.jsp"/>
											</span>
										</button>
									</form:form>
									
								</figure>
							</div>

							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form:form id="fitnessEvents" action="${pageContext.request.contextPath}/user/admin/events" method="get"> 
										<button type="submit" class="tileButton" form="fitnessEvents">
											<span class="text-center">Zarządzaj zajęciami</span>
											<span style="font-size: 1.2em;">
												<jsp:include page="/WEB-INF/view/components/bootstrap-icons/list-check.jsp"/>
											</span>
										</button>
									</form:form>
								</figure>
							</div>

							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form:form action="${pageContext.request.contextPath}/user/admin/trainers" method="get"> 
										<input type="submit" value="Zarządzaj trenerami" class="tileButton">
									</form:form>
								</figure>
							</div>

							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form:form action="${pageContext.request.contextPath}/user/admin/trainingRooms" method="get"> 
										<input type="submit" value="Zarządzaj salami treningowymi" class="tileButton">
									</form:form>
								</figure>
							</div>

							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form:form action="${pageContext.request.contextPath}/user/admin/workouts" method="get"> 
										<input type="submit" value="Zarządzaj typami treningu" class="tileButton">
									</form:form>
								</figure>
							</div>
							
							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form:form action="${pageContext.request.contextPath}/user/admin/equipment" method="get"> 
										<input type="submit" value="Zarządzaj sprzętem" class="tileButton">
									</form:form>
								</figure>
							</div>
							
							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form:form action="${pageContext.request.contextPath}/user/admin/function" method="get"> 
										<input type="submit" value="Statystyki" class="tileButton">
									</form:form>
								</figure>
							</div>

						</div>
						
					</section>
				</article>
			</div>
		</main>
		<jsp:include page="/WEB-INF/view/components/footer.jsp"/>
		<jsp:include page="/WEB-INF/view/components/scripts.jsp"/>
	</body>
</html>