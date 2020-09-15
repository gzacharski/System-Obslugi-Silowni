<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
	<head>
		<title>Strefa Klienta - Zarejestruj się</title>
		<jsp:include page="/WEB-INF/view/components/metadata.jsp"/>
		<jsp:include page="/WEB-INF/view/components/stylesheets.jsp"/>

		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/rejestracja.css" type="text/css" />
		
		<script src="https://www.google.com/recaptcha/api.js" async defer></script>
	    <script>
	       function onSubmit(token) {
	         document.getElementById("register").submit();
	       }
	    </script>
		
	</head>
	
	<body>
		<jsp:include page="/WEB-INF/view/components/header.jsp"/>
		
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
											<jsp:include page="/WEB-INF/view/components/bootstrap-icons/person.jsp"/>
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
											<jsp:include page="/WEB-INF/view/components/bootstrap-icons/person.jsp"/>
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
											<jsp:include page="/WEB-INF/view/components/bootstrap-icons/telephone.jsp"/>
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
											<jsp:include page="/WEB-INF/view/components/bootstrap-icons/lock.jsp"/>
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
											<jsp:include page="/WEB-INF/view/components/bootstrap-icons/lock.jsp"/>
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
		
		<jsp:include page="/WEB-INF/view/components/footer.jsp"/>
		<jsp:include page="/WEB-INF/view/components/scripts.jsp"/>
	</body>
</html>