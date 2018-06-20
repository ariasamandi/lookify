<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/songs/new">Add New</a>
	<a href="/search/topTen">Top Songs</a>
	<form action="/search" method="post">
    <p>
        <label">Artist</label>
        <input type="text" name="artist">
        <input type="submit" value="Search Artists">
    </p>
    </form>
    <table>
	<tr>
	<th>Name</th>
	<th>rating</th>
	<th>action</th>
	</tr>
    <c:forEach var="s" items="${song}">
	 <tr>
         <td><a href="/songs/${s.id}"><c:out value="${s.name}"/></a></td>
         <td><c:out value="${s.rating}"/></td>
         <td><a href="/delete/${s.id}">Delete</a>
     </tr>
    </c:forEach>
	</table>
</body>
</html>