package com.callor.todo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;
import com.callor.todo.service.impl.TodoServiceImplV1;

@WebServlet("/")
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 2390118487195951184L;
	TodoService tdService;
	public HomeController() {
		tdService = new TodoServiceImplV1();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<TodoVO> tdList = tdService.selectAll();
		
//		System.out.println("11 " + tdList.toString());
		req.setAttribute("TDLIST",  tdList);
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		
	}
	
	

}
