<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pl">

	<head>
		<meta charset="UTF-8">
		<title>System Obsługi siłowni</title>
	</head>
	
	<body>
	
		<main>
			<article>
			
				<table>
					<tr>
						<th>Type of workout</th>
						<th>Description</th>
						<th>Image</th>
						<th>Duration</th>
					</tr>
					
					<c:forEach var="tempWorkout" items="${workouts}">
						<tr>
							<td>${tempWorkout.typeOfWorkout}</td>
							<td>${tempWorkout.description}</td>
							<td>${tempWorkout.image}</td>
							<td>${tempWorkout.duration}</td>
						</tr>
					</c:forEach>
					
				</table>
			
			</article>
		</main>
		
	</body>
	
</html>