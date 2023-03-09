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

@WebServlet("/EditLibrarian")
public class EditLibrarian extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name1");
		String email=request.getParameter("email1");
		String password=request.getParameter("password1");
		String smobile=request.getParameter("mobile1");
		long mobile=Long.parseLong(smobile);
		
		LibrarianBean bean=new LibrarianBean(id,name, email, password, mobile);
		LibrarianDao.update(bean);
		
		response.sendRedirect("ViewLibrarian");
	}

}
