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
	
	document.querySelector("button.td_save").addEventListener("click",function(ev){
		
		let dom = document;
		let td_date = dom.querySelector("input[name='td_date']");
		let td_time = dom.querySelector("input[name='td_time']");
		let td_plan = dom.querySelector("input[name='td_plan']");
		let td_place = dom.querySelector("input[name='td_place']");		

		if(td_date.value == ""){
			alert("날짜를 확인해주세요");
			dt_date.focus();
			return false;
		}
		if(td_time.value == ""){
			alert("시간을 확인해주세요")
			td_time.focus();
			return false;
		}
		if(td_plan.value == ""){
			alert("할일을 입력해주세요")
			td_plan.focus();
			return false;
		}
		if(td_place.value == ""){
			alert("장소를 입력해주세요")
			td_place.focus();
			return false;
		}
		alert("저장버튼"
			 + td_date.value + "/"
			 + td_time.value + "/"
			 + td_plan.value + "/"
			 + td_place.value + "/"
		)

		dom.querySelector("form.v1").submit();
	})
	
})
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/plan.jsp"%>
	<form class="v1" method="POST">
		<fieldset>
			<legend>계획 작성하기</legend>
			<div>
				<label>작성일자</label> <input name="td_date" type="date"
					value="${TD.td_date}">
			</div>
			<div>
				<label>작성시각</label> <input name="td_time" type="time"
					value="${TD.td_time}">
			</div>
			<div>
				<label>할 일</label> <input name="td_plan" type="plan"
					value="${TD.td_plan}">
			</div>
			<div>
				<label>장소</label> <input name="td_place" type="place"
					value="${TD.td_place}">
			</div>
			<div>
				<label></label>
				<button class="td_save" type="button">저장</button>
				
			</div>
		</fieldset>
	</form>

</body>
</html>