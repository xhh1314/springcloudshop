<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<#assign ctx=request.contextPath />
<head>
<script type="text/javascript">
function refreshCode(){
document.getElementById("verifyImage").src="${ctx}/user/verifyCode/"+Math.random();
}

</script>

</head>

<body>

<h2>测试页面</h2>
<img id="verifyImage" name="verifyImage" src="${ctx}/user/verifyCode/1"  style="cursor: pointer;" title="点击刷新"  onclick="refreshCode()"/>
</body>

</html>