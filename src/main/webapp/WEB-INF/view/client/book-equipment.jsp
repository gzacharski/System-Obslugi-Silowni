<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 

<!DOCTYPE html>
<html lang="pl">
	<head>
		<title>Strefa Klienta - Zarezerwuj sprzęt</title>
		<jsp:include page="/WEB-INF/view/components/metadata.jsp"/>
		<jsp:include page="/WEB-INF/view/components/stylesheets.jsp"/>

		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/rejestracja.css" type="text/css" />
	</head>
	
	<body>
		<jsp:include page="/WEB-INF/view/components/header.jsp"/>
		
		<main class="wrapper">
			<div class="container px-md-5">
			
				<div class="justify-content-md-center">
					<h3 align="left" class="font-weight-lighter">Wypełnij poniższy formularz, aby aby zarezerwować sprzęt</h3>
					
					<form:form id="bookEquipment" action="${pageContext.request.contextPath}/user/client/equipment/book" modelAttribute="bookingOfEquipment" method="post">
						
						<div class="row">
							<div class="col-12 mb-3">
								<label for="equipment">Wybierz sprzęt</label>
								<div class="input-group">
									<form:select path="equipment.id" id="bookEquipment" class="form-control">
										<c:forEach var="tempEquipment" items="${equipments}">
											<form:option value="${tempEquipment.key}" label="${tempEquipment.value}"></form:option>
										</c:forEach>
									</form:select>
								</div>
								<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
									<form:errors path="equipment.id"/>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-6 mb-3">
								<label for="startTime">Czas rozpoczęcia używania sprzętu</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">
											<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-calendar3" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
											  <path fill-rule="evenodd" d="M14 0H2a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zM1 3.857C1 3.384 1.448 3 2 3h12c.552 0 1 .384 1 .857v10.286c0 .473-.448.857-1 .857H2c-.552 0-1-.384-1-.857V3.857z"/>
											  <path fill-rule="evenodd" d="M6.5 7a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
											</svg>
										</span>
									</div>
									<form:input path="startTime" id="startTime" type="datetime-local" class="form-control" placeholder="Czas rozpoczęcia" required="required"/>
								</div>
								<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
									<form:errors path="startTime"/>
								</div>
							</div>
							
							<div class="col-md-6 mb-3">
								<label for="endTime">Czas zakończenia używania sprzętu</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-calendar3" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
										  <path fill-rule="evenodd" d="M14 0H2a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zM1 3.857C1 3.384 1.448 3 2 3h12c.552 0 1 .384 1 .857v10.286c0 .473-.448.857-1 .857H2c-.552 0-1-.384-1-.857V3.857z"/>
										  <path fill-rule="evenodd" d="M6.5 7a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
										</svg>
									</div>
									<form:input path="endTime" id="endTime" type="datetime-local" class="form-control" placeholder="Czas zakończenia"/>
								</div>
								<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
									<form:errors path="endTime"/>
								</div>
							</div>
						</div>
						
						<button type="submit" class="btn btn-lg btn-block myButton" form="bookEquipment">Zarezerwuj sprzęt</button>
						
					</form:form>
					
				</div>
			</div>
		</main>
		
		<jsp:include page="/WEB-INF/view/components/footer.jsp"/>
		<jsp:include page="/WEB-INF/view/components/scripts.jsp"/>
	</body>
</html>