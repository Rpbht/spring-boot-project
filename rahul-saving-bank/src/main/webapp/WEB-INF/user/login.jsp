
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/webhome/css/bootstrap.css" type="text/css" rel="stylesheet"
	media="all">
<link href="/webhome/css/style.css" type="text/css" rel="stylesheet"
	media="all">
<link href="/webhome/css/font-awesome.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container" align="center" style="margin-top: 5%;">
		<h4 style="color: navy; margin-bottom: 2%" align="center">Welcome
			to Rahul Bank!</h4>
	</div>
	<div style="width: 100%">
		<div class="col-sm-4"></div>


	<%if(request.getSession().getAttribute("msg") != null){%>
	<%=request.getSession().getAttribute("msg")%>
	<%} %>
		<div class="col-sm-4">

			<form:form modelAttribute="user" action="/user/logged" method="post">

				<form:input path="email" cssClass="form-control" required="required"
					placeholder="Email" type="email" />
				<br>

				<form:input path="password" cssClass="form-control"
					required="required" placeholder="Password" type="password" />
				<br>

				<div align="center">
					<input type="submit" class="btn-success" value="Login">
				</div>
			</form:form>

		</div>
		<div class="col-sm-4"></div>
	</div>

</body>
</html>