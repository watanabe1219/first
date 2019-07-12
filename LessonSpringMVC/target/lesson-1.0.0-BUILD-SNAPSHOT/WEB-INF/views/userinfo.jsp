<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userinfo</title>
</head>
<body>

<c:if test = "${not empty userinfoList}"> 
	<table border = "1">
		<tr><th>名前</th>
			<th>年齢</th>
			<th>性別</th>
			<th>E-mail</th>
			<th>出身地</th>
			<th>好きな言語</th>
			<th>備考</th>
			<tr>
				<c:forEach var="UserInfoForm" items="${UserInfoForm}">
			<tr>
				<td><c:out value="${UserInfoForm.name}"></c:out>
				<td><c:out value="${UserInfoForm.age}"></c:out>
				<td><c:out value="${UserInfoForm.gender}"></c:out>  
				<td><c:out value="${UserInfoForm.mail}"></c:out>
				<td><c:out value="${UserInfoForm.birthplace}"></c:out>
				<td><c:out value="${UserInfoForm.FavoriteLangs}"></c:out>
				<td><c:out value="${UserInfoForm.bikou}"></c:out>   
			</tr>
				</c:forEach>
			</tr>
		
	</table>
	<br>
</c:if>
<form:form modelAttribute = "UserInfoForm">
		名前<form:input path ="name"/><br/>
		 年齢<form:input path ="age"/><br/>
		 性別<form:radiobuttons path="gender" items="${genders}"/><br/>
		E-mail<form:input path ="mail"/><br/>
      	 出身地<form:select path="birthplace" items="${birthplaces}" multiple="false"/><br/> 
		 好きな言語<form:checkboxes path="favoriteLangs" items="${langs}"/><br/>
		備考<form:input path = "bikou"/><br/> 
	
		<input type = "submit" value = "送信"><br/>
</form:form>
</body>
</html>