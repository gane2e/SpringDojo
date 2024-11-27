<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/resources/csss/index.css" rel="stylesheet"/> 
<link href="${path}/resources/csss/phoneDetail.css" rel="stylesheet"/> 
</head>
<body>
 <%@ include file="../includes/header.jsp"%>


	<form method="post" action="">
		<div class="sub-conts product-info">
			<div class="box-phone-info">
			  <div class="phone-thumb">
			  
			  </div>
			  <div class="phone-detail">
			      <div class="detail-top">
			         <div class="box-name">
			            <h2 class="product-name">
			            <span>삼성 갤럭시 A25</span>
			            <div class="chip-wrap">
			             <img src="${pageContext.request.contextPath}/resources/img/chip-5g.png">
			            </div>
			            </h2>
			            <button class="btn-share"></button>
			            <ul class="box-detail">
			               <li>OMD-SM-A256N</li>
			               <li> 128GB</li>
			               <li> 새폰</li>
			            </ul>
			         </div>
			      </div>
			      <div class="detail-bottom">
			        <h3 class="detail-title">가입조건 선택</h3>
			        <dl class="phone-type-form">
			          <dt>색상</dt>
			          <dd class="box-pick-color">
								<ul class="color-type">
									<li><input type="radio" id="color1" name="color"
										value="#c8a4b5" data-count="1" data-colorseq="1"
										data-colornm="핑크골드"> <label for="color1"
										style="background-color: #c8a4b5"> <b class="hidden">핑크골드</b>
									</label></li>
									<li><input type="radio" id="color2" name="color"
										value="#fff" data-count="2" data-colorseq="2"
										data-colornm="펜텀 화이트"> <label for="color2"
										style="background-color: #fff"> <b class="hidden">펜텀
												화이트</b>
									</label></li>
									<li><input type="radio" id="color3" name="color"
										value="#008000" data-count="3" data-colorseq="3"
										data-colornm="그린"> <label for="color3"
										style="background-color: #008000"> <b class="hidden">그린</b>
									</label></li>
									<li><input type="radio" id="color4" name="color"
										value="#800080" data-count="4" data-colorseq="4"
										data-colornm="B퍼플"> <label for="color4"
										style="background-color: #800080"> <b class="hidden">B퍼플</b>
									</label></li>
									<li><input type="radio" id="color5" name="color"
										value="#000000" data-count="5" data-colorseq="5"
										data-colornm="블랙"> <label for="color5"
										style="background-color: #000000"> <b class="hidden">블랙</b>
									</label></li>
								</ul>
								<div class="box-color-name btn-mark">
			             <strong>색상을 선택하세요</strong>
			            </div>
			          </dd> 
			        </dl>
			        <dl class="phone-type-form1">
			          <dt>할부개월</dt>
			          <dd>
			            <div class="btn-radio-group radio-list">
			               <div class="btn-radio">
			                  <input type="radio" id="devHalbuMonth1" name="devHalbuMonth" value="12" data-devhalbumonth="12" data-gtm-form-interact-field-id="1">
			                   <label for="devHalbuMonth1">12개월</label>
			               </div>
			                <div class="btn-radio">
			                  <input type="radio" id="devHalbuMonth2" name="devHalbuMonth" value="24" data-devhalbumonth="24" data-gtm-form-interact-field-id="2">
			                   <label for="devHalbuMonth2">24개월</label>
			               </div>
			               <div class="btn-radio">
			                  <input type="radio" id="devHalbuMonth3" name="devHalbuMonth" value="30" data-devhalbumonth="30" data-gtm-form-interact-field-id="3">
			                   <label for="devHalbuMonth3">30개월</label>
			               </div>
			               <div class="btn-radio">
			                  <input type="radio" id="devHalbuMonth4" name="devHalbuMonth" value="36" data-devhalbumonth="36" data-gtm-form-interact-field-id="4">
			                   <label for="devHalbuMonth4">36개월</label>
			               </div>
			               <div class="btn-radio">
			                  <input type="radio" id="devHalbuMonth5" name="devHalbuMonth" value="일시불" data-devhalbumonth="일시불" data-gtm-form-interact-field-id="5">
			                   <label for="devHalbuMonth5">일시불</label>
			               </div>
			            </div>
			            <div class="box-btn">
			              <a href="#" class="btn-text-right-s">무이자 할부 카드</a>
			            </div>
			          </dd>
			        </dl>
			        <div class="banner-slid">
			           <a href="#"><img src="${pageContext.request.contextPath}/resources/img/PC_휴대폰상세.png"></a>
			        </div>
			      </div>
			  </div> 
			</div>
			<!-- 요금제 선택  -->
			<div class="box-tab02 tab-ctrl">
			    <div class="tab-contents-wrap">
			         <div class="box-phone-rate">
			          <h3 class="detail-title">
			            요금제 선택
			            <div class="box-btn">
			              <a href="#" class="btn-text-right">전체요금제 보기</a>
			            </div>
			          </h3>
			          <div class="card-rate-wrap" id="planList">
			             <div class="payment-imgCard-btn">
			                 <div class="cardList">
			                 <input type="radio" name="ppnCd" id="ppnCd1" value="LPZ0019036" data-upppncd="H004" data-pppncd="LPZ0019036" data-ppnseq="365" data-ppnnm="LTE (1.5GB/통화기본)" data-gtm-form-interact-field-id="2">
			                  <div class="ppnCd1">
			                    <div class="item-top">
			                       <div class="chip-wrap">
			                         <a href="#"><img src="${pageContext.request.contextPath}/resources/img/통화무제한.png"></a>
			                       </div>
			                       <dl class="payment-desc">
			                          <dt>
			                            <b class="title">LTE (1.5GB/통화기본)</b>
			                          </dt>
			                          <dd>
			                            <div class="feature">
			                               <span class="vol">
			                                 <a>1.5GB</a>
			                               </span>
			                               <span class="limit">
			                                 <a>기본제공</a>
			                               </span>
			                               <span class="supply">
			                                 <a>기본제공</a>
			                               </span>
			                            </div>
			                          </dd>
			                       </dl>
			                    </div>
			                  </div>
			                  <div class="pay-amount">
			                     <span class="origin-pay">25,900원</span>
			                     <strong class="discount-pay">19,300원</strong>
			                  </div>
			                 </div>
			             </div>
			             <div class="payment-imgCard-btn">
			                 <div class="cardList">
			                 <input type="radio" name="ppnCd" id="ppnCd1" value="LPZ0019036" data-upppncd="H004" data-pppncd="LPZ0019036" data-ppnseq="365" data-ppnnm="LTE (1.5GB/통화기본)" data-gtm-form-interact-field-id="2">
			                  <div class="ppnCd1">
			                    <div class="item-top">
			                       <div class="chip-wrap">
			                         <a href="#"><img src="${pageContext.request.contextPath}/resources/img/badge_textprov.png"></a>
			                         <a href="#"><img src="${pageContext.request.contextPath}/resources/img/1Mbps 무제한.png"></a>
			                         <a href="#"><img src="${pageContext.request.contextPath}/resources/img/통화무제한.png"></a>
			                       </div>
			                       <dl class="payment-desc">
			                          <dt>
			                            <b class="title">LTE (1GB+/통화기본)</b>
			                          </dt>
			                          <dd>
			                            <div class="feature">
			                               <span class="vol">
			                                 <a>1GB</a>
			                               </span>
			                               <span class="limit">
			                                 <a>기본제공</a>
			                               </span>
			                               <span class="supply">
			                                 <a>기본제공</a>
			                               </span>
			                            </div>
			                          </dd>
			                       </dl>
			                    </div>
			                  </div>
			                  <div class="pay-amount">
			                     <strong class="discount-pay">월 24,900원</strong>
			                  </div>
			                 </div>
			             </div>
			                <div class="payment-imgCard-btn">
			                 <div class="cardList">
			                 <input type="radio" name="ppnCd" id="ppnCd2" value="LPZ0019036" data-upppncd="H004" data-pppncd="LPZ0019036" data-ppnseq="365" data-ppnnm="LTE (1.5GB/통화기본)" data-gtm-form-interact-field-id="2">
			                  <div class="ppnCd2">
			                    <div class="item-top">
			                       <div class="chip-wrap">
			                         <a href="#"><img src="${pageContext.request.contextPath}/resources/img/1Mbps 무제한.png"></a>
			                       </div>
			                       <dl class="payment-desc">
			                          <dt>
			                            <b class="title">LTE (6GB+/통화기본))</b>
			                          </dt>
			                          <dd>
			                            <div class="feature">
			                               <span class="vol">
			                                 <a>6GB</a>
			                               </span>
			                               <span class="limit">
			                                 <a>기본제공</a>
			                               </span>
			                               <span class="supply">
			                                 <a>기본제공</a>
			                               </span>
			                            </div>
			                          </dd>
			                       </dl>
			                    </div>
			                  </div>
			                  <div class="pay-amount">
			                     <span class="origin-pay">34,900원</span>
			                     <strong class="discount-pay">33,300원</strong>
			                  </div>
			                 </div>
			             </div>
			             </div>
			             <!-- 할인 유형 시작 -->
			               <dl class="phone-type-form">
			                  <dt>할인 유형</dt>
			                  <dd class="dd">
			                    <div class="radio-group-wrap">
			                       <ul class="btn-radio-group" id="phoneSupportArea">
			                          <li class="btn-radio1">
			                            <input type="radio" id="support1" name="support" value="DIS" data-support="휴대폰 할인 (24개월)" checked="checked">
			                            <label for="support1" class="label">
			                              <strong>
			                               휴대폰 가격 할인
			                               <span>(공시 지원금)</span>
			                              </strong>
			                              <b class="txt-vt">
			                               총
			                               <span id="publicSupport">-449,900</span>
			                                원
			                              </b>
			                            </label>
			                          </li>
			                          <li class="btn-radio1">
			                            <input type="radio" id="support2" name="support" value="DIS" data-support="휴대폰 할인 (24개월)" checked="checked">
			                            <label for="support2" class="label">
			                              <strong>
			                               휴대폰 가격 할인
			                               <span>(공시 지원금)</span>
			                              </strong>
			                              <b class="txt-vt">
			                               총
			                               <span id="publicSupport">-449,900</span>
			                                원
			                              </b>
			                            </label>
			                          </li>
			                       </ul>
			                    </div>
			                  </dd>
			                  <dt class="ucashArea">
			                     <span class="ucash-tit">U폰캐시 할인</span>
			                     <div class="tooltip-wrap">
			                        <div class="box-tooltip"> 
			                            <button class="btn-tooltip" type="button">
			                            </button>
			                        </div>
			                        <span class="txt">
			                          추가혜택
			                        </span>
			                     </div>
			                  </dt>
			                  <dd class="ucashArea">
			                     <div class="txt-box" id="ucashLoginBtn">
			                       <p>
			                       <strong>로그인</strong>
			                       하고 휴대폰 구매할 때 받을 수 있는 더
			                       <strong> 큰 혜택</strong>
			                       을 확인하세요.
			                       </p>
			                     </div>
			                  </dd>
			               </dl>
			               <dl class="phone-type-form2">
			                 <dt>사은품</dt>
			                 <dd class="box-gift">
			                   <img src="${pageContext.request.contextPath}/resources/img/phone-gift-icon.png">
			                   <div class="box-btn">
			                      <p class="speech-bubble">휴대폰 개통 완료하면 사은품을 드립니다.</p>
			                      <button class="btn-text-right" type="button">
			                      사은품 확인하기
			                      </button>
			                   </div>
			                 </dd>
			               </dl>
			             <!-- 할인 유형 끝 -->
			          </div>
			         </div>
			    </div>
			    <!-- 하단 시작 -->
			    <div class="box-tab tab-ctrl">
			       <ul class="tab-btn-wrap line-tab">
					<li><a href="#" class="on" title="상품정보" aria-selected="true"
						role="tab">상품정보</a></li>
					<li><a href="#" title="상세스펙" aria-selected="false" role="tab">상세스펙</a>
					</li>
					<li><a href="#" title="상품후기" aria-selected="false" role="tab">상품후기</a>
					</li>
					<li><a href="#" title="가입안내" aria-selected="false" role="tab">가입안내</a>
					</li>
				</ul>
				
				 <div class="tab-contents-wrap product-view">
				     <div class="aria">
				       <table class="table-type-04">
				         <caption class="hiddden">휴대폰 상세스펙 제공</caption>
				         <colgroup>
				           <col width="220px">
				           <col width="420px">
				           <col width="220px">
				           <col width="*">
				         </colgroup>
				         <tbody class="tbody">
				            <tr class="tr">
				              <th scope="row">
				                제조사
				              </th>
				              <td>삼성</td>
				              <th scope="row">
				                출시일
				              </th>
				              <td>2024.01.05</td>
				            </tr>
				            <tr class="tr">
				              <th scope="row">
				                크기
				              </th>
				              <td>161.0x76.5x8.3mm</td>
				              <th scope="row">
				                무게
				              </th>
				              <td>197g</td>
				            </tr>
				             <tr class="tr">
				              <th scope="row">
				                배터리
				              </th>
				              <td>5000mAh</td>
				              <th scope="row">
				                OS
				              </th>
				              <td>Android </td>
				            </tr>
				            <tr>
				              <th scope="row">색상</th>
				              <td colspan="3">라이트블루/옐로우/블루블랙</td>
				            </tr>
				            <tr>
				              <th scope="row">CPU</th>
				              <td colspan="3">Octa-Core (2.4GHz, 2.0GHz)</td>
				            </tr>
				            <tr>
				              <th scope="row">메모리</th>
				              <td colspan="3">6GB RAM / 128GB</td>
				            </tr>
				            <tr>
				              <th scope="row">디스플레이</th>
				              <td colspan="3">Infinity-U Display</td>
				            </tr>
				            <tr>
				              <th scope="row">카메라</th>
				              <td colspan="3">후면 5,000만 화소 / 전면 : 1,300만 화소</td>
				            </tr>
				            <tr>
				              <th scope="row">기타(옵션)</th>
				              <td colspan="3">OIS 지원, FM 라디오 지원</td>
				            </tr>
				         </tbody>
				       </table>
				     </div>
				 </div>
				
			    </div>
			    <!-- 하단 끝 -->
			    <!-- 팝업 시작  -->
			    
			     <div class="bottom-layer-pop">
			        <button class="bottom-pop-btn" type="button">
			          <span class="ico-pop-btn">
			             팝업열기
			          </span>
			        </button>
			        <div class="bottom-container" id="paymentdetail">
			            <div class="bottom-container" id="paymentdetail">
			              <div class="show-conts">
			                 <div class="price-conts sello-prc">
			                   <div class="price">
			                   부가세포함 월 납부 금액
			                   <strong class="txt-tv">
			                      <span id="monthMoneyFeeDw3">19,900</span>
			                      원
			                   </strong>
			                   </div>
			                 </div>
			                 <div class="box-btn btn-conts">
			                    <div class="ripper-area">
			                      <p class="sello-bubble">		         
			                      추가 상품권 최대 5만원
			                      </p>
			                      <button class="btns btn-sello" type="button">
			                         <span>
			                         중고폰 보상 신청하기(시세 조회)
			                         </span>
			                      </button>
			                    </div>
			                    <button class="btns1 md-ripples ripples-light" type="submit" id="mobileJoinBtn" onclick="fMoveOnsaleCmmn();">휴대폰 가입 신청하기
							</button>
			              </div>
			             </div>
			         </div>
			     </div>
			    
			    <!--  팝업 끝  -->
			</div>
		</div>
	</form>

</body>
</html>

<script>
const radioButtons = document.querySelectorAll('input[name="color"]');


radioButtons.forEach(button => {
    button.addEventListener('change', function() {
  
        const colorName = this.getAttribute('data-colornm');

        document.querySelector('.box-color-name strong').textContent = colorName;
    });
});


document.querySelectorAll('.tab-btn-wrap a').forEach(tab => {
    tab.addEventListener('click', function (event) {
        event.preventDefault();

        // 모든 탭에서 "on" 클래스를 제거하고, 비활성화 상태로 만듬
        document.querySelectorAll('.tab-btn-wrap a').forEach(tab => {
            tab.classList.remove('on');
            tab.setAttribute('aria-selected', 'false');
        });

        // 클릭한 탭에 "on" 클래스를 추가하고, 활성화 상태로 만듬
        this.classList.add('on');
        this.setAttribute('aria-selected', 'true');

        // 모든 탭 내용 숨기고, 클릭한 탭에 맞는 내용을 표시
        const tabContents = document.querySelectorAll('.tab-content');
        tabContents.forEach(content => content.classList.remove('active'));
        
        const index = Array.from(this.parentElement.children).indexOf(this.parentElement.querySelector('a.on'));
        tabContents[index].classList.add('active');
    });
});


</script>