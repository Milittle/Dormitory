package com.action;

import com.bean.StudentBean;
import com.dao.StudentDao;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.deploy.net.HttpResponse;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mizeshuang on 2016/6/3.
 */
public class StudentTH2 extends ActionSupport {
    private List<StudentBean> studentBeanList = new ArrayList<>();

    public List<StudentBean> getStudentBeanList() {
        return studentBeanList;
    }

    public void setStudentBeanList(List<StudentBean> studentBeanList) {
        this.studentBeanList = studentBeanList;
    }

    @Override
    public String execute() throws Exception {

        //解决网页输出乱码问题
        HttpServletResponse response = null;
        response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        //创建会话
        HttpSession session = ServletActionContext.getRequest().getSession();
        if(session.getAttribute("id")==null){
            out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
            out.flush();out.close();return null;
        }

        studentBeanList = new StudentDao().GetAllList("Student_State='" + "入住'", "");
        return SUCCESS;
    }
}
