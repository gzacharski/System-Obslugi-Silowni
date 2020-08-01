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
		
		<link rel="stylesheet" href="resources/css/bootstrap.min.css">
		<link rel="stylesheet" href="resources/css/main.css" type="text/css" />
		<link rel="stylesheet" href="resources/css/header.css" type="text/css" />
		<link rel="stylesheet" href="resources/css/footer.css" type="text/css" />
		<link rel="stylesheet" href="resources/css/fontello.css">
		
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">
		
	</head>
	<body>
		<header>
			<jsp:include page="myHeader.jsp"/>
		</header>
		<main>
			<article>
				<section>
					<h1 align="center">Witaj na stronie!</h1>
				</section>
				<section>
					<div class="mySection">
						Sekcja nr1 - 
						${pageContext.request.contextPath}
					</div>
				</section>
				<section>
					<div class="mySection">
						Sekcja nr2
					</div>
				</section>
				<section>
					<div class="mySection">
						Sekcja nr3
					</div>
				</section>
				<section>
					<div class="mySection">
						Sekcja nr3
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
		<script src="resources/js/bootstrap.min.js"></script>
	</body>
</html>