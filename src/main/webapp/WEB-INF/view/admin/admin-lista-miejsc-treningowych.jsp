<%@ page language="java" contentType="text/html; charset=utf-8"
      pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 

<% if (session.getAttribute("isadmin") == null  || session.getAttribute("isadmin").equals(0)) { 
	response.sendRedirect("admin-login.jsp");
	}%>
	
<sql:query var="listPlaces" dataSource="jdbc/webgymsystem">
        select * from places;
</sql:query>

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
		<link rel="stylesheet" href="css/main.css" type="text/css" />
		<link rel="stylesheet" href="css/header.css" type="text/css" />
		<link rel="stylesheet" href="css/footer.css" type="text/css" />
		<link rel="stylesheet" href="css/strefa-klienta-zalogowany-user.css" type="text/css" />
		
		<link rel="stylesheet" href="css/fontello.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">
		
	</head>
	<body>
		<header>
			<jsp:include page="myHeader.jsp"/>
		</header>
		<main>
		
			<article>
				<section>
					<div id="container" style="height: auto; margin-bottom: 20px;">
						<div class="headerTile">
							Lista miejsc treningowych<br/>
						</div>
						<div style="clear:both;"></div>
						<table border="1" cellpadding="5" style="width: 100%">
				            <tr>
				                <th>ID</th>
				                <th>Nazwa</th>
				                <th>Opis</th>
				                <th>Edytuj</th>
				            </tr>
				            <c:forEach var="place" items="${listPlaces.rows}">
				                <tr>
				                    <td><c:out value="${place.place_id}" /></td>
				                    <td><c:out value="${place.place_name}" /></td>
				                    <td><c:out value="${place.description}" /></td>
				                    <td><a style="color:white;" href="admin-edytuj-miejsce-treningowe.jsp?id=<c:out value="${place.place_id}" />">Kliknij</a></td>
				                </tr>
				            </c:forEach>
				        </table>
						<div style="clear:both;"></div>
						<div class="button">
							<form action="Admin" method="post"> 
								<input type="hidden" name="command" value="SHOW_ADD_PLACE"/>
								<input type="submit" value="Dodaj salę treningową" class="tileButton">
							</form>
						</div>
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