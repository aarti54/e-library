package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BookBean;
import dao.BookDao;
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
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
		
		out.println("<div>");
		String callno=request.getParameter("callno2");
		String name=request.getParameter("name2");
		String author=request.getParameter("author2");
		String publisher=request.getParameter("publisher2");
		String squantity=request.getParameter("quantity2");
		int quantity=Integer.parseInt(squantity);
		BookBean bean=new BookBean(callno,name,author,publisher,quantity);
		
		int i=BookDao.save(bean);
		if(i>0){
			request.getRequestDispatcher("navlibrarian.html").include(request, response);

			out.println("<div class='output'><label>Book saved successfully</label></div>");
		}
		out.println("</div>");
		
		out.close();
	}

}
