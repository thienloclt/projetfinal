<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include  page="../../include/header.jsp"/>
<jsp:include page="../../include/menu.jsp"/>

<spring:url value="/centreequestre" var="url" />

				<div class="card">
					<div class="card-header">
						Liste des Centre Equestres&nbsp;&nbsp;
						<sec:authorize access="not hasRole('ADMIN')">
						<a href="${url}/add">
							<button class="btn btn-success"><img src='<c:url value="/resources/images/add.png"/>' width="20px" height="20px"></button>
						</a>
						</sec:authorize>
					</div>
					<div class="card-body">
						<table id="tblEleves" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Nom</th>
									<th scope="col">Adresse</th>
									<th scope="col">Code Postal</th>
									<sec:authorize access="not hasRole('ADMIN')">
									<th scope="col"></th>
									</sec:authorize>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${centreEquestres}" var="centreEquestre">
									<tr>
										<td><a href="${url}/detail/${centreEquestre.id}">${centreEquestre.id}</a></td>
										<td>${centreEquestre.nom}</td>
										<td>${centreEquestre.adresse}</td>
										<td>${centreEquestre.codepostal}</td>
										<sec:authorize access="not hasRole('ADMIN')">
										<td>
											<a href="${url}/edit/${centreEquestre.id}">
												<button class="btn btn-info"><img src='<c:url value="/resources/images/edit.png" />' width="20px" height="20px"></button>
											</a>
											<a href="${url}/del/${centreEquestre.id}">
												<button class="btn btn-danger"><img src='<c:url value="/resources/images/delete.png" />' width="20px" height="20px"></button>
											</a>
										</td>
										</sec:authorize>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
<jsp:include page="../../include/footer.jsp"/>