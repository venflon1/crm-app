<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Register</title>
	<script src="https://use.fontawesome.com/3fd4f4126b.js"></script>
	<style type="text/css">
		.title {
			text-align: center;
		}
		
		.register-form-wrap {
			min-height: 550px; 
			display: flex;
			flex-direction: row;
			justify-content: center;
			align-items: center;
		}
		
		.register-form-wrap .register-form {
			min-height: 450px; 
			min-width: 400px;
			display: flex;
			flex-direction: column;
			justify-content: flex-start;
			align-items:  center;
			background: #F9F7F3;
			box-shadow: 5px 5px 15px 15px #CCC;		}
		
		.register-form-wrap .register-form .gouped-input {
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			margin-top: 40px;
		}
		
		.register-form-wrap .register-form .gouped-input .label-input {
			display: flex;
			min-height: 40px;
			flex-direction: row;
			justify-content: center;
			align-items: center;
			margin-top: 10px;
		}
		
		.register-form-wrap .register-form .gouped-input .label-input .label{
		 	width: 100px;
		 	height: 25px;
		 	display: flex;
			flex-direction: row;
			justify-content: flex-start;
		 }
		 
		.register-form-wrap .register-form .gouped-input .label-input .input{
		 	width: 250px;
		 	height: 25px;
		 	display: flex;
			flex-direction: row;
			justify-content: flex-end;
		 }
		 
		 .register-form-wrap .register-form .form-button {
		 	margin-top: 35px;
		 }
		 
		 .register-form-wrap .register-form .form-button input[type="submit"]{
		 	height: 30px;
		 	width: 150px;
		 }
	</style>
</head>
<body>
	<div class="title">
		<h2>User Registration</h2>
	</div>
	<div class="register-form-wrap">
		<form:form class="register-form" action="${pageContext.request.contextPath}/registerUser" method="POST">
			<div class="gouped-input">
				<div class="label-input">
					<div class="label">
						<label>Username</label>
					</div>
					<div class="input">
						<input type="text" name="username" style="width: 250px"/>
					</div>
				</div>
				<div class="label-input">
					<div class="label">
						<label>Email</label>
					</div>
					<div class="input">
						<input type="email" name="email" style="width: 250px"/>
					</div>
				</div>
				<div class="label-input">
					<div class="label">
						<label>Role</label>
					</div>
					<div class="input" >
						<select name="role" style="width: 250px">
							<option value="">--Selected value--</option>
							<option value="EMPLOYEE">Employee</option>
						  	<option value="MANAGER">Manager</option>
						  	<option value="GUEST">Guest</option>
						</select>
					</div>
				</div>
				<div class="label-input" >
					<div class="label">
						<label>Birth Date</label>
					</div>
					<div class="input">
						<input type="Date" name="birthDate" style="width: 250px"/>
					</div>
				</div>
				<div class="label-input">
					<div class="label">
						 <label>Password</label>
					</div>
					<div class="input">
						<input type="password" name="password" style="width: 250px"/>
					</div>
				</div>
				<div class="label-input">
					<div class="label">
						<label>Confirm password</label>
					</div>
					<div class="input">
						<input type="password" name="confirm-password" style="width: 250px"/>
					</div>
				</div>
			</div>
			<div class="form-button">
				<input type="submit" value="Register"/>
			</div>
		</form:form>
	</div>
</body>
</html>