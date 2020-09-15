<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<table class="table table-striped table-hover table-dark">		
    <tr>
        <th>ID</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Email</th>
        <th>Zarządzaj kontem</th>
    </tr>
    
    <c:forEach var="user" items="${users}">
    	<c:url var="editUser" value="/user/admin/editUser">
			<c:param name="userId" value="${user.id}" />
		</c:url>
		
		<c:url var="deleteUser" value="/user/admin/deleteUser">
			<c:param name="userId" value="${user.id}" />
		</c:url>

        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.email}</td>
            <td>
            	<a href="${editUser}" class="btn btn-info">Edytuj</a>
            	<a href="${deleteUser}" class="btn btn-warning"
            		onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">
            		Usuń
            	</a>
            </td>
        </tr>
        
    </c:forEach>
</table>