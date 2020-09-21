<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-12 col-md-6 col-lg-4">
	<figure class="buttonWrapper">
		<form:form id="fitnessEvents" action="${pageContext.request.contextPath}/user/events/" method="get"> 
			<button type="submit" class="tileButton" form="fitnessEvents">
				<span class="text-center">Zarządzaj zajęciami</span>
				<span style="font-size: 1.2em;">
					<jsp:include page="/WEB-INF/view/components/bootstrap-icons/list-check.jsp"/>
				</span>
			</button>
		</form:form>
	</figure>
</div>