<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<table class="table table-striped table-hover table-dark">
    <tr>
        <th>ID</th>
        <th>Nazwa</th>
        <th>Opis</th>
        <th>Zarządzaj</th>
    </tr>
    
    <c:forEach var="place" items="${places}">
       
       	<c:url var="editTrainingRoom" value="/user/admin/trainingRooms/edit">
		<c:param name="trainingRoomId" value="${place.id}" />
		</c:url>
		
		<c:url var="deleteTrainingRoom" value="/user/admin/trainingRooms/delete">
			<c:param name="trainingRoomId" value="${place.id}" />
		</c:url>

         <tr>
             <td>${place.id}</td>
	         <td>${place.placeName}</td>
	         <td><span class="d-inline-block text-truncate" style="max-width: 600px;">${place.description}</span></td>
	         <td><a href="${editTrainingRoom}" class="btn btn-info">Edytuj</a>
	         	<a href="${deleteTrainingRoom}" class="btn btn-warning"
	         		onclick="if(!(confirm('Are you sure you want to delete this training room?'))) return false">
	         		Usuń
	         	</a>
	         </td>
        </tr>
        
    </c:forEach>
</table>