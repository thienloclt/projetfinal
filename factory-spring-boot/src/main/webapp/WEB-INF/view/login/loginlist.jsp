<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="../include/header.jsp"/>
<jsp:include page="../include/menu.jsp"/>
				<div class="card">
					<div class="card-header">
						Liste des Utilisateurs&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/login/add">
						<button class="btn btn-success">
						<img src='<c:url value="/resources/images/add.png" />' width="20px" height="20px"></button></a>
					</div>
					<div class="card-body" style="padding-bottom: 0px;">
						<table id="tblEleves" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Nom d'utilisateur</th>
									<th scope="col">Role</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${logins}" var="login">
									<tr>
										<td><a href="detail/${login.id}">${login.id}</a></td>
										<td>${login.login}</td>
										<td>${login.role}</td>
										<td>
											<a href="${pageContext.request.contextPath}/login/edit/${login.id}">
												<button class="btn btn-info">
													<img src='<c:url value="/resources/images/edit.png" />' width="20px" height="20px">
												</button>
											</a>
											<a href="${pageContext.request.contextPath}/login/del/${login.id}">
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
<jsp:include page="../include/footer.jsp"/>