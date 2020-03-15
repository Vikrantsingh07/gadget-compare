<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="img" value="/resources/img"/>
<spring:url var="font" value="/resources/fonts"/>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Online Shopping - ${title}</title>

    <!-- Favicon  -->
    <link rel="icon" href="${img}/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="${css}/core-style.css">
    <link rel="stylesheet" href="${css}/style.css">

</head>

<body>
    <!-- Search Wrapper Area Start -->
    <div class="search-wrapper section-padding-100">
        <div class="search-close">
            <i class="fa fa-close" aria-hidden="true"></i>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="search-content">
                        <form action="#" method="get">
                            <input type="search" name="search" id="search" placeholder="Type your keyword...">
                            <button type="submit"><img src="${img}/core-img/search.png" alt=""></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Search Wrapper Area End -->

    <!-- ##### Main Content Wrapper Start ##### -->
    <div class="main-content-wrapper d-flex clearfix">
        <!-- Mobile Nav (max width 767px)-->
        <div class="mobile-nav">
            <!-- Navbar Brand -->
            <div class="amado-navbar-brand">
                <a href="index.html"><img src="${img}/core-img/logo.png" alt=""></a>
            </div>
            <!-- Navbar Toggler -->
            <div class="amado-navbar-toggler">
                <span></span><span></span><span></span>
            </div>
        </div>
  
  
        <!-- Header Area Start -->
             <%@include file="./shared/page_header.jsp"%>
        <!-- Header Area End -->
    
        <!-- Product Catagories Area Start -->
             <c:if test="${userClickHome == true}">
                 <%@include file="./shared/page_product_catagory.jsp"%>
             </c:if>
       <!-- Product Catagories Area End -->
    
       <!-- Newsletter Area Start -->
             <%@include file="./shared/page_newsletter.jsp"%>
       <!--  Newsletter Area End  -->

       <!--  Footer Area Start  -->
             <%@include file="./shared/page_footer.jsp"%>
       <!--  Footer Area End  -->

    </div>
    <!-- ##### Main Content Wrapper End ##### -->
      
    <!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
    
    <script src="${js}/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="${js}/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="${js}/bootstrap.min.js"></script>
    <!-- Plugins js -->
    <script src="${js}/plugins.js"></script>
    <!-- Active js -->
    <script src="${js}/active.js"></script>

</body>

</html>