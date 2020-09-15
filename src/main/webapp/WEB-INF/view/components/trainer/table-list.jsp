<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<table class="table table-striped table-hover table-dark">
					
    <tr>
        <th>ID Trenera</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Email</th>
        <th>Zarządzaj kontem</th>
    </tr>
    
    <c:forEach var="trainer" items="${trainers}">
    	<c:url var="editTrainer" value="/user/admin/trainers/edit">
			<c:param name="trainerId" value="${trainer.id}" />
		</c:url>
		
		<c:url var="deleteTrainer" value="/user/admin/trainers/delete">
			<c:param name="trainerId" value="${trainer.id}" />
		</c:url>
    	
        <tr>
            <td>${trainer.id}</td>
            <td>${trainer.user.name}</td>
            <td>${trainer.user.surname}</td>
            <td>${trainer.user.email}</td>
            <td>
            	<a href="${editTrainer}" class="btn btn-info">Edytuj</a>
            	<a href="${deleteTrainer}" class="btn btn-warning"
            		onclick="if(!(confirm('Are you sure you want to delete this trainer?'))) return false">
            		Usuń
            	</a>
            </td>
        </tr>
    </c:forEach>
</table>