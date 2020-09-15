<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<fieldset class="form-group col-sm-12 col-4">
	<legend>Uprawnienia</legend>
	
	<div class="row">
		<div class="col-sm-6 col-md-2 mb-3">
			<div class="custom-control custom-checkbox">
				<form:checkbox path="role[0]" value="ROLE_ADMIN" cssClass="custom-control-input" id="admin"/>
			  	<label class="custom-control-label" for="admin">
			  	Administrator
			  </label>
			</div>
		</div>
		
		<div class="col-sm-6 col-md-2 mb-3">
			<div class="custom-control custom-checkbox">
				<form:checkbox path="role[3]" value="ROLE_CLIENT" cssClass="custom-control-input" id="client"/>
			  	<label class="custom-control-label" for="client">
			  	Klient
			  </label>
			</div>
		</div>

		<div class="col-sm-6 col-md-2 mb-3">
			<div class="custom-control custom-checkbox">
				<form:checkbox path="role[4]" value="ROLE_MANAGER" cssClass="custom-control-input" id="manager"/>
			  	<label class="custom-control-label" for="manager">
			  	Menadżer
			  </label>
			</div>
		</div>
		
		<div class="col-sm-6 col-md-2 mb-3">
			<div class="custom-control custom-checkbox">
				<form:checkbox path="role[1]" value="ROLE_EMPLOYEE" cssClass="custom-control-input" id="employee"/>
			  	<label class="custom-control-label" for="employee">
			  	Pracownik
			  </label>
			</div>
		</div>
		
		<div class="col-sm-6 col-md-2 mb-3">
			<div class="custom-control custom-checkbox">
				<form:checkbox path="role[2]" value="ROLE_TRAINER" cssClass="custom-control-input" id="trainer"/>
			  	<label class="custom-control-label" for="trainer">
			  	Trener
			  </label>
			</div>
		</div>		
		
	</div>
</fieldset>