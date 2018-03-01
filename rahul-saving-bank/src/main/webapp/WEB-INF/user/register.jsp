<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="/user/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/user/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/user/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/user/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/user/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/user/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/user/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/user/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="/user/css/util.css">
<link rel="stylesheet" type="text/css" href="/user/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	<form:form modelAttribute="user" action="/user/abc" method="post">
		<div class="container-contact100">
			<div class="wrap-contact100">
				<form class="contact100-form validate-form">
					<span class="contact100-form-title"> Welcome to Rahul Bank!
					</span>
					<div class="wrap-input100 validate-input"
						data-validate="Name is required">
						<span class="label-input100">Your FirstName</span> <input
							class="input100" type="text" name="firstName"
							placeholder="Enter your firstname"> <span
							class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Name is required">
						<span class="label-input100">Your LastName</span> <input
							class="input100" type="text" name="lastName"
							placeholder="Enter your lastname"> <span
							class="focus-input100"></span>
					</div>

					<div class="wrap-input100 input100-select">
						<span class="label-input100">Gender</span>
						<div>
							<select class="selection-2" name="gender">
								<option>Male</option>
								<option>Female</option>
							</select>
						</div>
						<span class="focus-input100"></span>
					</div>


					<div class="wrap-input100 validate-input"
						data-validate="Valid email is required: ex@abc.xyz">
						<span class="label-input100">Email</span> <input class="input100"
							type="text" name="email" placeholder="Enter your email addess">
						<span class="focus-input100"></span>
					</div>


					<div class="wrap-input100 validate-input"
						data-validate="Name is required">
						<span class="label-input100">Your password</span> <input
							class="input100" type="password" name="password"
							placeholder="Enter your password"> <span
							class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Name is required">
						<span class="label-input100">Your City</span> <input
							class="input100" type="text" name="city"
							placeholder="Enter your city"> <span
							class="focus-input100"></span>
					</div>



					<div class="wrap-input100 validate-input"
						data-validate="Name is required">
						<span class="label-input100">Your Number</span> <input
							class="input100" type="number" name="mobileNumber"
							placeholder="Enter your number"> <span
							class="focus-input100"></span>
					</div>

					<div class="container-contact100-form-btn">
						<div class="wrap-contact100-form-btn">
							<div class="contact100-form-bgbtn"></div>
							<button class="contact100-form-btn" type="submit"
								style="color: white" value="Submit"></button>
						</div>
					</div>
				</form>
			</div>
		</div>



	<div id="dropDownSelect1"></div>

	<!--===============================================================================================-->
	<script src="/user/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="/user/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="/user/vendor/bootstrap/js/popper.js"></script>
	<script src="/user/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="/user/vendor/select2/select2.min.js"></script>
	<script>
		$(".selection-2").select2({
			minimumResultsForSearch : 20,
			dropdownParent : $('#dropDownSelect1')
		});
	</script>
	<!--===============================================================================================-->
	<script src="/user/vendor/daterangepicker/moment.min.js"></script>
	<script src="/user/vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="/user/vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>

	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async
		src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag() {
			dataLayer.push(arguments);
		}
		gtag('js', new Date());

		gtag('config', 'UA-23581568-13');
	</script>

	</form:form>



</body>

</html>