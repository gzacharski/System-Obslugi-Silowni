<%@	page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="pl">

	<head>
		<meta charset="UTF-8">
		<title>Strefa Admina</title>

		<meta name="description" content="System obsługi twojej siłowni" />
		<meta name="keywords" content="system, obsługa, siłowni" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/strefa-klienta-zalogowany-user.css" type="text/css" />
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fontello.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" >
	</head>
	
	<body>
	
		<header>
			<jsp:include page="/WEB-INF/view/myHeader.jsp"/>
		</header>
		
		<main>
			<div class="container">
			
				<div class="row">
					
					<div class="headerTile col-12">
						Edytuj użytkownika<br/>
					</div>
					<div style="clear:both;"></div>
					
						<c:if test="${hasBeenSaved == true}">
							<div class="alert alert-success alert-dismissible fade show" role="alert" >
								Dane zostały zaktualizowane.
							</div>
						</c:if>
					
						<form:form id="saveForm" action="${pageContext.request.contextPath}/user/client/editUser" modelAttribute="user" method="post" cssClass="row">
						
					        <form:hidden path="id"/>
					        <form:hidden path="userAddress.id"/>
					        <form:hidden path="userAgreements.id"/>
					        <form:hidden path="userDetails.id"/>
							
							<fieldset class="form-group col-sm-12 col-md-6 col-4">
								<legend>Dane podstawowe</legend>
								
								<table border="1" cellpadding="5" style="width: 100%">
									<tbody>
						                <tr>
						                    <td>Imię:</td>
						                    <td><form:input path="name"/></td>
						                </tr>
						                <tr>
						                    <td>Nazwisko:</td>
						                   	<td><form:input path="surname"/></td>
						                </tr>
						               	<tr>
						                    <td>Email:</td>
						                   	<td><form:input path="email"/></td>
						                </tr>
						                <tr>
						                    <td>Telefon:</td>
						                   	<td><form:input path="telephone"/></td>
						                </tr>
						            </tbody>
						            
						        </table>
					        </fieldset>
					        
					        <fieldset class="form-group col-sm-12 col-md-6 col-4">
								<legend>Adres</legend>
								
								<table border="1" cellpadding="5" style="width: 100%">
									<tbody>
						                <tr>
						                    <td>Ulica:</td>
						                    <td><form:input path="userAddress.street"/></td>
						                </tr>
						                <tr>
						                    <td>Nr domu:</td>
						                   	<td><form:input path="userAddress.homeNumber"/></td>
						                </tr>
						               	<tr>
						                    <td>Kod pocztowy:</td>
						                   	<td><form:input path="userAddress.postalCode"/></td>
						                </tr>
						                <tr>
						                    <td>Miasto:</td>
						                   	<td><form:input path="userAddress.city"/></td>
						                </tr>
						            </tbody>
						            
						        </table>
					        </fieldset>
					        
					        <fieldset class="form-group col-sm-12 col-md-6 col-4">
								<legend>Wyrażone zgody</legend>
								
								<table border="1" cellpadding="5" style="width: 100%">
									<tbody>
						                <tr>
						                    <td>Zgoda nr 1:</td>
						                    <td><form:checkbox path="userAgreements.agreement1"/></td>
						                </tr>
						                <tr>
						                    <td>Zgoda nr 2:</td>
						                   	<td><form:checkbox path="userAgreements.agreement2"/></td>
						                </tr>
						               	<tr>
						                    <td>Zgoda nr 3:</td>
						                   	<td><form:checkbox path="userAgreements.agreement3"/></td>
						                </tr>
						                <tr>
						                    <td>Zgoda nr 4:</td>
						                   	<td><form:checkbox path="userAgreements.agreement4"/></td>
						                </tr>
						                 <tr>
						                    <td>Zgoda nr 5:</td>
						                   	<td><form:checkbox path="userAgreements.agreement5"/></td>
						                </tr>
						            </tbody>
						            
						        </table>
					        </fieldset>
					        
					     	<fieldset class="form-group col-sm-12 col-md-6 col-4">
								<legend>Uprawnienia</legend>

								<table border="1" cellpadding="5" style="width: 100%">
									<tbody>
							                <tr>
							                    <td>Administrator:</td>
							                    <td>
								                   <form:checkbox path="role[0]" value="ROLE_ADMIN"/>
							                    </td>
							                </tr>
							                <tr>
							                    <td>Klient</td>
							                   	<td>
							                   		<form:checkbox path="role[3]" value="ROLE_CLIENT"/>
							                   	</td>
							                </tr>
							                <tr>
							                    <td>Menadżer</td>
							                   	<td>
							                 		<form:checkbox path="role[4]" value="ROLE_MANAGER"/>
							                   	</td>
							                </tr>
							                <tr>
							                    <td>Pracownik:</td>
							                   	<td>
							                   		<form:checkbox path="role[1]" value="ROLE_EMPLOYEE"/>
							                   	</td>
							                </tr>
							                <tr>
							                    <td>Trener</td>
							                   	<td>
							                   		<form:checkbox path="role[2]" value="ROLE_TRAINER"/>
							                   	</td>
							                </tr>
						            </tbody>
						            
						        </table>
					        </fieldset>
							
				        </form:form>
				 </div>
				   
			   <div class="row">
			   
			       <div class="d-flex justify-content-between col-12">
			       
				       	<form:form action="${pageContext.request.contextPath}/user/admin/users" method="get"> 
							<button type="submit" class="btn btn-secondary float-left">Powrót</button>
						</form:form>
				     
						<form:form>
							<button type="submit" class="btn btn-secondary float-right" form="saveForm">Zapisz zmiany</button> 
						</form:form>

					</div>
					
				</div>
				
			</div>
		</main>
		
		<footer>
			<jsp:include page="/WEB-INF/view/myFooter.jsp"/>
		</footer>
		
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" 
			integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" 
			crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" 
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" 
			crossorigin="anonymous"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
		
	</body>
</html>