<html>
<#assign ctx=request.contextPath />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单信息</title>
<style type="text/css">
.deliveryDetails{
width:80%;
margin-left:10%;
margin-top:2%;
}
.deliveryTitle{
font-size:24px;
}
.notnull{
color:red;
}
.confirmTitle{
margin-left:10%;
}
.deliveryTable{
margin-top:10px;
}
.confirmIterm{
margin-top:20px;
}
.confirmTitle{
font-size:16px;
color:#FF0036;
}
.deliveryImformation{
width:500px;
}
.deliveryImformation input {
width:200px;
}
.deliveryImformation textarea{
width:300px;
}


.cartDiv{
width:80%;
position:relative;
right:-10%;
}
.cartProductList{
width:100%;
}
.productImage{
width:30px;
height:30px;
}
thead td{
padding:10px;
}
tbody{
border:1px solid #CCCCCC;
}
.confirm_tbody tr{
border-bottom:thin solid #CCCCCC;
}
tbody tr td{
padding:5px;
}

.productDescription{
color:black;
width:150%;
}
.originalPrice{
text-decoration:line-through;
color:#9C9C9C;
}
.promotePrice{
font-size:16px;
font-weight:lighter;
}
.numberInput{
width:30px;
text-align:center;
}
.changeNumber input{
margin-left:5px;
margin-right:5px;
border:none;
}
.numberDecrease{
margin-left:10px;
cursor:pointer;
display:inline-block;
width:5px;
}
.numberIncrease{
margin-right:10px;
cursor:pointer;
display:inline-block;
width:5px;
}
.changeNumber{
display:inline-block;
margin:0px auto;
background:#F0F0F0;
border:1px solid #E5E5E5;
}
.changeNumber *{
display:inline-block;
}
.totalPrice{
color:#FF0036;
font-size:20px;
}
/* 这里cartFoot的宽度和上边的carDiv保持一致 */
.cartFoot{
width:80%; 
position:relative;
margin-left:10%;
display:inline-block;
line-height:40px;
}
.cartfoodLine{
float:right;
}
.createOrderButton{
width:100px;
font-size:16px;
background:#FE0137;
color:white;
border:none;
}
.hasSelectNumber{
margin-right:20px;
}
.hasSelectNumber .totalNumber{
color:#FF5136;
margin:0 2px;
}
.sumandFreight{
margin-right:5px;
}
.sumandFreight .cartSumPrice{
font-size:16px;
color:#FF5136;
}
</style>
<script type="text/javascript">
//格式化数字算法
function formatNumber(num){
    if (num<1000)
    return num;
   var num=num.toString();
   var decimals="";
   var integers;
   if(num.indexOf(".")>=0){//判断是不是有小数的情况
   decimals=decimals+num.substring(num.indexOf(".")+1)
   integers=num.substring(0,num.indexOf("."));
   }
   else{
   integers=num;
   }
   var tag=integers.length/3;
   var end=integers.length;
   var new_integers="";
   for(var i=1;i<=tag;i++){
   new_integers+=","+integers.substring(end-3,end);
   end-=3;
   }
   if(integers.length%3>0)//非3倍长度情况
   new_integers=integers.substring(0,integers.length%3)+new_integers;
   else
   new_integers=new_integers.substring(1);//去掉开端多余的逗号
   
   if(decimals=="")
   return new_integers;
   else
  return new_integers+"."+decimals;
}

//初始化页面，计算出每种商品的价格，并且计算出总件数和总价格
function initial(){
	var sumPrice=0;
	var sumNumber=0;
	$(".promotePrice").each(function(){
		var oid=$(this).attr("oid");
		var promoteprice=parseInt($(this).text());
		var number=parseInt($(".numberInput[oid="+oid+"]").val());
		var price=promoteprice*number;
		$(".totalPrice[oid="+oid+"]").html(formatNumber(price));
		sumPrice+=price;
		sumNumber+=number;
	});
	$(".cartSumPrice").html(formatNumber(sumPrice));
	$(".totalNumber").html(formatNumber(sumNumber));
}
//提交表单操作，提交之前验证表单内容是否规范
function submitForm(){
	var address=$("#address").val();
	address=address.replace(/\s+|\s+$/g,"");//替换掉空格
	if(document.getElementById("addressInfo").firstChild!=null)//这里如果已经存在子节点则，移除掉再增加新的
		document.getElementById("addressInfo").removeChild(document.getElementById("addressInfo").firstChild);
	if(address.length<5)//地址长度不够则无法提交表单
		{
		var span=document.createElement("span");
		span.innerText="地址长度不够，至少5个字!";
		span.style.cssText="vertical-align:top;color:red";
		$("#addressInfo").append(span);
		return false;
		}
		
	var receiver=$("#receiver").val();
	if(document.getElementById("receiverInfo").firstChild!=null)//这里如果已经存在子节点则，移除掉再增加新的
	document.getElementById("receiverInfo").removeChild(document.getElementById("receiverInfo").firstChild);
	if(receiver==null || receiver=="" || receiver==undefined)//收货人不能为空
	{
	var span=document.createElement("span");
	span.innerText="收货人不能为空!";
	span.style.cssText="color:red"
	document.getElementById("receiverInfo").appendChild(span);
	return false;
	}
	var telephone=$("#mobile").val();
	var patt=new RegExp("^(15|13|18)\\d{9}");
	var flag=patt.test(telephone);
	if(document.getElementById("mobileInfo").firstChild!=null)//这里如果已经存在子节点则，移除掉再增加新的
		document.getElementById("mobileInfo").removeChild(document.getElementById("mobileInfo").firstChild);
	if(!flag)//匹配手机号是否填列规范
	{
		var span=document.createElement("span");
		span.innerText="请填写正确的手机号!";
		span.style.cssText="vertical-align:top;color:red";
		$("#mobileInfo").append(span);
		return false;
	}
	//表单内容没有问题，提交表单数据
	document.getElementById("OrderForm").submit();
	
}
</script>
</head>
<body onload="initial()">
<div class="wrapper">
<div class="deliveryDetails">
<div class="deliveryTitle">
收货信息
</div>
<div class="deliveryTable">
<form action="${ctx}/forePermission/addOrder"   method="post" id="OrderForm">
<table>
<tr>
<td>地址<span class="notnull">*</span></td>
<td class="deliveryImformation" ><input type="text" name="address" id="address"/><span style="vertical-align: top" id="addressInfo"></span></td>
</tr>
<tr>
<td>邮政编码</td>
<td class="deliveryImformation" ><input  type="text" name="postCode" /></td>
</tr>
<tr>
<td>收货人<span class="notnull">*</span></td>
<td class="deliveryImformation" ><input type="text" name="receiver" /><span id="receiverInfo"></span></td>
</tr>
<tr>
<td>手机号<span class="notnull">*</span></td>
<td class="deliveryImformation" ><input type="text" name="mobile"/><span id="mobileInfo"></span></td>
</tr>
</table>
<!-- 隐藏表单，提交订单项编号orderItem -->
<#list orderItems as orderItem>
<input type="hidden" value="${orderItem?if_exists.id}" name="oid"/>
</#list>
</form>
</div>
</div>
<!-- 确认订单信息 -->
<div class="confirmIterm">
<span class="confirmTitle">确认订单信息</span>
<div class="cartDiv">
		<table class="cartProductList">
			<thead>
				<tr>
					<td class="selectAndImage"> 店铺：晚来风雨
					</td>
					<td>商品信息</td>
					<td>单价</td>
					<td>数量</td>
					<td>金额</td>
					<td>配送方式</td>
				</tr>
			</thead>
			<tbody class="confirm_tbody" >
				<#list orderItems as orderItem>
					<tr class="cartProductItemTR" oid="${orderItem.id}">
						<td> 
						<a href="#nowhere" style="diplay: none"></a>
							<#list orderItem.product.productImage as image>
								<img src="${ctx}/${image?if_exists.value}" class="productImage">
							</#list></td>
						<td class="td_productDescription" ><a
							href="${ctx}/fore/showProduct/${orderItem?if_exists.product.uuid}"
							class="productDescription">${orderItem?if_exists.product.name}</a></td>
						<td><span class="originalPrice">${orderItem?if_exists.product?if_exists.originalPrice}</span>
							<span class="promotePrice" oid="${orderItem?if_exists.id}">${orderItem?if_exists.product?if_exists.promotePrice}</span>
						</td>
						<td>
							<div class="changeNumber">
								<input type="text" name="number" class="numberInput"
									value="${orderItem?if_exists.number}"  oid="${orderItem?if_exists.id}"/>
							</div>
						</td>
						<td>
						<span class="totalPrice" oid="${orderItem?if_exists.id}">${totalPrice}</span>
						</td>
						<td>
						<input type="radio" value="checked"/>普通配送
						<select  >
						<option>快递免邮费</option>
						</select>
	
						</td>
					</tr>
				</#list>
			</tbody>
		</table>
	</div>
	<div class="cartFoot">
		<div class="  pull-right">
			<span class="hasSelectNumber">已选商品<span class="totalNumber"></span>件
			</span> <span class="sumandFreight">合计（含运费）:<span class="cartSumPrice"></span></span>
			<button class="createOrderButton" onclick="submitForm()">提交订单</button>

		</div>
	</div>
</div>


</div>
</body>
</html>