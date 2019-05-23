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
<script type="text/javascript">
$(function(){
    $('.reply-comment').on('click', function(e){
        e.preventDefault();
        $(this).next('.reply-comment-form').show();
    });
});
</script>
<style type="text/css">
	.reply-comment-form{ display:none; }
</style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="header_bg1">
<div class="container">
	<div class="row header">
		<div class="logo navbar-left">
			<h1><a href="index.html">Learner </a></h1>
		</div>
		<c:if test="${(not empty user) && (user != 'anonymousUser')}">
			<div class="h_search navbar-right">
				<form>
					<!-- <input type="text" class="text" value="Enter text here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter text here';}">
					<input type="submit" value="search"> -->
					  Dear <strong>${user}</strong>, Welcome to Admin Page.
	    				<a href="<c:url value="/logout" />">Logout</a>
				</form>
			</div>
		</c:if>
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
	<div class="main_question">
		<div class="container">
			<div class="col_md_7 navbar-left">
				<c:if test="${not empty user_question}">
					<c:if test="${not empty USER_COMMENT_NOT_LOGIN}">
									<a href="<c:url value='/' />">Sign Up!</a> Or 
							<a href="<c:url value='/user/login/question' />">Login</a>
									<div class="alert alert-danger">
										<p>${USER_COMMENT_NOT_LOGIN}</p>
									</div>
								</c:if>
								<c:if test="${not empty USER_NOT_LOGIN}">
									<a href="<c:url value='/' />">Sign Up!</a> Or 
							<a href="<c:url value='/user/login/question' />">Login</a>
									<div class="alert alert-danger">
											<p>${USER_NOT_LOGIN}</p>
									</div>
								</c:if> 
					<div style="height: 10em; width: 70em;">
						<h2>${user_question.question_title}</h2>
					</div>
					<hr>
					<div style="margin-top: 2em; height: 10em; width: 70em;"><h4>${user_question.question_desc}</h4></div>
					<div>
					<hr>
					
						<b> <c:forEach var="obj"
								items="${user_question.userQuestionTags}">
       										 &nbsp;&nbsp;<span style="background-color: #baf4eb">&nbsp;${obj}&nbsp;</span>
							</c:forEach>
						</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span style="float: right;">${user_question.askedAgo}&nbsp;<a href="">${user_question.askedBy}</a></span>
					</div>
					<hr>
				</c:if>
			</div>
			<div class="col_md_5 navbar-right"></div>
			
		</div>
	</div>
	<div class="main_question_comment">
		<div class="container">
			<div style="width: 70em;">
						<c:forEach var="questionComment"
								items="${user_question.questionComments}">
										<div >
											<h6>${questionComment.questionComment}</h6>
											<span style="float: right;">${questionComment.created_Date}&nbsp;<a href="">${questionComment.givenBy}</a></span>
										</div>
										<hr>
							</c:forEach>
						<a style="margin-top: 2em;" href="" class="reply-comment"> Add a comment </a>
						<div class="reply-comment-form well">
						     <form:form action="${contextPath}/user/question/comment" method="post" modelAttribute="questionComment" class="form-horizontal" name="reply-form">
								<div class="form-group required">		
									<form:label path="questionComment" class="control-label col-sm-2"></form:label>
									<div class="col-sm-12">
										 <form:textarea path="questionComment"  class="form-control input-lg"  name="comment" placeholder="Use comments to ask for more information or suggest improvements. Avoid answering questions in comments." required="required" cssStyle=" height: 5em;"/>
									</div>
								</div>	
								<input id="questionId" name="questionId" type="hidden" value="${user_question.userQuestionId}"/>
								<form:button class="btn btn-success" value="Post Your comment">Comment</form:button>			
							</form:form>
						</div> 
							
					</div>
		</div>
	</div>
	<div class="main_answer">
		<div class="container">
			<div class="col_md_7 navbar-left" style="width: 70em;">
				<c:if test="${not empty user_question.userAnswerGiven}">
				<h2>Answers</h2>
					<div>
						<b> <c:forEach var="userAnswer"
								items="${user_question.userAnswerGiven}">
										<div>
											
											<h4>${userAnswer.givenAnswer}</h4>
											<span style="float: right;">${userAnswer.answeredAgo}&nbsp;<a href="">${userAnswer.givenBy}</a></span>
										</div>
										
										<hr>
										<c:if test="${not empty userAnswer.answerComments}">
												<c:forEach var="answerComment"
												items="${userAnswer.answerComments}">
												<div >
													<h6>${answerComment.answerComment}</h6>
													<span style="float: right;">${answerComment.created_Date}&nbsp;<a href="">${answerComment.givenBy}</a></span>
												</div>
												<hr>
										</c:forEach>
									</c:if>


								<a style="margin-top: 2em;" href="" class="reply-comment">
									Add a comment </a>
								<div class="reply-comment-form well">
									<form:form action="${contextPath}/user/answer/comment"
										method="post" modelAttribute="answerComment"
										class="form-horizontal" name="reply-form">
										<div class="form-group required">
											<form:label path="answerComment"
												class="control-label col-sm-2"></form:label>
											<div class="col-sm-12">
												<form:textarea path="answerComment"
													class="form-control input-lg" name="comment"
													placeholder="Use comments to ask for more information or suggest improvements. Avoid answering questions in comments."
													required="required" cssStyle=" height: 5em;" />
											</div>
										</div>
										<input id="answerId" name="answerId" type="hidden"
											value="${userAnswer.userAnswerId}" />
										<input id="questionId" name="questionId" type="hidden" value="${user_question.userQuestionId}"/>	
										<form:button class="btn btn-success" value="Post Your comment">Comment</form:button>
									</form:form>
								</div>
								<hr>
							</c:forEach>
						</b>
					</div>
					
				</c:if>
			</div>
			<div class="col_md_5 navbar-right"></div>
		</div>
	</div>
	<div class="main_answer">
	<div class="container">
		<div class="col_md_8 navbar-left">
			
			<h2>Your Answer</h2><c:if test="${(empty user) || (user == 'anonymousUser')}">
					<a href="<c:url value='/' />">Sign Up!</a> Or 
					<a href="<c:url value='/user/login/question' />">Login</a>
				</c:if>
			<form:form action="${contextPath}/user/answer" method="post" modelAttribute="userAnswer" class="form-horizontal">
				<div class="form-group required">		
					<form:label path="givenAnswer" class="control-label col-sm-2" for="inputlg"></form:label>
					<div class="col-sm-12">
						 <form:textarea path="givenAnswer"  class="form-control input-lg" id="givenAnswer" name="givenAnswer" placeholder="" required="required" cssStyle=" height: 15em;"/>
					</div>
				</div>	
						<input id="userQuestionId" name="userQuestionId" type="hidden" value="${user_question.userQuestionId}"/>
						<form:button class="btn btn-success" value="Post Your Answer">Post Your Answer</form:button>			
			</form:form>
			</div>
			<div class="col_md_4 navbar-right"></div>
	</div>
</div>

<div class="footer_bg"><!-- start footer -->
	<div class="container">
		<div class="row  footer">
			<div class="copy text-center">
				<p class="link"><span>&#169; All rights reserved | Design by&nbsp;<a href=""> Neeraj gahlawat</a></span></p>
			</div>
		</div>
	</div>
</div>
</body>
</html>