<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html> 
<head>
<link rel='stylesheet' href='css/styles.css'  type="text/css" />
<meta charset="UTF-8">
<title></title>
</head>
<body>
<div style="text-align:center" >
<h1>請依照類別來挑選產品：</h1>
<hr>
<div align='center'>
        <a href="<c:url value='/queryByCategory' />">回前頁</a>
</div>
<hr>
<c:forEach var='category' items='${categoryList}' >
	<a href="<c:url value='/products/${category}' />">${category}</a><br>
</c:forEach>
</div>
</body>
</html>