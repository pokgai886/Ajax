<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<title>Insert title here</title>
<script>
	$(function() {
		$("#username").blur(function() {
			$.post("TestAjaxController", {
				username : $("#username").val()
			}, function(data, status) {
				$("#usernameTip").text(data);

			});

		});

	})
</script>

</head>
<body>
	<form action="" method="post">
		用户名: <input type="text" name="username" id="username" value="" /> <span
			id="usernameTip"></span> <br> 密码: <input type="password"
			id="userpwd" name="userpwd" value="" /><br>
	<input type="submit" value="注册">





	</form>



</body>
</html>