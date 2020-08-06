package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.etc.entity.Article;
import com.google.gson.Gson;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/TestAjaxController")
public class TestAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestAjaxController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			List<Article> list=new ArrayList<Article>();
			list.add(new Article(1,"A","b","c","d"));
			list.add(new Article(2,"B","b","c","d"));
			PrintWriter out=response.getWriter();
			Gson gson=new Gson();
			String string=gson.toJson(list);
			out.print(string);
			out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
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
