<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="includes/header.jsp" %>
	
	<div class="col-md-4 col-md-offset-4">
		<div class="login-panel panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Logout Page</h3>
			</div>
			<div class="panel-body">
				<form role="form" action="/customLogouts" method="post">
					<fieldset>
						<a href="/customLogin" class="btn btn-lg btn-success btn-block">Logout</a>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	
	<script>
		$(".btn-success").on("click", function(e){
			e.preventDefault();
			$("form").submit();
		});
	</script>
	
</body>
</html>