<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Learner a education bootstrap Website Template | Blog :: w3layouts</title>
<!-- Bootstrap -->
<link href="<c:url value='/resources/css/bootstrap.min.css' />" rel='stylesheet' type='text/css' />
<link href="<c:url value='/resources/css/bootstrap.css' />" rel='stylesheet' type='text/css' />
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
<div class="header_bg1">
<div class="container">
	<div class="row header">
		<div class="logo navbar-left">
			<h1><a href="index.html">Learner </a></h1>
		</div>
		<div class="h_search navbar-right">
			<form>
				<input type="text" class="text" value="Enter text here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter text here';}">
				<input type="submit" value="search">
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
		        <li><a href="<c:url value='/about' />">About</a></li>
		        <li class="active"><a href="<c:url value='/blog' />">Blog</a></li>
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
<div class="main_bg"><!-- start main -->
	<div class="container">
		<div class="main row">
			<div class="col-md-8 blog_left">
				<h4><a href="single-page.html">Lorem Ipsum is simply dummy text of the printingy </a></h4>
				<a href="single-page.html"><img src="<c:url value='/resources/images/blog_pic1.jpg' />" alt="" class="blog_img img-responsive"/></a>
				<div class="blog_list">
					  <ul class="list-unstyled">
						<li><i class="fa fa-calendar-o"></i><span>June 3, 2013</span></li>
						<li><a href="#"><i class="fa fa-comment"></i><span>Comments</span></a></li>
				  		<li><a href="#"><i class="fa fa-user"></i><span>Admin</span></a></li>
				  		<li><a href="#"><i class="fa fa-eye"></i><span>124 views</span></a></li>
					  </ul>
				</div>
				<p class="para">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing</p>
				<div class="read_more">
					<a href="single-page.html" class="fa-btn btn-1 btn-1e">view more</a>
				</div>
				<h4><a href="single-page.html">a long established fact that a reader will be distracted</a></h4>
				<a href="single-page.html"><img src="<c:url value='/resources/images/blog_pic2.jpg' />" alt="" class="blog_img img-responsive"/></a>
				<div class="blog_list">
					  <ul class="list-unstyled">
						<li><i class="fa fa-calendar-o"></i><span>June 3, 2013</span></li>
						<li><a href="#"><i class="fa fa-comment"></i><span>Comments</span></a></li>
				  		<li><a href="#"><i class="fa fa-user"></i><span>Admin</span></a></li>
				  		<li><a href="#"><i class="fa fa-eye"></i><span>124 views</span></a></li>
					  </ul>
				</div>
				<p class="para">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing</p>
				<div class="read_more">
					<a href="single-page.html" class="fa-btn btn-1 btn-1e">view more</a>
				</div>
			</div>
			<div class="col-md-4 blog_right">
				<!-- start social_network_likes -->
					<div class="social_network_likes">
				      		 <ul class="list-unstyled">
				      		 	<li><a href="#" class="tweets"><div class="followers"><p><span>2k</span>Followers</p></div><div class="social_network"><i class="twitter-icon"> </i> </div></a></li>
				      			<li><a href="#" class="facebook-followers"><div class="followers"><p><span>5k</span>Followers</p></div><div class="social_network"><i class="facebook-icon"> </i> </div></a></li>
				      			<li><a href="#" class="email"><div class="followers"><p><span>7.5k</span>members</p></div><div class="social_network"><i class="email-icon"> </i></div> </a></li>
				      			<li><a href="#" class="dribble"><div class="followers"><p><span>10k</span>Followers</p></div><div class="social_network"><i class="dribble-icon"> </i></div></a></li>
				      			<div class="clear"> </div>
				    		</ul>
		          	</div>
				<ul class="ads_nav list-unstyled">
					<h4>Ads 125 x 125</h4>
						<li><a href="#"><img src="<c:url value='/resources/images/ads_pic.jpg' />" alt=""> </a></li>
						<li><a href="#"><img src="<c:url value='/resources/images/ads_pic.jpg' />" alt=""> </a></li>
						<li><a href="#"><img src="<c:url value='/resources/images/ads_pic.jpg' />" alt=""> </a></li>
						<li><a href="#"><img src="<c:url value='/resources/images/ads_pic.jpg' />" alt=""> </a></li>
					<div class="clearfix"></div>
				</ul>
				<ul class="tag_nav list-unstyled">
					<h4>tags</h4>
						<li class="active"><a href="#">art</a></li>
						<li><a href="#">awesome</a></li>
						<li><a href="#">classic</a></li>
						<li><a href="#">photo</a></li>
						<li><a href="#">wordpress</a></li>
						<li><a href="#">videos</a></li>
						<li><a href="#">standard</a></li>
						<li><a href="#">gaming</a></li>
						<li><a href="#">photo</a></li>
						<li><a href="#">music</a></li>
						<li><a href="#">data</a></li>
						<div class="clearfix"></div>
				</ul>
				<div class="news_letter">
					<h4>news letter</h4>
						<form>
							<span><input type="text" placeholder="Your email address"></span>
							<span  class="pull-right fa-btn btn-1 btn-1e"><input type="submit" value="subscribe"></span>
						</form>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div><!-- end main -->
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