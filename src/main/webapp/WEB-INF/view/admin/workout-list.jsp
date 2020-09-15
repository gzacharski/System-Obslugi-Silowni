<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="pl">
	<head>
		<title>Strefa Admina</title>
		<jsp:include page="/WEB-INF/view/components/metadata.jsp"/>
		<jsp:include page="/WEB-INF/view/components/stylesheets.jsp"/>

		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/strefa-klienta-zalogowany-user.css" type="text/css" />
	</head>
	<body>
		<jsp:include page="/WEB-INF/view/components/header.jsp"/>
		
		<main>
			<div class="container">
				
				<div class="headerTile my-2">
					Lista dostępnych treningów<br/>
				</div>
				
				<div class="d-flex justify-content-between col-12 my-2">
					<form:form action="${pageContext.request.contextPath}/user/admin/workouts/add" method="get">
						<input type="submit" value="Dodaj trening" class="btn btn-info float-left">
					</form:form>
				</div>
		
				<div class="row">
					<jsp:include page="/WEB-INF/view/components/workout/table-list.jsp"/>

					<div class="button my-2">
						<form:form action="${pageContext.request.contextPath}/user/admin/main" method="get"> 
							<input type="submit" value="Wróć" class="btn btn-secondary">
						</form:form>
					</div>
					
				</div>
			</div>
		</main>
		
		<jsp:include page="/WEB-INF/view/components/footer.jsp"/>
		<jsp:include page="/WEB-INF/view/components/scripts.jsp"/>
	</body>
</html>