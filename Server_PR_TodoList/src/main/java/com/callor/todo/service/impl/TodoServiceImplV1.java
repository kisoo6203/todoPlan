package com.callor.todo.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.todo.config.DBContract;
import com.callor.todo.config.DBInfo;
import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;

public class TodoServiceImplV1 implements TodoService{

	protected Connection dbConn;
	public TodoServiceImplV1() {
		dbConn = DBContract.getDBConnection();
	}
	
	protected List<TodoVO> select(PreparedStatement pStr) throws SQLException{
		List<TodoVO> tdList = new ArrayList<TodoVO>();
		
		ResultSet rSet = pStr.executeQuery();
		while(rSet.next()) {
			
			TodoVO tdVO = new TodoVO();
			tdVO.setTd_seq(rSet.getInt(DBInfo.td_seq));
			tdVO.setTd_date(rSet.getString(DBInfo.td_date));
			tdVO.setTd_time(rSet.getString(DBInfo.td_time));
			tdVO.setTd_plan(rSet.getString(DBInfo.td_plan));
			tdVO.setTd_place(rSet.getString(DBInfo.td_place));
			tdList.add(tdVO);
			
		}
		System.out.println(tdList.toString());
		
		
		return null;
	}
	
	@Override
	public List<TodoVO> selectAll() {
		
		String sql = " SELECT * FROM todoPlan ";
		sql += " ORDER BY td_date DESC, td_time DESC ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			List<TodoVO> tdList = this.select(pStr);
			pStr.close();
			
			return tdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public TodoVO findById(Integer td_seq) {
		
		String sql = " SELECT * FROM todoPlan ";
		sql += " WHERE td_seq = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setInt(1, td_seq);
			
			List<TodoVO> tdList = this.select(pStr);
			pStr.close();
			if(tdList != null && tdList.size() > 0) {
				
				return tdList.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public Integer insert(TodoVO tdVO) {
		// TODO 데이터 추가부분
		String sql = " INSERT INTO todoPlan ";
		sql += " (";
		sql += " td_date,";
		sql += " td_time,";
		sql += " td_plan,";
		sql += " td_place)";
		sql += " VALUES( ?,?,?,?,? ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, tdVO.getTd_date());
			pStr.setString(2, tdVO.getTd_time());
			pStr.setString(3, tdVO.getTd_plan());
			pStr.setString(4, tdVO.getTd_place());
			
			return pStr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Integer update(TodoVO tdVO) {
		// TODO 데이터 업데이트 하는곳
		String sql = " UPDATE todoPlan SET ";
		
		sql += " td_date = ?, ";
		sql += " td_time = ?, ";
		sql += " td_plan = ?, ";
		sql += " td_place = ? ";
		sql += " WHERE td_seq = ? ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, tdVO.getTd_date());
			pStr.setString(2, tdVO.getTd_time());
			pStr.setString(3, tdVO.getTd_plan());
			pStr.setString(4, tdVO.getTd_place());
			pStr.setInt(5, tdVO.getTd_seq());
			
			return pStr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Integer delete(Integer td_seq) {
		// TODO 데이터 삭제 하는곳
		String sql = " DELETE FROM todoPlan ";
		sql += " WHERE td_seq = ? ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setInt(1, td_seq);
			
			return pStr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
