package servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.IssueBookBean;
import dao.BookDao;
@WebServlet("/IssueBook")
public class IssueBook extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Book Form</title>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		//request.getRequestDispatcher("navlibrarian.html").include(request, response);
		
		out.println("<div>");
		String callno=request.getParameter("callno");
		String studentid=request.getParameter("studentid");
		String studentname=request.getParameter("studentname");
		String sstudentmobile=request.getParameter("studentmobile");
		long studentmobile=Long.parseLong(sstudentmobile);
		
		IssueBookBean bean=new IssueBookBean(callno,studentid,studentname,studentmobile);
		int i=BookDao.issueBook(bean);

		if(i>0){
			request.getRequestDispatcher("navlibrarian.html").include(request, response);

			out.println("<div class='output'><label>Book issued successfully</label></div>");
		}else{
			request.getRequestDispatcher("navlibrarian.html").include(request, response);

			out.println("<div class='output'><label>Sorry, unable to issue book.</label><p>We may have sortage of books. Kindly visit later.</p></div>");
		}
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
