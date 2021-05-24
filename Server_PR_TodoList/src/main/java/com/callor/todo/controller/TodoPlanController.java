package com.callor.todo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;
import com.callor.todo.service.impl.TodoServiceImplV1;

@WebServlet("/todo/*")
public class TodoPlanController extends HttpServlet {

	private static final long serialVersionUID = 7263044293863251225L;
	
	protected TodoService tdService;
	public TodoPlanController() {
		tdService = new TodoServiceImplV1();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String subPath = req.getPathInfo();
		if(subPath.equals("/seq")) {
			String strSeq = req.getParameter("td_seq");
			Integer td_seq = Integer.valueOf(strSeq);
			TodoVO tdVO = tdService.findById(td_seq);
			
			req.setAttribute("TD", tdVO);
			SeqController.forword(req, resp, "seq");
		} else if(subPath.equals("/insert")) {
			TodoVO tdVO = new TodoVO();
			
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");
			
			Date date = new Date(System.currentTimeMillis());
			
			tdVO.setTd_seq(0);
			tdVO.setTd_date(sd.format(date));
			tdVO.setTd_time(st.format(date));
			
			req.setAttribute("TD", tdVO);
			SeqController.forword(req, resp, "write");
		} else if(subPath.equals("/update")) {
			String strSeq = req.getParameter("td_seq");
			Integer td_seq = Integer.valueOf(strSeq);
			
			TodoVO tdVO = tdService.findById(td_seq);
			req.setAttribute("TD", tdVO);
			
			SeqController.forword(req, resp, "write");
		
		} else if(subPath.equals("/delete")) {
			String strSeq = req.getParameter("td_seq");
			Integer td_seq = Integer.valueOf(strSeq);
			
			tdService.delete(td_seq);
			resp.sendRedirect("/todo/");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
	
	
	

}
