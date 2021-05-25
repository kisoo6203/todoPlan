<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	document.addEventListener("DOMContentLoaded",function(ev){
		document
		.querySelector("div.td_btn")
		.addEventListener("click",function(ev){
			let className = ev.target.className
		
		if(className == "td_home"){
			
		} else if(className == "td_update"){
			document.location
			.href="${rootPath}/todo/update?td_seq="+${TD.td_seq}
		
			<%--Uncaught SyntaxError: Unexpected token '}' 뜨는이유?--%>
		} else if(className == "td_delete"){
			if(confirm("자료 삭제 완료")){
				document.location
				.replace( "${rootPath}/todo/delete?td_seq="+${TD.td_seq})
				
			}
		}
		
		})
	})
</script>
</head>

<body>


	<div class="td_btn">
		<button class="td_home">Home</button>
		<button class="td_update">수정하기</button>
		<button class="td_delete">삭제하기</button>
	</div>

</body>
</html>