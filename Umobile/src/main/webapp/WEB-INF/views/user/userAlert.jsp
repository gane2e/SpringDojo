<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 필요</title>
    <script type="text/javascript">
        function showAlert() {
            alert("로그인 후 이용해주세요.");
        }
    </script>
</head>
<body>
    <c:choose>
        <c:when test="${empty sessionScope.user}">
            <script type="text/javascript">
                window.onload = function() {
                    showAlert();
                    // 로그인 페이지로 리다이렉트
                   window.location.href = '/user/login';  // 로그인 페이지 URL을 맞게 변경하세요.
                }
            </script>
        </c:when>
    </c:choose>
</body>
</html>
