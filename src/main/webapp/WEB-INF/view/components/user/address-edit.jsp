<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
   
<fieldset class="form-group col-sm-12 col-4">
	<form:hidden path="userAddress.id"/>
	<legend>Adres</legend>
	
	<div class="row">
		<div class="col-md-6 mb-3">
			<label for="street">Ulica</label>
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">
						<jsp:include page="/WEB-INF/view/components/bootstrap-icons/signpost.jsp"/>
					</span>
				</div>
				<form:input path="userAddress.street" id="street" class="form-control" placeholder="Ulica"/>
			</div>
			<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
				<form:errors path="userAddress.street"/>
			</div>
		</div>
		
		<div class="col-md-6 mb-3">
			<label for="homeNumber">Nr domu</label>
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">
						<jsp:include page="/WEB-INF/view/components/bootstrap-icons/house.jsp"/>
					</span>
				</div>
				<form:input path="userAddress.homeNumber" id="homeNumber" class="form-control" placeholder="Nr domu"/>
			</div>
			<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
				<form:errors path="userAddress.homeNumber"/>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-6 mb-3">
			<label for="postalCode">Kod pocztowy</label>
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">
						<jsp:include page="/WEB-INF/view/components/bootstrap-icons/envelope.jsp"/>
					</span>
				</div>
				<form:input path="userAddress.postalCode" id="postalCode" class="form-control" placeholder="Kod pocztowy"/>
			</div>
			<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
				<form:errors path="userAddress.postalCode"/>
			</div>
		</div>
		
		<div class="col-md-6 mb-3">
			<label for="city">Miasto</label>
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">
						<jsp:include page="/WEB-INF/view/components/bootstrap-icons/building.jsp"/>
					</span>
				</div>
				<form:input path="userAddress.city" id="city" class="form-control" placeholder="Miasto"/>
			</div>
			<div class="mt-2 font-weight-lighter text-warning" style="font-size: smaller;">
				<form:errors path="userAddress.city"/>
			</div>
		</div>
	</div>
</fieldset>
      