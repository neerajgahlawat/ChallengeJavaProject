<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Challenge Java | Home</title>
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
<!-- start slider -->
<link href="<c:url value='/resources/css/slider.css' />" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="<c:url value='/resources/js/modernizr.custom.28468.js' />"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.cslider.js' />"></script>
	<script type="text/javascript">
			$(function() {

				$('#da-slider').cslider({
					autoplay : true,
					bgincrement : 450
				});

			});
		</script>
<!-- Owl Carousel Assets -->
<link href="<c:url value='/resources/css/owl.carousel.css' />" rel="stylesheet">
<script src="<c:url value='/resources/js/owl.carousel.js' />"></script>
		<script>
			$(document).ready(function() {

				$("#owl-demo").owlCarousel({
					items : 4,
					lazyLoad : true,
					autoPlay : true,
					navigation : true,
					navigationText : ["", ""],
					rewindNav : false,
					scrollPerPage : false,
					pagination : false,
					paginationNumbers : false,
				});

			});
		</script>
		<!-- //Owl Carousel Assets -->
<!----font-Awesome----->
   	<link rel="stylesheet" href="<c:url value='/resources/fonts/css/font-awesome.min.css' />">
<!----font-Awesome----->
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<style type="text/css">
	ul li, ol li {
     line-height:160%; /*or whatever height you like*/
}
</style>
</head>
<body>
<div class="header_bg">
<div class="container">
	<div class="row header">
		<div class="logo navbar-left">
			<h1><a href="index.html">Challenge Java </a></h1>
		</div>
		<div class="h_search navbar-right">
			<form>
				<input type="text" class="text" value="Enter text here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter text here';}">
				<input type="submit" value="search">
			</form>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
</div>
<div class="container">
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
		        <li class="active"><a href="<c:url value='/' />">HOME</a></li>
		        <li><a href="<c:url value='/tech' />">JAVA</a></li>
		        <li><a href="<c:url value='/' />">INTERVIEW</a></li>
		        <li><a href="<c:url value='/about' />">ABOUT US</a></li>
		        <li><a href="<c:url value='/blog' />">BLOG</a></li>
		        <li><a href="<c:url value='/contact' />">CONTACT US</a></li>
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
</div>
<div class="slider_bg" ><!-- start slider -->
	<div class="container">
		<div style="width: 32em;float: right;height: 46em;background-color: silver;">
			<!-- <div class="col-md-6 content_right" style=" width: 50em;float: right; height: 38em;">form start
				 
			</div>form end -->
			<c:if test="${SUCCESS_MESSAGE != null}">
 				 <h5 id="status_message">${SUCCESS_MESSAGE}</h5>
			</c:if> 
			<form:form action="${contextPath}/notifyme" modelAttribute="notify" style="margin-top: 5em;" method="post">
					<table>
						<tr>
							<td><form:label path="firstName" class="required">FIRST NAME</form:label></td>
						</tr>
						<tr>
							<td> <form:input path="firstName" id="fname" name="firstname" placeholder="Your name.." required="required" style="height: 4em;width: 30em;"/></td>
						</tr>
						<tr>
							<td><form:label path="lastName" class="required">LAST NAME</form:label></td>
						</tr>
						<tr>
							<td> <form:input path="lastName"  id="lname" name="lastname" placeholder="Your last name.." required="required"  style="height: 4em;width: 30em;"/></td>
						</tr>
						<tr>
							<td><form:label path="email" class="required">EMAIL</form:label></td>
						</tr>
						<tr>
							<td><form:input path="email" id="email" name="email" placeholder="Your Email.." required="required"  style="height: 4em;width: 30em;"/> </td>
						</tr>
						<tr>
							<td><form:label path="phone" class="required">PHONE NO:</form:label></td>
						</tr>
						<tr>
							<td><form:input path="phone" id="phone" name="phone" placeholder="Your phone No.." required="required"  style="height: 4em;width: 30em;"/></td>
						</tr>
						<tr><td><form:button name="notifyme" value="NOTIFY ME" style="height: 3em; width: 30em;background-color: #2df109; margin-top: 3em;">NOTIFY ME</form:button></td></tr>
					</table>			
				 </form:form>
				 <h5>contact for free demo class</h5>
				 <h4>+91-9210842216</h4>
				 <h5>challengejava@gmail.com</h5>
		</div>
		<div id="da-slider" class="da-slider" style="width: 80em;float: left;">
			<div class="da-slide" >
				<h2>CHALLENGE JAVA</h2>
				<!-- <p>Challenge Java  offers online and off line platform where students, professionals can learn about Java<span class="hide_text"> We have experinced tranners.</span></p> -->
				<!-- <h3 class="da-link"><a href="single-page.html" class="fa-btn btn-1 btn-1e">view more</a></h3> -->
			</div>
			 <div class="da-slide">
				<h2>CARRER OPPERTUNITES</h2>
				<!-- <p>Our trainner and students are key to our success.<span class="hide_text"></span></p> -->
				<!-- <h3 class="da-link"><a href="single-page.html" class="fa-btn btn-1 btn-1e">view more</a></h3> -->
			</div>
			<div class="da-slide">
				<h2>SHAPE YOUR FUTURE</h2>
				<!-- <p>Challenge java is a leading name in the computer trainning.<span class="hide_text"></span></p> -->
				<!-- <h3 class="da-link"><a href="single-page.html" class="fa-btn btn-1 btn-1e">view more</a></h3> -->
			</div>
			<!--<div class="da-slide">
				<h2>online educations</h2>
				<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.<span class="hide_text"> Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</span></p>
				<h3 class="da-link"><a href="single-page.html" class="fa-btn btn-1 btn-1e">view more</a></h3>
			</div> -->
	   </div>
	</div>
</div><!-- end slider -->
<div class="main_bg">start main
	<div class="container">
		<div class="main row">
			<div class="col-md-3 images_1_of_4 text-center">
				<span class="bg"><i class="fa fa-globe"></i></span>
				<h4><a href="#">Sed Porta Dolor</a></h4>
				<p class="para">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text 1500s.</p>
				<a href="single-page.html" class="fa-btn btn-1 btn-1e">read more</a>
			</div>
			<div class="col-md-3 images_1_of_4 bg1 text-center">
				<span class="bg"><i class="fa fa-laptop"></i></span>
				<h4><a href="#">Lorem Ipsum is</a></h4>
				<p class="para">It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.</p>
				<a href="single-page.html" class="fa-btn btn-1 btn-1e">read more</a>
			</div>
			<div class="col-md-3 images_1_of_4 bg1 text-center">
				<span class="bg"><i class="fa fa-cog"></i></span>
				<h4><a href="#">Sed Porta Dolor</a></h4>
				<p class="para">The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32  by H. Rackham.</p>
				<a href="single-page.html" class="fa-btn btn-1 btn-1e">read more</a>
			</div>		
			<div class="col-md-3 images_1_of_4 bg1 text-center">
				<span class="bg"><i class="fa fa-shield"></i> </span>
				<h4><a href="#">Contrary  belief</a></h4>
				<p class="para">There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour.</p>
				<a href="single-page.html" class="fa-btn btn-1 btn-1e">read more</a>
			</div>	
		</div>
	</div>
</div>end main
<div class="main_btm"><!-- start main_btm -->
	<div class="container">
		<div class="main row">
			<div class="col-md-6 content_left">
				<img src="<c:url value='/resources/images/pic1.jpg' />" alt="" class="img-responsive">
			</div>
			<div class="col-md-6 content_right">
				<h4>OUR MENTORS</h4>
				<p class="para">Mentors play an essential role in an institute, the level of education, development of student’s skills are based on their trainers. If you do not have a good mentor then you may lagin many things from others and that is why we at Ducat gives you the facility of skilled employees so that you do not feel unsecured about the academics.</p>
				<p class="para">Personality development and academic status are some of those things which lie on mentor’s hands. If you are trained well then you can do well in your future and knowing its importance Ducat always tries to give you the best.</p>
				<p class="para">We have a great team of skilled mentors who are always ready to direct their trainees in the best possible way they ca and to ensure the skills of mentors we held many skill development programs as well so that each and every mentor can develop their own skills with the demands of the companies so that they can prepare a complete packaged trainee.</p>
				<!-- <a href="single-page.html" class="fa-btn btn-1 btn-1e">read more</a> -->
			</div>
		</div>
				<!----start-img-cursual---->
					<div id="owl-demo" class="owl-carousel text-center">
						<div class="item">
							<div class="cau_left">
								<img class="lazyOwl" data-src="<c:url value='/resources/images/neeraj.jpg' />" alt="Lazy Owl Image">
							</div>
							<div class="cau_left">
								<h4><a href="#">vehicula diam</a></h4>
								<p>
									Lorem ipsum dolor amet,consectetur adipisicing elit, sed do eiusmod tempor incididunt dolore magna aliqua.
								</p>
							</div>
						</div>
						<div class="item">
							<div class="cau_left">
								<img class="lazyOwl" data-src="<c:url value='/resources/images/c2.jpg' />" alt="Lazy Owl Image">
							</div>
							<div class="cau_left">
								<h4><a href="#">Morbi nunc</a></h4>
								<p>
									Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium,
								</p>
							</div>
						</div>
						<div class="item">
							<div class="cau_left">
								<img class="lazyOwl" data-src="<c:url value='/resources/images/c3.jpg' />" alt="Lazy Owl Image">
							</div>
							<div class="cau_left">
								<h4><a href="#">Lorem ipsum</a></h4>
								<p>
									On the other hand, we denounce with righteous indignation and dislike men who are so beguiled  pleasure of the moment,
								</p>
							</div>
						</div>
						<div class="item">
							<div class="cau_left">
								<img class="lazyOwl" data-src="<c:url value='/resources/images/c4.jpg' />" alt="Lazy Owl Image">
							</div>
							<div class="cau_left">
								<h4><a href="#">Sed faucibus</a></h4>
								<p>
									Lorem ipsum dolor amet,consectetur adipisicing elit, sed do eiusmod tempor incididunt dolore magna aliqua.
								</p>
							</div>
						</div>
						<div class="item">
							<div class="cau_left">
								<img class="lazyOwl" data-src="<c:url value='/resources/images/c2.jpg' />" alt="Lazy Owl Image">
							</div>
							<div class="cau_left">
								<h4><a href="#">Lorem ipsum</a></h4>
								<p>
									Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium,
								</p>
							</div>
						</div>
						<div class="item">
							<div class="cau_left">
								<img class="lazyOwl" data-src="<c:url value='/resources/images/c3.jpg' />" alt="Lazy Owl Image">
							</div>
							<div class="cau_left">
								<h4><a href="#">Lorem ipsum</a></h4>
								<p>
									On the other hand, we denounce with righteous indignation and dislike men who are so beguiled  pleasure of the moment,
								</p>
							</div>
						</div>
						<div class="item">
							<div class="cau_left">
								<img class="lazyOwl" data-src="<c:url value='/resources/images/c4.jpg' />" alt="Lazy Owl Image">
							</div>
							<div class="cau_left">
								<h4><a href="#">vehicula diam</a></h4>
								<p>
									Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium,
								</p>
							</div>
						</div>
						<div class="item">
							<div class="cau_left">
								<img class="lazyOwl" data-src="<c:url value='/resources/images/c1.jpg' />" alt="Lazy Owl Image">
							</div>
							<div class="cau_left">
								<h4><a href="#">Lorem ipsum</a></h4>
								<p>
									On the other hand, we denounce with righteous indignation and dislike men who are so beguiled  pleasure of the moment,
								</p>
							</div>
						</div>
						<div class="item">
							<div class="cau_left">
								<img class="lazyOwl" data-src="<c:url value='/resources/images/c2.jpg' />" alt="Lazy Owl Image">
							</div>
							<div class="cau_left">
								<h4><a href="#">Lorem ipsum</a></h4>
								<p>
									Lorem ipsum dolor amet,consectetur adipisicing elit, sed do eiusmod tempor incididunt dolore magna aliqua.
								</p>
							</div>
						</div>
						<div class="item">
							<div class="cau_left">
								<img class="lazyOwl" data-src="<c:url value='/resources/images/c3.jpg' />" alt="Lazy Owl Image">
							</div>
							<div class="cau_left">
								<h4><a href="#">vehicula diam</a></h4>
								<p>
									Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium,
								</p>
							</div>
						</div>
						<div class="item">
							<div class="cau_left">
								<img class="lazyOwl" data-src="<c:url value='/resources/images/c1.jpg' />" alt="Lazy Owl Image">
							</div>
							<div class="cau_left">
								<h4><a href="#">Lorem ipsum</a></h4>
								<p>
									On the other hand, we denounce with righteous indignation and dislike men who are so beguiled  pleasure of the moment,
								</p>
							</div>
						</div>
						<div class="item">
							<div class="cau_left">
								<img class="lazyOwl" data-src="<c:url value='/resources/images/c4.jpg' />" alt="Lazy Owl Image">
							</div>
							<div class="cau_left">
								<h4><a href="#">Morbi nunc</a></h4>
								<p>
									Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium,
								</p>
							</div>
						</div>
					</div>
					<!----//End-img-cursual---->
	</div>
</div>
<div class="author_view">
	<div class="container" style="border: 1em;background-color: #f44242;">
			<h2>Author view</h2>
		<div class="col-md-2" style="border: 1em;background-color: pink;"> 
			<img  data-src="<c:url value='/resources/images/author_jpg.jpg' />" width="200" height="200" alt="Author">
		</div>
		<div class="col-md-10">
			<H5><b><i>Hi, I have written and developed this site so that students may learn computer science related technologies easily. I'm committed to provide</i></b></H5>
			<H5><b><i>easy and in-depth tutorials on various technologies. No one is perfect in this world and nothing is eternally best. But we can try to be better.</i></b></H5>
			<h5><b><i>I hope it will help you a lot.</i></b></h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h5>-:Neeraj gahlawat</h5>
		</div>	
	</div>
</div>
<div class="footer_up_bg" style="border: 1em;background-color: #ef3434;">
	<div class="container" style="border: 1em;background-color: #ef3434;">
		<div class="col-md-3">
			<h3>LEARN TUTORIALS</h3>
			<ul style="list-style-type:none">
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
            </ul>
		</div>
		<div class="col-md-3">
			<h3>OUR SERVICES</h3>
			<ul style="list-style-type:none;">
                <li style="margin: 1em;"><a href="#">Website Development</a></li>
                <li><a href="#">Android Development</a></li>
                <li><a href="#">Website Designing</a></li>
                <li><a href="#">Digital Marketing</a></li>
                <li><a href="#">Summer Training</a></li>
                <li><a href="#">Industrial Training</a></li>
               	<li><a href="#">College Campus Training</a></li>
            </ul>
		</div>
		<div class="col-md-3">
			<h3>OUR WEBSITES</h3>
			<ul style="list-style-type:none">
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
            </ul>
		</div>
		<div class="col-md-3">
			<h3>CONTACT US</h3>
			<h4>Contact No: 9210842216</h4>
			
		</div>
	</div>
</div>
<div class="footer_bg"><!-- start footer -->
	<div class="container">
		<div class="row  footer">
			<div class="copy text-center">
				<p class="link"><span>&#169; All rights reserved | Design by&nbsp;<a href=""> Challenge Java</a></span></p>
			</div>
		</div>
	</div>
</div>
</body>
</html>