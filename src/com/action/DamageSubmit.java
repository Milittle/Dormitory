package com.action;

import com.bean.DamageBean;
import com.dao.DamageDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by mizeshuang on 2016/6/10.
 */
public class DamageSubmit extends ActionSupport {
    private String Damage_ID;
    private String Repair_ID;
    private DamageBean cnbean = new DamageBean();

    public String getDamage_ID() {
        return Damage_ID;
    }

    public void setDamage_ID(String damage_ID) {
        Damage_ID = damage_ID;
    }

    public String getRepair_ID() {
        return Repair_ID;
    }

    public void setRepair_ID(String repair_ID) {
        Repair_ID = repair_ID;
    }

    public DamageBean getCnbean() {
        return cnbean;
    }

    public void setCnbean(DamageBean cnbean) {
        this.cnbean = cnbean;
    }

    @Override
    public String execute() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = ServletActionContext.getRequest().getSession();

        if(session.getAttribute("id")==null){
            out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
            out.flush();
            out.close();
            return null;
        }
        cnbean = new DamageDao().GetBean(Integer.parseInt(Damage_ID));
        cnbean.setRepair_ID(Integer.parseInt(Repair_ID));
        cnbean.setDamage_State("正在维修");
        new DamageDao().Update(cnbean);
        //跳转
        out.print("<script language='javascript'>alert('提交成功！');window.location='DamageManager.action';</script>");
        out.flush();
        out.close();
        return null;
    }


    public static void main(String[] args) {
        System.out.println(new DamageDao().GetBean(2));
    }
}
