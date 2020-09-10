<%@	page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="pl">
	<head>
		<meta charset="UTF-8">
		<title>Strefa Admina</title>

		<meta name="description" content="System obsługi twojej siłowni" />
		<meta name="keywords" content="system, obsługa, siłowni" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/strefa-klienta-zalogowany-user.css" type="text/css" />
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fontello.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">
		
	</head>
	<body>
	
		<header>
			<jsp:include page="/WEB-INF/view/myHeader.jsp"/>
		</header>
		
		<main>
		
			<div class="container">
			
				<div class="row">
				 
					<div class="headerTile col-12">
						Edytuj zajęcia<br/>
					</div>
					
					<c:if test="${info != null}">
						<div class="alert alert-success alert-dismissible fade show" role="alert" >
							${info}
						</div>
					</c:if>
					
					<c:if test="${warning != null}">
						<div class="alert alert-warning alert-dismissible fade show" role="alert" >
							${warning}
						</div>
					</c:if>
						
					<form:form id="saveForm" action="${pageContext.request.contextPath}/user/admin/events/edit" modelAttribute="fitnessEvent" method="post">
						<table>
							<tbody>
								<form:hidden path="id"/>
								<tr>
									<td><label>Wybierz typ treningu:</label></td>
									<td>
										<form:select path="workout.id" >
											<c:forEach var="tempWorkout" items="${workouts}">
												<form:option value="${tempWorkout.key}" label="${tempWorkout.value}"></form:option>
											</c:forEach>
										</form:select>
									</td>
								</tr>
								<tr>
									<td><label>Datę i czas rozpoczęcia zajęć:</label></td>
									<td><form:input path="startTime" type="datetime-local" name="startTime"/></td>
								</tr>
								
								<tr>
									<td><label>Maksymalna licznę osób:</label></td>
									<td><form:input path="maxPeople" type="number" name="maxPeople" step="1" min="0" max="100"/></td>
								</tr>
								<tr>
									<td><label>Wybierz trenera:</label></td>
									<td>
										<form:select path="trainer.id">
											<c:forEach var="tempTrainer" items="${trainers}">
												<option value="${tempTrainer.key}" label="${tempTrainer.value}"></option>
											</c:forEach>
										</form:select>
									</td>
								</tr>
								<tr>
									<td><label>Miejce zajęć:</label></td>
									<td>
										<form:select path="place.id">
											<c:forEach var="tempPlace" items="${places}">
												<option value="${tempPlace.key}" label="${tempPlace.value}"></option>
											</c:forEach>
										</form:select>
									</td>
								</tr>
								<tr>
									<td><label>Opis: </label></td>
									<td><form:textarea path="description" rows="4" cols="80" maxlength="255" minlength="10"></form:textarea></td>
								</tr>
							</tbody>
						</table>
					</form:form>
					
				</div>
					
				<div class="row">
			       <div class="d-flex justify-content-between col-12">
			       
				       	<form:form action="${pageContext.request.contextPath}/user/admin/events" method="get"> 
							<button type="submit" class="btn btn-secondary float-left">Powrót</button>
						</form:form>
				     	
						<form:form>
							<button type="submit" class="btn btn-secondary float-right" form="saveForm">Zapisz zmiany</button> 
						</form:form>
						
					</div>
				</div>
				
			</div>
		</main>
		
		<footer>
			<jsp:include page="/WEB-INF/view/myFooter.jsp"/>
		</footer>
		
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" 
			integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" 
			crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" 
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" 
			crossorigin="anonymous"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	</body>
</html>