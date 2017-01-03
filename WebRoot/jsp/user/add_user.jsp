<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<script src="js/jquery.js"></script>
<script>
	function check() {
		var user = $("#name").val(); //获取表单元素值
		var password = $("#password").val();
		if (user=="" || password=="") {
			$("#msg").text("用户名和密码不能为空！");
			return false;
		} else {
			return true;
		}
	}
</script>
<style type="text/css">
body{
 	background-color: #f5f5f5;
}
#container {
	margin-top: 50px;
	margin-left: 100px;
}
</style>
</head>
<body>
	<div id="container">
		<form action="./user_add.do" method="POST"  onsubmit="return check()">
			<input type="hidden" name="id" value="${user.id}"/>
			<c:if test="${empty user.id}">
				姓名:<input type="text" name="userName" id="name" value="${user.userName}"/>
			</c:if> 
			<c:if test="${!empty user.id}">
				<input type="hidden" name="userName" id="name" value="${user.userName}"/>
			</c:if><br> <br> 
			密码:<input type="password" name="passWord" id="password" value="${user.passWord}"/> <br> <br> 
			
			<span id="msg" style="color:red;font-size:10px">${error}</span><br><br>
			<input type="submit" value="提交" />
		</form>
	</div>
</body>
</html>