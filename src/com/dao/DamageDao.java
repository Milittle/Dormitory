package com.dao;

import com.bean.DamageBean;
import com.bean.DomitoryBean;
import com.bean.RepairBean;
import com.db.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mizeshuang on 2016/6/4.
 */
public class DamageDao {
    public List<DamageBean> getAlllist() {
        String sql = "select * from damage";
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        List<DamageBean> list = new ArrayList<>();
        try {
            sta = conn.createStatement();
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                DamageBean damageBean = new DamageBean();
                damageBean.setDamage_ID(rs.getInt("Damage_ID"));
                damageBean.setBuilding_ID(rs.getInt("Building_ID"));
                damageBean.setDamage_Description(rs.getString("Damage_Description"));
                damageBean.setDamage_State("Damage_State");
                list.add(damageBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn!=null)
            conn.close();
            if (sta != null) {
                sta.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<DamageBean> GetList(String strwhere, String strorder){
        String sql="select Damage_ID,damage.Building_ID,Damage_Description,Damage_State,Building_Name from damage,building where damage.Building_ID=building.Building_ID";
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
        List<DamageBean> list=new ArrayList<>();
        try{
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()){
                DamageBean cnbean=new DamageBean();
                cnbean.setBuilding_ID(rs.getInt("Building_ID"));
                cnbean.setDamage_ID(rs.getInt("Damage_ID"));
                cnbean.setDamage_Description(rs.getString("Damage_Description"));
                cnbean.setDamage_State(rs.getString("Damage_State"));
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

            }
        }
        return list;
    }

    public DamageBean GetBean(int id){
        String sql="select Damage_ID,damage.Building_ID,Damage_Description,Damage_State,Repair_ID,Building_Name from damage,building where damage.Building_ID=building.Building_ID and Damage_ID='"+id+"'";
        Statement stat = null;
        ResultSet rs = null;
        Connection conn = new DBHelper().getConn();
        DamageBean cnbean=new DamageBean();
        try{
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()){
                cnbean.setDamage_ID(rs.getInt("Damage_ID"));
                cnbean.setBuilding_Name(rs.getString("Building_Name"));
                cnbean.setDamage_Description(rs.getString("Damage_Description"));
                cnbean.setDamage_State(rs.getString("Damage_State"));
                cnbean.setBuilding_ID(rs.getInt("Building_ID"));
                cnbean.setRepair_ID(rs.getInt("Repair_ID"));
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

    public void Add(DamageBean damageBean) {
        String sql = "insert into damage ";
        sql += "values(";
        sql += "default" + ",'" + damageBean.getBuilding_ID() + "','" + damageBean.getDamage_Description() + "','" + damageBean.getDamage_State() + "',"+"default";
        sql += ")";
        Connection connection = null;
        Statement sta = null;
        try {
            connection = new DBHelper().getConn();
            sta = connection.createStatement();
            sta.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(connection!=null)
                connection.close();
            if(sta!=null)
                sta.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Update(DamageBean cnbean) {
        String sql = "update damage set ";
        sql += "Damage_State='" + cnbean.getDamage_State() + "',";
        sql += "Repair_ID='" + cnbean.getRepair_ID() + "'";

        sql += " where Damage_ID='" + cnbean.getDamage_ID() + "'";

        Statement sta = null;
        ResultSet rs = null;

        Connection conn = new DBHelper().getConn();
        try {
            sta = conn.createStatement();
            sta.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (conn != null)
                    conn.close();
                if (sta != null)
                    sta.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void Delete(String strwhere) {
        String sql = "delete from damage where ";
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

    public boolean isInvalid(String value) {
        return value == null || value.length() == 0;
    }

}
