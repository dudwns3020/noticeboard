<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="상세 페이지" />
<%@ include file="../common/head.jspf" %>

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
			<td>${article.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${article.body }</td>
		</tr>
	</thead>
</table>
<div>
	<button type="button" onclick="history.back();">뒤로가기</button>
	<a href="../article/modify?id=${article.id }">수정</a> <a
		onclick="if(confirm('게시물을 삭제하겠습니까?') == false) { return false }"
		href="../article/doDelete?id=${article.id}">삭제</a>
</div>
<%@ include file="../common/foot.jspf"%>