package com.dao;

import com.bean.RepairBean;
import com.bean.StudentBean;
import com.db.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mizeshuang on 2016/6/3.
 */
public class RepairDao {


    public String CheckLogin(String username, String password){
        String id = null;
        String sql="select * from repair where Repair_Username='"+username+"' and Repair_Password='"+password+"'";
        Statement stat = null;
        ResultSet rs = null;
        Connection conn = new DBHelper().getConn();
        try{
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                id = rs.getString("Repair_ID");
            }
        }
        catch(SQLException ex){}
        return id;
    }

    public boolean CheckPassword(String id, String password){
        boolean ps = false;
        String sql="select * from repair where Repair_ID='"+id+"' and Repair_Password='"+password+"'";
        Statement stat = null;
        ResultSet rs = null;
        Connection conn = new DBHelper().getConn();
        try{
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                ps=true;
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

        return ps;
    }

    public List<RepairBean> GetAllList() {
        String sql = "select * from repair";
        Connection conn = new DBHelper().getConn();
        Statement sta=null;
        ResultSet res=null;
        List<RepairBean> list = new ArrayList<>();
        try {
            sta = conn.createStatement();
            res = sta.executeQuery(sql);
            while (res.next()) {
                RepairBean repairBean = new RepairBean();
                repairBean.setRepair_ID(res.getInt("Repair_ID"));
                repairBean.setRepair_Username(res.getString("Repair_Username"));
                repairBean.setRePair_Password(res.getString("Repair_Password"));
                repairBean.setRepair_Name(res.getString("Repair_Name"));
                repairBean.setRepair_Tel(res.getString("Repair_Tel"));
                list.add(repairBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<RepairBean> GetList(String strwhere, String strorder){
        String sql="select * from repair where 1=1";
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
        List<RepairBean> list=new ArrayList<>();
        try{
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()){
                RepairBean cnbean=new RepairBean();
                cnbean.setRepair_ID(rs.getInt("Repair_ID"));
                cnbean.setRepair_Username(rs.getString("Repair_Username"));
                cnbean.setRePair_Password(rs.getString("Repair_Password"));
                cnbean.setRepair_Sex(rs.getString("Repair_Sex"));
                cnbean.setRepair_Name(rs.getString("Repair_Name"));
                cnbean.setRepair_Tel(rs.getString("Repair_Tel"));
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

            }
        }
        return list;
    }


    public RepairBean GetBean(int id){
        String sql="select * from repair where Repair_ID="+id;
        Statement stat = null;
        ResultSet rs = null;
        Connection conn = new DBHelper().getConn();
        RepairBean cnbean=new RepairBean();
        try{
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()){
                cnbean.setRepair_ID(rs.getInt("Repair_ID"));
                cnbean.setRepair_Username(rs.getString("Repair_Username"));
                cnbean.setRePair_Password(rs.getString("Repair_Password"));
                cnbean.setRepair_Name(rs.getString("Repair_Name"));
                cnbean.setRepair_Sex(rs.getString("Repair_Sex"));
                cnbean.setRepair_Tel(rs.getString("Repair_Tel"));
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

    public void Add(RepairBean cnbean){
        String sql="insert into repair";
        sql+=" values(";
        sql+="default"+",'"+cnbean.getRepair_Username()+"','"+cnbean.getRePair_Password()+"','"+cnbean.getRepair_Name()+"','"+cnbean.getRepair_Sex()+"','"+cnbean.getRepair_Tel()+"'";
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


    public void Update(RepairBean cnbean){
        String sql="update repair set ";
        sql+="Repair_ID='"+cnbean.getRepair_ID()+"',";
        sql+="Repair_Username='"+cnbean.getRepair_Username()+"',";
        sql+="Repair_Password='"+cnbean.getRePair_Password()+"',";
        sql+="Repair_Name='"+cnbean.getRepair_Name()+"',";
        sql+="Repair_Sex='"+cnbean.getRepair_Sex()+"',";
        sql+="Repair_Tel='"+cnbean.getRepair_Tel()+"'";

        sql+=" where Repair_ID='"+cnbean.getRepair_ID()+"'";
        Statement stat = null;
        ResultSet rs = null;
        Connection conn = new DBHelper().getConn();
        try{
            stat = conn.createStatement();
            stat.executeUpdate(sql);
        } catch (SQLException e) {

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

    public void Delete(String strwhere) {
        String sql="delete from repair where ";
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

    }


}
