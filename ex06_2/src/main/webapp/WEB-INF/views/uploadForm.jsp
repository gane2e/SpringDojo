<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<form action="uploadFormAcrion" method="post" enctype="multipart/form-data">
	
		<input type="file" name="uploadFile" multiple="multiple" />
		<button type="submit">Submit</button>
	
	</form>
</body>
</html>
