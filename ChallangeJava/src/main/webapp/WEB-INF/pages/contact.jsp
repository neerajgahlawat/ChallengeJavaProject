<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Learner a education bootstrap Website Template | Contact :: w3layouts</title>
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
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="header_bg1">
<div class="container">
	<div class="row header">
		<div class="logo navbar-left">
			<h1><a href="index.html">Learner</a></h1>
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
		        <li><a href="<c:url value='/blog' />">Blog</a></li>
		        <li class="active"><a href="<c:url value='/contact' />">Contact</a></li>
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
			<!-- <iframe width="100%" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.co.in/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265&amp;output=embed"></iframe><br><small><a href="https://maps.google.co.in/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265" style="font-family: 'Open Sans', sans-serif;color:#555555;text-shadow:0 1px 0 #ffffff; text-align:left;font-size:12px;padding: 5px;">View Larger Map</a></small> -->
			<div style="width: 32em;float: right;">
		<h4 class="text-center">NOTIFY US</h4>
			<c:if test="${SUCCESS_MESSAGE != null}">
 				 <div id="status_message" class="alert alert-success">${SUCCESS_MESSAGE}</div>
			</c:if> 
			<form:form action="${contextPath}/notifyme" modelAttribute="notify" method="post">
				<div class="form-group">
					<form:label path="firstName" class="required">FIRST NAME</form:label>
					<form:input path="firstName" id="fname" name="firstname" placeholder="Your name.." required="required" style="height: 4em;width: 32em;"/>
				</div>
				<div class="form-group">		
					<form:label path="lastName" class="required">LAST NAME</form:label></td>
					 <form:input path="lastName"  id="lname" name="lastname" placeholder="Your last name.." required="required"  style="height: 4em;width: 32em;"/>
				</div>	
				<div class="form-group">	
					<form:label path="email" class="required">EMAIL</form:label></td>
					<form:input path="email" id="email" name="email" placeholder="Your Email.." required="required"  style="height: 4em;width: 32em;"/>
				</div>
				<div class="form-group">		
					<form:label path="phone" class="required">PHONE NO:</form:label></td>
					<form:input path="phone" id="phone" name="phone" placeholder="Your phone No.." required="required"  style="height: 4em;width: 32em;"/>
				</div>		
						<form:button class="btn btn-success btn-block" name="notifyme" value="NOTIFY ME">NOTIFY ME</form:button>			
				 </form:form>
		</div>
		</div>
	</div>
</div><!-- end main -->
<div class="main_btm"><!-- start main_btm -->
	<div class="container">
		<div class="main row">
			    <div class="col-md-4 company_ad">
				    <h2>find Address :</h2>
      				<address>
						 <p>H.No - 29 A Rajendra Park Ext,</p>
						 <p>Nangloi, Delhi</p>
						 <p>INDIA</p>
				   		<p>Phone:(+91) 9210842216</p>
				   		<p>Fax: (000) 000 00 00 0</p>
				 	 	<p>Email: <a href="challengejava@gmail.com">info(at)challengeJava.com</a></p>
				   		<p>Follow on: <a href="#">Facebook</a>, <a href="#">Twitter</a></p>
				   	</address>
				</div>
				<div class="col-md-8">
				  <div class="contact-form">
				  	<h2>Contact Us</h2>
					    <form:form action="${contextPath}/contactus" modelAttribute="contact" method="post">
					    	<table>
					    		<tr>
					    			<td><form:label path="username" cssClass="required">USER EMAIL</form:label></td>
					    		</tr>
					    		<tr>
					    			<td><form:input path="username" cssClass="form-control" id="userName" placeholder="User name.."/></td>
					    		</tr>
					    		<tr>
					    			<td><form:label path="from" cssClass="required" id="inputEmail3">FROM</form:label></td>
					    		</tr>
					    		<tr>
					    			<td><form:input path="from" cssClass="form-control" id="from" placeholder="challegnejava@gmail.com" readonly="true" /></td>
					    		</tr>
					    		<tr>
					    			<td><form:label path="to" cssClass="required" id="inputEmail3">TO</form:label></td>
					    		</tr>
					    		<tr>
					    			<td><form:input path="to" cssClass="form-control" id="to" placeholder="challegnejava@gmail.com" readonly="true"/></td>
					    		</tr>
					    		<tr>
					    			<td><form:label path="subject" cssClass="required" id="subject">SUBJECT</form:label></td>
					    		</tr>
					    		<tr>
					    			<td><form:input path="subject" cssClass="form-control" id="subject" placeholder="Subject.." /></td>
					    		</tr>
					    		<tr>
					    			<td><form:label path="message" cssClass="required" id="subject">MESSAGE</form:label></td>
					    		</tr>
					    		<tr>
					    			<td><form:textarea path="message" cssClass="form-control" id="body" placeholder="" /></td>
					    		</tr>
					    		<tr><td></td></tr>
					    		<tr><td><form:button value="submit us">Send</form:button></td></tr>
					    	</table>
					    	<!-- <div>
						    	<span>name</span>
						    	<span><input type="username" class="form-control" id="userName"></span>
						    </div>
						    <div>
						    	<span>e-mail</span>
						    	<span><input type="email" class="form-control" id="inputEmail3"></span>
						    </div>
						    <div>
						    	<span>subject</span>
						    	<span><textarea name="userMsg"> </textarea></span>
						    </div>
						   <div>
						   		<label class="fa-btn btn-1 btn-1e"><input type="submit" value="submit us"></label>
						  </div> -->
					    </form:form>
				    </div>
  			</div>		
  			<div class="clearfix"></div>		
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