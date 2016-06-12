<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Nian Zi Technology Co., Ltd</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="./Resources/css/frame.css" type="text/css">
	<link rel="stylesheet" href="./Resources/css/sweetalert.css"
		type="text/css">
	<link rel="stylesheet" href="./Resources/css/style.default.css">

  </head>
  
  <body class="signin">





  <section>
    
      <div class="signinpanel">
          
          <div class="row">
              
              <div class="col-md-7">
                  
                  <div class="signin-info">
                      <div class="logopanel">
                          <h1><span></span> 碾子科技 <span></span></h1>
                      </div><!-- logopanel -->
                  
                      <div class="mb20"></div>
                  
                      <h5><strong>见好数据管理系统</strong></h5>
                      <ul>
                          <li><i class="fa fa-arrow-circle-o-right mr5"></i> 数据查询</li>
                          <li><i class="fa fa-arrow-circle-o-right mr5"></i> 数据管理</li>
                          <li><i class="fa fa-arrow-circle-o-right mr5"></i> 可视化分析</li>
                          <li><i class="fa fa-arrow-circle-o-right mr5"></i> 功能不断完善中</li>
                      </ul>
                      <div class="mb20"></div>
                     
                  </div><!-- signin0-info -->
              
              </div><!-- col-sm-7 -->
              
              <div class="col-md-5">
                  
                  <form method="post" action="admin/login">
                      <h4 class="nomargin">登录</h4>
                      <p class="mt5 mb20">请输入您的账户.</p>
                  
                      <input type="text" name="name" class="form-control uname" placeholder="Username" />
                      <input type="password" name="pwd" class="form-control pword" placeholder="Password" />
                      <a href=""><small>忘记密码?</small></a>
                      <button class="btn btn-success btn-block">登录</button>
                      
                  </form>
              </div><!-- col-sm-5 -->
              
          </div><!-- row -->
          
          <div class="signup-footer">
              <div class="pull-left">
                  &copy; 2016. All Rights Reserved. Nian Zi Technology Co., Ltd
              </div>
              <div class="pull-right">
                  Created By: <a href="" target="_blank">bingkuaix3</a>
              </div>
          </div>
          
      </div><!-- signin -->

  </section>


  <script src="js/jquery-1.11.1.min.js"></script>
  <script src="js/jquery-migrate-1.2.1.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/modernizr.min.js"></script>
  <script src="js/jquery.sparkline.min.js"></script>
  <script src="js/jquery.cookies.js"></script>

  <script src="js/toggles.min.js"></script>
  <script src="js/retina.min.js"></script>

  <script src="js/custom.js"></script>
  <script type="text/javascript">
  window.onload=function(){
  }
</script>
  </body>
</html>
