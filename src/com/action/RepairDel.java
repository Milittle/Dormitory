package com.action;

import com.dao.RepairDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by mizeshuang on 2016/6/4.
 */
public class RepairDel extends ActionSupport {
    private String Repair_ID;

    public String getRepair_ID() {
        return Repair_ID;
    }

    public void setRepair_ID(String repair_ID) {
        Repair_ID = repair_ID;
    }

    @Override
    public String execute() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = ServletActionContext.getRequest().getSession();
        if (session.getAttribute("id") == null) {
            out.print("<script language='javascript'>alert('请重新登陆！');window.location='Login.jsp';</script>");
            out.flush();
            out.close();
            return null;
        }
        new RepairDao().Delete("Repair_ID='" + Repair_ID + "'");
        out.print("<script language='javascript'>alert('删除成功！');window.location='RepairManager.action';</script>");
        out.flush();
        out.close();
        return null;
    }
}
