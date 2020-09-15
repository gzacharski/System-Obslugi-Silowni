<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html lang="pl">
	<head>
		<title>Trenerzy</title>
		<jsp:include page="/WEB-INF/view/components/metadata.jsp"/>
		<jsp:include page="/WEB-INF/view/components/stylesheets.jsp"/>
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/trenerzy.css" type="text/css" />
	</head>
	<body>
		<jsp:include page="/WEB-INF/view/components/header.jsp"/>
		
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
												<img src="${pageContext.request.contextPath}/resources/${tempTrainer.image}" alt="trener">
												<span class="trener_img_info" href="#"><i class="icon-search"></i>Kliknij po więcej informacji</span>
											</div>
										</div>

										<div class="trener_opis">
											<h2>${tempTrainer.user.name} ${tempTrainer.user.surname}</h2>
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
		
		<jsp:include page="/WEB-INF/view/components/footer.jsp"/>
		<jsp:include page="/WEB-INF/view/components/scripts.jsp"/>
	</body>
</html>