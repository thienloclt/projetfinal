<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="../include/header.jsp"/>
<jsp:include page="../include/menu.jsp"/>

<form name="abc" method="POST" action="">
				<div class="card">
					<div class="card-header">Authentification</div>
					<div class="card-body" style="padding-bottom: 0px;">
<%-- 						<spring:hasBindErrors name="authObj">
 						<div class="alert alert-danger">
							<form:errors path="login"/><br>
							<form:errors path="passwrd"/>
						</div>
						</spring:hasBindErrors> --%>
						<div class="modal-body" style="padding-top: 0px;">
							<div class="form-group">
								<label>Login *</label>
								<input name="username" class="form-control"/>
							</div>
							<div class="form-group">
								<label>Password *</label>
								<input name="password" class="form-control"/>
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-primary">
								<img src='<c:url value="/resources/images/submit.png" />' width="20px" height="20px">
							</button>
							<button type="reset" class="btn btn-warning">
								<img src='<c:url value="/resources/images/reset.png" />' width="20px" height="20px">
							</button>
						</div>
					</div>
				</div>
</form>
<jsp:include page="../include/footer.jsp"/>