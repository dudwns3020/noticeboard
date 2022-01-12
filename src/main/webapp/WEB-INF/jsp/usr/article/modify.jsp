<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="게시물 수정" />
<%@ include file="../common/head.jspf" %>

<form class="table-box-type-1" method="POST"
	action="../article/doModify">
	<input type="hidden" name="id" value="${article.id }" />
	<table border=1>
		<thead>
			<tr>
				<th>번호</th>
				<td>${article.id }</td>
			</tr>
			<tr>
				<th>작성날짜</th>
				<td>${article.regDate }</td>
			</tr>
			<tr>
				<th>수정날짜</th>
				<td>${article.updateDate }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input name="title" type="text" value="${article.title }" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="body" rows="10">${article.body }</textarea></td>
			</tr>
			<tr>
				<th>수정</th>
				<td>
					<button type="submit">수정</button>
				</td>
			</tr>
		</thead>
	</table>
</form>
<div>
	<button type="button" onclick="history.back();">뒤로가기</button>
	<a onclick="if(confirm('게시물을 삭제하겠습니까?') == false) { return false }"
		href="../article/doDelete?id=${article.id}">삭제</a>
</div>
<%@ include file="../common/foot.jspf"%>
