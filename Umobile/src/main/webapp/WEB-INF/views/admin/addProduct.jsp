<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <form action="addProduct" method="post" enctype="multipart/form-data">
            
            <!-- 시리얼 넘버 -->
            <div class="form-group">
                <label for="serial">휴대폰 시리얼넘버</label>
                <input type="text" class="form-control" id="serial" name="serial" required>
            </div>
            
            <!-- 용량 -->
            <div class="form-group">
                <label for="giga">휴대폰 용량</label>
                <input type="text" class="form-control" id="giga" name="giga" required>
            </div>

            <!-- 가격 -->
            <div class="form-group">
                <label for="price">휴대폰 가격</label>
                <input type="text" class="form-control" id="price" name="price" required>
            </div>

            <!-- 이름 -->
            <div class="form-group">
                <label for="phone_Name">휴대폰 이름</label>
                <input type="text" class="form-control" id="phone_Name" name="phone_Name" required>
            </div>

            <!-- 사이즈 -->
            <div class="form-group">
                <label for="phone_Size">휴대폰 사이즈</label>
                <input type="text" class="form-control" id="phone_Size" name="phone_Size" required>
            </div>

            <!-- 무게 -->
            <div class="form-group">
                <label for="phone_Weight">휴대폰 무게</label>
                <input type="text" class="form-control" id="phone_Weight" name="phone_Weight" required>
            </div>

            <!-- 카메라 정보 -->
            <div class="form-group">
                <label for="camera">휴대폰 카메라 정보</label>
                <input type="text" class="form-control" id="camera" name="camera" required>
            </div>

            <!-- 배터리 정보 -->
            <div class="form-group">
                <label for="battery">휴대폰 배터리 정보</label>
                <input type="text" class="form-control" id="battery" name="battery" required>
            </div>

            <!-- 메모리 정보 -->
            <div class="form-group">
                <label for="memory">휴대폰 메모리 정보</label>
                <input type="text" class="form-control" id="memory" name="memory" required>
            </div>

            <!-- 상태 -->
            <div class="form-group">
                <label for="status">휴대폰 상태</label>
                <input type="text" class="form-control" id="status" name="status" required>
            </div>

            <!-- 제조사 -->
            <div class="form-group">
                <label for="manufacturer">제조사</label>
                <input type="text" class="form-control" id="manufacturer" name="manufacturer" required>
            </div>

            <!-- 색상 -->
            <div class="form-group">
                <label for="color">색상</label>
                <input type="text" class="form-control" id="color" name="color" required>
            </div>

            <!-- CPU 정보 -->
            <div class="form-group">
                <label for="cpu">CPU 정보</label>
                <input type="text" class="form-control" id="cpu" name="cpu" required>
            </div>

            <!-- 기타 옵션 -->
            <div class="form-group">
                <label for="options">기타 옵션</label>
                <input type="text" class="form-control" id="options" name="options">
            </div>

            <!-- 출시일 -->
            <div class="form-group">
                <label for="release_Date">출시일</label>
                <input type="date" class="form-control" id="release_Date" name="release_Date" required>
            </div>

            <!-- 운영체제 -->
            <div class="form-group">
                <label for="os">운영체제 (OS)</label>
                <input type="text" class="form-control" id="os" name="os" required>
            </div>

            <!-- 썸네일 이미지 -->
            <div class="form-group">
                <label for="thumbnail">상품 썸네일</label>
                <input type="file" class="form-control" id="thumbnail" name="thumbnail" accept="image/*" required>
            </div>

            <!-- 상품 설명 1 -->
            <div class="form-group">
                <label for="description1">상품 설명 1</label>
                <textarea class="form-control" id="description1" name="description1" rows="4" required></textarea>
            </div>

            <!-- 상품 설명 2 -->
            <div class="form-group">
                <label for="description2">상품 설명 2</label>
                <textarea class="form-control" id="description2" name="description2" rows="4"></textarea>
            </div>

            <button type="submit" class="btn btn-primary">상품 등록</button>
        </form>
</body>
</html>