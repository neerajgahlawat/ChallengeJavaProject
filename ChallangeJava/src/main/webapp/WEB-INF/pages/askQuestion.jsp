<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Learner a education bootstrap Website Template | About :: w3layouts</title>
<!-- Bootstrap -->
<link href="<c:url value='/resources/css/bootstrap.min.css' />" rel='stylesheet' type='text/css' />
<link href="<c:url value='/resources/css/bootstrap.css' />" rel='stylesheet' type='text/css' />
<link href="<c:url value='/resources/css/display.css' />" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!--[if lt IE 9]>
     <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
     <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<link href="<c:url value='/resources/css/style.css' />" rel="stylesheet" type="text/css" media="all" />
<!-- start plugins -->
<script type="text/javascript" src="<c:url value='/resources/js/jquery.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/resources/js/bootstrap.js' />"></script>
<script type="text/javascript" src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
<!----font-Awesome----->
   	<link rel="stylesheet" href="<c:url value='/resources/fonts/css/font-awesome.min.css' />">
<!----font-Awesome----->
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="header_bg1">
<div class="container">
	<div class="row header">
		<div class="logo navbar-left">
			<h1><a href="index.html">Learner </a></h1>
		</div>
		<div class="h_search navbar-right">
			<form>
				<!-- <input type="text" class="text" value="Enter text here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter text here';}">
				<input type="submit" value="search"> -->
				  Dear <strong>${user}</strong>, Welcome to Admin Page.
    				<a href="<c:url value="/logout" />">Logout</a>
			</form>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="row h_menu">
		<nav class="navbar navbar-default navbar-left" role="navigation">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		    </div>
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		        <li><a href="<c:url value='/' />">Home</a></li>
		        <li><a href="<c:url value='/tech' />">Technologies</a></li>
		        <li  class="active"><a href="<c:url value='/about' />">About</a></li>
		        <li><a href="<c:url value='/blog' />">Blog</a></li>
		        <li><a href="<c:url value='/contact' />">Contact</a></li>
		      </ul>
		    </div><!-- /.navbar-collapse -->
		    <!-- start soc_icons -->
		</nav>
		<div class="soc_icons navbar-right">
			<ul class="list-unstyled text-center">
				<li><a href="#"><i class="fa fa-twitter"></i></a></li>
				<li><a href="#"><i class="fa fa-facebook"></i></a></li>
				<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
				<li><a href="#"><i class="fa fa-youtube"></i></a></li>
				<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
			</ul>	
		</div>
	</div>
	<div class="clearfix"></div>
</div>
</div>
<div class="main_bg">
	<div class="container" style="margin-top: 1em;">
		<div class="col-md-8">
			<form:form action="" method="post" modelAttribute="askQuestion" class="form-horizontal">
				<div class="form-group required">
					<form:label path="title" class="control-label col-sm-2" for="inputlg" >Title :</form:label>
					<div class="col-sm-10">
						<form:input path="title" class="form-control input-lg" id="title" name="title" placeholder="what's your programming question? Be specific" required="required" size="30%" />
					</div>
				</div>
				<div class="form-group required">		
					<form:label path="question" class="control-label col-sm-2" for="inputlg"></form:label>
					<div class="col-sm-10">
						 <form:textarea path="question"  class="form-control input-lg" id="lname" name="lastname" placeholder="" required="required" cssStyle=" height: 15em;"/>
					</div>
				</div>		
						<form:button class="btn btn-success" name="notifyme" value="Post Your Question">Post Your Question</form:button>			
				 </form:form>
		</div>
		<div class="col-md-4" style="float: right;overflow: hidden;">
			<div style="margin-bottom: 1em;background-color: #FCC9B9;padding: 10px; position: fixed;"> 
				<h3>How to Ask</h3>
				<h4><b>Is your question about programming?</b></h4><br>
				<h5>We prefer questions that can be answered, not just discussed.</h5><br>
				<h5>Provide details. Share your research.</h5><br>
				<h5>If your question is about this website, ask it on meta instead.</h5><br>
			</div>
		</div>
		</div>
	</div>	
<div class="footer_bg"><!-- start footer -->
	<div class="container">
		<div class="row  footer">
			<div class="copy text-center">
				<p class="link"><span>&#169; All rights reserved | Design by&nbsp;<a href="http://w3layouts.com/"> W3Layouts</a></span></p>
			</div>
		</div>
	</div>
</div>
</body>
</html>