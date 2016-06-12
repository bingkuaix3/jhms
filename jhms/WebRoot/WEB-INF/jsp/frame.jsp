<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>">
<title>frame</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="./Resources/css/frame.css" type="text/css">
<link rel="stylesheet" href="./Resources/css/sweetalert.css"
	type="text/css">
<link rel="stylesheet" href="./Resources/css/style.default.css">
</head>

<body>

	<section>

		<div class="leftpanel">

			<div class="logopanel">
				<h1>
					<span></span> 碾子科技 <span></span>
				</h1>
			</div>
			<!-- logopanel -->

			<div class="leftpanelinner">

				<!-- This is only visible to small devices -->
				<div class="visible-xs hidden-sm hidden-md hidden-lg">
					<div class="media userlogged">
						<img alt="" src="../../images/photos/loggeduser.png"
							class="media-object">
						<div class="media-body">
							<h4>John Doe</h4>
							<span>"Life is so..."</span>
						</div>
					</div>

					<h5 class="sidebartitle actitle">Account</h5>
					<ul class="nav nav-pills nav-stacked nav-bracket mb30">
						<li><a href="profile.html"><i class="fa fa-user"></i> <span>Profile</span></a></li>
						<li><a href=""><i class="fa fa-cog"></i> <span>Account
									Settings</span></a></li>
						<li><a href=""><i class="fa fa-question-circle"></i> <span>Help</span></a></li>
						<li><a href="signout.html"><i class="fa fa-sign-out"></i>
								<span>Sign Out</span></a></li>
					</ul>
				</div>

				<h5 class="sidebartitle">数据管理</h5>
				<ul class="nav nav-pills nav-stacked nav-bracket">
					<li class="nav-parent nav-active nav-hover"><a
						href="index.html"><i class="fa fa-list"></i> <span>方案</span></a>
						<ul class="children" style="display:block">
							<li><a href="general-forms.html"><i
									class="fa fa-caret-right"></i> 方案</a></li>
							<li><a href="general-forms.html"><i
									class="fa fa-caret-right"></i> 方案类别</a></li>
							<li><a href="form-layouts.html"><i
									class="fa fa-caret-right"></i> 细节</a></li>
							<li><a href="form-validation.html"><i
									class="fa fa-caret-right"></i> 组方</a></li>
							<li><a href="form-wizards.html"><i
									class="fa fa-caret-right"></i> 穴位</a></li>
							<li><a href="wysiwyg.html"><i class="fa fa-caret-right"></i>
									需求</a></li>
							<li><a href="code-editor.html"><i
									class="fa fa-caret-right"></i> 体制</a></li>
							<li><a href="x-editable.html"><i
									class="fa fa-caret-right"></i> 问题</a></li>
							<li><a href="x-editable.html"><i
									class="fa fa-caret-right"></i> 产品</a></li>
						</ul></li>
					<li class="nav-parent"><a href="email.html"><i
							class="fa  fa-pencil"></i> <span>统计</span></a>
						<ul class="children">
							<li><a href="general-forms.html"><i
									class="fa fa-caret-right"></i> 用户检测</a></li>
							<li><a href="form-wizards.html"><i
									class="fa fa-caret-right"></i> 意见反馈</a></li>
							<li><a href="wysiwyg.html"><i class="fa fa-caret-right"></i>
									用户信息</a></li>

						</ul></li>
					<li class="nav-parent"><a href=""><i class="fa fa-tags">
						</i> <span>坚持</span></a>
						<ul class="children">
							<li><a href="general-forms.html"><i
									class="fa fa-caret-right"></i> 坚持数据</a></li>
							<li><a href="form-layouts.html"><i
									class="fa fa-caret-right"></i> 坚持类别</a></li>
							<li><a href="form-validation.html"><i
									class="fa fa-caret-right"></i> 我的坚持</a></li>
							<li><a href="form-wizards.html"><i
									class="fa fa-caret-right"></i> 评论</a></li>

						</ul></li>
					<li class="nav-parent"><a href=""><i class="fa fa-rocket"></i>
							<span>其他</span></a>
						<ul class="children">
							<li><a href="general-forms.html"><i
									class="fa fa-caret-right"></i> 展示图片</a></li>

						</ul></li>
					<li class="nav-parent"><a href=""><i class="fa fa-signal"></i>
							<span>图表</span></a>
						<ul class="children">
							<li><a href="general-forms.html"><i
									class="fa fa-caret-right"></i> 用户检测</a></li>
							<li><a href="form-layouts.html"><i
									class="fa fa-caret-right"></i> 用户登录</a></li>
							<li><a href="form-validation.html"><i
									class="fa fa-caret-right"></i> 点击检测</a></li>
							<li><a href="form-wizards.html"><i
									class="fa fa-caret-right"></i> 意见反馈</a></li>
							<li><a href="wysiwyg.html"><i class="fa fa-caret-right"></i>
									使用</a></li>
							<li><a href="wysiwyg.html"><i class="fa fa-caret-right"></i>
									用户信息</a></li>

						</ul></li>
				</ul>



			</div>
			<!-- leftpanelinner -->
		</div>
		<!-- leftpanel -->

		<div class="mainpanel">

			<div class="headerbar">

				<a class="menutoggle"><i class="fa fa-bars"></i></a>

				<form class="searchform" action="index.html" method="post">
					<input type="text" class="form-control" name="keyword"
						placeholder="Search here..." />
				</form>

			</div>
			<!-- headerbar -->

			<div class="pageheader">
				<h2>
					<i class="fa fa-list"></i>&nbsp&nbsp&nbsp&nbsp方案 <span>方案数据
					</span>
				</h2>
				<div class="breadcrumb-wrapper">
					<span class="label">位置&nbsp:</span>
					<ol class="breadcrumb">
						<li><a href="index.html">方案</a></li>
						<li class="active">方案</li>
					</ol>
				</div>
			</div>

			<div class="contentpanel">
				<!-- content goes here... -->
			</div>

		</div>
		<!-- mainpanel -->

	</section>
</body>
<script src="./Resources/js/jquery-1.11.1.min.js"></script>
<script language='javascript'
	src="./Resources/js/jquery-migrate-1.2.1.min.js"></script>
<script language='javascript' src="./Resources/js/bootstrap.min.js"></script>
<script language='javascript' src="./Resources/js/modernizr.min.js"></script>
<script language='javascript'
	src="./Resources/js/jquery.sparkline.min.js"></script>
<script language='javascript' src="./Resources/js/toggles.min.js"></script>
<script language='javascript' src="./Resources/js/retina.min.js"></script>
<script language='javascript' src="./Resources/js/jquery.cookies.js"></script>
<script language='javascript' src="./Resources/js/custom.js"></script>
<script language='javascript' src='./Resources/js/frame.js'></script>
<script language='javascript' src='./Resources/js/sweetalert.min.js'></script>
<script type="text/javascript">
	
</script>
</html>
