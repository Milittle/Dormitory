package com.action;

import com.bean.DamageBean;
import com.dao.DamageDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by mizeshuang on 2016/6/4.
 */
public class DamageAddSave extends ActionSupport {
    private String Building_ID;
    private String Damage_Description;

    public String getBuilding_ID() {
        return Building_ID;
    }

    public void setBuilding_ID(String building_ID) {
        Building_ID = building_ID;
    }

    public String getDamage_Description() {
        return Damage_Description;
    }

    public void setDamage_Description(String damage_Description) {
        Damage_Description = damage_Description;
    }

    @Override
    public String execute() throws Exception {
        HttpServletResponse response=null;
        response= ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        //创建session对象
        HttpSession session = ServletActionContext.getRequest().getSession();
        //验证是否正常登录
        if(session.getAttribute("id")==null){
            out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
            out.flush();out.close();return null;
        }
        DamageBean damageBean=new DamageBean();
        damageBean.setDamage_Description(Damage_Description);
        damageBean.setBuilding_ID(Integer.parseInt(Building_ID));
        damageBean.setDamage_State("未维修");
        new DamageDao().Add(damageBean);
        //跳转
        out.print("<script language='javascript'>alert('添加成功！');window.location='Index.jsp';</script>");
        out.flush();out.close();return null;
    }
}
