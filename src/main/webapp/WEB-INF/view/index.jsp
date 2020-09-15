<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
      
<!DOCTYPE html>
<html lang="pl">
	<head>
		<title>System Obsługi siłowni</title>
		<jsp:include page="/WEB-INF/view/components/metadata.jsp"/>
		<jsp:include page="/WEB-INF/view/components/stylesheets.jsp"/>
	</head>
	<body>
		<jsp:include page="/WEB-INF/view/components/header.jsp"/>
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
		<jsp:include page="/WEB-INF/view/components/footer.jsp"/>
		<jsp:include page="/WEB-INF/view/components/scripts.jsp"/>
	</body>
</html>