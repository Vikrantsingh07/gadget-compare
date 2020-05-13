<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="Vikrant Singh Kushwah">

<title>Online Shopping - ${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}'
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable Theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
<link href="${css}/bootstrap-theme.css" rel="stylesheet">


<!-- Bootstrap DataTables -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">


<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
<div class='wrapper'>
    <!-- Navigation Start-->
	<%@include file="./shared/mainpage_navibar.jsp"%>
	<!-- Navigation End-->
	
	
<div class='content'>
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

	<!-- Page Content -->
	<div class="container">
	
	 <!-- Sidebar Menu Start-->
	 <c:if test="${userClickHome == true }">
			<%@include file="./home.jsp"%>
	</c:if>		
	    <!-- Sidebar Menu  End-->

		<!--Product Menu Start  -->
		<c:if test="${userClickHome==true}">
			<%@include file="./shared/mainpage_product_menu.jsp"%>
		</c:if>
		<!--Product Menu End  -->

	</div>
	
	<!-- Contact Start-->
	<c:if test="${userClickAllProduct==true or userclickCategoryProduct==true}">
		<%@include file="./mainpage_productlist.jsp"%>
	</c:if>
	<!-- Contact End-->
	
	<!-- Load only when user clicks show product -->
    <c:if test="${userClickShowProduct == true}">
	   <%@include file="singleProduct.jsp"%>
	</c:if>	
	
	
</div>
	<!-- Footer start -->
	<jsp:include page="./shared/mainpage_footer.jsp" />
	<!-- Footer End -->
	
	<!-- jQuery -->
	<script src="${js}/jquery.js"></script>
		
	<!-- Bootstrap core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script>
	
	<!-- DataTable Plugin -->
	<script src="${js}/jquery.dataTables.js"></script>
		
	<!-- DataTable Bootstrap Script -->
	<script src="${js}/dataTables.bootstrap.js"></script>
		
	<%-- <%-- <!-- DataTable Bootstrap Script -->
	<script src="${js}/bootbox.min.js"></script> --%> 
	
	<!--Self created javaScript  -->
	<script src="${js}/myapp.js"></script>
	
	
	</div>
</body>

</html>