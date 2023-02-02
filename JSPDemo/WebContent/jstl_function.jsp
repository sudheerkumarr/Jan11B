<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:set var="str1" value="Hello World"/>

<!-- fn:contains -->
<c:if test="${fn:contains(str1, 'Hello')}">
	Found 'Hello' in : <c:out value="${str1}" />
</c:if>
<br/><br/>

<!-- fn:startsWith(var, expected) -->
<c:if test="${ fn:startsWith(str1, 'He')}">
	<c:out value="${str1}"/> starts with 'He'
</c:if>
<br/><br/>

<!-- trim -->
<c:set var="str2" value="    H ell o    " />
<c:out value="${fn:trim(str2)}"/>
<br/><br/>


<!-- indexOf -->
<c:set var="str3" value="Hello" />
<c:out value="${fn:indexOf(str3, 'e') }"/> 
<br/><br/>


<!-- toUpperCase -->
toUpperCase: <c:out value="${fn:toUpperCase(str1)} "/>
<br/><br/>

<!-- length -->
Length: <c:out value="${fn: length(str1) }"/>
<br/><br/>

<!-- Split -->
<c:set var="ph" value="91-044-23454567" />
<c:set var="nums" value="${fn:split(ph, '-')}"/>
<c:forEach var="i" begin="0" end="${fn:length(nums) }">
	<p><c:out value="${nums[i]}"/>
</c:forEach>

<!-- substring -->
<c:out value="${fn:substring(str1, 6, 11)}" />


</body>
</html>