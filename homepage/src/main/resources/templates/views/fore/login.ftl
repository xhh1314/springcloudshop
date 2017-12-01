<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<#assign ctx=request.contextPath />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<!-- 引入bootstrap文件 和jquery -->
<script type="text/javascript" src="${ctx}/static/js/jquery-3.1.0.js"></script>
<link rel="stylesheet" href="${ctx }/static/js/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${ctx }/static/js/bootstrap/js/bootstrap.min.js"></script>
<!-- ddddd -->
 
<style type="text/css">
body{
background:#F7FAFC;

}
.login{
width:25%;
position:relative;
margin:auto auto;
margin-top:5%;
border:1px solid #F7F7F9;
}
.loginGroup input{
display:block;
height:40px;
width:100%;
border:1px solid #D5D5D5;
}
button{
width:100%;
margin-top:20px;
font-size:20px !important;
}
.login-fault{
text-align:right;
margin-top:10px;
}
.title{
margin-top:10%;
text-align:center;
}
.title h1{
font-size:50px;
color:#0F88EB;
}
.message{
color:red;
}
</style>

</head>
<body>
<div class="title">
<h1>shopping</h1>
</div>
<div class="login" >
<form action="${ctx}/user/login"  method="post" >
<div class="loginGroup">
<input type="text"  name="email" placeholder="邮箱"  /><span class="message" >${message!}</span>
<input type="password" name="password" placeholder="密码" />
</div>
<button type="submit" class="btn btn-primary">登录</button>
<!-- previousUri 用于记录登录之前的页面 -->
<input type="hidden"  name="previousUri" value="${previousUri!}">
<input type="hidden" name ="webToken" value="${webToken?if_exists}">
</form>
<div class="login-fault">
<a>无法登陆？</a>
</div>
</div>

</body>
</html>