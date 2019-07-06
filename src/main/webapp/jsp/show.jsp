<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 在所有的链接前面加上动态获取的绝对全路径 -->
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示</title>
<script src="jquery/jquery-2.1.4.js"></script>
<script type="text/javascript">
	$(function() {
		var currentPage = 1;
		$.getJSON("show.lovo",{currentPage:currentPage},fillData);
		$("input[type=button]").click(function(){
			var operation = this.value;
			currentPage = parseInt($("input[name=currentPage]").val());
			var totalPage = $("input[name=totalPage]").val();
			if(operation=="首页"){
				currentPage = 1;
			}else if(operation=="上一页"){
				currentPage = currentPage - 1;
			}else if(operation=="下一页"){
				currentPage = currentPage + 1;
			}else{
				currentPage = totalPage;
			}
			$.getJSON("show.lovo",{currentPage:currentPage},fillData);
		});
	});
	
	function fillData(data) {
		var $table = $("table");
		$table.empty();
		var head = "<tr><th>姓名</th><th>性别</th><th>生日</th><th>电话</th><th>年龄</th></tr>";
		$table.append(head);
		$.each(data.list,function(i,e){
			var tr = "<tr><td>"+e.name+"</td><td>"+e.sex+"</td><td>"+e.birthday+"</td><td>"+e.tel+"</td><td>"+e.age+"</td></tr>";
			$table.append(tr);
		});
		
		$("input[name=currentPage]").val(data.currentPage);
		$("input[name=totalPage]").val(data.totalPage);
		$("span").html("第"+data.currentPage+"页"+"/共"+data.totalPage+"页");
	}
</script>
</head>
<body>
	<div>
		<table>
		
		</table>
	</div>
	<div>
		<input type="button" name="operator" value="首页"/>
		<input type="button" name="operator" value="上一页"/>
		<span></span>
		<input type="button" name="operator" value="下一页"/>
		<input type="button" name="operator" value="尾页"/>
		<input type="hidden" name="currentPage">
		<input type="hidden" name="totalPage">
	</div>
</body>
</html>