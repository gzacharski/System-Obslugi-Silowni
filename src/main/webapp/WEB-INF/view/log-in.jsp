<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
      
<%
	if(session.getAttribute("client")!=null) response.sendRedirect("strefa-klienta-main.jsp");
%>
      
<!DOCTYPE html>
<html lang="pl">
<html>
	<head>
		<meta charset="UTF-8">
		<title>Strefa Klienta</title>

		<meta name="description" content="System obsługi twojej siłowni" />
		<meta name="keywords" content="system, obsługa, siłowni" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/strefa-klienta.css" type="text/css" />
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fontello.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">
		
		<style>
			.fb-login-button{
			margin-top:10px;
			margin-left:5px;}
		</style>
		<script>
		function fb_logged(token){
			window.location.href="FBLogin?login="+FB.getAccessToken();
		}
		</script>
	</head>
	<body>
		<div id="fb-root"></div>
		<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v7.0&appId=256807115505376&autoLogAppEvents=1"></script>
		
		<header>
			<jsp:include page="myHeader.jsp"/>
		</header>
		<main>
			<div class="container">
				<article>
					<section>

						<div class="row">
							<div class="col-12 col-lg-6">
								<figure class="square">
									<h1>Zaloguj się</h1>
									
										<form:form action="${pageContext.request.contextPath}/authenticateUser" method="post">
											
											<div class="form-group">
										        <div class="col-xs-15">
										            <div>
															
													<!-- Check for login error -->
						
													<c:if test="${param.error != null}">
					
														<div class="alert alert-danger col-xs-offset-1 col-xs-10">
															Invalid username and password.
														</div>
													
													</c:if>
																						
													<c:if test="${param.logout !=null}">            
														<div class="alert alert-success col-xs-offset-1 col-xs-10">
															You have been logged out.
														</div>
													</c:if>	
					
										            </div>
										        </div>
										    </div>
									
											<table>
												<tbody>
													<tr>
														<td><label>Email: </label></td>
														<td><input type="text" name="username" placeholder="email"/></td>
													</tr>
													
													<tr>
														<td><label>Hasło: </label></td>
														<td><input type="password" name="password" placeholder="hasło"/></td>
													</tr>

													<tr>
														<td><label></label></td>
														<td><input type="submit" value="Zaloguj"/></td>
													</tr>
												</tbody>
											</table>
											
											<hr>
										<div class="fb-login-button" data-onlogin="fb_logged" data-scope="public_profile,email" data-size="large" data-button-type="continue_with" data-layout="default" data-auto-logout-link="false" data-use-continue-as="false" data-width=""></div>
												
									</form:form>
								</figure>
							</div>
							
							<div class="col-12 col-lg-6">
								<figure class="square">
									<h1>Zarejestruj się</h1>
									<p>Jeżeli jeszcze nie masz konta, a chcesz utworzyć - kliknij przycisk "Zarejestruj się"</p>
									<td><a href="rejestracja.jsp">
										<input type="button" value="Zarejestruj się"/>
									</a></td>
								</figure>
							</div>
							
						</div>
						
					</section>
				</article>
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