<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<%@page import="com.rahul.savingbank.rahulsavingbank.model.Account"%>
<%@page import="com.rahul.savingbank.rahulsavingbank.model.User"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html class="no-js">
<!--<![endif]-->

<head>
  <!-- BASICS -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Rahul Saving Bank</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="/home/css/isotope.css" media="screen" />
  <link rel="stylesheet" href="/home/js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
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
 <!-- contact -->
  <section id="section-contact" class="section appear clearfix">
    <div class="container">

      <div class="row mar-bot40">
        <div class="col-md-offset-3 col-md-6">
          <div class="section-header">
            <h2 class="section-heading animated" data-animation="bounceInUp">Contact us</h2>
            <p>Let us know what issues you're facing, we would take a look at your issue :)</p>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-8 col-md-offset-2">
          <div class="cform" id="contact-form">
            <div id="sendmessage">
              Your message has been sent. Thank you!
            </div>
            <div id="errormessage"></div>
            <form:form modelAttribute="inquiry" action="/user/inquired" method="post" cssClass="contactForm">
              <div class="form-group">
                <label for="email">Your Email</label>
                <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" data-rule="email" data-msg="Please enter a valid email" />
                <div class="validation"></div>
              </div>
              <div class="form-group">
                <label for="message">Message</label>
                <textarea class="form-control" name="issue" id="issue" rows="5" data-rule="required" data-msg="Please write something for us"></textarea>
                <div class="validation"></div>
              </div>

              <button type="submit" class="btn btn-theme pull-left">SEND MESSAGE</button>
            </form:form>

          </div>
        </div>
        <!-- ./span12 -->
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