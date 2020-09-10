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
				
				<div class="headerTile">
					Lista dostępnego sprzętu<br/>
				</div>
				
				<div class="d-flex justify-content-between col-12">
					<form:form action="${pageContext.request.contextPath}/user/admin/workouts/add" method="get">
						<input type="submit" value="Dodaj trening" class="btn btn-primary float-left">
					</form:form>
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
				
				<div class="row">
					
					<table class="table table-striped table-hover table-dark">
			            <tr>
			                <th>ID</th>
			                <th>Typ</th>
			                <th>Czas trwania</th>
			                <th>Edytuj</th>
			            </tr>
			            
			            <c:forEach var="workout" items="${workouts}">
			            
			            	<c:url var="editWorkout" value="/user/admin/workouts/edit">
								<c:param name="workoutId" value="${workout.id}" />
							</c:url>
							
							<c:url var="deleteWorkout" value="/user/admin/workouts/delete">
								<c:param name="workoutId" value="${workout.id}" />
							</c:url>
			            	
			                <tr>
			                    <td>${workout.id}</td>
			                    <td>${workout.typeOfWorkout}</td>
			                    <td>${workout.duration}</td>
			                    <td>
			                    	<a href="${editWorkout}" class="btn btn-info">Edytuj</a>
			                    	<a href="${deleteWorkout}" class="btn btn-warning"
			                    		onclick="if(!(confirm('Are you sure you want to delete this workout?'))) return false">
			                    		Usuń
			                    	</a>
			                    </td>
			                </tr>
			            </c:forEach>
			            
			        </table>
			        
					<div class="button">
						<form:form action="${pageContext.request.contextPath}/user/admin/main" method="get"> 
							<input type="submit" value="Wróć" class="btn btn-secondary">
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