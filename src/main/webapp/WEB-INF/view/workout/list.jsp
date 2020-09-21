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
					<form:form action="${pageContext.request.contextPath}/user/workouts/add" method="get">
						<input type="submit" value="Dodaj trening" class="btn btn-secondary float-left mx-2">
					</form:form>
					
					<form:form action="${pageContext.request.contextPath}/user/workouts/search" method="get" cssClass="input-group">
						<div class="input-group-prepend">
							 <span class="input-group-text" id="basic-addon1">
							   <jsp:include page="/WEB-INF/view/components/bootstrap-icons/search.jsp"/>
							</span>
						</div>
						<input type="text" name="searchedPhrase" placeholder="Szukaj treningu" class="form-control">
						<div class="input-group-append">
							<input type="submit" value="Szukaj" class="btn btn-secondary float-right">
						</div>
					</form:form>
				</div>
		
				<div class="row">
					<div class="d-flex justify-content-between col-12 my-2">
						<jsp:include page="/WEB-INF/view/components/workout/table-list.jsp"/>
					</div>

					<div class="button my-2">
						<form:form action="${pageContext.request.contextPath}/user/" method="get"> 
							<input type="submit" value="Wróć" class="btn btn-secondary">
						</form:form>
					</div>
				</div>
				
			</div>
		</main>
		
		<jsp:include page="/WEB-INF/view/components/modals/confirm-to-delete.jsp"/>
		<jsp:include page="/WEB-INF/view/components/footer.jsp"/>
		<jsp:include page="/WEB-INF/view/components/scripts.jsp"/>
	</body>
</html>