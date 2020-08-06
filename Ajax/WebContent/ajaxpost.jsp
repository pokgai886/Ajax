<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
		<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#mybtn").click(function() {
					//1 创建对象
					var xmlhttp = new XMLHttpRequest();
					//2 发送请求
					xmlhttp.open("POST", "UserController", true);
					xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
					xmlhttp.send("op=lg");

					//3 相应
					xmlhttp.onreadystatechange = function() {
						if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
							document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
						}

					}

				})
			})
		</script>
	</head>

	<body>
		<button id="mybtn">ajax请求</button>
		<div id="myDiv">

		</div>

	</body>

</html>