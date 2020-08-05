<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'hw2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <!-- jqury库 -->
<script src="${pageContext.request.contextPath }/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url:"getProvince",
			type:"GET",
			datatype:"json",
			success:function(data){
				//显示
				for(var i=0;i<data.length;i++){
					$("#province").append("<option value='"+i+"'>"+data[i]+"</option>");
				}
			}
			
		});
		$("#province").change(function(){
			//发送ajax请求
			$.ajax({
				url:"getCity",
				type:"GET",
				data:{pname:$("#province").val()},
				datatype:"json",
				success:function(data){
					//显示
					$("#city").empty();
					$("#city").append("<option>请选择市级</option>");
					for(var i=0;i<data.length;i++){
						$("#city").append("<option value='"+i+"'>"+data[i]+"</option>");
						
					}
				}
				
				
			})
			
			
		});
		$("#city").change(function(){
			//发送ajax请求
			$.ajax({
				url:"getArea",
				type:"GET",
				data:{pname:$("#province").val(),cname:$("#city").val()},
				datatype:"json",
				success:function(data){
					//显示
					$("#area").empty();
					$("#area").append("<option>请选择县</option>")
					for(var i=0;i<data.length;i++){
						$("#area").append("<option value='"+i+"'>"+data[i]+"</option>");
						
					}
				}
				
				
			})
			
			
		});
		
	})


</script>
  <body>
    <select id="province" >
      <option value="">请选择省份</option>
    </select>
    <select  id="city">
      <option value="">请选择市级</option>
    </select>
    <select  id="area" >
      <option>请选择县</option>
    </select>
  </body>
</html>






