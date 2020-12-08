<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home</title>
	<script src="https://use.fontawesome.com/3fd4f4126b.js"></script>
	<style type="text/css">
		.logo {
		
		}
		
		.home-topBar {
			display: flex;
			flex-direction: row;
			justify-content: space-between;
			align-items: center;
		}
		
		.home-topBar .logout {
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
		}
		
		.home-topBar .logout icon{
			height: 28px;	
			width: 28px;	
			display: flex;
			flex-direction: row;
			justify-content: center;
			align-items: center;
		}
		
		.home-topBar .logout button{
			heigth:  22px;
			width: 90px;
			background: #4B82F0;
		}
		
		.page-links {
			display: flex;
			flex-direction: row;
		}
		
		.page-links .manager-link {
			height: 20px;
			color: green;
			border: 1px solid black;
			margin-right: 10px;
		}
		
		.page-links .system-link {
			height: 20px;
			color: red;
			border: 1px solid black;
			margin-right: 10px;
		}
	</style>
</head>
<body>
	<div class="home-topBar">
		<div class="logo">
			<h1>Welcome to home</h1>
		</div>
		
		<div class="logout">
			<div class="user-role">
				<label>User: <security:authentication property="principal.username"/></label> 
				<label><security:authentication property="principal.authorities"/></label> 
			</div>
			<form:form action="${pageContext.request.contextPath}/logout" method="POST">
				<span class="icon"> <i class="fa fa-sign-out fa-lg" aria-hidden="true"></i> </span> 
				<input type="submit" value="Logout" />
			</form:form>
		</div>
	</div>
	<hr>
	<h2>My company s.r.l Home Page</h2>
	<div class="page-links">
		<security:authorize access="hasRole('MANAGER')">
				<div class="manager-link">
					<a href="${pageContext.request.contextPath}/leaders">Leadehsip Meeting</a>
					(Only for Manager)
				</div>
		</security:authorize>
		
		<security:authorize access="hasRole('ADMIN')">
			<div class="system-link">
				<a href="${pageContext.request.contextPath}/systems">System admin</a>
				(Only for Administator)
			</div>
		</security:authorize>
	</div>
</body>
</html>