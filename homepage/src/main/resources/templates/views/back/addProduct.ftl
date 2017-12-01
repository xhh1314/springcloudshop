<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<#assign ctx=request.contextPath />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!-- 引入bootstrap文件 -->
<script type="text/javascript" src="${ctx}/static/js/jquery-3.1.0.js"></script>
<link rel="stylesheet" href="${ctx }/static/js/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${ctx }/static/js/bootstrap/js/bootstrap.min.js"></script>

<!-- 打印错误信息 -->
<script type="text/javascript">
var message=${message!};
if(message !=null && message!=undefined && message!="" ){
	alert(message);
}

</script>
</head>
<body>
<form action="${ctx}/product/add"  method="post" enctype="multipart/form-data">
<div class="form-group">
<label for="name">name</label>
<input type="text" name="name" id="name" class="form-control" style="width:50%"/>
</div>
<div class="form-group">
<label for="originalPrice">originalPrice</label>
<input type="text" name="originalPrice" id="originalPrice" class="form-control" style="width:50%"/>
</div>
<div class="form-group">
<label for="promotePrice">promotePrice</label>
<input type="text" name="promotePrice" class="form-control" id="promotePrice" style="width:50%"/>
</div>

<div class="form-group">
<label for="stock">stock</label>
<input type="text" name="stock" class="form-control" id="stock" style="width:50%"/>
</div>

<!-- 这里的日期使用type=“date” Chrome 浏览器可以识别 -->
<div class="form-group">
<label for="createTime">createTime</label>
<input name="createTime"  type="date" class="form-control" style="width:50%"/>
</div>

<div class="form-group">
<label for="subdivide.uuid">subdivide</label>
<select name="subdivide.uuid" class="form-control" style="width:25%">
<#list subdivides as sb >
<option value="${sb.uuid}">${sb.name }</option>
</#list>
</select>
</div>
<div class="form-group">
<label for="iamge">图片上传</label>
<input type="file" name="image" ></input>
</div>

<button  type="submit" name="submit">submit</button>


</form>

</body>
</html>