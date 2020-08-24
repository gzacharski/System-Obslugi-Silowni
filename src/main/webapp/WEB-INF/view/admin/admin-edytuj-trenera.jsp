<%@ page language="java" contentType="text/html; charset=utf-8"
      pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 

<sql:query var="listTrainers" dataSource="jdbc/webgymsystem">
        select * from trainers where trainer_id=${param.id};
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
							Edytuj trenera
						</div>
						<div style="clear:both;"></div>
						
						<form action="Admin" method="post" id="add_trainer">
							<input type="hidden" name="command" value="EDIT_TRAINER"/>
				            <input type="hidden" name="id" value="<c:out value="${param.id}" />">
				            <c:forEach var="trainer" items="${listTrainers.rows}">
								<table>
									<tbody>
										<tr>
											<td><label>Imię: </label></td>
											<td><input type="text" name="name" value="${trainer.name}"/></td>
										</tr>
										<tr>
											<td><label>Nazwisko: </label></td>
											<td><input type="text" name="surname" value="${trainer.surname}"/></td>
										</tr>
										<tr>
											<td><label>Opis: </label></td>
											<td><textarea name="description" rows="4" cols="80" maxlength="255" minlength="10">${trainer.description}</textarea></td>
										</tr>
										<tr>
											<td><label>Zdjęcie: </label></td>
											<td><input type="text" name="image" value="${trainer.image}"/></td>
										</tr>
									</tbody>
								</table>
								
								<div style="clear:both;"></div>
								<div class="button">
										<input type="submit" value="Zapisz" class="tileButton">
								</div>
				            </c:forEach>
						</form>
						<div class="button">
							<form action="admin-lista-trenerow.jsp" method="get"> 
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