<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC Example</title>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type="text/css" />
</head>
<body>
	<h1 style="text-align: center">MVC Exercise</h1>
	<hr>
	<table border="1" style="margin: 0px auto;">
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> <a
				href="<c:url value='/welcome' />">Hello, Spring MVC</a><BR></td>
			<td width="350"><a href="<c:url value='/products' />">查詢產品資料</a><BR>
				<BR></td>
		</tr>
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> <a
				href="<c:url value='/update/stock' />">更新多筆產品的庫存數量</a><BR></td>
			<td width="350"><a href=""></a><BR> <BR></td>
		</tr>
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> <a
				href="<c:url value='/queryByCategory' />">分類查詢</a><BR></td>
			<td width="350"><p align="left" /> <a
				href="<c:url value='/products/add' />">新增產品資料</a><BR></td>
		</tr>
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> <a
				href="<c:url value='/forwardDemo' />">RedirectView: forwardDemo</a><br>
			</td>
			<td width="350"><p align="left" /> <a
				href="<c:url value='/redirectDemo' />">RedirectView:
					redirectDemo</a><br></td>
		</tr>
	</table>
<hr>
<img src='<c:url value="/image/micky.jpg" />' width='120' height='180' />
</body>
</html>
