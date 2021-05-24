<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	document.addEventListener("DOMContentLoaded",function(){
		document.querySelector("table#tdlist")
		.addEventListener("click",function(ev){
			let tag_name = ev.target.tagName;
			
			if(tag_name == "TD"){
				let td_seq = ev.target.closest("TR").dataset.seq
				
				document.location.href="${rootPath}/todo/seq?td_seq=" + td_seq
			}
		})
		document.querySelector("button.td_write").addEventListener("click",function(ev){
			document.location.href = "${rootPath}/todo/insert"
		})
	})
</script>
<%-- 홈 꾸밀때 사용할 것
<link href="${rootPath}/static/css/home.css?ver2021-05-24-00" rel="stylesheet"/> --%>
</head>
<body>
	<h1>TO DO List</h1>
	<%-- 홈화면 꾸밀때 사용 --%>
	<%@ include file="/WEB-INF/views/seq.jsp" %>
	<section id="main">
		<button class="td_write">작성하기</button>
	</section>
	<table id="tdlist">
		<tr>
			<th>작성일자</th>
			<th>작성시각</th>
			<th>할일</th>
			<th>장소</th>
			
		</tr>
		<c:forEach items="${TDLIST}" var="TD">
			<tr data-seq="${TD.td_seq}">
				
				<td>${TD.td_date}</td>
				<td>${TD.td_time}</td>
				<td>${TD.td_plan}</td>
				<td>${TD.td_place}</td>		
				
		</c:forEach>
	</table>

</body>
</html>