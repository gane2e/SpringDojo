<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customLogin</title>
</head>
<body>
	<h1>customLogin.jsp</h1>
	<h2><c:out value="${error}" /></h2>
	<h2><c:out value="${logout}" /></h2>
	
	<form action="login" method="post">
		<div>
			<input type="text" name="username"/>
		</div>
		<div>
			<input type="password" name="password"/>
		</div>
		
		<!-- 자동 로그인하기 -->
		<div>
			<input type="checkbox" name="remember-me"> Remember me
		</div>
		
		<div>
			<input type="submit" value="로그인" />
		</div>
		
		<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> --%>
	</form>
	
	
</body>
</html>