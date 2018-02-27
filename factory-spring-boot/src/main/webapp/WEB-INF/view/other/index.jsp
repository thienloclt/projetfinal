<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="../include/header.jsp"/>
<jsp:include page="../include/menu.jsp"/>

	<div class="card">
		<div class="card-header">Bienvenue!</div>
		<div class="card-body">
			<c:choose>
				<c:when test="${empty pageContext.request.userPrincipal}">
					Vous devez <a href="${pageContext.request.contextPath}/auth/login">vous enregistrer</a> pour accéder à l'application
				</c:when>
				<c:otherwise>
					Index content
				</c:otherwise>
			</c:choose>
		</div>					
	</div>
				
<jsp:include page="../include/footer.jsp"/>