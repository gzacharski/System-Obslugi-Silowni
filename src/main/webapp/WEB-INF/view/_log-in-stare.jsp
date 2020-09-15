<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
      
<%
	if(session.getAttribute("client")!=null) response.sendRedirect("strefa-klienta-main.jsp");
%>
      
<!DOCTYPE html>
<html lang="pl">
	<head>
		<title>Strefa Klienta</title>
		<jsp:include page="/WEB-INF/view/components/metadata.jsp"/>
		<jsp:include page="/WEB-INF/view/components/stylesheets.jsp"/>		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/strefa-klienta.css" type="text/css" />
		
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
		
		<jsp:include page="/WEB-INF/view/components/header.jsp"/>
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
									<form:form action="${pageContext.request.contextPath}/register/form" method="get">
										<h1>Zarejestruj się</h1>
										<p>Jeżeli jeszcze nie masz konta, a chcesz utworzyć - kliknij przycisk "Zarejestruj się"</p>
										<td>
											<input type="submit" value="Zarejestruj się"/>
										</td>
									</form:form>
								</figure>
							</div>
							
						</div>
						
					</section>
				</article>
			</div>
		</main>
		<jsp:include page="/WEB-INF/view/components/footer.jsp"/>
		<jsp:include page="/WEB-INF/view/components/scripts.jsp"/>
	</body>
</html>