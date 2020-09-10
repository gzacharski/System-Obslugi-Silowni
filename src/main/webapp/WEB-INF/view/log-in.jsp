<%@page import="com.myprojects.gza.myGymApp.config.AppConfig"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="pl" >
	<head>
		<meta charset="UTF-8">
		<title>Strefa Klienta</title>

		<meta name="description" content="System obsługi twojej siłowni" />
		<meta name="keywords" content="system, obsługa, siłowni" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/strefa-klienta.css" type="text/css" />
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fontello.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/floating-labels.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">
		<script src="https://www.google.com/recaptcha/api.js" async defer></script>
	    <script>
	       function onSubmit(token) {
	         document.getElementById("logIn").submit();
	       }
	    </script>
		
	</head>
	<body>

		<header>
			<jsp:include page="myHeader.jsp"/>
		</header>
		
		<main class="wrapper">
			
			<form:form action="${pageContext.request.contextPath}/authenticateUser" method="post" cssClass="form-signin" id="logIn">

				<div class="form-group">
			        <div class="col-xs-15">
			            <div>
		
						<c:if test="${param.error != null}">
		
							<div class="alert alert-danger col-xs-offset-1 col-xs-10">
								Nieprawidłowy adres email lub hasło.
							</div>
						
						</c:if>
						
						<c:if test="${param.captcha != null}">
		
							<div class="alert alert-danger col-xs-offset-1 col-xs-10">
								Logowanie się nie powiodło. Proszę, spróbuj za jakiś czas.
							</div>
						
						</c:if>
															
						<c:if test="${param.logout !=null}">            
							<div class="alert alert-success col-xs-offset-1 col-xs-10">
								Poprawnie wylogowano.
							</div>
						</c:if>	
						
						<c:if test="${register==true}">            
							<div class="alert alert-success col-xs-offset-1 col-xs-10">
								Rejestracja przebiegła pomyślnie.</br> Zaloguj się, aby aktywować konto.
							</div>
						</c:if>	
		
			            </div>
			        </div>
			    </div>
					
				<div class="form-label-group">
					<input type="email" id="inputEmail" name="username" placeholder=" " class="form-control"/>
					<label for="inputEmail">Adres email</label>
				</div>
				
				<div class="form-label-group">
					<input type="password" id="inputPassword" name="password" placeholder=" " class="form-control"/>
					<label for="inputPassword">Hasło</label>
				</div>
				
				<button type="submit" class="btn btn-lg btn-block myButton g-recaptcha" data-sitekey="${siteKey}" data-callback='onSubmit' form="logIn">Zaloguj się</button>
				
				<div class="text-center m-4" style="font-size: smaller;">
					<p>Jeżeli nie masz jeszcze konta, </br> to kliknij <a href="${pageContext.request.contextPath}/register/form" style="font-style: italic; font-weight: bold; color: white;">Zarejestruj się</a></p>
					<hr color="white">
					<a href="#" style="font-style: italic; font-weight: bold; color: white;">Nie pamiętasz nazwy konta?</a>
				</div>
			</form:form>
				
		</main>
		
		<footer>
			<jsp:include page="myFooter.jsp"/>
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