package com.dao;

import com.db.DBHelper;
import com.bean.OutBean;

import java.util.*;
import java.sql.*;

public class OutDao {


	public List<OutBean> GetList(String strwhere,String strorder){
		String sql="select * from out1 as o,student as s where o.Out_StudentID=s.Student_ID";
		if(!(isInvalid(strwhere)))
		{
			sql+=" and  "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<OutBean> list=new ArrayList<OutBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				OutBean cnbean=new OutBean();
				cnbean.setOut_ID(rs.getInt("Out_ID"));
				cnbean.setOut_StudentID(rs.getInt("Out_StudentID"));
				cnbean.setOut_Date(rs.getString("Out_Date"));
				cnbean.setOut_Remark(rs.getString("Out_Remark"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Class(rs.getString("Student_Class"));
				list.add(cnbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}


	public OutBean GetBean(int id){
		String sql="select * from out1 where Out_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		OutBean cnbean=new OutBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setOut_ID(rs.getInt("Out_ID"));
				cnbean.setOut_StudentID(rs.getInt("Out_StudentID"));
				cnbean.setOut_Date(rs.getString("Out_Date"));
				cnbean.setOut_Remark(rs.getString("Out_Remark"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnbean;
	}


	public void Add(OutBean cnbean){
		String sql="insert into out1 (";
		sql+="Out_StudentID,Out_Date,Out_Remark";
		sql+=") values(";
		sql+="'"+cnbean.getOut_StudentID()+"','"+cnbean.getOut_Date()+"','"+cnbean.getOut_Remark()+"'";
		sql+=")";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	public void Update(OutBean cnbean){
		String sql="update out1 set ";
		sql+="Out_StudentID='"+cnbean.getOut_StudentID()+"',";
		sql+="Out_Date='"+cnbean.getOut_Date()+"',";
		sql+="Out_Remark='"+cnbean.getOut_Remark()+"'";
		
		sql+=" where Out_ID='"+cnbean.getOut_ID()+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void Delete(String strwhere){
		String sql="delete from out1 where ";
		sql+=strwhere;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	

	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}


	public static void main(String[] args) {
		System.out.println("");
	}
	
}

