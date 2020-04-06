<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="img" value="/resources/img" />
<spring:url var="font" value="/resources/fonts" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}'
</script>
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/shop-homepage.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- Custom Themes for this template -->
<link href="${css}/pulse_themes.css" rel="stylesheet">


</head>

<body>
<div class='wrapper'>
<div class='content'>
	<!-- Navigation Start-->
	<%@include file="./shared/mainpage_navibar.jsp"%>
	<!-- Navigation End-->


	<!-- About Start-->
	<c:if test="${userClickAbout==true}">
		<%@include file="./shared/mainpage_about.jsp"%>
	</c:if>
	<!-- About End-->

	<!-- Contact Start-->
	<c:if test="${userClickContact==true}">
		<%@include file="./shared/mainpage_contact.jsp"%>
	</c:if>
	<!-- Contact End-->

	<!-- Contact Start-->
	<c:if test="${userClickService==true}">
		<%@include file="./shared/mainpage_service.jsp"%>
	</c:if>
	<!-- Contact End-->

	<!-- Page Content -->
	<div class="container">
		<!-- Side Menu Start-->
			<%@include file="./shared/mainpage_sidemenu.jsp"%>
			<!-- Side Menu  End-->

		<!--Product Menu Start  -->
		<c:if test="${userClickHome==true}">
			<%@include file="./shared/mainpage_product_menu.jsp"%>
		</c:if>
		<!--Product Menu End  -->

	</div>
</div>
	<!-- Footer start -->
	<jsp:include page="./shared/mainpage_footer.jsp" />
	<!-- Footer End -->
	
	<!-- Bootstrap core JavaScript -->
	<script src="${js}/jquery.min.js"></script>
	<script src="${js}/bootstrap/bootstrap.bundle.min.js"></script>
	<!--Self created javaScript  -->
	<script src="${js}/my_app.js"></script>
	</div>
</body>

</html>