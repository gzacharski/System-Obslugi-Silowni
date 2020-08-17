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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/rejestracja.css" type="text/css" />
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fontello.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">
		
	</head>
	
	<body>
		<header>
			<jsp:include page="myHeader.jsp"/>
		</header>
		<main>
		
			<article>
				<section>
				
					<div id="container">
						<div class="square">
							<h1>Zarejestruj się</h1>
							
							<form:form action="${pageContext.request.contextPath}/register/process" modelAttribute="newUser">
							
								<c:if test="${registrationError!=null}">
									<div class="alert alert-danger">
											${registrationError}
									</div>
								</c:if>
							
								<table>
									<tbody>
										<tr>
											<td><label>Imię: </label></td>
											<td>
												<form:errors path="name"/>
												<form:input path="name" placeholder="imię (*)"/>
											</td>
										</tr>
										<tr>
											<td><label>Nazwisko: </label></td>
											<td>
												<form:errors path="surname"/>
												<form:input path="surname" placeholder="nazwisko (*)"/>
											</td>
										</tr>
										<tr>
											<td><label>Telefon: </label></td>
											<td>
												<form:errors path="telephoneNumber"/>
												<form:input path="telephoneNumber" placeholder="Telefon"/>
											</td>
										</tr>
										<tr>
											<td><label>Email: </label></td>
											<td>
												<form:errors path="email"/>
												<form:input path="email" placeholder="Email (*)"/>
											</td>
										</tr>
										<tr>
											<td><label>Hasło: </label></td>
											<td>
												<form:errors path="password"/>
												<form:password path="password" placeholder="Hasło (*)"/>
											</td>
										</tr>

										<tr>
											<td><label>Powtórz hasło: </label></td>
											<td>
												<form:errors path="matchingPassword"/>
												<form:password path="matchingPassword" placeholder="Powtórz hasło (*)"/>
										</tr>
										<tr>
											<td><label></label></td>
											<td><input type="submit" value="Zarejestruj się"/></td>
										</tr>
									</tbody>
								</table>
							</form:form>
						</div>
					</div>
					
				</section>
			</article>
			
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