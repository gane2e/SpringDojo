<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 필요</title>
    <script type="text/javascript">
        // 페이지가 로드된 후 실행되는 함수
        window.onload = function() {
            // 비밀번호 확인용 메시지 표시
            showAlert();
            // 로그인 페이지로 리다이렉트
            window.location.href = '/admin/adminloginJoin';  
        }

        // 경고창을 띄우는 함수
        function showAlert() {
            alert("관리자 로그인 후 이용 가능한 서비스입니다.");
        }
    </script>
</head>
<body style="visibility: hidden;">  <!-- 페이지 내용이 보이기 전에 숨김 -->
    <c:choose>
        <c:when test="${empty sessionScope.admin}">
            <!-- 로그인 정보가 없으면 이 블록의 스크립트가 실행 -->
            <script type="text/javascript">
                // 위에서 작성한 window.onload를 통해 바로 리다이렉트 진행
            </script>
        </c:when>
    </c:choose>
</body>
</html>
