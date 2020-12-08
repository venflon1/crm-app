<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<script src="https://use.fontawesome.com/3fd4f4126b.js"></script>
	<style type="text/css">
		.logo-wrap {
			display: flex;
			justify-content: center;
			align-items: center;
		}
	
		.logo {
			text-align: center;
			background-repeat: no-repeat;
			background-position: center;
			display: block;
			max-width:230px;
			max-height:105px;
			width: auto;
			height: auto;
		}
		
		.form-wrap {
			height: 380px;
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
		}
		.login-form {
			min-height: 280px;
			min-width: 400px;
			display: flex;
			justify-content: center;
			align-items: center;
			background: #F9F7F3;
			box-shadow: 5px 5px 15px 15px #CCC;
		}
	
		.login-form .form-grouped {
			min-height: 150px;
			display: flex;
			flex-direction: column;
		}
		
		.login-form .form-grouped .input-wrap {
			display: flex;
			flex-direction: row;
			justify-content: center;
			align-items: center;
		}
		
		.login-form .form-grouped .input-wrap .icon {
			height: 28px;	
			width: 28px;	
			display: flex;
			flex-direction: row;
			justify-content: center;
			align-items: center;
		}
		
		.login-form .form-grouped .input-wrap input {
			margin: 5px;
			height: 28px;	
			width:  260px;
		}
		
		.login-form .form-grouped .form-buttons {
			display: flex;
			flex-direction: row;
			justify-content: center;
			margin-top: 10px;
		}
		
		.form-wrap .login-error {
			border: 1px solid black;
			border-radius: 5px;
			background: #FA4E4E;
			margin-bottom: 10px;
			text-align: center;
			font-weight: bold;
		}
		
		.form-wrap .logout-messge {
			border: 1px solid black;
			border-radius: 5px;
			background: #45E67B;
			margin-bottom: 10px;
			text-align: center;
			font-weight: bold;
		}
		
		.form-wrap .form-grouped .login-error i
		.form-wrap .form-grouped .logout-messge i{
			padding: 2px;
		}
		
		.login-form .form-buttons button {
			width:  22px;
			width: 90px;
		}
		
		.login-form .form-buttons #submit-loginForm {
			background: #4B82F0;
		}
		
		.login-form .form-buttons #reset-button{
			background: #F09308;
		}
		
		.login-form .form-grouped .form-links {
			margin-top: 5px;
			display: flex;
			flex-direction: row;
			justify-content: center;
			align-items: center;
			color: black;
			text-decoration: none;
		}
		
		.login-form .form-grouped .links-form-links:hover {
			text-decoration: underline;
			color: #4B82F0;
		}
		
		.footer {
			text-align: center;		
/* 			background: #F9F7F3; */
/* 			position: absolute; */
/* 		    top: 499px; */
/* 		    bottom: 0; */
/* 		    width: 100%; */
		}
		
	</style>
</head>
<body>
	<div class="logo-wrap">
		<div class="logo">
			<img width="140" height="90" src=https://tse2.mm.bing.net/th?id=OIP.oxIjiBJzXOIAlUJ6EKRpNgHaJ4&pid=Api&P=0&w=300&h=300">
		</div>
	</div>
	<div class="form-wrap">
		<form:form action="${pageContext.request.contextPath}/authUser" method="POST">
		   <c:if test="${param.error != null}">
				<div class="login-error">
					<i>Sorry! You entered invalid username/pasword</i>
				</div>
			</c:if>
			
			<c:if test="${param.logout != null}">
				<div class="logout-messge">
					<i>Logged out succesfull</i>
				</div>		
			</c:if>
			
			<div class="login-form">
				<div class="form-grouped">
					<div class="input-wrap">
						<span class="icon"> <i class="fa fa-user fa-lg" aria-hidden="true"></i> </span> 
						<input type="text" name="username" placeholder="username" />
					</div>

					<div class="input-wrap">
						<span class="icon"> <i class="fa fa-lock fa-lg"></i> </span> 
						<input type="password" name="password" placeholder="password" />
					</div>					
					
					<div class="form-buttons">		
						<button id="submit-loginForm">Login</button>
						<button id="reset-button">Reset</button>
					</div>
					
					<div class="form-links">
						<a href="${pageContext.request.contextPath}/register">You are not register? Do it now</a>
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<hr style="box-shadow: 2px 2px 6px 6px #DDD;">
	<div class="footer">
		all rights needed
	</div>
</body>
</html>