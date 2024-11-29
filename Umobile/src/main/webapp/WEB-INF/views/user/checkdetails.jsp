<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/resources/csss/subindex.css" rel="stylesheet" />
<link href="${path}/resources/csss/checkdeails.css" rel="stylesheet" />
</head>
<body>
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
															<th scope="col" class="th-title">휴대폰 명</th>
															<th scope="col" class="th-date">용량</th>
															<th scope="col" class="th-date">색상</th>
															<th scope="col" class="th-date">할부 개월</th>
															<th scope="col" class="th-date">결제금액</th>
															<th scope="col" class="th-date">신청일자</th>
															<th scope="col" class="th-date">후기</th>
														</tr>
													</thead>
													<tbody>
													<c:forEach items="${orderList}" var="orderList">
														<tr>
																<td>3</td>
																<th>${orderList.phone_Name}</th>
																<td>${orderList.giga}</td>
																<td>${orderList.color}</td>
																<td>${orderList.installment}</td>
																<td>${orderList.vatPrice}</td>
																<td>${orderList.regDate}</td>
																<td><button type="button"
																		class="btn-t btn-outline-secondary"
																		onclick="window.location.href='/user/review';">
																		후기 입력하기</button></td>
														</tr>
														</c:forEach>
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
	<%@ include file="../includes/subfooter.jsp"%>
</body>
</html>