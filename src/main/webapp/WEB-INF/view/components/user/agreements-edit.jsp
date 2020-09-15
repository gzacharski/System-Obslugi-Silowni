<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>



  
<fieldset class="form-group col-12">
	<legend>Wyrażone zgody</legend>
	
	<button class="btn btn-secondary col-12" type="button" data-toggle="collapse" data-target="#collapseAgreements" aria-expanded="false" aria-controls="collapseAgreements">
	  Pokaż wyrażone zgody
	</button>

	<div class="collapse" id="collapseAgreements">
	  <div class="card card-body" style="text-align: justify; color: black !important;">
	  
		<form:hidden path="userAgreements.id"/>
		
		<div class="custom-control custom-checkbox">
			<form:checkbox path="userAgreements.agreement1" cssClass="custom-control-input" id="agreement1"/>
		  	<label class="custom-control-label" for="agreement1">
		  	1. Etiam a elit nulla. Vestibulum dictum purus vel dolor fermentum tincidunt. Etiam venenatis nibh vel commodo vehicula. Praesent sit amet tincidunt urna. In hac habitasse platea dictumst. Nulla pretium viverra neque et mollis. Duis accumsan posuere faucibus. Proin pellentesque et odio non congue. Duis sem orci, euismod eget mi vel.
		  </label>
		</div>
		
		<div class="custom-control custom-checkbox">
			<form:checkbox path="userAgreements.agreement2" cssClass="custom-control-input" id="agreement2"/>
		  	<label class="custom-control-label" for="agreement2">
		  	2. Sed blandit ipsum pellentesque nisi mollis vehicula. Nunc pulvinar eget odio in iaculis. Sed quis tellus urna. Suspendisse facilisis et nibh dapibus sagittis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed ex lectus, venenatis in tristique quis, malesuada id neque. Fusce lectus nisl, porttitor.
		  </label>
		</div>
		
		<div class="custom-control custom-checkbox">
			<form:checkbox path="userAgreements.agreement3" cssClass="custom-control-input" id="agreement3"/>
		  	<label class="custom-control-label" for="agreement3">
		  	3. Donec auctor scelerisque cursus. Cras molestie scelerisque justo id rhoncus. Etiam eget nibh est. Quisque dapibus pharetra leo sed auctor. Proin ultricies pulvinar blandit. Sed vehicula posuere arcu eget placerat. Ut eget ex eu mi vestibulum venenatis. Etiam rutrum sapien nec odio posuere tristique. Suspendisse in velit vel lacus tempus.
		  </label>
		</div>
		
		<div class="custom-control custom-checkbox">
			<form:checkbox path="userAgreements.agreement4" cssClass="custom-control-input" id="agreement4"/>
		  	<label class="custom-control-label" for="agreement4">
		  	4. Nullam interdum malesuada pulvinar. Morbi dignissim odio ac sem vehicula dignissim. In eget interdum neque. Aliquam dui nibh, luctus quis dui sit amet, euismod mollis ex. Mauris quam dolor, suscipit mattis feugiat sed, tincidunt vel ipsum. Duis sit amet quam non metus posuere mattis quis sit amet nisi. Vivamus faucibus.
		  </label>
		</div>
		
		<div class="custom-control custom-checkbox">
			<form:checkbox path="userAgreements.agreement5" cssClass="custom-control-input" id="agreement5"/>
		  	<label class="custom-control-label" for="agreement5">
		  	5. Sed vehicula ac lorem ut lobortis. Curabitur facilisis ante vitae sem molestie tincidunt. Curabitur leo enim, euismod at justo ut, molestie fringilla sem. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Fusce facilisis sapien sit amet nibh vestibulum, ut blandit mauris rutrum. Nam a magna vitae.
		  </label>
		</div>
		
	 </div>
	</div>
</fieldset>

 