<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%-- <h6><%= request.getParameter("email") %> logged in successfully!</h6>
	<h6><%= request.getParameter("password") %> </h6> --%>
	<%
		String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    
	    if(email=="" || password=="") {
	    	out.println("Failed to login");
	    } else {
	    	out.println("Login success");
	    }
	
	%>

</body>
</html>