<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<table class="table table-striped table-hover table-dark">
	<tr>
	     <th>ID</th>
	     <th>Nazwa</th>
	     <th>Dostępna ilość</th>
	     <th>Zarządzaj</th>
	</tr>
    
    <c:forEach var="equipment" items="${equipments}">
	    <c:url var="editEquipment" value="/user/equipments/edit">
			<c:param name="equipmentId" value="${equipment.id}" />
		</c:url>
		
		<c:url var="deleteEquipment" value="/user/equipments/delete">
			<c:param name="equipmentId" value="${equipment.id}" />
		</c:url>
        	
       <tr>
           <td>${equipment.id}</td>
           <td>${equipment.name}</td>
           <td>${equipment.quantity}</td>
           <td>
           	<a href="${editEquipment}" class="btn btn-info">Edytuj</a>
           	<a href="${deleteEquipment}" data-href="${deleteEquipment}" class="btn btn-warning"
           		data-toggle="modal" data-target="#modalDelete">
           		Usuń
           	</a>
           </td>
       </tr>
   </c:forEach>
</table>