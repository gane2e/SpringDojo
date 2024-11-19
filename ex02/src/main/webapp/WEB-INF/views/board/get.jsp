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
</div>
<!-- end-row -->

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
