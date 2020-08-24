<%@ page language="java" contentType="text/html; charset=utf-8"
      pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 


<sql:query var="listEvents" dataSource="jdbc/webgymsystem">
        select *,DATE_FORMAT(start_time, '%Y-%m-%dT%T') AS myDate from fitness_events where event_id=${param.id};
</sql:query>

<sql:query var="listWorkouts" dataSource="jdbc/webgymsystem">
        select * from workouts;
</sql:query>

<sql:query var="listPlaces" dataSource="jdbc/webgymsystem">
        select * from places;
</sql:query>

<sql:query var="listTrainers" dataSource="jdbc/webgymsystem">
        select * from trainers;
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
							Edytuj zajęcia
						</div>
						<div style="clear:both;"></div>
						
						<form action="Admin" method="post" id="add_event">
							<input type="hidden" name="command" value="EDIT_EVENT"/>
				            <input type="hidden" name="id" value="<c:out value="${param.id}" />">
				            <c:forEach var="event" items="${listEvents.rows}">
								<table>
									<tbody>
										<tr>
											<td><label for="workoutId">Wybierz typ treningu:</label></td>
											<td>
												<select id="workout" name="workoutId">
													<c:forEach var="workout" items="${listWorkouts.rows}">
														<option <c:if test="${workout.workout_id == event.workout_id}">selected="selected"</c:if> value="${workout.workout_id}">${workout.type_of_workout}</option>
													</c:forEach>
												</select>
											</td>
										</tr>
										<tr>
											<td><label>Datę i czas rozpoczęcia zajęć:</label></td>
											<td><input type="datetime-local" name="startTime" value="${event.myDate}"/></td>
										</tr>
										<tr>
											<td><label for="placeId">Miejce zajęć:</label></td>
											<td>
												<select id="place" name="placeId">
													<c:forEach var="place" items="${listPlaces.rows}">
														<option <c:if test="${place.place_id == event.place_id}">selected="selected"</c:if> value="${place.place_id}">${place.place_name}</option>
													</c:forEach>
												</select>
											</td>
										</tr>
										<tr>
											<td><label for="trainerId">Wybierz trenera:</label></td>
											<td>
												<select id="trainer" name="trainerId">
													<c:forEach var="trainer" items="${listTrainers.rows}">
														<option <c:if test="${trainer.trainer_id == event.trainer_id}">selected="selected"</c:if> value="${trainer.trainer_id}">${trainer.name} ${trainer.surname}</option>
													</c:forEach>
												</select>
											</td>
										</tr>
										<tr>
											<td><label>Ustal maksymalną licznę osób:</label></td>
											<td><input type="number" name="maxPeople" step="1" min="0" max="100" value="${event.max_people}" }"/></td>
										</tr>
										<tr>
											<td><label>Opis: </label></td>
											<td><textarea name="description" form="add_event" rows="4" cols="80" maxlength="255" minlength="10">${event.description}</textarea></td>
										</tr>
									</tbody>
								</table>
								<div class="button">
										<input type="submit" value="Zapisz" class="tileButton">
								</div>
							</c:forEach>
						</form>
						<div class="button">
							<form action="admin-lista-eventow.jsp" method="get"> 
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