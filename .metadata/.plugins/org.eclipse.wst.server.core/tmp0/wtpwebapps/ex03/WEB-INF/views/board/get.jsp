<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>

<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Read Page</div>
			<!-- /.panel-heading -->
			
			<div class="panel-body">
			
				<div class="form-group">
					<label>Bno</label><input class="form-control" name="bno" value='<c:out value="${board.bno}" />' readonly="readonly">
				</div>
				
				<div class="form-group">
					<label>Title</label><input class="form-control" name="title" value='<c:out value="${board.title}" />' readonly="readonly">
				</div>
				
				<div class="form-group">
					<label>Text area</label><textarea rows="3" name="content" readonly class="form-control"><c:out value="${board.content}"></c:out></textarea>
				</div>
				
				<div class="form-group">
					<label>Writer</label><input class="form-control" name="writer" value='<c:out value="${board.writer}" />' readonly="readonly">
				</div>
				
				<!-- 수정 -->
				<button data-oper="modify" class="btn btn-default">Modify</button>
				<!-- 목록 -->
				<button data-oper="list" class="btn btn-info">List</button>
				
				<form id="operForm" action="/board/modify" method="get">
					<input type="hidden" id="bno" name="bno" value="${board.bno}">
					<input type="hidden" name="pageNum" value="${cri.pageNum}">
					<input type="hidden" name="amount" value="${cri.amount}">
					<input type="hidden" name="type" value="${cri.type}">
					<input type="hidden" name="keyword" value="${cri.keyword}">
				</form>
				
			</div>
		</div>
		<!-- /.panel-body -->
	</div>
	<!-- /.panel -->
</div>
<!-- /.col-lg-6 -->
<!-- /.row -->

<!-- 댓글 처리 시작 -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i> Reply
				<button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">
					New Reply
				</button>
			</div>
			<!-- /.panel-heading -->
			
			<!-- 댓글처리 -->
			<div class="panel-body">
				<ul class="chat">
				</ul>
			</div>
			
			<!-- 댓글 페이징 처리 -->
			<div class="panel-footer">
		
			</div>
		
		</div>
		<!-- /.panel-body -->
	</div>
	<!-- /.panel -->
</div>
<!-- /.col-lg-6 -->

<!-- 댓글 처리 종료 -->


<!-- modal start -->

<div id="myModal" class="modal" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Reply Modal</h5>
				<!--   <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button> -->
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label>Reply</label>
					<input class="form-control" name="reply" value="New Reply!!" />
				</div>
				<div class="form-group">
					<label>Replyer</label>
					<input class="form-control" name="replyer" value="New Replyer!!" />
				</div>
				<div class="form-group">
					<label>Reply Date</label>
					<input class="form-control" name="updateDate" value="" />
				</div>
			</div>
			
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="modalModBtn">Modify</button>
				<button type="button" class="btn btn-danger" id="modalRemoveBtn">Remove</button>
				<button type="button" class="btn btn-info" id="modalRegisterBtn">Register</button>
				<button type="button" class="btn btn-default" id="modalCloseBtn" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<!-- modal end -->



<script src="/resources/js/reply.js"></script>

<style>
	.chat:hover{
		cursor:pointer;
	}
</style>

<script>
	$(document).ready(function(){
		console.log("--------------------");
		console.log("JS TEST");
		
		let bnovalue = '<c:out value="${board.bno}"/>';
		
		let replyUL = $(".chat");
		showList(1);
		
		//start showList
		function showList(page){
			//param
			replyService.getList({bno:bnovalue , page:page||1},
			//callback start
			function(replyCnt, list){

				if(page == -1){
					pageNum = Math.ceil(replyCnt/10.0);
					return;
				}
				let str="";
				
				if(list == null || list.length == 0){
					replyUL.html("");
					return;
				}
				for(let i=0, len=list.length||0; i<len; i++){
					str += "<li class='left clearfix' data-rno='"+list[i].rno+"'>";
					str += "<div class='header'>";
					str += "<strong class='primary-font'>"+list[i].replyer+"</strong>";
					str += "<small class='pull-right text-muted'>"+replyService.displayTime(list[i].replyDate) +"</small>";
					str += "</div>";
					str += "<p>"+list[i].reply+"</p>";
					str += "</li>";
				}
				replyUL.html(str)
				
				showReplyPage(replyCnt); //페이징번호 출력
			}//end callback		
		)
	} //end showList
	
	//팝업창
	let modal = $("#myModal");
	let modalInputReply = modal.find("input[name='reply']");
	let modalInputReplyer = modal.find("input[name='replyer']");
	let modalInputReplyDate = modal.find("input[name='updateDate']");
	
	let modalModBtn = $("#modalModBtn");
	let modalRemoveBtn = $("#modalRemoveBtn"); //삭제버튼
	let modalRegisterBtn = $("#modalRegisterBtn"); 
	
	$("#addReplyBtn").on("click", function(e){
		modal.find("input").val("");
		modalInputReplyDate.closest("div").hide();
		modal.find("button[id != 'modalCloseBtn']").hide();
		
		modalRegisterBtn.show();
		
		modal.modal("show");
	});
	
	
	//댓글 등록
	modalRegisterBtn.on("click", function(e){
		let reply = {
			reply: modalInputReply.val(),
			replyer:  modalInputReplyer.val(),
			bno: bnovalue
		};
		replyService.add(reply, function(result){
			alert(result);
			modal.find("input").val(""); //내용지우고
			modal.modal("hide"); //모달창닫기
//			showList(1); 댓글등록후 댓글창 재실행
			showList(-1); 
		});
		
		
	});
	
	//댓글 클릭 이벤트 --> 이벤트
	$(".chat").on("click", "li", function(e){
		let rno = $(this).data("rno");
		//console.log(rno)
		
		replyService.get(rno, function(reply){ //클릭한 댓글 데이터 조회
			modalInputReply.val(reply.reply); //데이터값 입력
			modalInputReplyer.val(reply.replyer); //데이터값 입력
			modalInputReplyDate.val(replyService.displayTime(reply.updateDate)).attr("readonly", "readonly"); //데이터값 입력
			modal.data("rno", reply.rno);
			
			modal.find("button[id != 'modalCloseBtn']").hide();
			modalModBtn.show();//수정버튼
			modalRemoveBtn.show();//삭제버튼
			
			modal.modal("show");
		})
	})
	
	
	
	//댓글 수정
	modalModBtn.on("click", function(e){
		let reply = {
				rno: modal.data("rno"),
				reply: modalInputReply.val()
		};
		
		replyService.update(reply, function(result){
			alert(result);//SUCCESS 알럿창
			modal.modal("hide");//모달 숨김
			showList(pageNum);//update 성공 시 현재 삭제한 페이지 댓글 목록을 show한다.
		});
		
	})
	
	//댓글 삭제
	modalRemoveBtn.on("click", function(e){
		let rno = modal.data("rno");
		
		replyService.remove(rno, function(result){
			alert(result); //SUCCESS 알럿창
			modal.modal("hide"); //모달 숨김
			showList(pageNum); //remove 성공 시 현재 삭제한 페이지 댓글 목록을 show한다.
		})
	})
		
	
	//댓글 페이징 처리 (showReplyPage START)
	let pageNum = 1;
	let replyPageFooter = $(".panel-footer");
	
	function showReplyPage(replyCnt){ // replyCnt: 전체 페이지 개수
		let endNum = Math.ceil(pageNum / 10.0) * 10;
		let startNum = endNum - 9;
		
		let prev = startNum != 1; //이전버튼
		let next = false; //다음버튼
		
		//realpage 계산
		if(endNum *10 >= replyCnt){
			endNum =  Math.ceil(replyCnt / 10.0)
		}
		
		//next버튼 표출조건
		if(endNum *10 < replyCnt){
			 next = true;
		}
		
		let str = "<ul class='pagination pull-right'>";
		
		if(prev){
			str += "<li class='page-item'><a class='page-link' href='"+(startNum-1)+"'>Prevous</a></li>";
		}
		for(let i=startNum; i<=endNum; i++){
			let active = pageNum == i ? "active" : "";
			
			str += "<li class='page-item "+ active +"'><a class='page-link' href='"+i+"'>"+i+"</a></li>";
		}
		
		if(next){
			str += "<li class='page-item'><a class='page-link' href='"+(endNum+1)+"'>Next</a></li>";
		}
		
		str += "</ul>";
		
		console.log(str);
		
		replyPageFooter.html(str);
	} // end showReplyPage
	
	replyPageFooter.on("click", "li a" ,function(e){
		e.preventDefault();
		let targetPageNum = $(this).attr("href");
		pageNum = targetPageNum;
		showList(pageNum);
	})
	
	
}); //end ready
</script>

<script>
	$(document).ready(function(){
/* 		console.log("--------------------");
		console.log("JS TEST");
		
		let bnovalue = '<c:out value="${board.bno}"/>';
		 */
/* 		replyService.add(
			
			//reply
			{reply:"JS TEST", replyer:"tester", bno:bnovalue},
			//callback 0x10
			function(result){ 
				alert("RESULT : " + result);
			}
		) */
		
/* 		replyService.getList(
		         {bno:bnovalue , page:1},
		         function(list){
		            for(let i=0 , len = list.length||0; i<len; i++){
		               console.log(list[i]);
		            }
		         }
		      )  */
		      
/* 		replyService.remove(
			34,
			function(msg){
				if(msg == "success"){
					alert("REMOVED");
				}
			},
			function(err){
				alert("ERROR..........");
			}	  
		); */
		
/* 		replyService.update(
			{
				rno:51,
				//bno:bnovalue,
				reply:"modify reply,,,,,,,2"
			}, function(msg){
				if(msg == "success"){
					alert("UPDATE SUCCESS");}
			},
			function(err){
				alert("ERROR..........");
			}	
		); */
		
/* 		replyService.get(
				51, 
				function(result){
						console.log(result);
				}	
			); */
		
	});
</script>



<script type="text/javascript">

	$(document).ready(function(){
		
		let operForm = $("#operForm");
		
		$("button[data-oper='modify']").on("click", function(e){
			operForm.attr("action", "/board/modify").submit();
	});
		$("button[data-oper='list']").on("click", function(e){
			operForm.find("#bno").remove();
			operForm.attr("action", "/board/list")
			operForm.submit();
	});
});
</script>

<%@ include file="../includes/footer.jsp"%>
