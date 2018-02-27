<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="../include/header.jsp"/>
<jsp:include page="../include/menu.jsp"/>

<form:form method="POST" modelAttribute="loginObj" action="${pageContext.request.contextPath}/login/add">
				<div class="card">
					<div class="card-header">Edition du login</div>
					<div class="card-body" style="padding-bottom: 0px;">
						<spring:hasBindErrors name="loginObj">
						<div class="alert alert-danger">
							<form:errors path="login"/><br>
							<form:errors path="passwrd"/>
						</div>
						</spring:hasBindErrors>
						<div class="modal-body" style="padding-top: 0px;">
							<div class="form-group">
								<label>Nom d'utilisateur *</label>
								<form:input path="login" class="form-control"/>
							</div>
							<div class="form-group">
								<label>Mot de passe *</label>
								<form:input path="passwrd" class="form-control" type="password"/>
							</div>
<%-- 							<div class="form-group">
								<label>Répétez mot de passe *</label>
								<input name="repasswrd" value="${loginObj.passwrd}" class="form-control"/>
							</div> --%>
							
							<%-- <label style="padding-top: 10px;">Role *</label><br>
							<form:input path="role"/> --%>

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
<jsp:include page="../include/footer.jsp"/>