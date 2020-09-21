<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-12 col-md-6 col-lg-4">
	<figure class="buttonWrapper">
		<form:form action="${pageContext.request.contextPath}/user/equipments/" method="get"> 
			<input type="submit" value="Zarządzaj sprzętem" class="tileButton">
		</form:form>
	</figure>
</div>