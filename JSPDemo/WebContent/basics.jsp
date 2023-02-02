<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.example.Util" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Expression tags -->
  Current Date: <%= java.time.LocalDateTime.now()  %>
  <h3><%= 10+10 %></h3>
  
  <!-- Scriptlet tags -->
  <%
  	for(int i=0; i<10; i++) {
  		 out.println(i); 
  	}
  %>
  
  <!-- Declarative tag -->
  <%! 
  	boolean isEven(int num) {
	  return num%2==0;
  }
  %>
  
  <!-- Calling method defined using declarative tag -->
  <br/><h3>10 is even? <%=  isEven(10) %> </h3>
  
  <!--  Call java Util class method -->
  <%= new Util().square(10) %>
  

</body>
</html>