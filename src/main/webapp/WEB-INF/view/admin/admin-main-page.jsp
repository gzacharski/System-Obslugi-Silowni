<%@ page language="java" contentType="text/html; charset=utf-8"
      pageEncoding="utf-8"%>
<%@ page import = "java.io.*,java.util.*" %>
<% 
	/*
	response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
	response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
	response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
	response.setHeader("Pragma","no-cache");
	
	/*
	if (session.getAttribute("isadmin") == null  || session.getAttribute("isadmin").equals(0)) { 
		response.sendRedirect("admin-login.jsp");
	}
	*/
%>

<!DOCTYPE html>
<html lang="pl">
<html>
	<head>
		<meta charset="UTF-8">
		<title>Strefa Admina</title>

		<meta name="description" content="System obsługi twojej siłowni" />
		<meta name="keywords" content="system, obsługa, siłowni" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/strefa-klienta-zalogowany-user.css" type="text/css" />
		<link rel="stylesheet" href="css/main.css" type="text/css" />
		<link rel="stylesheet" href="css/header.css" type="text/css" />
		<link rel="stylesheet" href="css/footer.css" type="text/css" />
		
		<link rel="stylesheet" href="css/fontello.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">
		
	</head>
	<body>
		<header>
			<jsp:include page="myHeader.jsp"/>
		</header>
		<main>
			<div class="container">
				<article>
					<section>

						<div class="row">

							<div class="col-9">
								<figure class="headerTile">
									Witaj Adminie ${email}<br/>
								</figure>
							</div>

							<div class="col-3">
								<figure class="buttonWrapper">
									<form action="DoAdminLogout" method="get"> 
										<input type="submit" value="Wyloguj się" class="headerButton"/>
									</form>
								</figure>
							</div>	

						</div>

						<div class="row">

							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form action="admin-lista-user.jsp" method="get"> 
										<input type="submit" value="Zarządzaj kontami" class="tileButton">
									</form>
								</figure>
							</div>

							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form action="admin-lista-eventow.jsp" method="get"> 
										<input type="submit" value="Zarządzaj zajeciami" class="tileButton">
									</form>
								</figure>
							</div>

							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form action="admin-lista-trenerow.jsp" method="get"> 
										<input type="submit" value="Zarządzaj trenerami" class="tileButton">
									</form>
								</figure>
							</div>

							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form action="admin-lista-miejsc-treningowych.jsp" method="get"> 
										<input type="submit" value="Zarządzaj salami treningowymi" class="tileButton">
									</form>
								</figure>
							</div>

							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form action="admin-lista-typ-treningu.jsp" method="get"> 
										<input type="submit" value="Zarządzaj typami treningu" class="tileButton">
									</form>
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
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>