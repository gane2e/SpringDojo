<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/resources/csss/joindo.css" rel="stylesheet"/> 
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<form action="doJoin" method="post" class="joinForm" onsubmit="DoJoinForm__submit(this); return false;">
                                                                                               
      <h2>회원가입</h2>
      <div class="textForm">
        <input name="username" type="email" class="id" placeholder="아이디">
        <button type="button" onclick="checkEmailDuplication()">아이디 중복 체크</button> <!-- 중복 체크 버튼 -->
      </div>
      <div class="textForm">
        <input name="password" type="password" class="pw" placeholder="비밀번호">
      </div>
       <div class="textForm">
        <input name="passwordConfirm" type="password" class="pw" placeholder="비밀번호 확인">
      </div>
      <div class="textForm">
        <input name="name" type="text" class="name" placeholder="이름">
      </div>
      <div class="textForm">
        <input name="phone" type="number" class="cellphoneNo" placeholder="전화번호">
      </div>
      <div class="textForm">
        <input name="addr" type="text" class="addr" placeholder="주소">
      </div>
      <input type="submit" class="btn" value="J O I N"/>
    </form>
    
    <script type="text/javascript">
    // 아이디 중복 체크 함수
    function checkEmailDuplication() {
        var username = $("input[name='username']").val();
        if (username) {
            $.ajax({
                url: "/user/checkEmail",  // 이메일 중복 체크를 위한 URL
                type: "POST",
                data: { username: username },
                success: function(response) {
                    if (response === "exists") {
                        alert("이미 존재하는 아이디입니다.");
                    } else {
                        alert("사용 가능한 아이디입니다.");
                    }
                },
                error: function() {
                    alert("아이디 중복 체크 실패");
                }
            });
        } else {
            alert("아이디를 입력해주세요.");
        }
    }
    </script>
</body>
</html>