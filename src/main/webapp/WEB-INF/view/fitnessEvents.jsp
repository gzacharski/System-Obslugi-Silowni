<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% 
	
	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store"); 
	response.setDateHeader("Expires", 0); 
	response.setHeader("Pragma","no-cache");
	
	//if(session.getAttribute("client")==null) response.sendRedirect("strefa-klienta.jsp");
%> 
   
    
<!DOCTYPE html>
<html lang="pl">
<html>
	<head>
		<meta charset="UTF-8">
		<title>System Obsługi siłowni</title>

		<meta name="description" content="System obsługi twojej siłowni" />
		<meta name="keywords" content="system, obsługa, siłowni" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

		<link rel="stylesheet" href="resources/css/bootstrap.min.css">
		<link rel="stylesheet" href="resources/css/main.css" type="text/css" />
		<link rel="stylesheet" href="resources/css/header.css" type="text/css" />
		<link rel="stylesheet" href="resources/css/footer.css" type="text/css" />
		<link rel="stylesheet" href="resources/css/grafik.css" type="text/css" />
		
		<link rel="stylesheet" href="resources/css/fontello.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">
		
		<script defer="defer" src="resources/js/currentDate.js"></script>
	</head>
	<body>
		<header>
			<jsp:include page="myHeader.jsp"/>
		</header>
		<main>
			<div class="container">
			<article>
				<section>
					<h1 align="center">Zajęcia w dniach</h1>
					<h2 align="center"><%= request.getAttribute("mondayInSelectedWeek")%> do <%= request.getAttribute("sundayInSelectedWeek")%></h2>
				</section>
				<section>
					<form action="FitnessEvents" method="post" id="previousWeek">
						<input type="hidden" name="clientId" value="${sessionScope.client.id}"/>
						<input type="hidden" id="previousDateTime" name="selectedDateTime" value="<%= request.getAttribute("previousDateTime")%>"/>
					</form>
					
					<form action="FitnessEvents" method="post" id="selectedWeek">
						<input type="hidden" name="clientId" value="${sessionScope.client.id}"/>
						<input type="hidden" id="selectedDateTime" name="selectedDateTime" value="<%= request.getAttribute("selectedDateTime")%>"/>
					</form>
						
					<form action="FitnessEvents" method="post" id="nextWeek">
						<input type="hidden" name="clientId" value="${sessionScope.client.id}"/>
						<input type="hidden" id="nextDateTime" name="selectedDateTime" value="<%= request.getAttribute("nextDateTime")%>"/>
					</form>
					
					<form class="form-inline">
						<button class="btn headerTile btn-lg" type="submit" form="previousWeek">Poprzedni tydzień</button>
						<button class="btn headerTile btn-lg ml-auto" type="submit" form="nextWeek">Następny tydzień</button>
					</form>
					
					<c:forEach var="dayOfWeek" begin="1" end="7">
						<div class="row">
							<div class="col-12">
								<figure class="headerTile">
									<c:choose>
										<c:when test="${dayOfWeek==1}">Poniedziałek</c:when>
										<c:when test="${dayOfWeek==2}">Wtorek</c:when>
										<c:when test="${dayOfWeek==3}">Środa</c:when>
										<c:when test="${dayOfWeek==4}">Czwartek</c:when>
										<c:when test="${dayOfWeek==5}">Piątek</c:when>
										<c:when test="${dayOfWeek==6}">Sobota</c:when>
										<c:otherwise>Niedziela</c:otherwise>
									</c:choose>
								</figure>
							</div>
	
							<c:forEach var="tempFitnessEvent" items="${fitnessEvents}">
								<c:if test="${tempFitnessEvent.startTime.dayOfWeek.value==dayOfWeek}">
									<div class="col-6 col-md-4 col-lg-3 col-xl-2">
										<figure class="zajecia">
	
											<div class="zajecia_opis">
												<h2>${tempFitnessEvent.typeOfWorkout}</h2>
											</div>
	
											<div class="zajecia_img">
												<div class="overlay" onclick="#">
													<img src="${tempFitnessEvent.workoutImage}" alt="zajecia1">
													<span class="zajecia_img_info" href="#">Kliknij by się zapisać</span>
												</div>
											</div>
	
											<div class="zajecia_info">
												<div class="zajecia_info_header">Czas rozpoczęcia:</div>
												<div class="zajecia_info_content">${tempFitnessEvent.startTime}</div>
											</div>

											<form>
												<input type="hidden" id="workoutStartTime" value="${tempFitnessEvent.startTime}"/>
												<input type="hidden" id="workoutDuration" value="${tempFitnessEvent.workoutDuration}"/>
												<input type="hidden" id="trainerName" value="${tempFitnessEvent.trainerName} ${tempFitnessEvent.trainerSurname}"/>
												<input type="hidden" id="maxPeople" value="${tempFitnessEvent.maxPeople}"/>
												<input type="hidden" id="placeName" value="${tempFitnessEvent.placeName}"/>
												<input type="hidden" id="classId" value="${tempFitnessEvent.classId}"/>
											</form>

										</figure>
									</div>
								</c:if>
							</c:forEach>
						
						</div>
					</c:forEach>
				</section>
			</article>
			</div>
		</main>
		<footer>
			<jsp:include page="myFooter.jsp"/>
		</footer>

		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" 
			integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" 
			crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" 
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" 
			crossorigin="anonymous"></script>
		<script src="resources/js/bootstrap.min.js"></script>
		<script src="resources/js/grafik.js"></script>
		
	</body>
</html>