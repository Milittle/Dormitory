package com.action;

import com.dao.DamageDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by mizeshuang on 2016/6/4.
 */
public class DamageDel extends ActionSupport {
    private String Damage_ID;

    public String getDamage_ID() {
        return Damage_ID;
    }

    public void setDamage_ID(String damage_ID) {
        Damage_ID = damage_ID;
    }

    @Override
    public String execute() throws Exception {
        //解决乱码，用于页面输出
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
            out.flush();
            out.close();
            return null;
        }
        new DamageDao().Delete("Damage_ID='" + Damage_ID + "'");
        return SUCCESS;
    }
}
