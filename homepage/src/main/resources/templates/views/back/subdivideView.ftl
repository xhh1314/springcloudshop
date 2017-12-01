<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<#assign ctx=request.contextPath />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Insert title here</title>
<!-- 引入bootstrap文件 -->
<script type="text/javascript" src="${ctx}/static/js/jquery-3.1.0.js"></script>
<link rel="stylesheet" href="${ctx }/static/js/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${ctx }/static/js/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-hover table-condensed table-bordered">
<tr>
<td>名称</td><td>描述</td><td>修改</td><td>删除</td>
</tr>
<#list subdivides as cg>
<tr>
<td >${ cg.name}</td><td>${cg.description }</td><td ><button class="btn btn-default" type="submit" id="update">修改</button></td><td ><button class="btn btn-default" type="submit" id="delete">删除</button><input type="hidden" id="uuid" value="${cg.uuid}"/></td>
</tr>
</#list>
</table>
</body>

</html>