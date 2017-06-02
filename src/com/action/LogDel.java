package com.action;

import com.dao.LogDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by mizeshuang on 2016/6/3.
 */
public class LogDel extends ActionSupport {
    private String Log_ID;

    public String getLog_ID() {
        return Log_ID;
    }

    public void setLog_ID(String log_ID) {
        Log_ID = log_ID;
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
            out.flush();out.close();return null;
        }
        new LogDao().Delete("Log_ID='" + Log_ID + "'");
        out.print("<script>");
        return SUCCESS;
    }
}
