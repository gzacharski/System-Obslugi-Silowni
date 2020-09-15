<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 


<div class="row">
	<div class="col-md-6 mb-3">
		<label for="training">Wybierz typ treningu</label>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">
					<jsp:include page="/WEB-INF/view/components/bootstrap-icons/check.jsp"/>
				</span>
			</div>
			<form:select path="workout.id" id="training" cssClass="form-control">
				<c:forEach var="tempWorkout" items="${workouts}">
					<form:option value="${tempWorkout.key}" label="${tempWorkout.value}"></form:option>
				</c:forEach>
			</form:select>
		</div>
		<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
			<form:errors path="workout.id"/>
		</div>
	</div>
	
	<div class="col-md-6 mb-3">
		<label for="startTime">Datę i czas rozpoczęcia zajęć:</label>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">
					<jsp:include page="/WEB-INF/view/components/bootstrap-icons/clock.jsp"/>
				</span>
			</div>
			<form:input path="startTime" id="startTime" type="datetime-local" name="startTime" class="form-control"/>
		</div>
		<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
			<form:errors path="startTime"/>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-4 mb-3">
		<label for="quantity">Maksymalna licznę osób</label>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">
					<jsp:include page="/WEB-INF/view/components/bootstrap-icons/people-fill.jsp"/>
				</span>
			</div>
			<form:input path="maxPeople" id="quantity" type="number" name="maxPeople" step="1" min="0" max="100" class="form-control"/>
		</div>
		<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
			<form:errors path="maxPeople"/>
		</div>
	</div>
	
	<div class="col-md-4 mb-3">
		<label for="trainer">Wybierz trenera</label>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">
					<jsp:include page="/WEB-INF/view/components/bootstrap-icons/person.jsp"/>
				</span>
			</div>
			<form:select path="trainer.id" id="trainer" cssClass="form-control">
				<c:forEach var="tempTrainer" items="${trainers}">
					<option value="${tempTrainer.key}" label="${tempTrainer.value}"></option>
				</c:forEach>
			</form:select>
		</div>
		<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
			<form:errors path="trainer.id"/>
		</div>
	</div>
	
	<div class="col-md-4 mb-3">
		<label for="place">Miejsce zajęć</label>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">
					<jsp:include page="/WEB-INF/view/components/bootstrap-icons/check.jsp"/>
				</span>
			</div>
			<form:select path="place.id" id="place" cssClass="form-control">
				<c:forEach var="tempPlace" items="${places}">
					<option value="${tempPlace.key}" label="${tempPlace.value}"></option>
				</c:forEach>
			</form:select>
		</div>
		<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
			<form:errors path="place.id"/>
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
			<form:textarea path="description" id="" class="form-control" rows="4"  maxlength="255" minlength="0" placeholder="Dodaj opis do zajęć fitness. Długość tekstu ograniczona do 255 znaków."/>
		</div>
		<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
			<form:errors path="description"/>
		</div>
	</div>
</div>