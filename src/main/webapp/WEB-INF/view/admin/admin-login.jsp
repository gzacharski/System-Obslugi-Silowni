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
		
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/main.css" type="text/css" />
		<link rel="stylesheet" href="css/header.css" type="text/css" />
		<link rel="stylesheet" href="css/footer.css" type="text/css" />
		<link rel="stylesheet" href="css/strefa-admina.css" type="text/css" />
		
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
					<div id="container">
						<div class="square">
							<h1>Zaloguj się do panel</h1>
							
							<form action="DoAdminLogin" method="post">
								<input type="hidden" name="command" value="LOG_IN"/>
									<table>
										<tbody>
											<tr>
												<td><label>Email: </label></td>
												<td><input type="text" name="email"/></td>
											</tr>
											
											<tr>
												<td><label>Hasło: </label></td>
												<td><input type="password" name="haslo"/></td>
											</tr>

											<tr>
												<td><label></label></td>
												<td><input type="submit" value="Zaloguj"/></td>
											</tr>
											
										</tbody>
									</table>
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