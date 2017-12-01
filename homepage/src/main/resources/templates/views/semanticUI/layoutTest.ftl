<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<#assign ctx=request.contextPath />
<head>
<link rel="stylesheet" href="${ctx}/semantic/semantic.min.css">
<script src="${ctx}/semantic/semantic.min.js" > </script>
<style type="text/css">
.myTable{width:1000px;margin:0px auto;}

</style>

<link rel="stylesheet" type="text/css" href="${ctx}/semantic/components/reset.css">
  <link rel="stylesheet" type="text/css" href="${ctx}/semantic/components/site.css">
  <link rel="stylesheet" type="text/css" href="${ctx}/semantic/components/container.css">
  <link rel="stylesheet" type="text/css" href="${ctx}/semantic/components/grid.css">
  <link rel="stylesheet" type="text/css" href="${ctx}/semantic/components/header.css">
  <link rel="stylesheet" type="text/css" href="${ctx}/semantic/components/image.css">
  <link rel="stylesheet" type="text/css" href="${ctx}/semantic/components/menu.css">

  <link rel="stylesheet" type="text/css" href="${ctx}/semantic/components/divider.css">
  <link rel="stylesheet" type="text/css" href="${ctx}/semantic/components/list.css">
  <link rel="stylesheet" type="text/css" href="${ctx}/semantic/components/segment.css">
  <link rel="stylesheet" type="text/css" href="${ctx}/semantic/components/dropdown.css">
  <link rel="stylesheet" type="text/css" href="${ctx}/semantic/components/icon.css">

  <style type="text/css">
  body {
    background-color: #FFFFFF;
  }
  .ui.menu .item img.logo {
    margin-right: 1.5em;
  }
  .main.container {
    margin-top: 7em;
  }
  .wireframe {
    margin-top: 2em;
  }
  .ui.footer.segment {
    margin: 5em 0em 0em;
    padding: 5em 0em;
  }
  </style>

</head>
<body>

<div class="ui fixed inverted menu">
    <div class="ui container">
      <a href="#" class="header item">
        <img class="logo" src="assets/images/logo.png">
        Project Name
      </a>
      <a href="#" class="item">Home</a>
      <div class="ui simple dropdown item">
        Dropdown <i class="dropdown icon"></i>
        <div class="menu">
          <a class="item" href="#">Link Item</a>
          <a class="item" href="#">Link Item</a>
          <div class="divider"></div>
          <div class="header">Header Item</div>
          <div class="item">
            <i class="dropdown icon"></i>
            Sub Menu
            <div class="menu">
              <a class="item" href="#">Link Item</a>
              <a class="item" href="#">Link Item</a>
            </div>
          </div>
          <a class="item" href="#">Link Item</a>
        </div>
      </div>
    </div>
  </div>

  <div class="ui main text container">
    <h1 class="ui header">Semantic UI Fixed Template</h1>
    <p>This is a basic fixed menu template using fixed size containers.</p>
   <div class="myTable">
<table class="ui celled table">
  <thead>
    <tr><th>序号</th>
    <th>值</th>
    <th>所属产品</th>
  </tr></thead>
  <tbody>
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
    <tr><th colspan="3">
      <div class="ui right floated pagination menu">
        <a class="icon item">
          <i class="left chevron icon"></i>
        </a>
        <a class="item">1</a>
        <a class="item">2</a>
        <a class="item">3</a>
        <a class="item">4</a>
        <a class="icon item">
          <i class="right chevron icon"></i>
        </a>
      </div>
    </th>
  </tr></tfoot>
</table>
</div>
  </div>

  <div class="ui inverted vertical footer segment">
    <div class="ui center aligned container">
      <div class="ui stackable inverted divided grid">
        <div class="three wide column">
          <h4 class="ui inverted header">Group 1</h4>
          <div class="ui inverted link list">
            <a href="#" class="item">Link One</a>
            <a href="#" class="item">Link Two</a>
            <a href="#" class="item">Link Three</a>
            <a href="#" class="item">Link Four</a>
          </div>
        </div>
        <div class="three wide column">
          <h4 class="ui inverted header">Group 2</h4>
          <div class="ui inverted link list">
            <a href="#" class="item">Link One</a>
            <a href="#" class="item">Link Two</a>
            <a href="#" class="item">Link Three</a>
            <a href="#" class="item">Link Four</a>
          </div>
        </div>
        <div class="three wide column">
          <h4 class="ui inverted header">Group 3</h4>
          <div class="ui inverted link list">
            <a href="#" class="item">Link One</a>
            <a href="#" class="item">Link Two</a>
            <a href="#" class="item">Link Three</a>
            <a href="#" class="item">Link Four</a>
          </div>
        </div>
        <div class="seven wide column">
          <h4 class="ui inverted header">Footer Header</h4>
          <p>Extra space for a call to action inside the footer that could help re-engage users.</p>
        </div>
      </div>
      <div class="ui inverted section divider"></div>
      <img src="assets/images/logo.png" class="ui centered mini image">
      <div class="ui horizontal inverted small divided link list">
        <a class="item" href="#">Site Map</a>
        <a class="item" href="#">Contact Us</a>
        <a class="item" href="#">Terms and Conditions</a>
        <a class="item" href="#">Privacy Policy</a>
      </div>
    </div>
  </div>
</body>

</html>