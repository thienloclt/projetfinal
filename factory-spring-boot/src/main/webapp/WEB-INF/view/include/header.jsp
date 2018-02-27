<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>No title</title>

<!-- Required meta tags -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<script type="text/javascript" src=""></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col"></div>
			<div class="col-8">
				<div class="bg-dark text-white clearfix">
					<div class="float-left"	style="padding: 20px 20px;">
						<p class="h1"><a href="${pageContext.request.contextPath}"><spring:message code="banner" /></a></p>
						<p class="h6"><spring:message code="slogan" /></p>
					</div>
					<div class="float-right" style="padding-right: 10px; padding-top: 10px;">
					<a href="?language=en"><img src='<c:url value="/resources/images/ln-en.png" />' width="20px" height="20px"></a>
					<a href="?language=fr"><img src='<c:url value="/resources/images/ln-fr.png" />' width="20px" height="20px"></a>
					</div>
				</div>