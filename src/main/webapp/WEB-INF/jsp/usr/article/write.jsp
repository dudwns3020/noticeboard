<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="게시물 작성" />
<%@ include file="../common/head.jspf"%>

<form class="table-box-type-1" method="POST" action="../article/doWrite">
	<table border=1>
		<thead>
			<tr>
				<th>제목</th>
				<td><input required="required"
					class="w-96 input input-bordered" name="title" type="text"
					placeholder="제목" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea required="required"
						class="w-full textarea textarea-bordered" name="body" rows="10"
						placeholder="내용"></textarea></td>
			</tr>
			<tr>
				<th>작성</th>
				<td>
					<button type="submit">작성</button>
					<button type="button" onclick="history.back();">뒤로가기</button>
				</td>
			</tr>
		</thead>
	</table>
</form>
<%@ include file="../common/foot.jspf"%>

