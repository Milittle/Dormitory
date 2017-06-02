package com.dao;

import com.db.DBHelper;
import com.bean.LogBean;

import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;

public class LogDao {

	public List<LogBean> GetList(String strwhere,String strorder){
		String sql="select * from log,teacher,student,domitory,building where Log_TeacherID=Teacher_ID and Log_StudentID=Student_ID and Student_DomitoryID=Domitory_ID and Domitory_BuildingID=Building_ID";
		if(!(isInvalid(strwhere)))
		{
			sql+=" and "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
//		System.out.println(sql);
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<LogBean> list=new ArrayList<LogBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				LogBean cnbean=new LogBean();
				cnbean.setLog_ID(rs.getInt("Log_ID"));
				cnbean.setLog_StudentID(rs.getInt("Log_StudentID"));
				cnbean.setLog_TeacherID(rs.getInt("Log_TeacherID"));
				cnbean.setLog_Date(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("Log_Date")));
				cnbean.setLog_Remark(rs.getString("Log_Remark"));
				cnbean.setTeacher_Name(rs.getString("Teacher_Name"));
				cnbean.setTeacher_Sex(rs.getString("Teacher_Sex"));
				cnbean.setTeacher_Tel(rs.getString("Teacher_Tel"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Class(rs.getString("Student_Class"));
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
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

	public LogBean GetBean(int id){
		String sql="select * from log,teacher,student,domitory,building where Log_TeacherID=TeacherID and Log_StudentID=Student_ID and Student_DomitoryID=Domitory_ID and Domitory_BuildingID=Building_ID and Log_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		LogBean cnbean=new LogBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setLog_ID(rs.getInt("Log_ID"));
				cnbean.setLog_StudentID(rs.getInt("Log_StudentID"));
				cnbean.setLog_TeacherID(rs.getInt("Log_TeacherID"));
				cnbean.setLog_Date(rs.getString("Log_Date"));
				cnbean.setLog_Remark(rs.getString("Log_Remark"));
				cnbean.setTeacher_Name(rs.getString("Teacher_Name"));
				cnbean.setTeacher_Sex(rs.getString("Teacher_Sex"));
				cnbean.setTeacher_Tel(rs.getString("Teacher_Tel"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Class(rs.getString("Student_Class"));
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
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

	public void Add(LogBean cnbean){
		String sql="insert into log (";
		sql+="Log_StudentID,Log_TeacherID,Log_Date,Log_Remark";
		sql+=") values(";
		sql+="'"+cnbean.getLog_StudentID()+"','"+cnbean.getLog_TeacherID()+"','"+cnbean.getLog_Date()+"','"+cnbean.getLog_Remark()+"'";
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

	public void Update(LogBean cnbean){
		String sql="update log set ";
		sql+="Log_StudentID='"+cnbean.getLog_StudentID()+"',";
		sql+="Log_TeacherID='"+cnbean.getLog_TeacherID()+"',";
		sql+="Log_Date='"+cnbean.getLog_Date()+"',";
		sql+="Log_Remark='"+cnbean.getLog_Remark()+"'";
		
		sql+=" where Log_ID='"+cnbean.getLog_ID()+"'";
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
		String sql="delete from log where ";
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

