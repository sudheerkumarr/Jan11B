<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- parseNumber - String to number-->
<c:set var="salary" value="35000" />
<fmt:parseNumber var="s" type="number" value="${salary}"/>
<p><c:out value="${s}"/>
<br/><br/>



<!-- parseDate - String to Date -->
<fmt:parseDate value="21-10-2002" pattern="dd-MM-yyyy" var="dob"/>
<c:out value="${dob }"/>
</body>
</html>