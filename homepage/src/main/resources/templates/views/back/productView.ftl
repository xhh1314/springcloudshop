<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<#assign ctx=request.contextPath />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<!-- 引入bootstrap文件 -->
<script type="text/javascript"
	src="${ctx}/static/js/jquery-3.1.0.js"></script>
<link rel="stylesheet"
	href="${ctx }/static/js/bootstrap/css/bootstrap.min.css">
<script type="text/javascript"
	src="${ctx }/static/js/bootstrap/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<table class="table table-hover table-condensed table-bordered">
		<tr>
			<td>名称</td>
			<td>原始价格</td>
			<td>优惠价格</td>
			<td>库存</td>
			<td>商品上架时间</td>
			<td>图片信息</td>修改
			<td></td>
			<td>删除</td>
			<td>增加商品属性</td>
		</tr>
		<#list products as product>
			<tr>
				<td>${product.name}</td>
				<td>${product.originalPrice}</td>
				<td>${product.promotePrice}</td>
				<td>${product.stock}</td>
				<td>${product.createTime}</td>
				<td>
				<#list product.productImage as pi >
				<img name="image1" src="${ctx }/${pi.value}"/>
				</#list>
				</td>
				<td><button class="btn btn-default" type="submit" id="update">修改</button></td>
				<td><button class="btn btn-default" type="submit" id="delete">删除</button>
					<input type="hidden" id="uuid" value="${product.uuid}" /></td>
				<td><button onclick="javascript:window.location.href='${ctx}/pvc/addBefor/${product.uuid}'" class="btn btn-default" type="submit" id="addProperty">添加属性</button></td>
			</tr>
		</#list>
	</table>
</body>
</html>