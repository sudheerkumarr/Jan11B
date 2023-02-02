package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * Ways to create servlet 
 *  1. by implementing Servlet interface
 *  2. by extending HttpServlet class
 *  
 *  static web app
 *  dynamic web app
 *  
 *  WebServers - IIS, Tomcat4.0
 *   - handle only http request
 *   - contains WebContainer
 *  ApplicationServer - GlassFish, Tomcat, JBoss,WebSphere, WebLogic
 *   - Contains WebContainer + EJB Containers
 *   - handles https requests
 *   - serves business logic to application programs through any number of protocols.
 *   
 *   - Servlet Engine/Catalina - executes servlets.
 *   
 *   - 3 layered architecture
 *   Presentation layer                 Business/server layer              Database
 *   HTML, CSS, JS, React/Angular/VUE   Servlet/JSP struts/ spring         MySQL/Oracle
 *   
 *   Browser       --Request-->                   Server     ----SQL--->   DB
 *                 <--Response---                 Server     <---Res----
 *                  html/css/jsp/thymeleaf/velocity
 *                  Json/XML - JavaScriptObject
 *   
 *   MVC - Modal View Controller - Design pattern
 *   Spring MVC
 *   

 *   
 *   
 */

/**
 * Servlet implementation class GreetServlet
 */
@WebServlet("/GreetServlet")
public class GreetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GreetServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get values entered by user
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		// append fname, lname
		String fullname = String.join(" ", fname, lname);
		
		// Update request obj with fullname before sending request to another servlet 
		request.setAttribute("fullname", fullname);
		
		// RequestDispatcher - One servlet can call another servlet
		// Call UpperCaseServlet using RequestDispatcher
		
		RequestDispatcher rd = request.getRequestDispatcher("ucs");
		rd.forward(request, response);
		
		
		// return fname, lname with msg
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<html><body>");
//		out.println("<h3>");
//		out.println(fullname);
//		out.println("</h3>");
//		out.println("</body></html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	//Session management/ cookies/ ServletConfig/ServletContext
	
}
