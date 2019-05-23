<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Forgot Password</title>
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
<div class="reset_bg">
	<div class="container">
		<c:if test="${not empty RESET_PASS_MSG}">
			<div id="status_message" class="alert alert-success">${RESET_PASS_MSG}</div>
		</c:if>
			<form action="${contextPath}/user/resetPassword" id="identicalForm" class="form-horizontal">
				<h2>Forgot Password</h2>
				<div class="form-group">
					<label class="col-xs-3 control-label">EMAIL ID</label>
					<div class="col-xs-7">
						<input class="form-control" name="email"
							placeholder="Your Email.." required="required" id="email" />
					</div>
				</div>
				<button class="btn btn-success" name="reset" value="reset">Reset</button>
			</form>
 
<!-- <script src="jquery.min.js"></script>
<script th:inline="javascript">
var serverContext = [[@{/}]];
function resetPass(){
    var email = $("#email").val();
    $.post(serverContext + "user/resetPassword",{email: email} ,
      function(data){
          window.location.href = 
           serverContext + "login?message=" + data.message;
    })
    .fail(function(data) {
        if(data.responseJSON.error.indexOf("MailError") > -1)
        {
            window.location.href = serverContext + "emailError.html";
        }
        else{
            window.location.href = 
              serverContext + "login?message=" + data.responseJSON.message;
        }
    });
}
 
</script> -->
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