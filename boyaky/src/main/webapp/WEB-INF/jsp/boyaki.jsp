<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Boyaky</title>
</head>

<body>
	ぼやいてください。
	<form:form modelAttribute="boyaki" method="post">
		<p>
			<form:input path="content" />
			<form:errors path="content" cssClass="errors" />
		</p>
		<input type="submit" value="ぼやく" />
	</form:form>

	<hr>
	<ol>
		<c:forEach var="boyaki" items="${boyakiList}">
			<li><c:out value="${boyaki}" /></li>
		</c:forEach>
	</ol>
	<hr>
</body>
</html>