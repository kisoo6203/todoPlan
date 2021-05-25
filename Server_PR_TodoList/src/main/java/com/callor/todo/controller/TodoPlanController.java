package com.callor.todo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.config.DBInfo;
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
		String subPath = req.getPathInfo();
		req.setCharacterEncoding("UTF-8");
		String td_date = req.getParameter(DBInfo.td_date);
		String td_time = req.getParameter(DBInfo.td_time);
		String td_plan = req.getParameter(DBInfo.td_plan);
		String td_place = req.getParameter(DBInfo.td_place);
		TodoVO tdVO = new TodoVO();
		tdVO.setTd_date(td_date);
		tdVO.setTd_time(td_time);
		tdVO.setTd_plan(td_plan);
		tdVO.setTd_place(td_place);
		
		if(subPath.equals("/insert")) {
			tdService.insert(tdVO);
			resp.sendRedirect("/todo/");
		} else if(subPath.equals("/update")) {
			String strSeq = req.getParameter("td_seq");
			Integer td_seq = Integer.valueOf(strSeq);
			tdVO.setTd_seq(td_seq);
			tdService.update(tdVO);
			resp.sendRedirect("/todo/");
			
		}
	}
	
	
	
	
	

}
