package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.LibrarianBean;
import dao.LibrarianDao;

@WebServlet("/AddLibrarian")
public class AddLibrarian extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Librarian</title>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<div>");
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String smobile=request.getParameter("mobile");
		long mobile=Long.parseLong(smobile);
		LibrarianBean bean=new LibrarianBean(name, email, password, mobile);
		LibrarianDao.save(bean);
//		out.print("<h4>Librarian added successfully</h4>");
		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.print("<div class='output'><label>Librarian added successfully</label></div>");
		
		out.println("</div>");
//		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
