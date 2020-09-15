<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
<!DOCTYPE html>
<html lang="pl">
	<head>
		<title>System Obsługi siłowni</title>
		<jsp:include page="/WEB-INF/view/components/metadata.jsp"/>
		<jsp:include page="/WEB-INF/view/components/stylesheets.jsp"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/zajecia.css" type="text/css" />
	</head>
	<body>
		<jsp:include page="/WEB-INF/view/components/header.jsp"/>
		
		<main>
			<article>
			
				<div class="container">
					<section>
						<h1 align="center">Zarezwuj sprzęt do ćwiczeń</h1>
					</section>
	
					<div class="row">
						<c:forEach var="tempEquipment" items="${equipments}">
							<div class="col-12 col-md-6 col-lg-4">
								<figure class="zajecia">

									<a href="#">

										<div class="zajecia_img">
											<div class="overlay">
												<img src="${pageContext.request.contextPath}/resources/img/equipment/${tempEquipment.photo}" alt="${tempEquipment.name}">
												<span class="zajecia_img_info" href="#">Kliknij, aby zarezerwować</span>
											</div>
										</div>

										<div class="zajecia_opis">
											<h2>${tempEquipment.name}</h2>
											<p>${tempEquipment.description}</p>
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