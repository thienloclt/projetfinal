<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="../../include/header.jsp"/>
<jsp:include page="../../include/menu.jsp"/>

<form:form method="POST" modelAttribute="voitureObj" action="${pageContext.request.contextPath}/voiture/add">
				<div class="card">
					<div class="card-header">Edition du voiture</div>
					<div class="card-body" style="padding-bottom: 0px;">
						<spring:hasBindErrors name="voitureObj">
						<div class="alert alert-danger">
							<form:errors path="marque"/><br>
							<form:errors path="model"/><br>
							<form:errors path="serie"/><br>
							<form:errors path="annee"/><br>
						</div>
						</spring:hasBindErrors>
						<div class="modal-body" style="padding-top: 0px;">
							<label>marque *</label><br>
							<form:input path="marque"/>
							<br>
							
							<label style="padding-top: 10px;">model *</label><br>
							<form:input path="model"/>
							<br>
							
							<label style="padding-top: 10px;">serie *</label><br>
							<form:input path="serie"/>
							<br>
							
							<label style="padding-top: 10px;">annee *</label><br>
							<form:input path="annee" type="number"/>
							<br>
							
							<label style="padding-top: 10px;">couleur *</label><br>
							<form:select path="couleur" items="${couleurs}"/>
							
							<form:input type="hidden" path="id" />
						</div>
						<div class="modal-footer">
							<form:button type="submit" class="btn btn-primary">
								<img src='<c:url value="/resources/images/submit.png" />' width="20px" height="20px">
							</form:button>
							<form:button type="reset" class="btn btn-warning">
								<img src='<c:url value="/resources/images/reset.png" />' width="20px" height="20px">
							</form:button>
						</div>
					</div>
				</div>
</form:form>
<jsp:include page="../../include/footer.jsp"/>