<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div class="row">
	<div class="col-md-4 mb-3">
		<label for="typeOfWorkout">Typ treningu</label>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">
					<jsp:include page="/WEB-INF/view/components/bootstrap-icons/check.jsp"/>
				</span>
			</div>
			<form:input path="typeOfWorkout" id="typeOfWorkout" type="text" name="typeOfWorkout" class="form-control" placeholder="Nazwa treningu"/>
		</div>
		<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
			<form:errors path="typeOfWorkout"/>
		</div>
	</div>
	
	<div class="col-md-4 mb-3">
		<label for="duration">Czas trwania treningu</label>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">
					<jsp:include page="/WEB-INF/view/components/bootstrap-icons/clock.jsp"/>
				</span>
			</div>
			<form:input path="duration" id="duration" type="time" name="duration" step="1" class="form-control"/>
		</div>
		<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
			<form:errors path="duration"/>
		</div>
	</div>
	
	<div class="col-md-4 mb-3">
		<label for="image">Zdjęcie</label>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">
					<jsp:include page="/WEB-INF/view/components/bootstrap-icons/file-image.jsp"/>
				</span>
			</div>
			<form:input path="image" id="image" type="text" name="photo" class="form-control" placeholder="Obraz"/>
		</div>
		<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
			<form:errors path="image"/>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-sm-12 mb-3">
		<label for="textarea">Opis</label>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">
					<jsp:include page="/WEB-INF/view/components/bootstrap-icons/blockquote-left.jsp"/>
				</span>
			</div>
			<form:textarea path="description" id="" class="form-control" rows="4"  maxlength="255" minlength="0" placeholder="Dodaj opis do treningu. Długość tekstu ograniczona do 255 znaków."/>
		</div>
		<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
			<form:errors path="description"/>
		</div>
	</div>
</div>