<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div class="row">

      <div class="col-lg-3">

        <h1 class="my-4">Gadgets</h1>
       
        <div class="list-group">
          <c:forEach items="${categories}" var="category" >
          <a href="#" class="list-group-item">${category.name}</a>
        </c:forEach>
        </div>

      </div>
</body>
</html>