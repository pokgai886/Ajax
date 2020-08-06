<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
		<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#mybtn").click(function(){
					$.get("TestAjaxController",{op:"get",ajax:"jq"},function(data,status){
						var array=JSON.parse(data);
						var info="";
						$.each(array,function(index,article){
							info+=article.article+","+article.articleTitle+","+article.articleContent+","+article.articleAuthor+","+article.articleDate+"<br/>";
							
						
						})
						
						$("#myDiv").html(info);
						alert("Data:"+data+",nStatus:"+status);	
					});
					
				});
				
				
				
			})
		
			
		</script>
	</head>

	<body>
		<button id="mybtn">ajax请求</button>
		<div id="myDiv">
		
		</div>
		
	</body>

</html>