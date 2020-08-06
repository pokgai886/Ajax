package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String op=request.getParameter("op");
		String ajax=request.getParameter("ajax");
		System.out.println("op:"+op+",ajax:"+ajax);
		PrintWriter out=response.getWriter();
		out.print("hello");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		/*String op=request.getParameter("op");
		System.out.println("post请求"+op);
		PrintWriter out=response.getWriter();
		out.print("hello");
		out.close();*/
		String username=request.getParameter("username");
		PrintWriter out=response.getWriter();
		if(username.equals("小白")) {
			out.print("用户名已存在");
			
		}else {
			out.print("用户名可用");
		}
		out.close();
		
		
		
		
	}

}
