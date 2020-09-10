<%@ page language="java" contentType="text/html; charset=utf-8"
      pageEncoding="utf-8"%>
      
<!DOCTYPE html>
<html lang="pl">
<html>
	<head>
		<meta charset="UTF-8">
		<title>System Obsługi siłowni</title>

		<meta name="description" content="System obsługi twojej siłowni" />
		<meta name="keywords" content="system, obsługa, siłowni" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css" type="text/css" />
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
					<h1 align="center">Witaj na stronie!</h1>
				</section>
				<section>
					<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
					    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					    <li data-target="#myCarousel" data-slide-to="1"></li>
					    <li data-target="#myCarousel" data-slide-to="2"></li>
					  </ol>
						
					  <div class="carousel-inner">
					    <div class="carousel-item active">
					      	<img class="d-block w-75 mx-auto rounded" src="${pageContext.request.contextPath}/resources/img/index/runners-635906_1920.jpg" alt="First slide">
					   		<div class="carousel-caption d-none d-md-block">
							    <h5>Dołącz do naszej społeczności</h5>
							    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
						  	</div>
					    </div>
					    <div class="carousel-item">
					     	 <img class="d-block w-75 mx-auto rounded" src="${pageContext.request.contextPath}/resources/img/index/weight-lifting-1284616_1920.jpg" alt="Second slide">
					    	<div class="carousel-caption d-none d-md-block">
							    <h5>Najnowszy sprzęt</h5>
							    <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
						  	</div>
					    </div>
					    <div class="carousel-item">
					      	<img class="d-block w-75 mx-auto rounded" src="${pageContext.request.contextPath}/resources/img/index/dumbbell-1966247_1920.jpg" alt="Third slide">
					    	<div class="carousel-caption d-none d-md-block">
							    <h5>Treningi personalne</h5>
							    <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
						  	</div>
					    </div>
					  </div>
					  
					  <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
					    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					    <span class="sr-only">Poprzedni</span>
					  </a>
					  <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
					    <span class="carousel-control-next-icon" aria-hidden="true"></span>
					    <span class="sr-only">Następny</span>
					  </a>
					</div>
				</section>
				<section>
					</br>
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