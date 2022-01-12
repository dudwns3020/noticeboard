<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="회원가입" />
<%@ include file="../common/head.jspf" %>

	<form class="table-box-type-1" method="POST"
		action="../member/doJoin">
		<table border=1>
			<thead>
				<tr>
					<th>아이디</th>
					<td><input required="required"
						class="w-96 input input-bordered" name="loginId" type="text"
						placeholder="아이디를 입력하세요." /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input required="required"
						class="w-96 input input-bordered" name="loginPw" type="password"
						placeholder="비밀번호를 입력하세요." /></td>
				</tr>
				<!-- <tr>
					<th>비밀번호 확인</th>
					<td><input required="required"
						class="w-96 input input-bordered" name="loginPwCon" type="password"
						placeholder="비밀번호를 입력하세요." /></td>
				</tr> -->
				<tr>
					<th>이름</th>
					<td><input required="required"
						class="w-96 input input-bordered" name="name" type="text"
						placeholder="이름을 입력하세요." /></td>
				</tr>				
				<tr>
					<th>핸드폰 번호</th>
					<td><input required="required"
						class="w-96 input input-bordered" name="phoneNo" type="text"
						placeholder="핸드폰 번호를 입력하세요." /></td>
				</tr>
				<tr>
					<th>가입</th>
					<td>
						<button type="submit">가입</button>
						<button type="button" onclick="history.back();">뒤로가기</button>
					</td>
				</tr>
			</thead>
		</table>
	</form>
<%@ include file="../common/foot.jspf"%>