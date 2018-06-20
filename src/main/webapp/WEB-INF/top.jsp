<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Top Ten Songs:</h1>
	<c:forEach var="s" items="${song}" end="9">
		<h3><c:out value="${s.rating}"/> - <c:out value="${s.name}"/> - <c:out value="${s.artist}"/></h3>
	</c:forEach>
</body>
</html>