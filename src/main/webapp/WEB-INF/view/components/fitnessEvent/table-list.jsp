<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table class="table table-striped table-hover table-dark">
    <tr>
        <th>ID</th>
        <th>Zajęcia</th>
        <th>Trener</th>
        <th>Rozpoczęcie</th>
        <th>Czas trwania</th>
        <th>Max.liczba osób</th>
        <th>Sala</th>
        <th>Zarządzaj</th>
    </tr>
    
    <c:forEach var="event" items="${events}">
		<c:url var="editEvent" value="/user/admin/events/edit">
			<c:param name="eventId" value="${event.id}" />
		</c:url>
		
		<c:url var="deleteEvent" value="/user/admin/events/delete">
			<c:param name="eventId" value="${event.id}" />
		</c:url>

        <tr>
            <td>${event.id}</td>
            <td>${event.workout.typeOfWorkout}</td>
            <td>${event.trainer.user.name} ${event.trainer.user.surname}</td>
            <td>${localDateTimeFormat.format(event.startTime)}</td>
            <td>${event.workout.duration}</td>
            <td>${event.maxPeople}</td>
            <td>${event.place.placeName}</td>
            <td>
            	<a href="${editEvent}" class="btn btn-info">Edytuj</a>
            	<a href="${deleteEvent}" class="btn btn-warning"
            		onclick="if(!(confirm('Are you sure you want to delete this workout?'))) return false">
            		Usuń
            	</a>
            </td>
        </tr>
    </c:forEach>
</table>