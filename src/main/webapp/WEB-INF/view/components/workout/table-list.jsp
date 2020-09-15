<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

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