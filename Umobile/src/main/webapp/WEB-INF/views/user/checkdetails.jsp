<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/resources/csss/index.css" rel="stylesheet"/>
<link href="${path}/resources/csss/checkdeails.css" rel="stylesheet"/>
</head>
<body>
<!-- 로그인이 필요한 페이지에 임포트해주세요. -->
<%@ include file="userAlert.jsp" %>
 <%@ include file="../includes/header.jsp"%>
<div class="pt_cart">
   <div class="contents">
      <div class="cart-wrap">
        <div class="cart-top">
             <div class="row flex-no-gutters">
                 <div class="cart-group-list col-12">
                    <div class="cart-top-title">
                       <div class="flex flex-align-center display-show-pc">
                         <p class="title display-small-none">핸드폰 신청내역</p>
                       </div>
                        <div class="cart-list checkout-list">
									<section class="notice">

										<!-- board list area -->
										<div id="board-list">
											<div class="container">
												<table class="board-table">
													<thead>
														<tr>
															<th scope="col" class="th-num">번호</th>
															<th scope="col" class="th-title">핸드폰 명</th>
															<th scope="col" class="th-date">수량</th>
															<th scope="col" class="th-date">신청일자</th>
															<th scope="col" class="th-date">후기</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td>3</td>
															<th><a href="#!">[공지사항] 개인정보 처리방침 변경안내처리방침</a></th>
															<td>테스트</td>
															<td>테스트</td>
															<td><button type="button" class="btn btn-outline-secondary" onclick="window.location.href='/user/review';" > 후기 입력하기</button></td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>

									</section>

								</div>
                    </div>
                 </div>                  
             </div>
        </div>
      </div> 
   </div>
</div>
  <%@ include file="../includes/mainfooter.jsp"%>
</body>
</html>