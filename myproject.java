package com.controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.doa.Display;
import com.doa.Insertlogic;
import com.doa.Login;
import com.doa.Selectbyuser;
import com.doa.Updatedoa;
import com.doa.deletelogic;
import com.model.Insertmodel;
import com.model.displaymodel;
import com.model.loginmodel;
import com.model.updatemodel;

/**
 * Servlet implementation class myproject
 */
public class myproject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public myproject() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path=request.getServletPath();
		
		switch(path) {
		case "/login":login(request,response);
		break;
		case "/insert":insert(request,response);
		break;
		case "/add":add(request,response);
		break;
		case "/delete":delete(request,response);
		break;
		case "/home" :gethome(request,response);
		break;
		case "/edit" :edit(request,response);
		break;
		case"/update":update(request,response);
		break;
		default : getlogin(request,response);
		}
		}

	
	private void update(HttpServletRequest request, HttpServletResponse response)throws IOException {
		PrintWriter out=response.getWriter();
		int id= Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		long mobile=Long.parseLong(request.getParameter("mobile"));
		String course=request.getParameter("course");
		String state=request.getParameter("state");
		updatemodel um=new updatemodel(id,name,email,mobile,course,state);
		Updatedoa ud=new Updatedoa();
		int count=ud.update(um);
		if(count>0) {
			response.sendRedirect("home");
		}else {
			out.print("<h1>not updated<h2>"+id);
		}
	}
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		int sid=Integer.parseInt(request.getParameter("id"));
		Selectbyuser su=new Selectbyuser();
		displaymodel dm=su.Byuser(sid);
		request.setAttribute("list", dm);
		RequestDispatcher rs=request.getRequestDispatcher("insert.jsp");
		try {
			rs.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) {
			int sid=Integer.parseInt(request.getParameter("id"));
			deletelogic dl= new deletelogic();
		     dl.delete(sid);
		     try {
				response.sendRedirect("home");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	private void gethome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Display ds=new Display();
		ArrayList<displaymodel> am =ds.Show();
		request.setAttribute("display1",am );
		RequestDispatcher rs=request.getRequestDispatcher("homejsp.jsp");
		rs.forward(request, response);
	}
	private void getlogin(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rs=request.getRequestDispatcher("login.jsp");
		try {
			rs.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		long  mobile=Long.parseLong(request.getParameter("mobile"));
		String course =request.getParameter("course");
		String state=request.getParameter("state");
		Insertmodel im=new Insertmodel(name,email,mobile,course,state);
		Insertlogic il=new Insertlogic();
		int count =il.insert(im);
		if(count>0) {
			response.sendRedirect("home");
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("insert.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rs=request.getRequestDispatcher("insert.jsp");
		try {
			rs.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		loginmodel lm= new loginmodel(email,password);
		Login s=new Login();
		int count =0;
		 count =s.select(lm);
		if(count>0) {
			response.sendRedirect("home");
		}
		else {
			
			out.print("<h1>invalid<h1>"+count);
			
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
