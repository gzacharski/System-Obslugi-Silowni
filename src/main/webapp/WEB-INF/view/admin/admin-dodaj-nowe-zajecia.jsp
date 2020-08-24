<%@ page language="java" contentType="text/html; charset=utf-8"
      pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 


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
						<div class="headerTile" style="height: 47px;">
							Dodaj nowe zajęcia
						</div>
						<div style="clear:both;"></div>
						
						<form action="Admin" method="post" id="add_event">
							<input type="hidden" name="command" value="ADD_EVENT"/>
								<table>
									<tbody>
										<tr>
											<td><label for="workoutId">Wybierz typ treningu:</label></td>
											<td>
												<select id="workout" name="workoutId">
													<c:forEach var="tempWorkout" items="${workouts}">
														<option value="${tempWorkout.workoutId}">${tempWorkout.typeOfWorkout}</option>
													</c:forEach>
												</select>
											</td>
										</tr>
										<tr>
											<td><label>Datę i czas rozpoczęcia zajęć:</label></td>
											<td><input type="datetime-local" name="startTime"/></td>
										</tr>
										<tr>
											<td><label for="placeId">Miejce zajęć:</label></td>
											<td>
												<select id="place" name="placeId">
													<c:forEach var="tempPlace" items="${places}">
														<option value="${tempPlace.placeId}">${tempPlace.placeName}</option>
													</c:forEach>
												</select>
											</td>
										</tr>
										<tr>
											<td><label for="trainerId">Wybierz trenera:</label></td>
											<td>
												<select id="trainer" name="trainerId">
													<c:forEach var="tempTrainer" items="${trainers}">
														<option value="${tempTrainer.trainerId}">${tempTrainer.name} ${tempTrainer.surname}</option>
													</c:forEach>
												</select>
											</td>
										</tr>
										<tr>
											<td><label>Ustal maksymalną licznę osób:</label></td>
											<td><input type="number" name="maxPeople" step="1" min="0" max="100"/></td>
										</tr>
										<tr>
											<td><label>Opis: </label></td>
											<td><textarea name="description" form="add_event" rows="4" cols="80" maxlength="255" minlength="10"></textarea></td>
										</tr>
										<tr>
											<td><label></label></td>
											<td><input type="submit" value="Dodaj nowe zajęcia"/></td>
										</tr>
									</tbody>
								</table>
						</form>
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