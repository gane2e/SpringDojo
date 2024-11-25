<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
    </style>
</head>
<body>
	<h2>회원정보 수정 페이지</h2>
	<!-- 회원정보 수정 폼 -->
	<form action="<c:url value='/user/update' />" method="POST">
		<div>
			<label for="email">이메일 (변경 불가):</label> <input type="text" id="email"
				name="email" value="${user.email}" readonly class="readonly" />
		</div>

		<div>
			<label for="name">이름:</label> <input type="text" id="name"
				name="name" value="${user.name}" />
		</div>

		<div>
			<label for="password">비밀번호:</label> <input type="password"
				id="password" name="password"/>
		</div>

		<div>
			<label for="phone">전화번호 (변경 불가):</label> <input type="text"
				id="phone" name="phone" value="${user.phone}" readonly
				class="readonly" />
		</div>

		<div>
			<label for="addr">주소:</label> <input type="text" id="addr"
				name="addr" value="${user.addr}" />
		</div>

		<!-- 수정 버튼 -->
		<button type="submit">정보 수정</button>
	</form>
</body>
</html>