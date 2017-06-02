package com.dao;

import com.db.DBHelper;
import com.bean.DomitoryBean;

import java.util.*;
import java.sql.*;

public class DomitoryDao {


	public List<DomitoryBean> GetList(String strwhere,String strorder){
		String sql="select * from domitory,building where Domitory_BuildingID=Building_ID";
		if(!(isInvalid(strwhere)))
		{
			sql+=" and "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<DomitoryBean> list=new ArrayList<DomitoryBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				DomitoryBean cnbean=new DomitoryBean();
				cnbean.setDomitory_ID(rs.getInt("Domitory_ID"));
				cnbean.setDomitory_BuildingID(rs.getInt("Domitory_BuildingID"));
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setDomitory_Type(rs.getString("Domitory_Type"));
				cnbean.setDomitory_Number(rs.getString("Domitory_Number"));
				cnbean.setDomitory_Tel(rs.getString("Domitory_Tel"));
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


	public DomitoryBean GetBean(int id){
		String sql="select * from domitory,building where Domitory_BuildingID=Building_ID and Domitory_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		DomitoryBean cnbean=new DomitoryBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setDomitory_ID(rs.getInt("Domitory_ID"));
				cnbean.setDomitory_BuildingID(rs.getInt("Domitory_BuildingID"));
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setDomitory_Type(rs.getString("Domitory_Type"));
				cnbean.setDomitory_Number(rs.getString("Domitory_Number"));
				cnbean.setDomitory_Tel(rs.getString("Domitory_Tel"));
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


	public void Add(DomitoryBean cnbean){
		String sql="insert into domitory (";
		sql+="Domitory_BuildingID,Domitory_Name,Domitory_Type,Domitory_Number,Domitory_Tel";
		sql+=") values(";
		sql+="'"+cnbean.getDomitory_BuildingID()+"','"+cnbean.getDomitory_Name()+"','"+cnbean.getDomitory_Type()+"','"+cnbean.getDomitory_Number()+"','"+cnbean.getDomitory_Tel()+"'";
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

	public void Update(DomitoryBean cnbean){
		String sql="update domitory set ";
		sql+="Domitory_BuildingID='"+cnbean.getDomitory_BuildingID()+"',";
		sql+="Domitory_Name='"+cnbean.getDomitory_Name()+"',";
		sql+="Domitory_Type='"+cnbean.getDomitory_Type()+"',";
		sql+="Domitory_Number='"+cnbean.getDomitory_Number()+"',";
		sql+="Domitory_Tel='"+cnbean.getDomitory_Tel()+"'";
		
		sql+=" where Domitory_ID='"+cnbean.getDomitory_ID()+"'";
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
		String sql="delete from domitory where ";
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

