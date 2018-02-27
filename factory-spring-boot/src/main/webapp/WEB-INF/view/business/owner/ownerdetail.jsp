<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="../../include/header.jsp"/>
<jsp:include page="../../include/menu.jsp"/>

				<div class="card">
					<div class="card-header">
						Detail de owner
					</div>
					<div class="card-body">
						<label>Nom: ${owner.nom}</label><br>
						<label>Prenom: ${owner.prenom}</label><br>
						<label>Adresse: ${owner.adresse}</label><br>
						<label>Code Postal: ${owner.codepostal}</label><br>
						<label>Date de Naissance: ${owner.dateDeNaissance}</label>
					</div>
				</div>
<jsp:include page="../../include/footer.jsp"/>