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
var message=${message!}+"";
if(message !=null && message!=undefined && message!="" ){
	alert(message);
}
</script>
<!-- 把表格数据封装成JSON格式，封装成一个集合传到后台 -->
<script type="text/javascript">

function jsonTest(){
var pvs = [];
var rows=document.getElementById("tableList").rows.length;
var colums=colums = document.getElementById("tableList").rows[0].cells.length;
//alert("rows:"+rows);
//alert("colums:"+colums);
if(rows>=1){
	for(var i=0;i<rows-1;i++){
		var propertyValue={value:"",pp_uuid:"",pd_uuid:""};
		//第一个子节点是隐藏的Ttable
		propertyValue.value=document.getElementById("tableList").children[0].children[i].children[1].children[0].value;
		propertyValue.pp_uuid=document.getElementById("tableList").children[0].children[i].children[1].children[0].id;
		propertyValue.pd_uuid=document.getElementById("pd_uuid").value;
		pvs.push(propertyValue);
	}	
}
//pvs={value:"lihao",pp_uuid:"dgg22",pd_uuid:"d22dd"}
//alert(JSON.stringify(pvs));
if(pvs!==null){
	$.ajax({
	url:"${ctx}/pvc/add",
	type:"post",
	contentType:"application/json;charset=utf-8",
	data:JSON.stringify(pvs),
	//data:pvs,
	dataType:"json",
	success:function(data){
		//var data=JSON.parse(data);
		alert(data.message);//输出商品信息
		
	},
	error : function(XMLHttpRequest, textStatus, errorThrown) {//这个error函数调试时非常有用，如果解析不正确，将会弹出错误框　　　　
		//alert(XMLHttpRequest.responseText); 
		//alert(XMLHttpRequest.status);
		//alert(XMLHttpRequest.readyState);
		alert(textStatus); // parser error;
	}
	})
	
}

}
</script>

</head>
<body>
<form  >
<table class="table table-hover" id="tableList">
<#list propertys as property>
<tr>
<td>${property?if_exists.name}</td>
<td><input name="${property?if_exists.name}" id="${property?if_exists.uuid}"/></td>
</tr>

</#list>
<tr>
<td><button type="button" value="submit" onclick="jsonTest()">提交</button></td><td><input type="hidden" id="pd_uuid" value="${pd_uuid}"></input></td>
</tr>
</table>


</form>


</body>
</html>