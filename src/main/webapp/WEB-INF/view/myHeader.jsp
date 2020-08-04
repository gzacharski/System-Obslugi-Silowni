<%@ page language="java" contentType="text/html; charset=utf-8"
      pageEncoding="utf-8"%>

<h1 class="logo">System Obsługi Siłowni</h1>

<nav id="topnav" class="navbar navbar-dark bg-mynavbg navbar-expand-lg">
	
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
		<span class="togglenav"><i class="icon-pitch"></i>System obsługi siłowni</span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mx-auto menu">
			<li class="nav-item">
				<a class="nav-link" href="${pageContext.request.contextPath}/">Strona główna</a>
			</li>
			<li>
				<a class="nav-link" href="${pageContext.request.contextPath}/workouts/list">Zajęcia</a>
			</li>
			<li>
				<a class="nav-link" href="${pageContext.request.contextPath}/trainers/list">Trenerzy</a>
			</li>
			<li>
				<a class="nav-link" href="${pageContext.request.contextPath}/fitnessEvents">Grafik</a>
			</li>
			<li>
				<a class="nav-link" href="#">Kontakt</a>
			</li>
			<li>
				<a class="nav-link" href="#">O siłowni</a>
			</li>
			<li>
				<a class="nav-link" href="${pageContext.request.contextPath}/client">Strefa klienta</a>
			</li>
		</ul>
		
	</div>
	 
</nav>