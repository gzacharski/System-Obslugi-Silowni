<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="pl">

	<head>
		<title>Strefa Klienta</title>
		<jsp:include page="/WEB-INF/view/components/metadata.jsp"/>
		<jsp:include page="/WEB-INF/view/components/stylesheets.jsp"/>
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/grafik.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/strefa-klienta-zalogowany-user.css" type="text/css" />

		<jsp:include page="/WEB-INF/view/components/scripts.jsp"/>
		
		<script type="text/javascript">
		 	$(document).ready(function () {
			  $('[data-toggle="tooltip"]').tooltip()
			}); 
		</script>
	</head>
	
	<body>
		<jsp:include page="/WEB-INF/view/components/header.jsp"/>
		
		<main>
			<div class="container">
			
				<section>
					
					<div class="row">
		   
				       <div class="d-flex justify-content-between col-12">
	
					       <form:form action="${pageContext.request.contextPath}/user/client/events/previousWeek" method="post">
					       		<input type="hidden" name="selectedDate" value="${selectedDate}"/>
								<button type="submit" class="btn myButton float-left align-middle">Poprzedni tydzień</button>
							</form:form>

							<section>
								<h1 align="center">Twoje rezerwacje w dniach</h1>
								<h2 align="center">${mondayOfCurrentWeek} do ${sundayOfCurrentWeek}</h2>
							</section>
							
					     	<form:form action="${pageContext.request.contextPath}/user/client/events/nextWeek" method="post">
								<input type="hidden" name="selectedDate" value="${selectedDate}"/>
								<button type="submit" class="btn myButton float-right">Następny tydzień</button> 
							</form:form>
						</div>
						
					</div>
					
					<input type="hidden" id="absolutePath" value="${pageContext.request.serverName}:${pageContext.request.localPort}${pageContext.request.contextPath}"/>
					
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
												<h2>${tempFitnessEvent.workout.typeOfWorkout}</h2>
											</div>
											
											<div class="zajecia_inner">
	
												<div class="zajecia_img">
													<div class="overlay">
														<img src="${pageContext.request.contextPath}/resources/${tempFitnessEvent.workout.image}" alt="zajecia1">
														<span class="zajecia_img_info" style="font-size:medium; vertical-align: middle;">Kliknij po więcej informacji</span>
													</div>
												</div>
		
												<div class="zajecia_info">
													<div class="zajecia_info_header">Czas rozpoczęcia:</div>
													<div class="zajecia_info_content">${localDateTimeFormat.format(tempFitnessEvent.startTime)}</div>
												</div>
		
												<form:form>
													<input type="hidden" id="workoutStartTime" value="${localDateTimeFormat.format(tempFitnessEvent.startTime)}"/>
													<input type="hidden" id="workoutDuration" value="${tempFitnessEvent.workout.duration}"/>
													<input type="hidden" id="trainerName" value="${tempFitnessEvent.trainer.user.name} ${tempFitnessEvent.trainer.user.surname}"/>
													<input type="hidden" id="maxPeople" value="${tempFitnessEvent.maxPeople}"/>
													<input type="hidden" id="placeName" value="${tempFitnessEvent.place.placeName}"/>
													<input type="hidden" id="classId" value="${tempFitnessEvent.id}"/>
												</form:form>
											</div>
										
											<div class="d-flex justify-content-between">
											
												<c:url var="cancelEvent" value="/user/client/cancelEvent">
													<c:param name="fitnessEventId" value="${tempFitnessEvent.id}" />
												</c:url>
												
												<a href="${cancelEvent}" class="btn btn-secondary btn-block align-middle" data-toggle="tooltip" data-placement="bottom" title="Zrezygnuj z udziału w zajęciach">
													<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-person-dash-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
													  <path fill-rule="evenodd" d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm5-.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5z"/>
													</svg>
													<span>Anuluj</span>
												</a>
											</div>
											
										</figure>
									</div>
								</c:if>
							</c:forEach>
						
						</div>
					</c:forEach>
					
				</section>
			</div>
		</main>
		
		<jsp:include page="/WEB-INF/view/components/footer.jsp"/>
		
		<script src="${pageContext.request.contextPath}/resources/js/grafik.js"></script>
	</body>
</html>