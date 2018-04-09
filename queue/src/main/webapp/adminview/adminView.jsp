<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员管理界面</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<link href="../css/style.css" rel="stylesheet" />
<style type="text/css">
	body { padding-top: 70px; }
</style>

<script src="../js/jquery-1.11.3.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/toast.js"></script>

<script src="../js/personInfo.js"></script>

</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<!-- <nav class="navbar navbar-inverse navbar-static-top"> -->
		<div class="container">
			<!-- navbar-header START -->
			<div class="navbar-header">
				<button class="navbar-toggle" data-target="#navbar-collapse"
					data-toggle="collapse" type="button">
					<span class="sr-only"> 切换导航 </span> <span class="icon-bar"> </span>
					<span class="icon-bar"> </span> <span class="icon-bar"> </span>
				</button>
				<!-- <div class="navbar-brand">
					<img id="logoImg" alt="" src="image/logo.png" style="height: 50px;" />
				</div> -->
				<a class="navbar-brand" href="index.html">美味&middot;不用等</a>
			</div>
			<!-- navbar-header END -->
			<!-- navbar-collapse START -->
			<div class="collapse navbar-collapse" id="navbar-collapse">
				<ul class="nav navbar-nav navbar-right">				
					
					<c:if test="${user.account==null }">
						<li><a href="/queue/user/toAdminView.do"> <span
								class="glyphicon glyphicon-log-in"> </span> 安全登录
						</a></li>
						
					</c:if>
					
					<c:if test="${user.account!=null }">
						<li class="dropdown"><a id="" class="dropdown-toggle"
							data-toggle="dropdown" data-hover="dropdown"> <span
								class="glyphicon glyphicon-user"> </span>
								 <span id="accountID"><c:out value="${user.account }"></c:out></span>							 
								 <b	class="caret"> </b>
						</a>
							<ul class="dropdown-menu">
								<li><a id="" data-toggle="modal" href="#personalModal" onclick="getPersonInfo();"> <span
										class="glyphicon glyphicon-info-sign"> </span> 个人信息
								</a></li>
								<li><a href="/queue/user/exit.do"> <span
										class="glyphicon glyphicon-log-out"> </span> 退出系统
								</a></li>
							</ul></li>
	
					</c:if>
				</ul>
			</div>
			<!-- navbar-collapse END -->
		</div>
	</nav>
	
	
	
	
	
	

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="personalModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">个人信息</h4>
	            </div>
	            <div class="modal-body">
					<form class="form-horizontal" id="personInfo" role="form">
					  <div class="form-group">
					    <label for="model_account" class="col-sm-3 control-label">账    号：</label>
					    <div class="col-sm-9">
					    	<input type="text" class="form-control" id="model_account" disabled>
					    </div>
					  </div>
					  <div class="form-group" >
					    <label for="model_name" class="col-sm-3 control-label">姓    名：</label>
					    <div class="col-sm-9">
					    	<input type="text" class="form-control" id="model_name">
					    </div>
					  </div>
					  <div class="form-group" >
					    <label for="model_gender" class="col-sm-3 control-label">性    别：</label>				    
						<div class="col-sm-9">
						    <select class="form-control" id="model_gender">
						      <option value="1">男</option>
						      <option value="2">女</option>					     
						    </select>
						 </div>
					  </div>
					  <div class="form-group">
					    <label for="model_telephone" class="col-sm-3 control-label">联系方式：</label>
					    <div class="col-sm-9">
					    	<input type="text" class="form-control" id="model_telephone" >
					  	</div>
					  </div>
					</form>
				</div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal" id="closeBtn">关闭</button>
	                <button type="button" class="btn btn-primary" onclick="updateUser()">更改</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>

</body>
</html>