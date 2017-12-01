<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<#assign ctx=request.contextPath />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
  <frameset rows="10%,*">
  <!-- 这里直接使用controller 来控制src指定的链接的位置 -->
 <frame name=head src="${ctx}/back/head">
 <frameset cols="15%,*">
 <frame name=left src="${ctx}/back/left">
 <frame name=body src="${ctx}/back/body">
 </frameset>
 </frameset>
</html>