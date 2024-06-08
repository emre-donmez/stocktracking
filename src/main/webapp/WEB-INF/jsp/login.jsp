<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="tr">

<head>
	<title>Emrecan Dönmez</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="css/font.css" >
	<link rel="stylesheet" href="css/login.css">
    <link rel="shortcut icon" href="img/favicon.png">
  	<link rel="stylesheet" href="css/all.min.css">
    
</head>

<body>
	<section class="ftco-section">
		<div class="container">

			<div class="row justify-content-center">
				<div class="col-md-7 col-lg-5">
					<div class="login-wrap p-4 p-md-4">
						<div class="icon d-flex align-items-center justify-content-center">
							<span class="fa-solid fa-user-large">
						</div>
						<h3 class="text-center mb-4">Admin Login</h3>

						<form action="login" class="login-form" method="post">
							<div class="form-group">
								<input name="username" type="text" class="form-control rounded-left" placeholder="Username" required>
							</div>
							<div class="form-group d-flex">
								<input name="password" type="password" class="form-control rounded-left" placeholder="Password"
									required>
							</div>
							<input type="hidden"
								name="${_csrf.parameterName}" value="${_csrf.token}"/>
							
							<div class="form-group">
								<input type="submit" class="form-control btn btn-primary rounded submit px-3" value="Login" >
							</div>
								
							
							<c:if test="${not empty param.loginFailed}">
								<div class="alert alert-warning" style="margin-bottom: -10px">
									Login failed, check your information.
								</div>
							</c:if>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>

</html>