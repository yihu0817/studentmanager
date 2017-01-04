<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<table width="100%" border="0" 
		bgcolor="#cccccc">
		<tr>
			<td>头像</td>
			<td>姓名</td>
			<td>学号</td>
			<td>年龄</td>
			<td>性别</td>
			<td colspan="2">操作</td>
		</tr>
		
		<%
			String color = "";
			int c = 1;
		%>
		<c:forEach items="${studentLists}" var="student">
		    
		    <%
			    if (c == 1) {
					color = "#ffffff";
					c = 0;
				} else {
					color = "#f5f5f5";
					c = 1;
				}
		    %>
		    
			<tr bgcolor="<%=color%>">
				<td>
					<c:if test="${empty student.headerImg}">
					    <img src= "${pageContext.request.contextPath}/images/y.jpg" width="60px" height="60px"/>
					</c:if>
					<c:if test="${!empty student.headerImg}">
					   <img src= "${pageContext.request.contextPath}${student.headerImg}" width="60px" height="60px"/>
					</c:if>
				</td>
				<td>${student.name}</td>
				<td>${student.number}</td>
				<td>${student.age}</td>
				<td><c:if test="${student.sex == true}">男</c:if>
				    <c:if test="${student.sex == false}">女</c:if>
				</td>
				<td><a href="./user_delete.do?id=${user.id}">删除</a></td>
				<td><a href="./student_update.do?number=${student.number}">修改</a></td>
			</tr>
			
			
		</c:forEach>
	
	</table>

</body>
</html>