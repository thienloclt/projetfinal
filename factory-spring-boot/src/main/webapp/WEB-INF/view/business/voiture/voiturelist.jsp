<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="../../include/header.jsp"/>
<jsp:include page="../../include/menu.jsp"/>
				<div class="card">
					<div class="card-header">
						Liste des voitures&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/voiture/add">
						<button class="btn btn-success">
						<img src='<c:url value="/resources/images/add.png" />' width="20px" height="20px"></button></a>
					</div>
					<div class="card-body" style="padding-bottom: 0px;">
						<table id="tblEleves" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Marque</th>
									<th scope="col">Model</th>
									<th scope="col">Serie</th>
									<th scope="col">Annee</th>
									<th scope="col">Couleur</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${voitures}" var="voiture">
									<tr>
										<td><a href="detail/${voiture.id}">${voiture.id}</a></td>
										<td>${voiture.marque}</td>
										<td>${voiture.model}</td>
										<td>${voiture.serie}</td>
										<td>${voiture.annee}</td>
										<td>${voiture.couleur}</td>
										<td>
											<a href="${pageContext.request.contextPath}/voiture/edit/${voiture.id}">
												<button class="btn btn-info">
													<img src='<c:url value="/resources/images/edit.png" />' width="20px" height="20px">
												</button>
											</a>
											<a href="${pageContext.request.contextPath}/voiture/del/${voiture.id}">
												<button class="btn btn-danger">
													<img src='<c:url value="/resources/images/delete.png" />' width="20px" height="20px">
												</button>
											</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
<jsp:include page="../../include/footer.jsp"/>