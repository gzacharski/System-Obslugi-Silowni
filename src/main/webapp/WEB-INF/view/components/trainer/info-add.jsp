<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div class="row">
	<div class="col-md-6 mb-3">
		<label for="trainer">Wybierz użytkownika</label>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">
					<jsp:include page="/WEB-INF/view/components/bootstrap-icons/person.jsp"/>
				</span>
			</div>
			<form:select path="user.id" id="trainer" cssClass="form-control">
				<c:forEach var="tempTrainer" items="${trainersToBe}">
					<form:option value="${tempTrainer.key}" label="${tempTrainer.value}"/>
				</c:forEach>
			</form:select>
		</div>
		<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
			<form:errors path="user.id"/>
		</div>
	</div>
	
	<div class="col-md-6 mb-3">
		<label for="image">Dodaj zdjęcie</label>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">
					<jsp:include page="/WEB-INF/view/components/bootstrap-icons/file-image.jsp"/>
				</span>
			</div>
			<form:input path="image" id="image" class="form-control" placeholder="Obraz"/>
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
			<form:textarea path="description" id="" class="form-control" rows="4"  maxlength="255" minlength="0" placeholder="Dodaj opis dla trenera. Długość tekstu ograniczona do 255 znaków."/>
		</div>
		<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
			<form:errors path="description"/>
		</div>
	</div>
</div>