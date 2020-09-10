<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<h1 class="logo"><a href="${pageContext.request.contextPath}/" style="text-decoration: none; color: inherit;">System Obsługi Siłowni</a></h1>

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
				<a class="nav-link" href="${pageContext.request.contextPath}/user/">Siłownia online</a>
			</li>
			<security:authorize access="isAuthenticated()">
				<li>
					<div class="dropdown">
					  <a class="nav-link dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-door-open-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
						  <path fill-rule="evenodd" d="M1.5 15a.5.5 0 0 0 0 1h13a.5.5 0 0 0 0-1H13V2.5A1.5 1.5 0 0 0 11.5 1H11V.5a.5.5 0 0 0-.57-.495l-7 1A.5.5 0 0 0 3 1.5V15H1.5zM11 2v13h1V2.5a.5.5 0 0 0-.5-.5H11zm-2.5 8c-.276 0-.5-.448-.5-1s.224-1 .5-1 .5.448.5 1-.224 1-.5 1z"/>
						</svg>
					  </a>
					
					  <div class="dropdown-menu dropdown-menu-right text-muted" aria-labelledby="dropdownMenuLink">
					  	<p style="font-weight: bold; text-align: center; ">
							<security:authentication property="principal.username"/>
						</p>
					  	<p style="text-align: center;">
							<security:authentication property="principal.authorities"/>
						</p>
					  	<div class="dropdown-divider"></div>
					  	<button form="logOut" class="dropdown-item" style="text-align: center; cursor: pointer">Wyloguj się</button>

					  </div>
					  
					  <form:form id="logOut" action="${pageContext.request.contextPath}/logout" method="POST"/>
					</div>
				</li>
			</security:authorize>
			
		</ul>
		
	</div>
</nav>
<div class="container">

	<c:if test="${success != null}">
		<div class="alert alert-success alert-dismissible fade show mt-2" role="alert" >
			<svg width="1.2em" height="1.2em" viewBox="0 0 16 16" class="bi bi-check-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
			  <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
			  <path fill-rule="evenodd" d="M10.97 4.97a.75.75 0 0 1 1.071 1.05l-3.992 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.236.236 0 0 1 .02-.022z"/>
			</svg>
			<span>${success}</span>
		</div>
	</c:if>
	
	<c:if test="${danger!= null}">
		<div class="alert alert-danger alert-dismissible fade show mt-2" role="alert" >
			<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-x-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
			  <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
			  <path fill-rule="evenodd" d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
			</svg>
			<span>${danger}</span>
		</div>
	</c:if>
	
	<c:if test="${info!= null}">
		<div class="alert alert-info alert-dismissible fade show mt-2" role="alert" >
			<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-info-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
			  <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
			  <path d="M8.93 6.588l-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588z"/>
			  <circle cx="8" cy="4.5" r="1"/>
			</svg>
			<span>${info}</span>
		</div>
	</c:if>
	
	<c:if test="${warning != null}">
		<div class="alert alert-warning alert-dismissible fade show mt-2" role="alert" >
			<svg width="1.0625em" height="1em" viewBox="0 0 17 16" class="bi bi-exclamation-triangle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
			  <path fill-rule="evenodd" d="M7.938 2.016a.146.146 0 0 0-.054.057L1.027 13.74a.176.176 0 0 0-.002.183c.016.03.037.05.054.06.015.01.034.017.066.017h13.713a.12.12 0 0 0 .066-.017.163.163 0 0 0 .055-.06.176.176 0 0 0-.003-.183L8.12 2.073a.146.146 0 0 0-.054-.057A.13.13 0 0 0 8.002 2a.13.13 0 0 0-.064.016zm1.044-.45a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566z"/>
			  <path d="M7.002 12a1 1 0 1 1 2 0 1 1 0 0 1-2 0zM7.1 5.995a.905.905 0 1 1 1.8 0l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995z"/>
			</svg>
			<span>${warning}</span>
		</div>
	</c:if>	
</div>
