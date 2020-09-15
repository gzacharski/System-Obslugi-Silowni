<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:hidden path="userDetails.id"/>

<fieldset class="form-group col-sm-12 col-4">
	<form:hidden path="id"/>
	<legend>Dane podstawowe</legend>
	
	<div class="row">
		<div class="col-md-6 mb-3">
			<label for="name">Imię</label>
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">
						<jsp:include page="/WEB-INF/view/components/bootstrap-icons/person.jsp"/>
					</span>
				</div>
				<form:input path="name" id="name" class="form-control" placeholder="Imię" required="required"/>
			</div>
			<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
				<form:errors path="name"/>
			</div>
		</div>
		
		<div class="col-md-6 mb-3">
			<label for="surname">Nazwisko</label>
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">
						<jsp:include page="/WEB-INF/view/components/bootstrap-icons/person.jsp"/>
					</span>
				</div>
				<form:input path="surname" id="surname" class="form-control" placeholder="Nazwisko"/>
			</div>
			<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
				<form:errors path="surname"/>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-6 mb-3">
			<label for="email">Email</label>
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">@</span>
				</div>
				<form:input path="email" id="email" class="form-control" placeholder="Email"/>
			</div>
			<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
				<form:errors path="email"/>
			</div>
		</div>
		
		<div class="col-md-6 mb-3">
			<label for="telephone">Telefon (opcjonalnie)</label>
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">
						<jsp:include page="/WEB-INF/view/components/bootstrap-icons/telephone.jsp"/>
					</span>
				</div>
				<form:input path="telephone" id="telephone" class="form-control" placeholder="Telefon"/>
			</div>
			<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
				<form:errors path="telephone"/>
			</div>
		</div>
	</div>

</fieldset>