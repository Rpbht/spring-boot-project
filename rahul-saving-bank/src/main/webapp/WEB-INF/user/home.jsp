<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<%@page import="com.rahul.savingbank.rahulsavingbank.model.Account"%>
<%@page import="com.rahul.savingbank.rahulsavingbank.model.User"%>
<html class="no-js">
<!--<![endif]-->

<head>
<!-- BASICS -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Rahul Saving Bank</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="/home/css/isotope.css"
	media="screen" />
<link rel="stylesheet" href="/home/js/fancybox/jquery.fancybox.css"
	type="text/css" media="screen" />
<link rel="stylesheet" href="/home/css/bootstrap.css">
<link rel="stylesheet" href="/home/css/bootstrap-theme.css">
<link rel="stylesheet" href="/home/css/style.css">
<!-- skin -->
<link rel="stylesheet" href="/home/skin/default.css">
<!-- =======================================================
    Theme Name: Amoeba
    Theme URL: https://bootstrapmade.com/free-one-page-bootstrap-template-amoeba/
    Author: BootstrapMade
    Author URL: https://bootstrapmade.com
  ======================================================= -->
</head>

<body>

	<%
		User user = (User) request.getSession().getAttribute("user");
	%>
	<%
		Account account = (Account) request.getSession().getAttribute("account");
	%>
	<section id="header" class="appear"></section>
	<div class="navbar navbar-fixed-top" role="navigation"
		data-0="line-height:100px; height:100px; background-color:rgba(0,0,0,0.3);"
		data-300="line-height:60px; height:60px; background-color:rgba(0,0,0,1);">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="fa fa-bars color-white"></span>
				</button>
				<h1>
					<a class="navbar-brand" data-0="line-height:90px;"
						data-300="line-height:50px;">Rahul Saving Bank </a>
				</h1>

			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav" data-0="margin-top:20px;"
					data-300="margin-top:5px;">
					<li><a>Your Account No: <%=user.getAccountNumber()%></a></li>
					<li><a href="/user/transaction">Transaction</a></li>
					<li><a href="/user/contact">Contact</a></li>
					<li><a href="/user/logout">Logout</a></li>
				</ul>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</div>

	<section class="featured">
		<div class="container">
			<div class="row mar-bot40">
				<div class="col-md-6 col-md-offset-3">

					<div class="align-center">
						<h2 class="slogan">
							Welcome
							<%=user.getFirstName() + " " + user.getLastName() + "!"%></h2>
						<p>
							Your Current balance is Rs.<%=account.getAmount()%></p>
						<br> <br>
						<h2>
							<a href="/user/printPdf">Print Your Transactions Statment</a>
						</h2>
					</div>
				</div>
			</div>
		</div>
	</section>

	<div class="row align-center copyright">
		<div class="col-sm-12">
			<br> <br> <br>
			<p>Copyright &copy; Rahul Saving Bank</p>
		</div>
	</div>
	</div>

	</section>
	<a href="#header" class="scrollup"><i class="fa fa-chevron-up"></i></a>
	<script src="/home/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
	<script src="/home/js/jquery.js"></script>
	<script src="/home/js/jquery.easing.1.3.js"></script>
	<script src="/home/js/bootstrap.min.js"></script>
	<script src="https://maps.google.com/maps/api/js?sensor=true"></script>
	<script src="/home/js/jquery.isotope.min.js"></script>
	<script src="/home/js/jquery.nicescroll.min.js"></script>
	<script src="/home/js/fancybox/jquery.fancybox.pack.js"></script>
	<script src="/home/js/skrollr.min.js"></script>
	<script src="/home/js/jquery.scrollTo.js"></script>
	<script src="/home/js/jquery.localScroll.js"></script>
	<script src="/home/js/stellar.js"></script>
	<script src="/home/js/jquery.appear.js"></script>
	<script src="/home/js/main.js"></script>
	<script src="/home/contactform/contactform.js"></script>
</body>

</html>