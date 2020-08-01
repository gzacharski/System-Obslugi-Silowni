<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% 
	
	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store"); 
	response.setDateHeader("Expires", 0); 
	response.setHeader("Pragma","no-cache");
	
	//if(session.getAttribute("client")==null) response.sendRedirect("strefa-klienta.jsp");
%> 
   
    
<!DOCTYPE html>
<html lang="pl">
<html>
	<head>
		<meta charset="UTF-16">
		<title>System Obsługi siłowni</title>

		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<meta name="description" content="System obsługi twojej siłowni" />
		<meta name="keywords" content="system, obsługa, siłowni" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<link rel="stylesheet" href="resources/css/bootstrap.min.css">
		<link rel="stylesheet" href="resources/css/main.css" type="text/css" />
		<link rel="stylesheet" href="resources/css/header.css" type="text/css" />
		<link rel="stylesheet" href="resources/css/footer.css" type="text/css" />
		<link rel="stylesheet" href="resources/css/trenerzy.css" type="text/css" />
	
		
		<link rel="stylesheet" href="css/fontello.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">
		
	</head>
	<body>
		<header>
			<jsp:include page="myHeader.jsp"/>
		</header>
		<main>
			<article>

				<div class="container">
					<section>
						<h1 align="center">Nasi trenerzy</h1>
					</section>
	
					<div class="row">
						<c:forEach var="tempTrainer" items="${trainers}">
						
							<div class="col-12 col-md-6">
								<figure class="trener">

									<a href="#">

										<div class="trener_img">
											<div class="overlay">
												<img src="${tempTrainer.image}" alt="trener">
												<span class="trener_img_info" href="#"><i class="icon-search"></i>Kliknij po więcej informacji</span>
											</div>
										</div>

										<div class="trener_opis">
											<h2>${tempTrainer.name} ${tempTrainer.surname}</h2>
											<p>${tempTrainer.description}</p>
										</div>

									</a>

								</figure>
							</div>
						</c:forEach>
					</div>

				</div>

			</article>
		</main>

		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" 
			integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" 
			crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" 
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" 
			crossorigin="anonymous"></script>
		<script src="resources/js/bootstrap.min.js"></script>

		<footer>
			<jsp:include page="myFooter.jsp"/>
		</footer>
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" 
			integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" 
			crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" 
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" 
			crossorigin="anonymous"></script>
		<script src="resources/js/bootstrap.min.js"></script>
	</body>
</html>