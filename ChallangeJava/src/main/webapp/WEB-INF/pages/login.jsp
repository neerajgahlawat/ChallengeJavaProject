<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Challange Java | Login</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- Bootstrap -->
<link href="<c:url value='/resources/css/bootstrap.min.css' />"
	rel='stylesheet' type='text/css' />
<link href="<c:url value='/resources/css/bootstrap.css' />"
	rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!--[if lt IE 9]>
     <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
     <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"
	type="text/css" media="all" />
<!-- start plugins -->
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery.min.js' />"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.js' />"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
<!----font-Awesome----->
<link rel="stylesheet"
	href="<c:url value='/resources/fonts/css/font-awesome.min.css' />">
<!----font-Awesome----->
<link href="<c:url value='/resources/css/login.css' />"
	rel='stylesheet' type='text/css' />
</head>
<body>
	<div class="header_bg1">
		<div class="container">
			<div class="row header">
				<div class="logo navbar-left">
					<h1>
						<a href="index.html">Learner </a>
					</h1>
				</div>
				<div class="h_search navbar-right">
					<form>
						<input type="text" class="text" value="Enter text here"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Enter text here';}">
						<input type="submit" value="search">
					</form>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="row h_menu">
				<nav class="navbar navbar-default navbar-left" role="navigation">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a href="<c:url value='/' />">Home</a></li>
							<li class="active"><a href="<c:url value='/tech' />">Technologies</a></li>
							<li><a href="<c:url value='/about' />">About</a></li>
							<li><a href="<c:url value='/blog' />">Blog</a></li>
							<li><a href="<c:url value='/contact' />">Contact</a></li>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
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

	<%-- <div id="loginForm">
		<div class="container">
			<div class="col-md-6" style="margin-top: 5em;margin-bottom: 5em;">
			<h4>Login Form</h4><a href="<c:url value='/' />">Sign Up</a>
				<c:url var="loginUrl" value="/login" />
				<form action="${loginUrl}" method="post" class="form-horizontal">
					<c:if test="${param.error != null}">
						<div class="alert alert-danger">
							<p>Invalid username and password.</p>
						</div>
					</c:if>

					<div class="form-group">
						<label class="col-xs-3 control-label" for="username">USER
							NAME</label>
						<div class="col-xs-7">
							<input type="text" class="form-control" id="username"
								name="ssoId" placeholder="Enter Username" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label" for="password">PASSWORD</label>
						<div class="col-xs-7">
							<input type="password" class="form-control" id="password"
								name="password" placeholder="Enter Password" required>
						</div>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" /> <input type="submit"
						class="btn btn-block btn-success" value="Log in">

				</form>
				
			</div>
		</div>
	</div> --%>
	<div class="container">
<div class="row">
<div class="col-md-4 col-md-offset-4">
<div class="form-body">
    <ul class="nav nav-tabs final-login">
        <li class="active"><a data-toggle="tab" href="#sectionA">Sign In</a></li>
        <li><a href="<c:url value='/' />">Join us!</a></li>
    </ul>
    
    <div class="tab-content">
        <div id="sectionA" class="tab-pane fade in active">
        <div class="innter-form">
           <form action="${loginUrl}" method="post" class="form-horizontal">
					<c:if test="${param.error != null}">
						<div class="alert alert-danger">
							<p>Invalid username and password.</p>
						</div>
					</c:if>				

					<div class="form-group">
						<label class="col-xs-3 control-label" for="username">USER
							NAME</label>
						<div class="col-xs-7">
							<input type="text" class="form-control" id="username"
								name="ssoId" placeholder="Enter Username" style="width: 12em;" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label" for="password">PASSWORD</label>
						<div class="col-xs-7">
							<input type="password" class="form-control" id="password"
								name="password" placeholder="Enter Password" required>
						</div>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" /> <input type="submit"
						class="btn btn-block btn-success" value="Log in"> <a href="<c:url value='/user/reset/id' />">Forgot Password?</a>

				</form>
            </div>
            <div class="social-login">
            <p>- - - - - - - - - - - - - Sign In With - - - - - - - - - - - - - </p>
    		<ul>
            <li><a href=""><i class="fa fa-facebook"></i> Facebook</a></li>
            <li><a href=""><i class="fa fa-google-plus"></i> Google+</a></li>
            <li><a href=""><i class="fa fa-twitter"></i> Twitter</a></li>
            </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    </div>
    </div>
    </div>
    </div>
	

	<div class="footer_bg">
		<!-- start footer -->
		<div class="container">
			<div class="row  footer">
				<div class="copy text-center">
					<p class="link">
						<span>&#169; All rights reserved | Design by&nbsp;</span>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>