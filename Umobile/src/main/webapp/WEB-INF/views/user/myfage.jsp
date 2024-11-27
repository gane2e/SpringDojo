<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }
    .container {
        max-width: 500px;
        margin: 0 auto;
    }
    label {
        font-weight: bold;
        display: block;
        margin-top: 10px;
    }
    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
        margin-bottom: 10px;
        font-size: 14px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    .readonly {
        background-color: #f5f5f5;
    }
    button {
        padding: 10px 20px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    button:hover {
        background-color: #45a049;
    }
    .delete-button {
        background-color: #f44336; /* Red color for delete button */
        margin-top: 10px;
    }
    .delete-button:hover {
        background-color: #e53935; /* Darker red on hover */
    }
</style>
</head>
<body>
	<!-- 로그인이 필요한 페이지에 임포트해주세요. -->
	<%@ include file="userAlert.jsp" %>
    <h2>회원정보 수정 페이지</h2>
    <!-- 회원정보 수정 폼 -->
    <form action="/user/update" method="POST" onsubmit="return checkPassword()">
        <div>
            <label for="email">이메일 (변경 불가):</label> 
            <input type="text" id="email" name="email" value="${user.email}" readonly class="readonly" />
        </div>

        <div>
            <label for="name">이름:</label> 
            <input type="text" id="name" name="name" value="${user.name}" />
        </div>

        <div>
            <label for="password">비밀번호:</label> 
            <input type="password" id="password" name="password" placeholder="변경 비밀번호 입력"/>
            <input name="passwordConfirm" type="password" placeholder="비밀번호 확인">
        </div>

        <div>
            <label for="phone">전화번호 (변경 불가):</label> 
            <input type="text" id="phone" name="phone" value="${user.phone}" readonly class="readonly" />
        </div>

        <div>
            <label for="addr">주소:</label> 
            <input type="text" id="addr" name="addr" value="${user.addr}" />
        </div>
        
        <!-- 회원정보 수정 버튼 -->
        <div>
            <button type="submit">회원정보 수정</button>
        </div>

    </form>

    <!-- 회원탈퇴 버튼 -->
    <form action="/user/delete" method="POST" onsubmit="return confirm('정말로 탈퇴하시겠습니까?');">
        <button type="submit" class="delete-button">회원 탈퇴</button>
    </form>
    
    
    <script type="text/javascript">
    
    // 비밀번호 확인 함수
    function checkPassword() {
        var password = document.getElementById('password').value;
        var passwordConfirm = document.getElementsByName('passwordConfirm')[0].value;
        
        // 비밀번호와 비밀번호 확인 값이 일치하지 않으면 알림창을 띄움
        if (password !== passwordConfirm) {
            alert("비밀번호가 일치하지 않습니다.");
            document.getElementById('password').value = '';  // 비밀번호 입력란 값 비우기
            document.getElementsByName('passwordConfirm')[0].value = '';  // 비밀번호 확인란 값 비우기
            return false;  // 폼 제출X
      
    	}
        if(password == passwordConfirm){
        	let confirmUpdate = confirm("회원정보를 수정하시겠습니까?")
        	if(confirmUpdate){
        		 alert("수정이 완료되었습니다.");
        	}
        	return true;  // 폼 제출O
        	}
        }
    
    
    </script>
    
    

</body>
</html>
