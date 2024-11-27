<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>
   <div id="header">   
          <div class="logbox">
           <a href="/">
              <img class="logimg" src="${pageContext.request.contextPath}/resources/img/headerlogo.png">
              </a>
          </div>
         <div class="col-md-10">
			<ul class="lower-navbar">
				<li><a href="">유심/eSIM</a></li>
			    <li><a href="#" id="toggleLink">휴대폰</a></li>
			    <li><a href="">상품</a></li>
				<li><a href="#">이벤트/혜택</a></li>
				<li><a href="/user/notice">공지사항</a></li>
				<li><a href="/user/Edit">내 정보</a></li>
				<li><a href="#">유모바일</a></li>			
			</ul>
			<div class="submenu">
			  <div class="submenus">
			      <div class="submenuimg">
			         <a href="#"><img src="${pageContext.request.contextPath}/resources/img/img-gnb-lo.png"></a>
			      </div>
			      <ul class="submeul">
			        <li class="submeli"><a href="/phone/phoneproduct">가입신청</a></li>
			        <li class="submeli"><a href="#">모델별 지원금</a></li>
			      </ul>
			  </div>
			  <div class="submenus">
			      <div class="submenuimg">
			         <a href="#"><img src="${pageContext.request.contextPath}/resources/img/img-gnb-lo1.png"></a>
			      </div>
			      <ul class="submeul">
			        <li class="submeli"><a href="#">가입신청</a></li>
			     
			      </ul>
			  </div>
			</div>
		</div>
		
		<div class="top-util">
		    <div class="navlog">
		    <a href="#">
		     <img class="navimg" src="${pageContext.request.contextPath}/resources/img/navlog1.png">
		     </a>
		    </div>
		      <div class="navlog">
		       <a href="#">
		       <img class="navimg" src="${pageContext.request.contextPath}/resources/img/navlog2.png" id="togoll">
		      <b class="state"  style="display: none;">ON</b>
		       </a>
		       
		       <!--  로그인 전에만 보이는 부분 -->
		           <div class="navsub" >
		               <div class="info-basic">
              		<button type="button" id="btns" class="top-login" onclick="window.location.href = '/user/login';">
              		로그인
              		</button>
		                <ul class="find-join">
		                  <li><a href="#">ID/비밀번호찾기</a></li>
		                  <li><a href="user/join">회원가입</a></li>
		                </ul>
		               </div>
		              <div class="info-func">
		                <div class="func-btn">
		                 <ul>
		                 <img src="${pageContext.request.contextPath}/resources/img/log-doc.svg">
		                   <li><a href="#">신청내역조회</a></li>
		                 </ul>
		                 </div>
		              </div>
	               </div>
	               
	               
	               <!-- 로그인 후에만 보이는 부분  -->
	               <div class="loginboxs"style="display: none;">
	                   <strong class="info-user">
	                       <name id="gnbMmbrNm">이동희</name>
	                       님
	                       <a href="#" class="member-modify">회원정보수정</a>
	                   </strong>
	                   <div class="info-func">
	                       <ul class="func-btn">
	                          <li>
	                            <a href="#" class="member-modify2">신청내역 조회</a>
	                          </li>
	                          <li class="btnSBMB">
	                            <a href="#" class="btn-num-auth">유모바일 번호 인증</a>
	                          </li>
	                       </ul>
	                       
	                       <div class="guide-box pint-bx">
	                           <a href="#">
	                            <p>
	                              <strong>포인트</strong>
	                              <span id="gnbPoint">0P</span>
	                            </p>
	                           </a>
	                           <a href="#">
	                              <p id="ucashArea2">
	                                <strong>U폰 캐시</strong>
	                                <span id="gnbUcash">0C</span>
	                              </p>
	                           </a>
	                           <p class="fir" > 친구추천하고 특별한 혜택을 받으세요</p>
	                       </div>
	                       <p class="devcechg-txt">기기변경 상담 1661-0556 (유료)</p>
	                   </div>
	                   <div class="logbox-btm">
	                   <button onclick="" class="btn-text-right-s btn-logout" type="button">로그아웃</button>
	                   </div>
	               </div>
	               
	               
		    </div>
		      <div class="navlog">
		       <a href="#">
		       <img class="navimg" src="${pageContext.request.contextPath}/resources/img/navlog3.png">
		      </a>
		    </div>
		    
		    
		</div>
    </div>
    
    <!-- 헤더 끝 -->
</body>
</html>
<script>
<!--메뉴 펼침 -->

$(document).ready(function() {
    let isSubmenuVisible = false; // .submenu 표시 상태 변수

    $('#toggleLink').click(function() {
        isSubmenuVisible = !isSubmenuVisible; // 상태 토글
        if (isSubmenuVisible) {
            $('.submenu').show(); // 표시
        } else {
            $('.submenu').hide(); // 숨김
        }
    });
});


<!--메뉴 펼침 -->

<!-- 로그인 모달 -->
$(document).ready(function() {
	    $('#togoll').click(function() {
	        $('.navsub').toggle();  // .navsub의 표시/숨김을 토글
	    });
	});

<!-- 로그인 모달 -->


/* 로그인 전, 후 보여주는 */

function checkLoginStatus() {

    return false;
}


document.addEventListener("DOMContentLoaded", function () {
  const navSub = document.querySelector(".navsub");
  const loginBox = document.querySelector(".loginboxs");
  const navImg = document.querySelector(".navlog > a");

  if (checkLoginStatus()) {
    // 로그인 상태일 경우
    navSub.style.display = "none";
    loginBox.style.display = "block";
    navImg.style.display = "block";
  } else {
    // 비로그인 상태일 경우
    navSub.style.display = "block";
    loginBox.style.display = "none";
    navImg.style.display = "none";
  }
});

/* 로그인 전, 후 보여주는   */

/* 로그인 전, 후 보여주는   */

</script>