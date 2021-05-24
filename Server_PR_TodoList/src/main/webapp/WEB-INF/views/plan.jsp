<%--<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<style>
</style>
<script>
	document.addEventListener("DOMContentLoaded", function(ev) {

		document.querySelector("input#main").addEventListener("click",
				function(ev) {

					let url = "${rootPath}"
					if (text == "작성하기") {
						url += "/write"
					}

					document.location.href = url;
				})
	})
</script>

<h1>계획 및 일정 작성하기</h1>
<input id="main">
	<ul>
		
		<li><a href="${rootPath}/write">작성하기</a></li>

	</ul>
</input>
 --%>





