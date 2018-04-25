package net.wunderlin.jweb.servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet(description = "This is a minimal implementation of a Java Servlet.", urlPatterns = { "/Servlet.html" })
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String sirname;
	private String firstname;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String template = "";
		String f = getServletContext().getRealPath("WEB-INF/templates/form.html");
		BufferedReader br = new BufferedReader(new FileReader(f));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    template = sb.toString();
		} finally {
		    br.close();
		}
		
		if (sirname == null)
			sirname = "";
		if (firstname == null)
			firstname = "";
		
		// replace template variables
		//System.out.println("doGet sirname: " + sirname);
		template = template.replace("$sirname", sirname);
		template = template.replace("$firstname", firstname);
		
		PrintWriter writer = response.getWriter();
		writer.append(template);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Simple example storing the values in class variables. This
		// makes them global to all visitors
		sirname = request.getParameter("sirname");
		firstname = request.getParameter("firstname");
		
		if (sirname == null)
			sirname = "<undefined>";
		if (firstname == null)
			firstname = "<undefined>";
		
		System.out.println("sirname: " + sirname);
		System.out.println("firstname: " + firstname);
		
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doHead(HttpServletRequest, HttpServletResponse)
	 */
	protected void doHead(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
