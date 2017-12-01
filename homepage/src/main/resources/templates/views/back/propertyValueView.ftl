<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<#assign ctx=request.contextPath />
<head>
<script type="text/javascript" src="${ctx}/static/js/jquery-3.1.0.js"></script>
<link rel="stylesheet" href="${ctx}/semantic/semantic.min.css">
<link rel="stylesheet" href="${ctx}/static/mycss/propertyValue.css">
<script src="${ctx}/semantic/semantic.min.js"> </script>

<style type="text/css">

</style>
<script type="text/javascript">
var currentPage=${page?if_exists.currentPage};
var beginPage=${page?if_exists.beginPage};
var endPage=${page?if_exists.endPage};
var totalPage=${page?if_exists.totalPage};
function initial(){
	//var a=document.getElementById("pageItem");
for(var i=beginPage;i<=endPage;i++){
var a=document.createElement('a');
a.href="${ctx}/pvc/current?currentPage="+i+"&beginPage="+beginPage+"&endPage="+endPage;
a.innerHTML=i;
a.className="item";
$("#pageNext").before(a);
}

if(beginPage==1){
$("#pagePrevious").addClass("disabled");
$("#pagePrevious").css("cursor","not-allowed");
}
if(endPage==totalPage)
	{
	$("#pageNext").addClass("disabled");
$("#pageNext").css("cursor","not-allowed");
	}
}
//下一页
function pageNext(){
	if(endPage==totalPage) return;
	document.location.href="${ctx}/pvc/next?currentPage="+currentPage+"&beginPage="+beginPage+"&endPage="+endPage;
	}
//上一页
	function pagePrevious(){
		if(beginPage==1) return;
		document.location.href="${ctx}/pvc/previous?currentPage="+currentPage+"&beginPage="+beginPage+"&endPage="+endPage;
		}
</script>
</head>
<body onload="initial()">
	<div class="myTable">
		<table class="ui celled table">
			<thead>
				<tr class="pvthead">
					<th class="tid">序号</th>
					<th class="tvalue">值</th>
					<th class="tp">所属产品</th>
				</tr>
			</thead>
			<tbody class="pvtable">
				<#list propertyValues?if_exists as pv>
				<tr>
					<td>
						<div class="ui ribbon label">${pv.pvid}</div>
					</td>
					<td>${pv.propertyValue}</td>
					<td>${pv.productName}</td>
				</tr>
				</#list>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="3">
						<div class="ui right floated pagination menu">
							<a class="icon item" id="pagePrevious" onclick="pagePrevious()">
								<i class="left chevron icon"></i>
							</a> <a class="icon item" id="pageNext" onclick="pageNext()"> <i
								class="right chevron icon"></i>
							</a>
						</div>
					</th>
				</tr>
			</tfoot>
		</table>
	</div>
</body>

</html>