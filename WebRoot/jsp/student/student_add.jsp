<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生</title>
</head>
<body>
	<form action="student_add.do" method="post" enctype="multipart/form-data">
		姓名:<input type="text" name="name" /><br><br>
		学号:<input type="text" name="number" /><br><br>
		年龄:<input type="text" name="age" /><br><br>
		性别:<select name="sex">
			<option value="1">男</option>
			<option value="0">女</option>
		</select><br><br>
		头像:<input type="file" name="myfile"/><br><br>
		${message}<br><br>
		<input type="submit" value="提交"/> <br>
	</form>
</body>
</html>