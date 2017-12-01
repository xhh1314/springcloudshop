<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<#assign ctx=request.contextPath />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${ctx}/semantic/semantic.min.css">
<script type="text/javascript" src="${ctx}/static/js/jquery-3.1.0.js"></script>
<script src="${ctx}/semantic/semantic.min.js"> </script>
<title>Insert title here</title>

<script type="text/javascript">
$(document).ready(function(){
	
		$('.ui .dropdown')
		.dropdown({
on:'hover'
			});


		$('#search-select').dropdown();

		$('#mytitle').accordion({
			on:'click'
			});

		$('#levelTitle').accordion();
		

	
});

</script>
</head>
<body>
<div class="ui styled accordion" id="mytitle">
<div class="title"><i class="dropdown icon"></i> 商品种类</div>
<div class="active content">
<div class="accordion">
<div class="content"><a href="${ctx}/category/insert" target="body">新增</a></div>
<div class="content"><a href="${ctx}/category/categoryView" target="body">查看</a></div>
</div>
</div>

<div class="title"><i class="dropdown icon"></i>种类细分</div>
<div class="active content">
<div class="accordion">
<div class="content"><a href="${ctx}/subdivide/insert" target="body">新增</a></div>
<div class="content"><a href="${ctx}/subdivide/subdivideView" target="body">查看</a></div>
</div>
</div>

<div class="title"><i class="dropdown icon"></i>属性</div>
<div class="active content">
<div class="accordion">
<div class="content"><a href="${ctx}/property/add" target="body">新增</a></div>
<div class="content"><a href="${ctx}/property/propertyView" target="body">查看</a></div>
</div>
</div>

<div class="title"><i class="dropdown icon"></i>属性值</div>
<div class="active content">
<div class="accordion">
<div class="content"><a href="" target="body">新增</a></div>
<div class="content"><a href="${ctx}/pvc/show" target="body">查看</a></div>
</div>
</div>


<div class="title"><i class="dropdown icon"></i>商品</div>
<div class="active content">
<div class="accordion">
<div class="content"><a href="${ctx}/product/add" target="body">新增</a></div>
<div class="content"><a href="${ctx}/product/productView" target="body">查看</a></div>
</div>
</div>

</div>

<br>
<br>
<br>
<br>
<br>

<div class="ui dropdown">
  <div class="text">File</div>
  <i class="dropdown icon"></i>
  <div class="menu">
    <div class="item">New</div>
    <div class="item">
      <span class="description">ctrl + o</span>
      Open...
    </div>
    <div class="item">
      <span class="description">ctrl + s</span>
      Save as...
    </div>
    <div class="item">
      <span class="description">ctrl + r</span>
      Rename
    </div>
    <div class="item">Make a copy</div>
    <div class="item">
      <i class="folder icon"></i>
      Move to folder
    </div>
    <div class="item">
      <i class="trash icon"></i>
      Move to trash
    </div>
    <div class="divider"></div>
    <div class="item">Download As...</div>
    <div class="item">
      <i class="dropdown icon"></i>
      Publish To Web
      <div class="menu">
        <div class="item">Google Docs</div>
        <div class="item">Google Drive</div>
        <div class="item">Dropbox</div>
        <div class="item">Adobe Creative Cloud</div>
        <div class="item">Private FTP</div>
        <div class="item">Another Service...</div>
      </div>
    </div>
    <div class="item">E-mail Collaborators</div>
  </div>
</div>


<select class="ui search selection dropdown" id="search-select">
  <option value="">State</option>
  <option value="AL">Alabama</option>
  <option value="AK">Alaska</option>
  <option value="AZ">Arizona</option>
  <option value="AR">Arkansas</option>
  <option value="CA">California</option>
  <!-- Saving your scroll sanity !-->
  <option value="OH">Ohio</option>
  <option value="OK">Oklahoma</option>
  <option value="OR">Oregon</option>
  <option value="PA">Pennsylvania</option>
  <option value="RI">Rhode Island</option>
  <option value="SC">South Carolina</option>
  <option value="SD">South Dakota</option>
  <option value="TN">Tennessee</option>
  <option value="TX">Texas</option>
  <option value="UT">Utah</option>
  <option value="VT">Vermont</option>
  <option value="VA">Virginia</option>
  <option value="WA">Washington</option>
  <option value="WV">West Virginia</option>
  <option value="WI">Wisconsin</option>
  <option value="WY">Wyoming</option>
</select>


<div class="ui styled accordion" id="levelTitle">
  <div class="active title">
    <i class="dropdown icon"></i>
    Level 1
  </div>
  <div class="active content">
    Welcome to level 1
    <div class="accordion">
      <div class="active title">
          <i class="dropdown icon"></i>
          Level 1A
      </div>
      <div class="active content">
        <p>Level 1A Contents</p>
        <div class="accordion">
          <div class="title">
              <i class="dropdown icon"></i>
              Level 1A-A
          </div>
          <div class="content">
              Level 1A-A Contents
          </div>
          <div class="title">
              <i class="dropdown icon"></i>
              Level 1A-B
          </div>
          <div class="content">
              Level 1A-B Contents
          </div>
        </div>
      </div>
      <div class="title">
          <i class="dropdown icon"></i>
          Level 1B
      </div>
      <div class="content">
          Level 1B Contents
      </div>
      <div class="title">
          <i class="dropdown icon"></i>
          Level 1C
      </div>
      <div class="content">
          Level 1C Contents
      </div>
    </div>
  </div>
  <div class="title">
    <i class="dropdown icon"></i>
    Level 2
  </div>
  <div class="content">
    <p>Welcome to level 2</p>
    <div class="accordion">
      <div class="active title">
        <i class="dropdown icon"></i>
        Level 2A
      </div>
      <div class="active content">
        <p>Level 2A Contents</p>
        <div class="accordion">
          <div class="title">
              <i class="dropdown icon"></i>
              Level 2A-A
          </div>
          <div class="content">
              Level 2A-A Contents
          </div>
          <div class="title">
              <i class="dropdown icon"></i>
              Level 2A-B
          </div>
          <div class="content">
              Level 2A-B Contents
          </div>
        </div>
      </div>
      <div class="title">
          <i class="dropdown icon"></i>
          Level 2B
      </div>
      <div class="content">
          Level 2B Contents
      </div>
      <div class="title">
          <i class="dropdown icon"></i>
          Level 2C
      </div>
      <div class="content">
          Level 2C Contents
      </div>
    </div>
  </div>
</div>

</body>
</html>