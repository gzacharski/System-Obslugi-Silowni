<%@ page language="java" contentType="text/html; charset=utf-8"
      pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 

<% if (session.getAttribute("isadmin") == null  || session.getAttribute("isadmin").equals(0)) { 
	response.sendRedirect("admin-login.jsp");
	}%>
	
<sql:query var="listUsers" dataSource="jdbc/webgymsystem">
        select * from clients;
</sql:query>

<!DOCTYPE html>
<html lang="pl">
	<head>
		<meta charset="UTF-8">
		<title>Strefa Admina</title>

		<meta name="description" content="System obsługi twojej siłowni" />
		<meta name="keywords" content="system, obsługa, siłowni" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/strefa-klienta-zalogowany-user.css" type="text/css" />
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fontello.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">
		
	</head>
	<body>
		<header>
			<jsp:include page="/WEB-INF/view/myHeader.jsp"/>
		</header>
		<main>
		
			<article>
				<section>
					<div id="container" style="height: auto; margin-bottom: 20px;">
						<div class="headerTile">
							Lista użytkowników<br/>
						</div>
						<div style="clear:both;"></div>
						<table border="1" cellpadding="5" style="width: 100%">
				            <tr>
				                <th>ID</th>
				                <th>Imię</th>
				                <th>Nazwisko</th>
				                <th>Email</th>
				                <th>Szczegóły</th>
				            </tr>
				            <c:forEach var="user" items="${listUsers.rows}">
				                <tr>
				                    <td><c:out value="${user.id}" /></td>
				                    <td><c:out value="${user.name}" /></td>
				                    <td><c:out value="${user.surname}" /></td>
				                    <td><c:out value="${user.email}" /></td>
				                    <td><a style="color:white;" href="admin-edytuj-user.jsp?id=<c:out value="${user.id}" />">Kliknij</a></td>
				                </tr>
				            </c:forEach>
				        </table>
						<div class="button">
							<form action="admin-main-page.jsp" method="get"> 
								<input type="submit" value="Wróć" class="tileButton">
							</form>
						</div>
						<div style="clear:both;"></div>

					</div>
				</section>
			</article>
		</main>
		<footer>
			<jsp:include page="/WEB-INF/view/myFooter.jsp"/>
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