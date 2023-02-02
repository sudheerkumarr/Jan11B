<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- core, function, format, xml, sql - libraries -->

<c:out value="Hello World!"></c:out>
<c:forEach var="i" begin="1" end="5">
	<br/><c:out value="${i }"/>
</c:forEach>

<!-- set value to a variable -->
<c:set var="age" value="27"/>

<!-- if -->
<c:if test="${age>18 }"/>
	<p><c:out value="Major" />
<br/><br/>

<!-- url -->
<!-- www.example.com -->
<c:url var="URL" value="www.example.com" />
<c:out value="${URL}" />
<br/><br/>

<!-- param -->
<!-- /JSTLDemo/index.jsp?username=Raj&password=passwd -->
<c:url value="/index.jsp" var="myUrl" >
	<c:param name="username" value="Raj"/>
	<c:param name="password" value="passwd" />
</c:url>
<c:out value="${myUrl}" />
<br/><br/>

<!-- choose, when & otherwise -->
<!-- Saturday -->
<c:set var="day" value="10" />
<c:choose>
	<c:when test="${day==1 }">
		<h3>Sunday</h3>
	</c:when>
	<c:when test="${day==2 }">
		<h3>Monday</h3>
	</c:when>
	<c:when test="${day==3 }">
		<h3>Tuesday</h3>
	</c:when>
	<c:when test="${day==4 }">
		<h3>Wednesday</h3>
	</c:when>
	<c:when test="${day==5 }">
		<h3>Thursday</h3>
	</c:when>
	<c:when test="${day==6 }">
		<h3>Friday</h3>
	</c:when>
	<c:when test="${day==7 }">
		<h3>Saturday</h3>
	</c:when>
	<c:otherwise>
		<h3>Choose any day number between 1-7</h3>
	</c:otherwise>
</c:choose>
<br/><br/>





</body>
</html>