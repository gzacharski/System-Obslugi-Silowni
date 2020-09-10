<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Strefa Klienta - Zarejestruj się</title>

		<meta name="description" content="System obsługi twojej siłowni" />
		<meta name="keywords" content="system, obsługa, siłowni" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/rejestracja.css" type="text/css" />
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fontello.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">
		<script src="https://www.google.com/recaptcha/api.js" async defer></script>
	    <script>
	       function onSubmit(token) {
	         document.getElementById("register").submit();
	       }
	    </script>
		
	</head>
	
	<body>
		<header>
			<jsp:include page="myHeader.jsp"/>
		</header>
		
		<main class="wrapper">
			<div class="container px-md-5">
			
				<div class="justify-content-md-center">
					<h3 align="left" class="font-weight-lighter">Wypełnij poniższy formularz, aby utworzyć konto.</h3>
					
					<form:form id="register" action="${pageContext.request.contextPath}/register/process" modelAttribute="newUser" method="post">
					
						<c:if test="${registrationError!=null}">
							<div class="alert alert-danger">
									${registrationError}
							</div>
						</c:if>
						
						<div class="row">
							<div class="col-md-6 mb-3">
								<label for="name">Imię</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">
											<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-person" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
											  <path fill-rule="evenodd" d="M10 5a2 2 0 1 1-4 0 2 2 0 0 1 4 0zM8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm6 5c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
											</svg>
										</span>
									</div>
									<form:input path="name" id="name" class="form-control" placeholder="Imię" required="required"/>
								</div>
								<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
									<form:errors path="name"/>
								</div>
							</div>
							
							<div class="col-md-6 mb-3">
								<label for="surname">Nazwisko</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">
											<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-person" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
											  <path fill-rule="evenodd" d="M10 5a2 2 0 1 1-4 0 2 2 0 0 1 4 0zM8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm6 5c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
											</svg>
										</span>
									</div>
									<form:input path="surname" id="surname" class="form-control" placeholder="Nazwisko"/>
								</div>
								<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
									<form:errors path="surname"/>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-6 mb-3">
								<label for="email">Email</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">@</span>
									</div>
									<form:input path="email" id="email" class="form-control" placeholder="Email"/>
								</div>
								<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
									<form:errors path="email"/>
								</div>
							</div>
							
							<div class="col-md-6 mb-3">
								<label for="telephone">Telefon (opcjonalnie)</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">
											<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-telephone" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
											  <path fill-rule="evenodd" d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.568 17.568 0 0 0 4.168 6.608 17.569 17.569 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.678.678 0 0 0-.58-.122l-2.19.547a1.745 1.745 0 0 1-1.657-.459L5.482 8.062a1.745 1.745 0 0 1-.46-1.657l.548-2.19a.678.678 0 0 0-.122-.58L3.654 1.328zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"/>
											</svg>
										</span>
									</div>
									<form:input path="telephoneNumber" id="telephone" class="form-control" placeholder="Telefon"/>
								</div>
								<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
									<form:errors path="telephoneNumber"/>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-6 mb-3">
								<label for="password">Hasło</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">
											<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-lock" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
											  <path fill-rule="evenodd" d="M11.5 8h-7a1 1 0 0 0-1 1v5a1 1 0 0 0 1 1h7a1 1 0 0 0 1-1V9a1 1 0 0 0-1-1zm-7-1a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h7a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2h-7zm0-3a3.5 3.5 0 1 1 7 0v3h-1V4a2.5 2.5 0 0 0-5 0v3h-1V4z"/>
											</svg>
										</span>
									</div>
									<form:password path="password" id="password" class="form-control" placeholder="Hasło"/>
								</div>
								<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
									<form:errors path="password"/>
								</div>
							</div>
							
							<div class="col-md-6 mb-3">
								<label for="matchingPassword">Powtórz hasło</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">
											<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-lock" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
											  <path fill-rule="evenodd" d="M11.5 8h-7a1 1 0 0 0-1 1v5a1 1 0 0 0 1 1h7a1 1 0 0 0 1-1V9a1 1 0 0 0-1-1zm-7-1a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h7a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2h-7zm0-3a3.5 3.5 0 1 1 7 0v3h-1V4a2.5 2.5 0 0 0-5 0v3h-1V4z"/>
											</svg>
										</span>
									</div>
									<form:password path="matchingPassword" id="matchingPassword" class="form-control" placeholder="Powtórz hasło"/>
								</div>
								<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
									<form:errors path="matchingPassword"/>
								</div>
							</div>
						</div>
						
						<button type="submit" class="btn btn-lg btn-block myButton g-recaptcha" data-sitekey="${siteKey}" data-callback='onSubmit' form="register">Zarejestruj się</button>
						
						<div class="text-justify mt-4 mx-4" style="font-size: smaller;">
							<hr color="white">
							<span>
								Klikając przycisk Zarejestruj się, akceptujesz nasz <a href="#" style="font-style: italic; font-weight: bold; color: white;">Regulamin</a>. 
								<a href="#" style="font-style: italic; font-weight: bold; color: white;">Zasady dotyczące danych</a> informują w jaki sposób gromadzimy, użytkujemy i udostępniamy dane użytkowników. 
								<a href="#" style="font-style: italic; font-weight: bold; color: white;">Zasady dotyczące plików cookie</a> informują jak korzystamy z plików cookie i podobnych technologii.
							</span>
						</div>
					</form:form>
					
				</div>
			</div>
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