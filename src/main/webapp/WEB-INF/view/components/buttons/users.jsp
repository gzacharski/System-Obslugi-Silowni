<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-12 col-md-6 col-lg-4">
	<figure class="buttonWrapper">
		<form:form id="userAccounts" action="${pageContext.request.contextPath}/user/users/" method="get"> 
			<button type="submit" class="tileButton" form="userAccounts">
				<span class="text-center">Zarządzaj kontami</span>
				<span style="font-size: 1.2em;">
					<jsp:include page="/WEB-INF/view/components/bootstrap-icons/people-fill.jsp"/>
				</span>
			</button>
		</form:form>
	</figure>
</div>